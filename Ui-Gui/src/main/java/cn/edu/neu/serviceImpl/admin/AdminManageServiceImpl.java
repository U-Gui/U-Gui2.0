package cn.edu.neu.serviceImpl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.edu.neu.entity.CabinetLocation;
import cn.edu.neu.entity.School;
import cn.edu.neu.mapper.admin.AdminManageMapper;
import cn.edu.neu.service.admin.AdminManageService;
import cn.edu.neu.vo.BoxUseRecordWithoutBoxInfo;
import cn.edu.neu.vo.CabinetLocationWithAll;
import cn.edu.neu.vo.UserWithoutBoxInfo;
import cn.edu.neu.vo.UserWithoutMajorAndBoxUseRecord;
import cn.edu.neu.vo.backJSON;
import cn.edu.neu.vo.schoolWithIdAndName;

@Service
public class AdminManageServiceImpl implements AdminManageService {
	
	@Autowired
	private AdminManageMapper adminManageMapper;

	public backJSON getSchools() {
		backJSON back = new backJSON();
		back.setCode(200);
		List<schoolWithIdAndName> allSchools = adminManageMapper.getSchools();
		Map<String,List<schoolWithIdAndName>> schools = new HashMap<String,List<schoolWithIdAndName>>();
		schools.put("schools", allSchools);
		back.setData(schools);
		return back;
	}

	public backJSON addSchool(String schoolName) {
		backJSON back = new backJSON();
		int status = adminManageMapper.addSchool(schoolName);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON deleteSchool(int schoolId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.deleteSchool(schoolId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON putSchool(Integer schoolId, String schoolName) {
		backJSON back = new backJSON();
		int status = adminManageMapper.putSchool(schoolId,schoolName);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON getSchoolById(Integer schoolId) {
		backJSON back = new backJSON();
		School school = adminManageMapper.getSchoolById(schoolId);
		if(school!=null) {
			back.setCode(200);
			Map<String,Object> schoolInfo = new HashMap<String,Object>();
			schoolInfo.put("schoolId",school.getSchoolId());
			schoolInfo.put("schoolName",school.getSchoolName());
			schoolInfo.put("majors",school.getMajors());
			schoolInfo.put("cabinets",school.getCabinetLocations());
			back.setData(schoolInfo);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON addMajor(Integer schoolId, String majorName) {
		backJSON back = new backJSON();
		int status = adminManageMapper.addMajor(schoolId,majorName);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON deleteMajor(Integer majorId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.deleteMajor(majorId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON putMajor(Integer majorId, String majorName) {
		backJSON back = new backJSON();
		int status = adminManageMapper.putMajor(majorId,majorName);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON addCabinetLocation(Integer schoolId, String cabinetlocationName) {
		backJSON back = new backJSON();
		int status = adminManageMapper.addCabinetLocation(schoolId,cabinetlocationName);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON deleteCabinetLocation(Integer cabinetlocationId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.deleteCabinetLocation(cabinetlocationId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON putCabinetLocation(Integer cabinetlocationId,String cabinetlocationName) {
		backJSON back = new backJSON();
		int status = adminManageMapper.putCabinetLocation(cabinetlocationId,cabinetlocationName);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON getCabinetLocations(Integer startIndex) {
		backJSON back = new backJSON();
		int searchStartIndex = (startIndex-1)*10;
		List<CabinetLocation> cabinetLocations = adminManageMapper.getCabinetLocations(searchStartIndex);
		if(cabinetLocations!=null) {
			back.setCode(200);
			Map<String,List<CabinetLocation>> dataResult = new HashMap<String,List<CabinetLocation>>();
			dataResult.put("cabinetlocations",cabinetLocations);
			back.setData(dataResult);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}
	
	public backJSON getCabinetsByLocation(Integer cabinetlocationId, Integer startIndex) {
		backJSON back = new backJSON();
		int searchStartIndex = (startIndex-1)*10;
		CabinetLocationWithAll cabinetsByLocation = adminManageMapper.getCabinetsByLocation(cabinetlocationId,searchStartIndex);
		if(cabinetsByLocation!=null) {
			back.setCode(200);
			back.setData(cabinetsByLocation);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON addCabinet(Integer cabinetlocationId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.addCabinet(cabinetlocationId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON deleteCabinet(Integer cabinetId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.deleteCabinet(cabinetId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON addBox(Integer cabinetId, Integer boxStatus, Integer boxType) {
		backJSON back = new backJSON();
		int status = adminManageMapper.addBox(cabinetId, boxStatus, boxType);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON deleteBox(Integer boxId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.deleteBox(boxId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON putBox(Integer boxId, Integer boxStatus, Integer boxType) {
		backJSON back = new backJSON();
		int status = adminManageMapper.putBox(boxId,boxStatus,boxType);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON deleteBoxUseRecord(Integer recordId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.deleteBoxUseRecord(recordId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON getBoxUseRecords(Integer startIndex) {
		backJSON back = new backJSON();
		int searchStartIndex = (startIndex-1)*10;
		List<BoxUseRecordWithoutBoxInfo> boxUseRecords = adminManageMapper.getBoxUseRecords(searchStartIndex);
		if(boxUseRecords!=null) {
			back.setCode(200);
			back.setData(boxUseRecords);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON getUsers(Integer startIndex) {
		backJSON back = new backJSON();
		int searchStartIndex = (startIndex-1)*10;
		List<UserWithoutMajorAndBoxUseRecord> users = adminManageMapper.getUsers(searchStartIndex);
		if(users!=null) {
			back.setCode(200);
			Map<String,List<UserWithoutMajorAndBoxUseRecord>> results = new HashMap<String,List<UserWithoutMajorAndBoxUseRecord>>();
			results.put("users", users);
			back.setData(results);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON getUserInfo(String userId) {
		backJSON back = new backJSON();
		UserWithoutBoxInfo user = adminManageMapper.getUserInfo(userId);
		if(user!=null) {
			back.setCode(200);
			back.setData(user);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON deleteUser(String userId) {
		backJSON back = new backJSON();
		int status = adminManageMapper.deleteUser(userId);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

	public backJSON putUser(UserWithoutMajorAndBoxUseRecord user) {
		backJSON back = new backJSON();
		int status = adminManageMapper.putUser(user);
		if(status!=0) {
			back.setCode(200);
		}else {
			back.setCode(1001);
			back.setData("操作失败");
		}
		return back;
	}

}
