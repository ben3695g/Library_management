package testProject;

public class student extends person implements java.io.Serializable 
{
	private String student_id;
	
	public student() {}
	public student(String name, String id, String phone, String email, String studentId)
	{
		super(name, id, phone, email);
		this.student_id=studentId;
	}
	String GetStudent_id()
	{
		return this.student_id;
	}
}
