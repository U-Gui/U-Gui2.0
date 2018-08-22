package cn.edu.neu.entity;

import java.util.Date;

import cn.edu.neu.vo.UserWithIdAndName;

public class BoxUseRecord {
	private Integer recordId;
	private BoxInfo boxInfo;
	private UserWithIdAndName user;
	private Date start_time;
	private Date end_time;
	private User uuser;
	public BoxUseRecord(Integer recordId, BoxInfo boxInfo, UserWithIdAndName user, Date start_time, Date end_time) {
		super();
		this.recordId = recordId;
		this.boxInfo = boxInfo;
		this.user = user;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public BoxUseRecord(BoxInfo boxInfo, Date start_time, Date end_time, User uuser) {
		super();
		this.boxInfo = boxInfo;
		this.start_time = start_time;
		this.end_time = end_time;
		this.uuser = uuser;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public BoxInfo getBoxInfo() {
		return boxInfo;
	}

	public void setBoxInfo(BoxInfo boxInfo) {
		this.boxInfo = boxInfo;
	}

	public UserWithIdAndName getUser() {
		return user;
	}

	public void setUser(UserWithIdAndName user) {
		this.user = user;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public BoxUseRecord() {
		super();
	}

	public User getUuser() {
		return uuser;
	}

	public void setUuser(User uuser) {
		this.uuser = uuser;
	}
	
}
