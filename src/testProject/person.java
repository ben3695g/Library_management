package testProject;

public class person implements java.io.Serializable 
{
	private String name;
	private String id; 
	private String email;
	private String phone;
	
	public person() {}
	public person(String id, String name, String phone, String email)
	{
		this.id=id;
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
	String getName()
	{
		return this.name;
	}
	String getId()
	{
		return this.id;
	}
	String getPhone()
	{
		return this.phone;
	}
	String getEmail()
	{
		return this.email;
	}
}
