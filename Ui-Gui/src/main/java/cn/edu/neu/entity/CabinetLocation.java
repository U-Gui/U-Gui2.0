package cn.edu.neu.entity;

import java.util.List;

public class CabinetLocation {
	private Integer cabinetlocationId;
	private School school;
	private String cabinetlocationName;
	private List<Cabinet> cabinets;
	public CabinetLocation() {}
	public CabinetLocation(Integer cabinetlocationId, School school, String cabinetlocationName) {
		super();
		this.cabinetlocationId = cabinetlocationId;
		this.school = school;
		this.cabinetlocationName = cabinetlocationName;
	}
	public CabinetLocation(Integer cabinetlocationId, School school, String cabinetlocationName, List<Cabinet> cabinets) {
		super();
		this.cabinetlocationId = cabinetlocationId;
		this.school = school;
		this.cabinetlocationName = cabinetlocationName;
		this.cabinets = cabinets;
	}
	public CabinetLocation(Integer cabinetlocationId, String cabinetlocationName, List<Cabinet> cabinets) {
		super();
		this.cabinetlocationId = cabinetlocationId;
		this.cabinetlocationName = cabinetlocationName;
		this.cabinets = cabinets;
	}
	public Integer getCabinetlocationId() {
		return cabinetlocationId;
	}
	public void setCabinetlocationId(Integer cabinetlocationId) {
		this.cabinetlocationId = cabinetlocationId;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getCabinetlocationName() {
		return cabinetlocationName;
	}
	public void setCabinetlocationName(String cabinetlocationName) {
		this.cabinetlocationName = cabinetlocationName;
	}
	public List<Cabinet> getCabinets() {
		return cabinets;
	}
	public void setCabinets(List<Cabinet> cabinets) {
		this.cabinets = cabinets;
	}
}
