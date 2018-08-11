package cn.edu.neu.vo;

import java.sql.Date;

public class UserWithoutMajorAndBoxUseRecord {
	private String userId;
	private String userPhone;
	private Integer userSex;
	private double userBalance;
	private long userBoxtime;
	private Integer userMajorId;
	private Integer usersignDays;
	private Date lastsignTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public double getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}
	public long getUserBoxtime() {
		return userBoxtime;
	}
	public void setUserBoxtime(long userBoxtime) {
		this.userBoxtime = userBoxtime;
	}
	public Integer getUserMajorId() {
		return userMajorId;
	}
	public void setUserMajorId(Integer userMajorId) {
		this.userMajorId = userMajorId;
	}
	public Integer getUsersignDays() {
		return usersignDays;
	}
	public void setUsersignDays(Integer usersignDays) {
		this.usersignDays = usersignDays;
	}
	public Date getLastsignTime() {
		return lastsignTime;
	}
	public void setLastsignTime(Date lastsignTime) {
		this.lastsignTime = lastsignTime;
	}
	@Override
	public String toString() {
		return "UserWithoutMajorAndBoxUserRecord [userId=" + userId + ", userPhone=" + userPhone + ", userSex="
				+ userSex + ", userBalance=" + userBalance + ", userBoxtime=" + userBoxtime + ", userMajorId="
				+ userMajorId + ", usersignDays=" + usersignDays + ", lastsignTime=" + lastsignTime + "]";
	}
	public UserWithoutMajorAndBoxUseRecord(String userId, String userPhone, Integer userSex, double userBalance,
			long userBoxtime, Integer userMajorId, Integer usersignDays, Date lastsignTime) {
		super();
		this.userId = userId;
		this.userPhone = userPhone;
		this.userSex = userSex;
		this.userBalance = userBalance;
		this.userBoxtime = userBoxtime;
		this.userMajorId = userMajorId;
		this.usersignDays = usersignDays;
		this.lastsignTime = lastsignTime;
	}
	public UserWithoutMajorAndBoxUseRecord() {
		super();
	}
}
