package cn.edu.neu.entity;

import java.util.List;

public class School {
	private Integer schoolId;
	private String schoolName;
	private List<Major> majors;
	private List<CabinetLocation> cabinetLocations;
	public School() {}
	public School(Integer schoolId, String schoolName) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
	}
	public School(Integer schoolId, String schoolName, List<Major> majors) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.majors = majors;
	}
	public School(Integer schoolId, String schoolName, List<Major> majors, List<CabinetLocation> cabinetLocations) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.majors = majors;
		this.cabinetLocations = cabinetLocations;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public List<Major> getMajors() {
		return majors;
	}
	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}
	public List<CabinetLocation> getCabinetLocations() {
		return cabinetLocations;
	}
	public void setCabinetLocations(List<CabinetLocation> cabinetLocations) {
		this.cabinetLocations = cabinetLocations;
	}
	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", majors=" + majors
				+ ", cabinetLocations=" + cabinetLocations + "]";
	}
}
