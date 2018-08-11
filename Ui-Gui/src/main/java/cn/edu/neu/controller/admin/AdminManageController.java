package cn.edu.neu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.neu.service.admin.AdminManageService;
import cn.edu.neu.vo.UserWithoutMajorAndBoxUseRecord;
import cn.edu.neu.vo.backJSON;

@Controller
@RequestMapping("/admin/manage")
public class AdminManageController {

	@Autowired
	private AdminManageService adminManageService;
	
	//2.管理员查看所有学校信息表接口
	@ResponseBody
	@RequestMapping(value="/schools",method=RequestMethod.GET)
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
	
	//7.管理员添加学校的专业信息接口
	@ResponseBody
	@RequestMapping(value="/major/{schoolId}",method=RequestMethod.POST)
	public backJSON addMajor(@PathVariable("schoolId")Integer schoolId,@RequestParam("majorName")String majorName) {
		return adminManageService.addMajor(schoolId,majorName);
	}
	
	//8.管理员删除学校的指定专业
	@ResponseBody
	@RequestMapping(value = "/major/{majorId}",method = RequestMethod.DELETE)
	public backJSON deleteMajor(@PathVariable("majorId")Integer majorId) {
		return adminManageService.deleteMajor(majorId);
	}
	
	//9.管理员修改学校的指定专业
	@ResponseBody
	@RequestMapping(value="/major/{majorId}",method=RequestMethod.PUT)
	public backJSON putMajor(@PathVariable("majorId")Integer majorId,@RequestParam("majorName") String majorName) {
		return adminManageService.putMajor(majorId,majorName);
	}
	
	//10.管理员添加柜子存放地点
	@ResponseBody
	@RequestMapping(value="/cabinetlocation/{schoolId}",method=RequestMethod.POST)
	public backJSON addCabinetLocation(@PathVariable("schoolId")Integer schoolId,@RequestParam("cabinetlocationName")String cabinetlocationName) {
		return adminManageService.addCabinetLocation(schoolId,cabinetlocationName);
	}
	
	//11.管理员删除柜子存放地点
	@ResponseBody
	@RequestMapping(value="/cabinetlocation/{cabinetlocationId}",method=RequestMethod.DELETE)
	public backJSON deleteCabinetLocation(@PathVariable("cabinetlocationId")Integer cabinetlocationId) {
		return adminManageService.deleteCabinetLocation(cabinetlocationId);
	}
	
	//12.管理员修改柜子存放地点
	@ResponseBody
	@RequestMapping(value="/cabinetlocation/{cabinetlocationId}",method=RequestMethod.PUT)
	public backJSON putCabinetLocation(@PathVariable("cabinetlocationId")Integer cabinetlocationId,@RequestParam("cabinetlocationName")String cabinetlocationName) {
		return adminManageService.putCabinetLocation(cabinetlocationId,cabinetlocationName);
	}
	
	//13.管理员查看所有柜子地点列表（分页）,startindex为当前页数下标，默认返回10条数据
	@ResponseBody
	@RequestMapping(value="/cabinetlocations/{startindex}",method=RequestMethod.GET)
	public backJSON getCabinetLocations(@PathVariable("startindex")Integer startIndex) {
		return adminManageService.getCabinetLocations(startIndex);
	}
	
	//14.管理员查看所有柜子地点下的柜子列表（分页）
	@ResponseBody
	@RequestMapping(value="/cabinets/{cabinetlocationId}/{startindex}",method=RequestMethod.GET)
	public backJSON getCabinetsByLocation(@PathVariable("cabinetlocationId")Integer cabinetlocationId,@PathVariable("startindex")Integer startindex){
		return adminManageService.getCabinetsByLocation(cabinetlocationId,startindex);
	}
	
	//15.管理员在柜子地点下添加柜子
	@ResponseBody
	@RequestMapping(value="/cabinet/{cabinetlocationId}",method=RequestMethod.POST)
	public backJSON addCabinet(@PathVariable("cabinetlocationId")Integer cabinetlocationId) {
		return adminManageService.addCabinet(cabinetlocationId);
	}
	
	//16.管理员在柜子地点页面删除指定柜子
	@ResponseBody
	@RequestMapping(value="/cabinet/{cabinetId}",method=RequestMethod.DELETE)
	public backJSON deleteCabinet(@PathVariable("cabinetId")Integer cabinetId) {
		return adminManageService.deleteCabinet(cabinetId);
	}
	
	//17.管理员在指定柜子页面添加箱子
	@ResponseBody
	@RequestMapping(value="/box/{cabinetId}",method=RequestMethod.POST)
	public backJSON addBox(@PathVariable("cabinetId")Integer cabinetId,@RequestParam("boxStatus")Integer boxStatus,@RequestParam("boxType")Integer boxType) {
		return adminManageService.addBox(cabinetId,boxStatus,boxType);
	}
	
	//18.管理员在指定柜子页面删除箱子
	@ResponseBody
	@RequestMapping(value="/box/{boxId}",method=RequestMethod.DELETE)
	public backJSON deleteBox(@PathVariable("boxId")Integer boxId) {
		return adminManageService.deleteBox(boxId);
	}
	
	//19.管理员在指定柜子页面修改箱子信息
	@ResponseBody
	@RequestMapping(value="/box/{boxId}",method=RequestMethod.PUT)
	public backJSON putBox(@PathVariable("boxId")Integer boxId,@RequestParam("boxStatus")Integer boxStatus,@RequestParam("boxType")Integer boxType) {
		return adminManageService.putBox(boxId,boxStatus,boxType);
	}
	
	//20.管理员在使用记录页面删除记录
	@ResponseBody
	@RequestMapping(value="/boxuserecord/{recordId}",method=RequestMethod.DELETE)
	public backJSON deleteBoxUseRecord(@PathVariable("recordId")Integer recordId) {
		return adminManageService.deleteBoxUseRecord(recordId);
	}
	
	//21.管理员查看箱子使用记录（分页）
	@ResponseBody
	@RequestMapping(value="/boxuserecords/{startindex}",method=RequestMethod.GET)
	public backJSON getBoxUseRecords(@PathVariable("startindex")Integer startindex) {
		return adminManageService.getBoxUseRecords(startindex);
	}
	
	//22.管理员查看所有用户信息列表（分页）
	@ResponseBody
	@RequestMapping(value="/users/{startindex}",method=RequestMethod.GET)
	public backJSON getUsers(@PathVariable("startindex")Integer startindex) {
		return adminManageService.getUsers(startindex);
	}
	
	//23.管理员查看用户信息详情
	@ResponseBody
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public backJSON getUserInfo(@PathVariable("userId")String userId) {
		return adminManageService.getUserInfo(userId);
	}
	
	//24.管理员删除用户
	@ResponseBody
	@RequestMapping(value="/user/{userId}",method=RequestMethod.DELETE)
	public backJSON deleteUser(@PathVariable("userId")String userId) {
		return adminManageService.deleteUser(userId);
	}
	
	//25.管理员修改用户信息
	@ResponseBody
	@RequestMapping(value="/user/{userId}",method=RequestMethod.PUT)
	public backJSON putUser(UserWithoutMajorAndBoxUseRecord user,@PathVariable("userId")String userId) {
		user.setUserId(userId);
		return adminManageService.putUser(user);
	}
}
