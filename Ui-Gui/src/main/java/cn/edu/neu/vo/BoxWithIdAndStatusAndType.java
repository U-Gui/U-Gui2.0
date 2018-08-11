package cn.edu.neu.vo;

public class BoxWithIdAndStatusAndType {
	private int boxId;
	private int boxStatus;
	private int boxType;
	public int getBoxId() {
		return boxId;
	}
	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}
	public int getBoxStatus() {
		return boxStatus;
	}
	public void setBoxStatus(int boxStatus) {
		this.boxStatus = boxStatus;
	}
	public int getBoxType() {
		return boxType;
	}
	public void setBoxType(int boxType) {
		this.boxType = boxType;
	}
	@Override
	public String toString() {
		return "BoxWithIdAndStatusAndType [boxId=" + boxId + ", boxStatus=" + boxStatus + ", boxType=" + boxType + "]";
	}
	public BoxWithIdAndStatusAndType(int boxId, int boxStatus, int boxType) {
		super();
		this.boxId = boxId;
		this.boxStatus = boxStatus;
		this.boxType = boxType;
	}
	public BoxWithIdAndStatusAndType() {
		super();
	}
}
