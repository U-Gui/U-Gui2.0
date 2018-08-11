package cn.edu.neu.entity;

import java.util.List;

import cn.edu.neu.vo.schoolWithIdAndName;

public class CabinetLocation {
	private Integer cabinetlocationId;
	private schoolWithIdAndName school;
	private String cabinetlocationName;
	private List<Cabinet> cabinets;
	public Integer getCabinetlocationId() {
		return cabinetlocationId;
	}
	public void setCabinetlocationId(Integer cabinetlocationId) {
		this.cabinetlocationId = cabinetlocationId;
	}
	public schoolWithIdAndName getSchool() {
		return school;
	}
	public void setSchool(schoolWithIdAndName school) {
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
	@Override
	public String toString() {
		return "CabinetLocation [cabinetlocationId=" + cabinetlocationId + ", school=" + school
				+ ", cabinetlocationName=" + cabinetlocationName + ", cabinets=" + cabinets + "]";
	}
}
