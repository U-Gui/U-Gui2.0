package cn.edu.neu.service;


import java.util.Date;
import java.util.Map;


import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.User;

public interface userservice {
	User finduserbyuserId(String userId);
	int adduserbyuserId(String userId);
	int registeruserbyuserId(String userId,String userPhone,int userMajorId,int userSix);
	int updateuserinfo(User use);
	Map<String, Object> getuserallrecord(BoxUseRecord bur);
	int updateusersign(String userId,int usersignDays);
	int usersignlasttime(String userId,Date lastsignTime);
}
