package cn.edu.neu.serviceImpl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.entity.School;
import cn.edu.neu.mapper.admin.AdminManageMapper;
import cn.edu.neu.service.admin.AdminManageService;
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

}
