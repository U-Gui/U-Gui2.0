package cn.edu.neu.service;

import java.util.List;
import java.util.Map;

import cn.edu.neu.entity.BoxInfo;
import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.School;
import cn.edu.neu.entity.User;


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
	public void alterUserBoxTime(long userBoxTime, String userId);
	public void alterUserBalance(double userBalance, String userId);
	public void alterUseEndTime(long end_time, int boxId);
	public User getUserBBSD(String userId);
	
}
