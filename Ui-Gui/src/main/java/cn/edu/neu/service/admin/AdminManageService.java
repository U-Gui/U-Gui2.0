package cn.edu.neu.service.admin;

import cn.edu.neu.vo.backJSON;

public interface AdminManageService {

	public backJSON getSchools();

	public backJSON addSchool(String schoolName);

	public backJSON deleteSchool(int schoolId);

	public backJSON putSchool(Integer schoolId, String schoolName);

	public backJSON getSchoolById(Integer schoolId);
	
}
