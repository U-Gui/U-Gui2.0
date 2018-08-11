package cn.edu.neu.vo;

import java.util.List;

import cn.edu.neu.entity.School;

public class CabinetLocationWithAll {
	private int cabinetlocationId;
	private schoolWithIdAndName school;
	private String cabinetlocationName;
	private List<CabinetWithIdAndBoxs>cabinets;
	public int getCabinetlocationId() {
		return cabinetlocationId;
	}
	public void setCabinetlocationId(int cabinetlocationId) {
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
	public List<CabinetWithIdAndBoxs> getCabinets() {
		return cabinets;
	}
	public void setCabinets(List<CabinetWithIdAndBoxs> cabinets) {
		this.cabinets = cabinets;
	}
	@Override
	public String toString() {
		return "CabinetLocationWithAll [cabinetlocationId=" + cabinetlocationId + ", school=" + school
				+ ", cabinetlocationName=" + cabinetlocationName + ", cabinets=" + cabinets + "]";
	}
	public CabinetLocationWithAll(int cabinetlocationId, schoolWithIdAndName school, String cabinetlocationName,
			List<CabinetWithIdAndBoxs> cabinets) {
		super();
		this.cabinetlocationId = cabinetlocationId;
		this.school = school;
		this.cabinetlocationName = cabinetlocationName;
		this.cabinets = cabinets;
	}
	public CabinetLocationWithAll() {
		super();
	}
}
