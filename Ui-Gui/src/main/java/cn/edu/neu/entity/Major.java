package cn.edu.neu.entity;

import java.util.List;

public class Major {
	private Integer majorId;
	private String majorName;
	private School school;
	private List<User> users;
	public Major() {}
	public Major(Integer majorId, String majorName) {
		super();
		this.majorId = majorId;
		this.majorName = majorName;
	}
	public Major(Integer majorId, String majorName, School school) {
		super();
		this.majorId = majorId;
		this.majorName = majorName;
		this.school = school;
	}
	public Major(Integer majorId, String majorName, School school, List<User> users) {
		super();
		this.majorId = majorId;
		this.majorName = majorName;
		this.school = school;
		this.users = users;
	}
	public Integer getMajorId() {
		return majorId;
	}
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Major [majorId=" + majorId + ", majorName=" + majorName + ", school=" + school + ", users=" + users
				+ "]";
	}
}
