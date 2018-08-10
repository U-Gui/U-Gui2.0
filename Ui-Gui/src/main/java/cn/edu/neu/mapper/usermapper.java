package cn.edu.neu.mapper;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.User;

public interface usermapper {
	User finduserbyuserId(String userId);

	int adduserbyuserId(String userId);

	int registeruserbyuserId(String userId, String userPhone, int userMajorId, int userSix);

	int updateuserinfo(@Param("user")User use);
	
	Map<String, Object> getuserallrecord(BoxUseRecord bur);
	int updateusersign(@Param("userId")String userId,@Param("usersignDays")int usersignDays);
	int usersignlasttime(@Param("userId")String userId,@Param("lastsignTime")Date lastsignTime);
}
