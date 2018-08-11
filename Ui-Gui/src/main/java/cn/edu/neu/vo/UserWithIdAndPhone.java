package cn.edu.neu.vo;

public class UserWithIdAndPhone {
	private String userId;
	private String userPhone;
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
	@Override
	public String toString() {
		return "UserWithIdAndPhone [userId=" + userId + ", userPhone=" + userPhone + "]";
	}
	public UserWithIdAndPhone(String userId, String userPhone) {
		super();
		this.userId = userId;
		this.userPhone = userPhone;
	}
	public UserWithIdAndPhone() {
		super();
	}
}
