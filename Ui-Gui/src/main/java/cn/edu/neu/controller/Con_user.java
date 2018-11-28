package cn.edu.neu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.Major;
import cn.edu.neu.entity.User;
import cn.edu.neu.service.userservice;
import cn.edu.neu.util.Value;
import cn.edu.neu.util.wxlogin;
import cn.edu.neu.vo.UserDefaultIBBDT;

@Controller
@RequestMapping(value = "user")
public class Con_user {

	@Autowired
	userservice us;

	/*
	 * 用户进行登录时，获取验证用户的6位唯一标识符，进行判断 ：isnew，表示这个用户是否存在
	 * http://localhost:8080/Ui-Gui/login?code=023Sk9G52Kyx1L0G3wH52hUqG52Sk9GV
	 * 
	 */
	@RequestMapping(value = "login")
	@ResponseBody
	public Map<String, Boolean> login(@RequestParam String code) {
		Map<String, Boolean> isnew = new HashMap<String, Boolean>();
		Map<String, Object> result = wxlogin.getopenid(code);
		if (result.get("openid") != null) {
			String openid = (String) result.get("openid");
			User user = new User();
			user = us.finduserbyuserId(openid);
			if (user != null) {
				System.out.println("------存在用户");
				isnew.put("isnew", false);
				return isnew;
			} else {
				System.out.println("------没有用户");
				int res = us.adduserbyuserId(openid);
				isnew.put("isnew", true);
				return isnew;
			}
		}
		// 获取openid失败
		else
			System.out.println("-------------获取openid失败");
		return null;
	}

	/*
	 * 用户注册信息
	 * http://localhost:8080/Ui-Gui/user/register?userId=222&userPhone=15521832222&
	 * userMajorId=1&userSex=0
	 * 
	 * 
	 * 
	 */
	/*
	 * 增加
	 * 2018.8.21
	 * author: bc
	 * 为用户信息赋初值
	 */
	@RequestMapping(value = "register")
	@ResponseBody
	public Map<String, Boolean> register(String userId, String userPhone, int userMajorId, Integer userSex) {
		Map<String, Boolean> result = new HashMap<String, Boolean>();

		try {
			us.registeruserbyuserId(userId, userPhone, userMajorId, userSex);
			/*
			 * 2018.8.22
			 * bc修改
			 * 为用户一些信息赋初值
			 * userBalance：钱--0.0
			 * userBoxtime：租用柜子时长--注册赠送
			 * usersignDays: 签到天数--0
			 * lastsignTime：上一次签到时间--当前时间
			 */
			long signBoxtime = Value.getSignboxtime();
			java.sql.Date lastsignTime = new java.sql.Date(System.currentTimeMillis());
//			us.addUserDefaultInfo(new UserDefaultIBBDT(userId, 0.0, signBoxtime, 0, lastsignTime));
			
			
			/*
			 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
			 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
			 * 这里是为了测试，没有支付功能时，默认给用户很多钱
			 * 正式上线要删掉，换成上面的
			 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
			 * ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
			 */
			us.addUserDefaultInfo(new UserDefaultIBBDT(userId, 1000.00, signBoxtime*10, 0, lastsignTime));
			
			
			result.put("result", true);
			return result;
		} catch (Exception e) {

			result.put("result", false);
			return result;
		}
	}

	/**
	 * 用户修改个人信息
	 * http://localhost:8080/Ui-Gui/user/updateuserinfo?userId=123&userPhone=15521832222&majorId=2&userSex=0
	 * 
	 * @param userId
	 * @param userPhone
	 * @param userMajorId
	 * @param userSix
	 * @return
	 */
	@RequestMapping(value = "updateuserinfo")
	@ResponseBody
	public Map<String, Boolean> updateuserinfo(User user, Major maj) {
		System.out.println(maj);
		user.setMajor(maj);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		System.out.println("===+++++++++++++++++++++++++++++" + user);
		int res = us.updateuserinfo(user);
		if (res == 1) {
			result.put("result", true);
			return result;
		}

		result.put("result", false);
		return result;
	}

	/**
	 * 用户修改电话号码
	 * http://localhost:8080/Ui-Gui/user/updateuserphone?userId=123&userPhone=15521832222&majorId=2&userSex=0
	 * 
	 * @param userId
	 * @param userPhone
	 * @param userMajorId
	 * @param userSix
	 * @return
	 */
	@RequestMapping(value = "updateuserphone")
	@ResponseBody
	public Map<String, Boolean> updateuserphone(String userId, String userPhone) {
		User user = new User();
		user.setUserId(userId);
		user.setUserPhone(userPhone);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		System.out.println("===+++++++++++++++++++++++++++++" + user);
		int res = us.updateuserinfo(user);
		if (res == 1) {
			result.put("result", true);
			return result;
		}

		result.put("result", false);
		return result;
	}

	/**
	 * 签到 url: http://localhost:8080/Ui-Gui/user/signinday?userid=123
	 * 
	 * @param user
	 * @return
	 * 
	 */

	@RequestMapping("signinday")
	@ResponseBody

	public Map<String, Object> signinday(String userid) {
		Map<String, Object> result =new HashMap<String, Object>();
		User user = us.finduserbyuserId(userid);
		int UsersignDays = user.getUsersignDays();
		Date lastsignTime = user.getLastsignTime();
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
		Date Nowdate = new Date(l);
		//转换提日期输出格式
		System.out.println(Nowdate);
		//计算日期差
		int disparitytime = (int) ((Nowdate.getTime() - lastsignTime.getTime()) / (1000*3600*24));

		if(disparitytime>1) {
			System.out.println("=======");
			int a=us.updateusersign(userid,1);
			result.put("signindays", 1);
			int awardtime=Value.awardtime(1);
			result.put("awardtime", awardtime);
			result.put("istoday", true);
		}
		else if(disparitytime==0) {
			result.put("signindays", UsersignDays);
			int awardtime=Value.awardtime(UsersignDays);
			result.put("awardtime", awardtime);
			result.put("istoday", false);
		}
		else {
			int a=us.updateusersign(userid,UsersignDays+1);
			System.out.println("确实连续签到");
			result.put("signindays", UsersignDays+1);
			int awardtime=Value.awardtime(UsersignDays+1);
			result.put("awardtime", awardtime);
			result.put("istoday", true);
		}
		int a =us.usersignlasttime(userid,Nowdate);
		System.out.println("ssssssssssssssssssssss"+a);
		return result;

	

	}

	
	
	
	
	
	
	
	
	
	
	
	
}