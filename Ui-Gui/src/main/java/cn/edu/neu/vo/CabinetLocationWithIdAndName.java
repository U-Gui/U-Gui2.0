package cn.edu.neu.vo;

public class CabinetLocationWithIdAndName {
	private int cabinetlocationId;
	private String cabinetlocationName;
	public int getCabinetlocationId() {
		return cabinetlocationId;
	}
	public void setCabinetlocationId(int cabinetlocationId) {
		this.cabinetlocationId = cabinetlocationId;
	}
	public String getCabinetlocationName() {
		return cabinetlocationName;
	}
	public void setCabinetlocationName(String cabinetlocationName) {
		this.cabinetlocationName = cabinetlocationName;
	}
	@Override
	public String toString() {
		return "CabinetLocationWithIdAndName [cabinetlocationId=" + cabinetlocationId + ", cabinetlocationName="
				+ cabinetlocationName + "]";
	}
}
