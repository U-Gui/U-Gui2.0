package cn.edu.neu.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.wxpay.sdk.WXPayUtil;

import cn.edu.neu.entity.PayRecord;
import cn.edu.neu.service.DealService;
import cn.edu.neu.util.Value;

/**
 * 小程序支付相关方法
 * @author bc
 * @date 2018年11月20日
 */
@RequestMapping("/pay/")
public class PayController {
	
	@Autowired
	private DealService dealService;

	/*
	 * 统一下单
	 * 	openid:用户标识
	 * 	body：商品描述	 1-充值钱包，2-支付超额时间
	 * 	payMoney：订单总金额
	 * 	needMoney:需要支付的钱 充值时赋0， 支付超额时间，正常填
	 */
	@PostMapping("callOrder")
	@ResponseBody
	public Map<String, String> callOrder(String openid, String body, double payMoney, double needMoney) {
		Map<String, String> resultMap = new HashMap<String, String>();
		String appid = Value.getAppid();
		String secret_key = Value.getSecretKey();
		int total_fee = (int)payMoney*100;
		String out_trade_no = System.currentTimeMillis()+randStr(5);
		Map<String, String> xmlParam = new HashMap<String, String>();
		//封装参数，参见官方文档
		xmlParam.put("appid", appid);
		xmlParam.put("mch_id", Value.getMchId());
		xmlParam.put("nonce_str", WXPayUtil.generateNonceStr());
		xmlParam.put("sign_type", "MD5");
		xmlParam.put("body", body);
		xmlParam.put("out_trade_no", out_trade_no);
		xmlParam.put("total_fee", String.valueOf(total_fee));
		xmlParam.put("spbill_create_ip", Value.getSpbillCreateIp());
		xmlParam.put("notify_url", Value.getNotifyUrl());
		xmlParam.put("trade_type", "JSAPI");
		xmlParam.put("openid", openid);
		String xmlParameter = null;
		try {
			xmlParameter = WXPayUtil.generateSignedXml(xmlParam, secret_key);  //生成带签名xml参数
			Map<String, String> map = xmlHttpRequest("https://api.mch.weixin.qq.com/pay/unifiedorder", xmlParameter);
			if(map.get("return_code").equals("SUCCESS")) {
				if(map.get("result_code").equals("SUCCESS")) {
					PayRecord payRecord = new PayRecord(openid, total_fee, needMoney, out_trade_no, body, 0);
					if(dealService.newPayRecord(payRecord)) {
						resultMap.put("appId", appid);
						resultMap.put("timeStamp", System.currentTimeMillis()+"");
						resultMap.put("nonceStr", map.get("nonce_str"));
						resultMap.put("package", "prepay_id="+map.get("prepay_id"));
						resultMap.put("signType", "MD5");
						String paySign = WXPayUtil.generateSignature(resultMap, secret_key);
						resultMap.put("paySign", paySign);
					} else {
						resultMap.put("myerr", "0");   //访问数据库出错
					}
				} 
				resultMap.put("err_code", map.get("err_code"));
				resultMap.put("err_code_des", map.get("err_code_des"));   //测试时使用，成功后可以删除
			}
			resultMap.put("return_msg", map.get("return_msg"));  //测试时使用，成功后可以删除
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	/*
	 * 暂时不需要了
	 * 用户确认付款后，后端需要更新数据库
	 * 支付超额的钱使用同一个确认接口
	 * money：需要更新的钱
	 * money = payMoney - needPay
	 * money= 用户支付的钱 - 用户应该支付的钱
	 */
	@PostMapping("orderConfirm")
	public void orderConfirm(String userid, double money, HttpServletResponse response) {
		String result = "{\"result\":0}";
		if(dealService.payUpdateBalance(money, userid))
			result = "{\"result\":1}";
		response.setContentType("application/json");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out!=null)
				out.close();
		}
	}
	/*
	 * 接收微信返回来的参数，支付超额时长与充值都在这接收
	 * 更新数据库
	 * 不知道通知频率是多久
	 * 如果不合适，再另写方法更改数据库
	 */
	@RequestMapping(value="resultNotify", method=RequestMethod.POST)
	public String resultNotify(HttpServletRequest request) {
		String return_code = "FAIL";
		String return_msg = "NO";
		String resultXml = "";   //返回的xml数据
		BufferedReader reader = null;
		try {
			//读取从微信服务器发来的xml数据
			reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line=reader.readLine())!=null) 
				sb.append(line+"\n");
			Map<String, String> xmlMap = WXPayUtil.xmlToMap(sb.toString());   //转成map
			if(xmlMap.get("return_code").equals("SUCCESS")) {
				String out_trade_no = xmlMap.get("out_trade_no");
				String openid = xmlMap.get("openid");
				Map<String, Object> moneyMap = dealService.getPayTotalfee(openid, out_trade_no);
				int nofity_status = (Integer) moneyMap.get("nofity_status");
				if(nofity_status==0) {
					String secret_key = Value.getSecretKey();
					int total_fee = Integer.parseInt(xmlMap.get("total_fee"));
					String bank_type = xmlMap.get("bank_type");
					String transaction_id = xmlMap.get("transaction_id");
					String time_end = xmlMap.get("time_end");
					Map<String, String> signMap = new HashMap<String, String>();  //封装签名验证需要的参数
					signMap.put("appid", xmlMap.get("appid"));
					signMap.put("mch_id", xmlMap.get("mch_id"));
					signMap.put("nonce_str", xmlMap.get("nonce_str"));
					signMap.put("result_code", xmlMap.get("result_code"));
					signMap.put("openid", openid);
					signMap.put("is_subscribe", xmlMap.get("is_subscribe"));
					signMap.put("trade_type", xmlMap.get("trade_type"));
					signMap.put("bank_type", bank_type);
					signMap.put("total_fee", total_fee+"");
					signMap.put("cash_fee", xmlMap.get("cash_fee"));
					signMap.put("transaction_id", transaction_id);
					signMap.put("out_trade_no", out_trade_no);
					signMap.put("time_end", time_end);
					String sign = WXPayUtil.generateSignature(signMap, secret_key);
					if(sign.equals(xmlMap.get("sign"))) {    //签名验证
						if((Integer)moneyMap.get("total_fee")==total_fee) {    //订单金额是否与我们保存的订单金额一致
							double overtime_money = (Double) moneyMap.get("overtime_money");
							double money = (double)total_fee/100;
							if(overtime_money!=0)    //判断支付原因，不为0：是支付超额的时间情况
								money -= overtime_money;
							//更新数据库用户钱包，更新交易记录
							if(dealService.payUpdateBalance(money, openid)&&dealService.updatePayRecord(bank_type, transaction_id, time_end, out_trade_no)) {
								return_code = "SUCCESS";
								return_msg = "OK";
							} else 
								return_msg = "DATABASE WRONG, PLEASE NOTIFY AGAIN";
						} else 
							return_msg = "TOTAL_FEE NOT CORRECT";
					} else 
						return_msg = "SIGN NOT CORRECT";
				} else if(nofity_status==1){
					return_code = "SUCCESS";
					return_msg = "ALREADY NOTIFY";
				} else 
					return_msg = "NO ORDER";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultXml = "<xml><return_code><![CDATA["+return_code+"]]></return_code><return_msg><![CDATA["+return_msg+"]]></return_msg></xml>";
		return resultXml;
	}
	/*
	 * 请求url，返回参数
	 * 	requestUrl：url地址
	 * 	xmlParam：参数，xml格式
	 */
	private Map<String, String> xmlHttpRequest(String requestUrl, String xmlParam) {
		OutputStreamWriter writer = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		sb.append("");
		String default_encoding = "UTF-8";
		try {
			URL url= new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(5000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setReadTimeout(10000);
			conn.connect();
			writer = new OutputStreamWriter(conn.getOutputStream(), default_encoding);
			writer.write(xmlParam);
			writer.flush();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), default_encoding));
			String line = null;
			while((line=br.readLine())!=null) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null)
					br.close();
				if(writer!=null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			return WXPayUtil.xmlToMap(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//生成随机字符串
	private String randStr(int length) {
		int size;
		String str = "";
		for(int i=0; i<length; i++) {
			size = ((int)(Math.random()*2))==0 ? 65 : 97;
			str += (char)((int)(Math.random()*26) + size);
		}
		return str;
	}
	
}
