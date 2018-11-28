package cn.edu.neu.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import cn.edu.neu.entity.BoxInfo;
import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.PayRecord;
import cn.edu.neu.entity.School;
import cn.edu.neu.entity.User;
import cn.edu.neu.vo.MajorWithIdAndName;
import cn.edu.neu.vo.schoolWithIdAndName;


public interface DealService {
	
	public List<Map<String, Object>> getCabinetIdOften(String userId, int size);
	public List<Map<String, Object>> offCabinetInfoOften(List<Map<String, Object>> list);
	public List<Integer> getUserSchoolCabLocIds(String userId);
	public List<Map<String, Object>> offgetCabinetInfoUserSchool(Map<String, Object> map);
	public List<Map<String, Object>> offCabinetInfoAll(int startLocation, int offSize);
	public List<School> offAllSchoolHaveCabinet();
	public List<Map<String, Object>> offCabinetLocbySchoolId(int schoolId);
	public Map<String, Object> offCabinetFreenum(int cabinetId);
	public List<BoxInfo> getBoxbyCabinetId(int cabinetId);
	public List<Integer> getBoxbyCabinetandType(int cabinetId,int boxType);
	public User getUserIBB(String userId);
	public BoxInfo getBoxIS(int boxId);
	public void alterBoxStatus(int boxStatus, int boxId);
	public void addBoxUseRecord(BoxUseRecord boxUseRecord);
	public List<Map<String, Object>> offOnUseAll(String userId);
	public boolean ifUseExist(String userid, int boxid);
	public void alterUserBoxTime(long userBoxTime, String userId);
	public void alterUserBalance(double userBalance, String userId);
	public boolean payUpdateBalance(double money, String userid);
	public void alterUseEndTime(Timestamp end_time, int boxId);
	public User getUserBBSD(String userId);
	public List<schoolWithIdAndName> getAllSchool();
	public List<MajorWithIdAndName> getAllMajorbySchoolId(int schoolId);
	boolean newPayRecord(PayRecord payRecord);
	Map<String, Object> getPayTotalfee(String openid, String out_trade_no);
	boolean updatePayRecord(String bank_type, String transaction_id, String time_end, String out_trade_no);
	boolean ifUserIn(String userId);
	
}
