package cn.edu.neu.entity;

import java.util.List;

public class BoxInfo {
	private Integer boxId;
	private Integer boxStatus;
	private Integer boxType;
	private Cabinet cabinet;
	private List<BoxUseRecord> boxUseRecords;
	public BoxInfo() {}
	public BoxInfo(Integer boxId, Integer boxStatus, Integer boxType) {
		super();
		this.boxId = boxId;
		this.boxStatus = boxStatus;
		this.boxType = boxType;
	}
	public BoxInfo(Integer boxId, Integer boxStatus, Integer boxType, Cabinet cabinet) {
		super();
		this.boxId = boxId;
		this.boxStatus = boxStatus;
		this.boxType = boxType;
		this.cabinet = cabinet;
	}
	public BoxInfo(Integer boxId, Integer boxStatus, Integer boxType, Cabinet cabinet, List<BoxUseRecord> boxUseRecords) {
		super();
		this.boxId = boxId;
		this.boxStatus = boxStatus;
		this.boxType = boxType;
		this.cabinet = cabinet;
		this.boxUseRecords = boxUseRecords;
	}
	public BoxInfo(Integer boxId, Integer boxType) {
		super();
		this.boxId = boxId;
		this.boxType = boxType;
	}
	public Integer getBoxId() {
		return boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public Integer getBoxStatus() {
		return boxStatus;
	}
	public void setBoxStatus(Integer boxStatus) {
		this.boxStatus = boxStatus;
	}
	public Integer getBoxType() {
		return boxType;
	}
	public void setBoxType(Integer boxType) {
		this.boxType = boxType;
	}
	public Cabinet getCabinet() {
		return cabinet;
	}
	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}
	public List<BoxUseRecord> getBoxUseRecords() {
		return boxUseRecords;
	}
	public void setBoxUseRecords(List<BoxUseRecord> boxUseRecords) {
		this.boxUseRecords = boxUseRecords;
	}
}
