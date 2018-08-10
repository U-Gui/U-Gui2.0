package cn.edu.neu.controller.admin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.neu.service.admin.AdminOptionsService;
import cn.edu.neu.vo.backJSON;

/*
 * @Author Jack汪喆
 * 对管理员基本操作的请求接收
 */
@Controller
@RequestMapping("/admin/options")
public class AdminOptionsController {

	@Autowired
	private AdminOptionsService adminOptionService;
	
	//用户登录请求处理
	@ResponseBody
	@RequestMapping("/login")
	public backJSON login(@RequestParam("adminId")String adminId,@RequestParam("adminPassword")String adminPassword) {
		try {
			return adminOptionService.findAdmin(adminId,adminPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new backJSON(2222,"信息验证失败，请重新登录！");
	}
	
	
	
}
