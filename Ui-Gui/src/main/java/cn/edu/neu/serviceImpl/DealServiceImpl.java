package cn.edu.neu.serviceImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.neu.entity.BoxInfo;
import cn.edu.neu.entity.BoxUseRecord;
import cn.edu.neu.entity.PayRecord;
import cn.edu.neu.entity.School;
import cn.edu.neu.entity.User;
import cn.edu.neu.mapper.DealMapper;
import cn.edu.neu.service.DealService;
import cn.edu.neu.vo.MajorWithIdAndName;
import cn.edu.neu.vo.schoolWithIdAndName;

@Service
public class DealServiceImpl implements DealService {

	@Autowired
	private DealMapper dealMapper;
	
	public List<Map<String, Object>> getCabinetIdOften(String userId, int size) {
		return dealMapper.getCabinetIdOften(userId, size);
	}
	public List<Map<String, Object>> offCabinetInfoOften(List<Map<String, Object>> list) {
		return dealMapper.offCabinetInfoOften(list);
	}
	public List<Integer> getUserSchoolCabLocIds(String userId) {
		return dealMapper.getUserSchoolCabLocIds(userId);
	}
	public List<Map<String, Object>> offgetCabinetInfoUserSchool(Map<String, Object> map) {
		return dealMapper.offgetCabinetInfoUserSchool(map);
	}
	public List<Map<String, Object>> offCabinetInfoAll(int startLocation, int offSize) {
		return dealMapper.offCabinetInfoAll(startLocation, offSize);
	}
	public List<School> offAllSchoolHaveCabinet() {
		return dealMapper.offAllSchoolHaveCabinet();
	}
	public List<Map<String, Object>> offCabinetLocbySchoolId(int schoolId) {
		return dealMapper.offCabinetLocbySchoolId(schoolId);
	}
	public Map<String, Object> offCabinetFreenum(int cabinetId) {
		return dealMapper.offCabinetFreenum(cabinetId);
	}
	public List<BoxInfo> getBoxbyCabinetId(int cabinetId) {
		return dealMapper.getBoxbyCabinetId(cabinetId);
	}
	public List<Integer> getBoxbyCabinetandType(int cabinetId, int boxType) {
		return dealMapper.getBoxbyCabinetandType(cabinetId, boxType);
	}
	public User getUserIBB(String userId) {
		return dealMapper.getUserIBB(userId);
	}
	public BoxInfo getBoxIS(int boxId) {
		return dealMapper.getBoxIS(boxId);
	}
	public void alterBoxStatus(int boxStatus, int boxId) {
		dealMapper.alterBoxStatus(boxStatus, boxId);
	}
	public void addBoxUseRecord(BoxUseRecord boxUseRecord) {
		dealMapper.addBoxUseRecord(boxUseRecord);
	}
	public List<Map<String, Object>> offOnUseAll(String userId) {
		return dealMapper.offOnUseAll(userId);
	}
	public boolean ifUseExist(String userid, int boxid) {
		if(dealMapper.ifUseExist(userid, boxid)==null)
			return false;
		return true;
	}
	public void alterUserBoxTime(long userBoxTime, String userId) {
		dealMapper.alterUserBoxTime(userBoxTime, userId);
	}
	public void alterUserBalance(double userBalance, String userId) {
		dealMapper.alterUserBalance(userBalance, userId);
	}
	public boolean payUpdateBalance(double money, String userid) {
		if((dealMapper.payUpdateBalance(money, userid))==1)
			return true;
		return false;
	}
	public void alterUseEndTime(Timestamp end_time, int boxId) {
		dealMapper.alterUseEndTime(end_time, boxId);
	}
	public User getUserBBSD(String userId) {
		return dealMapper.getUserBBSD(userId);
	}
	public List<schoolWithIdAndName> getAllSchool() {
		return dealMapper.getAllSchool();
	}
	public List<MajorWithIdAndName> getAllMajorbySchoolId(int schoolId) {
		return dealMapper.getAllMajorbySchoolId(schoolId);
	}
	public boolean newPayRecord(PayRecord payRecord) {
		if(dealMapper.newPayRecord(payRecord)==1)
			return true;
		return false;
	}
	public Map<String, Object> getPayTotalfee(String openid, String out_trade_no) {
		return dealMapper.getPayTotalfee(openid, out_trade_no);
	}
	public boolean updatePayRecord(String bank_type, String transaction_id, String time_end, String out_trade_no) {
		if(dealMapper.updatePayRecord(bank_type, transaction_id, time_end, out_trade_no)==1)
			return true;
		return false;
	}

}
