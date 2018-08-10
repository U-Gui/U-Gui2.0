package cn.edu.neu.vo;

public class schoolWithIdAndName {
	private int schoolId;
	private String schoolName;
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	@Override
	public String toString() {
		return "schoolWithIdAndName [schoolId=" + schoolId + ", schoolName=" + schoolName + "]";
	}
}
