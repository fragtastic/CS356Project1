public class Student {

	private String studentId;

	public Student(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public String toString() {
		return "Student: " + this.studentId;
	}
}