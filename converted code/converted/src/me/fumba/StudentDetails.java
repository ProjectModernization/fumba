package me.fumba;

/**
 * Student Details
 * 
 * @author fumba chibaka
 *
 */
public class StudentDetails {

	private int studentId;
	private String studentName;
	private String surname;
	private String initials;
	private String courseCode;
	private String gender;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Student ID - " + this.getStudentId());
		buffer.append("\n");
		buffer.append("Surname - " + this.getSurname());
		buffer.append("\n");
		buffer.append("Initials - " + this.getInitials());
		buffer.append("\n");
		buffer.append("Course Code- " + this.getCourseCode());
		buffer.append("\n");
		buffer.append("Gender - " + this.getGender());
		buffer.append("\n");
		return buffer.toString();
	}

}
