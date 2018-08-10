package cn.edu.neu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.neu.service.admin.AdminManageService;
import cn.edu.neu.vo.backJSON;

@Controller
@RequestMapping("/admin/manage")
public class AdminManageController {

	@Autowired
	private AdminManageService adminManageService;
	
	//2.管理员查看所有学校信息表接口
	@ResponseBody
	@RequestMapping("/schools")
	public backJSON getSchools() {
		return adminManageService.getSchools();
	}
	
	//3.管理员添加学校接口
	@ResponseBody
	@RequestMapping(value="/school",method=RequestMethod.POST)
	public backJSON addSchool(@RequestParam("schoolName")String schoolName){
		return adminManageService.addSchool(schoolName);
	}
	
	//4.管理员删除学校名称接口
	@ResponseBody
	@RequestMapping(value="/school/{schoolId}",method=RequestMethod.DELETE)
	public backJSON deleteSchool(@PathVariable("schoolId")Integer schoolId) {
		return adminManageService.deleteSchool(schoolId);
	}
	
	//5.管理员修改学校名称接口
	@ResponseBody
	@RequestMapping(value="/school/{schoolId}",method=RequestMethod.PUT)
	public backJSON putSchool(@PathVariable("schoolId")Integer schoolId,@RequestParam("schoolName")String schoolName) {
		return adminManageService.putSchool(schoolId,schoolName);
	}
	
	//6.管理员查看学校信息接口——Mybatis应用嵌套查询
	@ResponseBody
	@RequestMapping(value="/school/{schoolId}",method=RequestMethod.GET)
	public backJSON getSchool(@PathVariable("schoolId")Integer schoolId) {
		return adminManageService.getSchoolById(schoolId);
	}
	
}
