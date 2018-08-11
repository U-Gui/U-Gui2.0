package cn.edu.neu.mapper.admin;

import java.util.List;

import cn.edu.neu.entity.CabinetLocation;
import cn.edu.neu.entity.School;
import cn.edu.neu.vo.BoxUseRecordWithoutBoxInfo;
import cn.edu.neu.vo.CabinetLocationWithAll;
import cn.edu.neu.vo.UserWithoutBoxInfo;
import cn.edu.neu.vo.UserWithoutMajorAndBoxUseRecord;
import cn.edu.neu.vo.schoolWithIdAndName;

public interface AdminManageMapper {

	public List<schoolWithIdAndName> getSchools();

	public int addSchool(String schoolName);

	public int deleteSchool(int schoolId);

	public int putSchool(Integer schoolId, String schoolName);

	public School getSchoolById(Integer schoolId);

	public int addMajor(Integer schoolId, String majorName);

	public int deleteMajor(Integer majorId);

	public int putMajor(Integer majorId, String majorName);

	public int addCabinetLocation(Integer schoolId, String cabinetlocationName);

	public int deleteCabinetLocation(Integer cabinetlocationId);

	public int putCabinetLocation(Integer cabinetlocationId, String cabinetlocationName);

	public List<CabinetLocation> getCabinetLocations(int searchStartIndex);

	public int addCabinet(Integer cabinetlocationId);

	public int deleteCabinet(Integer cabinetId);

	public int addBox(int cabinetId, Integer boxStatus, Integer boxType);

	public int deleteBox(Integer boxId);

	public int putBox(Integer boxId, Integer boxStatus, Integer boxType);

	public int deleteBoxUseRecord(Integer recordId);

	public List<BoxUseRecordWithoutBoxInfo> getBoxUseRecords(int searchStartIndex);

	public List<UserWithoutMajorAndBoxUseRecord> getUsers(int searchStartIndex);

	public UserWithoutBoxInfo getUserInfo(String userId);

	public int deleteUser(String userId);

	public int putUser(UserWithoutMajorAndBoxUseRecord user);

	public CabinetLocationWithAll getCabinetsByLocation(Integer cabinetlocationId, int searchStartIndex);

}
