package cn.edu.neu.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.User;
import cn.edu.neu.vo.UserDefaultIBBDT;

public interface usermapper {
	User finduserbyuserId(String userId);

	int adduserbyuserId(String userId);

	int registeruserbyuserId(String userId, String userPhone, int userMajorId, int userSix);

	int updateuserinfo(@Param("user")User use);
	
	List<Map<String, Object>> getuserallrecord(BoxUseRecord bur);
	int updateusersign(@Param("userId")String userId,@Param("usersignDays")int usersignDays);
	int usersignlasttime(@Param("userId")String userId,@Param("lastsignTime")Date lastsignTime);
	
	void addUserDefaultInfo(UserDefaultIBBDT userDefault);
	
}
