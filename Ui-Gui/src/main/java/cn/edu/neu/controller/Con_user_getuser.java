package cn.edu.neu.controller;

import java.util.List;
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

	/*
	 * 2018.8.22
	 * bc修改
	 * 返回结果，原来的Map,应该为List<Map>,每个人不只一条记录
	 */
	public List<Map<String, Object>> allrecord(User user) {
		BoxUseRecord BUR = new BoxUseRecord();
		BUR.setUuser(user);
		try {
			return us.getuserallrecord(BUR);
		} catch (Exception e) {
			return null;
		}
	}
	

	
	

}
