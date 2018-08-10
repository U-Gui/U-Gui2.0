package cn.edu.neu.entity;

import java.util.List;

public class Cabinet {
	private Integer cabinetId;
	private CabinetLocation cabinetLocation;
	private List<BoxInfo> boxinfos;
	public Cabinet() {}
	public Cabinet(Integer cabinetId, CabinetLocation cabinetLocation) {
		super();
		this.cabinetId = cabinetId;
		this.cabinetLocation = cabinetLocation;
	}
	public Cabinet(Integer cabinetId, CabinetLocation cabinetLocation, List<BoxInfo> boxinfos) {
		super();
		this.cabinetId = cabinetId;
		this.cabinetLocation = cabinetLocation;
		this.boxinfos = boxinfos;
	}
	public Cabinet(Integer cabinetId, List<BoxInfo> boxinfos) {
		super();
		this.cabinetId = cabinetId;
		this.boxinfos = boxinfos;
	}
	public Integer getCabinetId() {
		return cabinetId;
	}
	public void setCabinetId(Integer cabinetId) {
		this.cabinetId = cabinetId;
	}
	public CabinetLocation getCabinetLocation() {
		return cabinetLocation;
	}
	public void setCabinetLocation(CabinetLocation cabinetLocation) {
		this.cabinetLocation = cabinetLocation;
	}
	public List<BoxInfo> getBoxinfos() {
		return boxinfos;
	}
	public void setBoxinfos(List<BoxInfo> boxinfos) {
		this.boxinfos = boxinfos;
	}
}
