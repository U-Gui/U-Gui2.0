package cn.edu.neu.vo;

public class UserWithIdAndName {
	private String userId;
	private String userName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserWithIdAndName [userId=" + userId + ", userName=" + userName + "]";
	}
	public UserWithIdAndName(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	public UserWithIdAndName() {
		super();
	}
}
