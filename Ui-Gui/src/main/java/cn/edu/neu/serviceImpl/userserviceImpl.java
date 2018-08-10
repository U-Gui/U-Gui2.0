package cn.edu.neu.serviceImpl;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.User;
import cn.edu.neu.mapper.usermapper;
import cn.edu.neu.service.userservice;


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


	public Map<String, Object> getuserallrecord(BoxUseRecord bur){
		return user.getuserallrecord(bur);
	}


	public int updateusersign(String userId, int usersignDays) {
		
		return user.updateusersign(userId, usersignDays);
	}


	public int usersignlasttime(String userId,Date lastsignTime) {
		return user.usersignlasttime(userId, lastsignTime);
	}





}
