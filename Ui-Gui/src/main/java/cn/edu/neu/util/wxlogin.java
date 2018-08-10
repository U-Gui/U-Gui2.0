package cn.edu.neu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.alibaba.fastjson.JSON;

public class wxlogin {

	public static Map<String, Object> getopenid(String code) {
		Map<String, Object> wxres = new HashedMap();
		String wxspAppid = "wx581a9407474a1f50";
		// 小程序的 app secret (在微信小程序管理后台获取)
		String wxspSecret = "0b1c471146ff539b53dd55b5f7583600";
		// 授权（必填）
		String grant_type = "authorization_code";
		String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="
				+ grant_type;
		params = "https://api.weixin.qq.com/sns/jscode2session?" + params;
		// 获取json
		System.out.println(params);
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(params);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 转为map
		String res = json.toString();
		Map mapTypes = JSON.parseObject(res);
		System.out.println(mapTypes);
		//如果失败返回空值
		//如果失败返回空值
		if (mapTypes.get("errcode") != null) {		
			System.out.println(wxres+"-------------失败返回空值");
			return wxres;
		}
		//满足UnionID返回条件时，返回的JSON数据包
		if (mapTypes.get("unionid") != null) {	
			wxres.put("openid", (String) mapTypes.get("openid"));	
			wxres.put("session_key", (String) mapTypes.get("session_key"));	
			wxres.put("unionid", (String) mapTypes.get("unionid"));	
			System.out.println(wxres+"-------------满足UnionID返回条件时");
			return wxres;
		}
		//正常返回的JSON数据包
		else {
		wxres.put("openid", (String) mapTypes.get("openid"));	
		wxres.put("session_key", (String) mapTypes.get("session_key"));	
		System.out.println(wxres+"-------------正常返回的JSON数据包");
		return wxres;
		}
	}

	public static Map loadJson(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String res = json.toString();
		Map mapTypes = JSON.parseObject(res);
		System.out.println(res);
		System.out.println("----------");
		System.out.println(mapTypes.get("user_tn"));
		System.out.println(mapTypes.get("user_id"));
		return mapTypes;
	}
}
