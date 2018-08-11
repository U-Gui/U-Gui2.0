package cn.edu.neu.vo;

import java.util.List;

public class CabinetWithIdAndBoxs {
	private int cabinetId;
	private List<BoxWithIdAndStatusAndType> boxs;
	public int getCabinetId() {
		return cabinetId;
	}
	public void setCabinetId(int cabinetId) {
		this.cabinetId = cabinetId;
	}
	public List<BoxWithIdAndStatusAndType> getBoxs() {
		return boxs;
	}
	public void setBoxs(List<BoxWithIdAndStatusAndType> boxs) {
		this.boxs = boxs;
	}
	@Override
	public String toString() {
		return "CabinetWithIdAndBoxs [cabinetId=" + cabinetId + ", boxs=" + boxs + "]";
	}
	public CabinetWithIdAndBoxs(int cabinetId, List<BoxWithIdAndStatusAndType> boxs) {
		super();
		this.cabinetId = cabinetId;
		this.boxs = boxs;
	}
	public CabinetWithIdAndBoxs() {
		super();
	}
}
