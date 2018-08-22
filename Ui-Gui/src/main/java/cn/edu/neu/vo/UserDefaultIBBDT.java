package cn.edu.neu.vo;

import java.sql.Date;

public class UserDefaultIBBDT {
	private String userId;
	private double userBalance;
	private long userBoxtime;
	private Integer usersignDays;
	private Date lastsignTime;
	public UserDefaultIBBDT() {}
	public UserDefaultIBBDT(String userId, double userBalance, long userBoxtime, Integer usersignDays,
			Date lastsignTime) {
		super();
		this.userId = userId;
		this.userBalance = userBalance;
		this.userBoxtime = userBoxtime;
		this.usersignDays = usersignDays;
		this.lastsignTime = lastsignTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
}
