package cn.edu.neu.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.User;
import cn.edu.neu.mapper.usermapper;
import cn.edu.neu.service.userservice;
import cn.edu.neu.vo.UserDefaultIBBDT;


@Service
public class userserviceImpl implements userservice {

	    @Autowired
       private usermapper user;
	
	
	public User finduserbyuserId(String userId) {
		
		 
		return user.finduserbyuserId(userId);
		
	}


	public int adduserbyuserId(String userId) {
		return user.adduserbyuserId(userId);
	}


	public int registeruserbyuserId(String userId, String userPhone, int userMajorId, int userSix) {
		  
		return user.registeruserbyuserId(userId, userPhone, userMajorId, userSix);
	}


	public int updateuserinfo(User use) {
		
		return user.updateuserinfo(use);
		
	}


	public List<Map<String, Object>> getuserallrecord(BoxUseRecord bur){
		return user.getuserallrecord(bur);
	}


	public int updateusersign(String userId, int usersignDays) {
		
		return user.updateusersign(userId, usersignDays);
	}


	public int usersignlasttime(String userId,Date lastsignTime) {
		return user.usersignlasttime(userId, lastsignTime);
	}


	public void addUserDefaultInfo(UserDefaultIBBDT userDefault) {
		user.addUserDefaultInfo(userDefault);
	}





}
