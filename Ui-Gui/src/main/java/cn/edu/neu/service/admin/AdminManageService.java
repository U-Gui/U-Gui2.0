package cn.edu.neu.service.admin;

import cn.edu.neu.vo.UserWithoutMajorAndBoxUseRecord;
import cn.edu.neu.vo.backJSON;

public interface AdminManageService {

	public backJSON getSchools();

	public backJSON addSchool(String schoolName);

	public backJSON deleteSchool(int schoolId);

	public backJSON putSchool(Integer schoolId, String schoolName);

	public backJSON getSchoolById(Integer schoolId);

	public backJSON addMajor(Integer schoolId, String majorName);

	public backJSON deleteMajor(Integer majorId);

	public backJSON putMajor(Integer majorId, String majorName);

	public backJSON addCabinetLocation(Integer schoolId, String cabinetlocationName);

	public backJSON deleteCabinetLocation(Integer cabinetlocationId);

	public backJSON putCabinetLocation(Integer cabinetlocationId, String cabinetlocationName);

	public backJSON getCabinetLocations(Integer startIndex);
	
	public backJSON getCabinetsByLocation(Integer cabinetlocationId, Integer startindex);

	public backJSON addCabinet(Integer cabinetlocationId);

	public backJSON deleteCabinet(Integer cabinetId);

	public backJSON addBox(Integer cabinetId, Integer boxStatus, Integer boxType);

	public backJSON deleteBox(Integer boxId);

	public backJSON putBox(Integer boxId, Integer boxStatus, Integer boxType);

	public backJSON deleteBoxUseRecord(Integer recordId);

	public backJSON getBoxUseRecords(Integer startindex);

	public backJSON getUsers(Integer startindex);

	public backJSON getUserInfo(String userId);

	public backJSON deleteUser(String userId);

	public backJSON putUser(UserWithoutMajorAndBoxUseRecord user);	
	
}
