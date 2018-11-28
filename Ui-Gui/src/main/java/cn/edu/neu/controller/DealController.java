package cn.edu.neu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.neu.entity.BoxInfo;
import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.School;
import cn.edu.neu.entity.User;
import cn.edu.neu.service.DealService;
import cn.edu.neu.util.OpenBox;
import cn.edu.neu.util.Value;
import cn.edu.neu.vo.MajorWithIdAndName;
import cn.edu.neu.vo.schoolWithIdAndName;

/**
 * @author bc
 */
@Controller
@RequestMapping("/deal")
public class DealController {
	
	@Autowired
	private DealService dealService;
	
	/*
	 * 为用户提供柜子地点，三种方式
	 * 0-根据使用频率，1-根据学校，2-返回所有柜子
	 */
	@RequestMapping("/getboxlocation/oftenuse")
	@ResponseBody
	public List<Map<String, Object>> offerCabLoc(String userid, int startlocation, int way) {
		List<Map<String, Object>> resultList = null;
		int offSize = Value.getOffsize();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(way==0) {
			way = 1;
			List<Map<String, Object>> cabinetIdOftenList = dealService.getCabinetIdOften(userid, offSize);
			if(cabinetIdOftenList.size()>=offSize) {
				resultList = dealService.offCabinetInfoOften(cabinetIdOftenList);
				resultMap.put("way", way);
				resultMap.put("startlocation", 0);
				resultList.add(resultMap);
				return resultList;
			}
		}
		if(way==1) {
			List<Integer> userSchoolCabLocIds = dealService.getUserSchoolCabLocIds(userid);
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.put("list", userSchoolCabLocIds);
			tempMap.put("startLocation", startlocation);
			tempMap.put("offSize", offSize);
			resultList = dealService.offgetCabinetInfoUserSchool(tempMap);
			if(resultList.size()<offSize) {
				way = 2;
				startlocation = 0;
			} else {
				startlocation += offSize;
			}
			resultMap.put("way", way);
			resultMap.put("startlocation", startlocation);
			resultList.add(resultMap);
			return resultList;
		}
		if(way==2) {
			resultList = dealService.offCabinetInfoAll(startlocation, offSize);
			if(resultList.size()<6) 
				startlocation = -1;
			else 
				startlocation += offSize;
			resultMap.put("way", way);
			resultMap.put("startlocation", startlocation);
			resultList.add(resultMap);
			return resultList;
		}
		return resultList;
	}
	/*
	 * 用户提供选择柜子地点
	 * 提供学校->提供柜子群位置及大柜子
	 */
	@RequestMapping("/getboxlocation/selectschool")
	@ResponseBody
	public List<School> offSelectSchool() {
		return dealService.offAllSchoolHaveCabinet();
	}
	@RequestMapping("/getboxlocation/selectcabinet")
	@ResponseBody
	public List<Map<String, Object>> offSelectCabinet(int schoolid) {
		if(schoolid>0) {
			return dealService.offCabinetLocbySchoolId(schoolid);
		} else
			return null;
	}
	//提供大柜子中不同类型柜子空闲数量
	@RequestMapping("/getcabinetfreenum")
	@ResponseBody
	public Map<String, Object> offCabinetFreenum(int cabinetid) {
		if(cabinetid>0)
			return dealService.offCabinetFreenum(cabinetid);
		else
			return null;
	}
	/*
	 * 为用户分配柜子
	 * 	随机分配
	 * 	选择型号随机分配
	 * 	用户自己选择柜子
	 */
	@RequestMapping("/getboxrandom")
	@ResponseBody
	public BoxInfo offBoxRandom(int cabinetid) {
		List<BoxInfo> boxInfos = dealService.getBoxbyCabinetId(cabinetid);
		int boxInfosSize = boxInfos.size();
		if(boxInfosSize>0) 
			return boxInfos.get(new Random().nextInt(boxInfosSize));
		else 
			return null;
	}
	@RequestMapping("/getboxtyperandom")
	@ResponseBody
	public void offBoxTypeRandom(int cabinetid, int boxtype, HttpServletResponse response) {
		PrintWriter writer;
		int boxId = -1;
		if(boxtype==0||boxtype==1) {
			List<Integer> boxIds = dealService.getBoxbyCabinetandType(cabinetid, boxtype);
			int boxIdsSize = boxIds.size();
			if(boxIdsSize>0) 
				boxId = boxIds.get(new Random().nextInt(boxIdsSize));
		}
//		String data = "{\"boxId\":\""+boxId+"\"}";
//		String data = "{\"boxId\":"+JSON.toJSONString(boxId)+"}";
		String data = "{\"boxId\":"+boxId+"}";
		response.setContentType("application/json");
		try {
			writer = response.getWriter();
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getboxselect")
	public @ResponseBody List<BoxInfo> offBoxSelect(int cabinetid) {
		return dealService.getBoxbyCabinetId(cabinetid);
	}
	/*
	 * 用户打开柜子
	 * 	改变状态  0->9
	 * 	确认使用，移进记录表,设置结束时间为1970-01-01 08:00:00
	 * 	不确认使用，返回状态
	 */
	@RequestMapping("/useropenbox")
	public void alterOpenBoxStatus(String userid, int boxid, HttpServletResponse response) {
		int result = 1;
		String data = null;
		PrintWriter writer;
		if(dealService.ifUserIn(userid)) {
			result = 2;
			BoxInfo boxInfo = dealService.getBoxIS(boxid);
			if(boxInfo.getBoxStatus()==0) {
				/*if(OpenBox.openBox(boxid)) {  //打开柜子，现在是根据是否连接上硬件端服务器判断是否正确
					dealService.alterBoxStatus(1, boxid);
					result = 0;
				}*/
				dealService.alterBoxStatus(9, boxid);  //改变柜子为待改变状态9
				result = 0;
			}
		}
		data = "{\"result\":"+result+"}";
		response.setContentType("application/json");
		try {
			writer = response.getWriter();
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/useconfirm")
	public void addRecordafterConfirm(String userid, int boxid, HttpServletResponse response) {
		int result = 1;
		String data = null;
		PrintWriter writer;
		User user = dealService.getUserIBB(userid);
		if(user!=null) {
			result = 2;
			BoxInfo boxInfo = dealService.getBoxIS(boxid);
			if(boxInfo!=null&&boxInfo.getBoxStatus()==1) {
				java.util.Date start_time = new java.util.Date(System.currentTimeMillis());
				java.util.Date end_time = new java.util.Date(0);
				BoxUseRecord boxUseRecord = new BoxUseRecord(boxInfo,start_time, end_time, user);
				dealService.addBoxUseRecord(boxUseRecord);
				result = 0;
			}
		}
		data = "{\"result\":"+result+"}";
		response.setContentType("application/json");
		try {
			writer = response.getWriter();
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/usenotconfirm")
	public void useNotConfirm(int boxid) {
		dealService.alterBoxStatus(0, boxid);
	}
	/*
	 * 解除柜子
	 * 	先获取所有正在租用的柜子，选择要打开的柜子
	 * 	临时打开柜子
	 * 	最终确认打开，不再使用
	 * 		1.默认使用剩余时长支付时间
	 * 		2.时长不够使用剩余钱支付
	 */
	@RequestMapping("/onuse/all")
	@ResponseBody
	public List<Map<String, Object>> offOnuseAll(String userid) {
		return dealService.offOnUseAll(userid);
	}
	@PostMapping("/tempOpenBox")
	public void tempOpenBox(String userid, int boxid, HttpServletResponse response) {
		response.setContentType("application/json");
		String data = "{\"result\":0}";
		if(dealService.ifUseExist(userid, boxid)) {
//			if(OpenBox.openBox(boxid))   //打开柜子，现在是判断是否连接上硬件端服务器
			dealService.alterBoxStatus(9, boxid);   //设置为待打开状态9
			data = "{\"result\":1}";
		}
		try {
			PrintWriter writer = response.getWriter();
			writer.print(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/opencomfirm")
	@ResponseBody
	public Map<String, Object> openConfrim(String userid, int boxid, long start_time) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(dealService.ifUseExist(userid, boxid)) {
			//时长或者钱是否够，开柜子是否成功
			boolean ifEnough = false, ifOpen = false;
			int payWay = 0;
			User user = dealService.getUserIBB(userid);
			long haveTime = user.getUserBoxtime();
			long end_time = System.currentTimeMillis();
			long payTime = end_time-start_time;
			double haveBalance, payMoney = 0.0;
			if(haveTime>=payTime) {
//				if((ifOpen=OpenBox.openBox(boxid))) {  //打开柜子
					dealService.alterUserBoxTime((haveTime-payTime), userid);
					payWay = 1;
					ifEnough = true;
//				}
			} else {
				haveBalance = user.getUserBalance();
				payMoney = payTime/3600000*Value.getTime2money();
				if(haveBalance>=payMoney) {
//					if((ifOpen=OpenBox.openBox(boxid))) {  //打开柜子
						dealService.alterUserBalance((haveBalance-payMoney), userid);
						ifEnough = true;
						payWay = 2;
//					}
				} else 
					payMoney -= haveBalance;
			}
			if(ifEnough&&ifOpen) {
				dealService.alterUseEndTime(new Timestamp(end_time), boxid);
				dealService.alterBoxStatus(8, boxid);   //改变为待打开状态
			}
			resultMap.put("ifopen", ifOpen);
			resultMap.put("ifenough", ifEnough);
			resultMap.put("payway", payWay);
			resultMap.put("paytime", payTime);
			resultMap.put("paymoney", payMoney);
		}
		return resultMap;
	}
	/*
	 * 用户支付超额时间后，自动打开柜子，要前端在用户确认支付的同时，触发这个url，打开柜子
	 * 可以加系统延时
	 * 这个方法暂时先这样，可以根据需求再改
	 * 不知道微信会多久给回复，如果后端回复很快的话，可以在微信回复的时候开柜子，传递的needMoney可以设置为  money-boxid,以打开柜子 
	 */
	@RequestMapping("/payOpenBox")
	public void payOverTime(int boxid) {
		if(OpenBox.openBox(boxid)) {
			dealService.alterUseEndTime(new Timestamp(System.currentTimeMillis()), boxid);
			dealService.alterBoxStatus(8, boxid);   //改变为待打开状态
		}
	}
	
	//根据userid获取钱，剩余租柜子时长，签到天数，上一次签到时间
	//根据奖励规则，计算获得时长
	@RequestMapping("/getuser/moneytime")
	@ResponseBody
	public Map<String, Object> offUserMoneyTime(String userid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		User user = dealService.getUserBBSD(userid);
		if(user!=null) {
			Date dayBeforeYesterday = new Date(System.currentTimeMillis()-86400000*2);
			Date lastSignDay = user.getLastsignTime();
			double awardTime = 0;
			if(lastSignDay!=null) {
				if(lastSignDay.after(dayBeforeYesterday)) {
					int signDays = user.getUsersignDays();
					int baseAward = Value.getBaseaward();
					int cycleAward = Value.getCycleaward();
					awardTime = (double) (1+(1+signDays)/2/cycleAward)*baseAward*signDays;
				}
			}
			resultMap.put("money", user.getUserBalance());
			resultMap.put("boxtime", user.getUserBoxtime());
			resultMap.put("awardtime", awardTime);
		}
		return resultMap;
	}
	@RequestMapping("/getallschool")
	public @ResponseBody List<schoolWithIdAndName> offAllSchool() {
		return dealService.getAllSchool();
	}
	@RequestMapping("/getallmajor")
	public @ResponseBody List<MajorWithIdAndName> offAllMajor(int schoolId) {
		return dealService.getAllMajorbySchoolId(schoolId);
	}
	
}

