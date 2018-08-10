package cn.edu.neu.mapper.admin;

import java.util.List;

import cn.edu.neu.entity.School;
import cn.edu.neu.vo.schoolWithIdAndName;

public interface AdminManageMapper {

	public List<schoolWithIdAndName> getSchools();

	public int addSchool(String schoolName);

	public int deleteSchool(int schoolId);

	public int putSchool(Integer schoolId, String schoolName);

	public School getSchoolById(Integer schoolId);

}
