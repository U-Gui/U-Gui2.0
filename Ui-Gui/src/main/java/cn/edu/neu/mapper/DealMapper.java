package cn.edu.neu.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.neu.entity.BoxInfo;
import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.PayRecord;
import cn.edu.neu.entity.School;
import cn.edu.neu.entity.User;
import cn.edu.neu.vo.MajorWithIdAndName;
import cn.edu.neu.vo.schoolWithIdAndName;

public interface DealMapper {
	
	List<Map<String, Object>> getCabinetIdOften(@Param("userId")String userId, @Param("size")int size);
	List<Map<String, Object>> offCabinetInfoOften(List<Map<String, Object>> list);
	List<Integer> getUserSchoolCabLocIds(String userId);
	List<Map<String, Object>> offgetCabinetInfoUserSchool(Map<String, Object> map);
	List<Map<String, Object>> offCabinetInfoAll(@Param("startLocation")int startLocation, @Param("offSize")int offSize);
	List<School> offAllSchoolHaveCabinet();
	List<Map<String, Object>> offCabinetLocbySchoolId(int schoolId);
	Map<String, Object> offCabinetFreenum(int cabinetId);
	List<BoxInfo> getBoxbyCabinetId(int cabinetId);
	List<Integer> getBoxbyCabinetandType(int cabinetId,int boxType);
	User getUserIBB(String userId);
	BoxInfo getBoxIS(int boxId);
	void alterBoxStatus(int boxStatus, int boxId);
	void addBoxUseRecord(BoxUseRecord boxUseRecord);
	List<Map<String, Object>> offOnUseAll(String userId);
	Integer ifUseExist(String userid, int boxid);
	void alterUserBoxTime(@Param("userBoxtime")long userBoxTime, @Param("userId")String userId);
	void alterUserBalance(@Param("userBalance")double userBalance, @Param("userId")String userId);
	int payUpdateBalance(@Param("money") double money, @Param("userId")String userid);
	void alterUseEndTime(@Param("end_time")Timestamp end_time, @Param("boxId")int boxId);
	User getUserBBSD(@Param("userId")String userId);
	List<schoolWithIdAndName> getAllSchool();
	List<MajorWithIdAndName> getAllMajorbySchoolId(int schoolId);
	int newPayRecord(PayRecord payRecord);
	Map<String, Object> getPayTotalfee(String openid, String out_trade_no);
	int updatePayRecord(String bank_type, String transaction_id, String time_end, String out_trade_no);
	int ifUserIn(String userId);
	
}
