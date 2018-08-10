package cn.edu.neu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.User;
import cn.edu.neu.service.userservice;

@Controller
@RequestMapping("user/getuser")
public class Con_user_getuser {

	@Autowired
	userservice us;

	/** 用户租用记录
	 * url: http://localhost:8080/Ui-Gui/user/getuser/allrecord?userId=123
	 * 
	 * @param user
	 * @return
	 * 
	 */

	@RequestMapping("allrecord")
	@ResponseBody

	public Map<String, Object> allrecord(User user) {
		BoxUseRecord BUR = new BoxUseRecord();
		Map<String, Object> result = new HashMap<String, Object>();
		BUR.setUser(user);
		System.out.println("+++++" + BUR);
		try {
			result = us.getuserallrecord(BUR);
			System.out.println("-----" + result);
			result.remove("userId");
			result.remove("recordId");
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	

	
	

}
