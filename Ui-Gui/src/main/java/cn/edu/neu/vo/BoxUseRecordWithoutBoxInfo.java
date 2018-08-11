package cn.edu.neu.vo;

import java.util.Date;

public class BoxUseRecordWithoutBoxInfo {
	private Integer recordId;
	private Integer boxId;
	private UserWithIdAndPhone user;
	private Date start_time;
	private Date end_time;
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getBoxId() {
		return boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public UserWithIdAndPhone getUser() {
		return user;
	}
	public void setUser(UserWithIdAndPhone user) {
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
	@Override
	public String toString() {
		return "BoxUseRecordWithoutBoxInfo [recordId=" + recordId + ", boxId=" + boxId + ", user=" + user
				+ ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
	public BoxUseRecordWithoutBoxInfo(Integer recordId, Integer boxId, UserWithIdAndPhone user, Date start_time,
			Date end_time) {
		super();
		this.recordId = recordId;
		this.boxId = boxId;
		this.user = user;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public BoxUseRecordWithoutBoxInfo() {
		super();
	}
}
