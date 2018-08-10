package cn.edu.neu.entity;

public class BoxUseRecord {
	private Integer recordId;
	private BoxInfo boxInfo;
	private User user;
	private long start_time;
	private long end_time;
	public BoxUseRecord() {}
	public BoxUseRecord(Integer recordId, BoxInfo boxInfo, User user, long start_time) {
		super();
		this.recordId = recordId;
		this.boxInfo = boxInfo;
		this.user = user;
		this.start_time = start_time;
	}
	public BoxUseRecord(Integer recordId, BoxInfo boxInfo, User user, long start_time, long end_time) {
		super();
		this.recordId = recordId;
		this.boxInfo = boxInfo;
		this.user = user;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public BoxUseRecord(BoxInfo boxInfo, User user, long start_time, long end_time) {
		super();
		this.boxInfo = boxInfo;
		this.user = user;
		this.start_time = start_time;
		this.end_time = end_time;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getStart_time() {
		return start_time;
	}
	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	@Override
	public String toString() {
		return "BoxUseRecord [recordId=" + recordId + ", boxInfo=" + boxInfo + ", user=" + user + ", start_time="
				+ start_time + ", end_time=" + end_time + "]";
	}
}
