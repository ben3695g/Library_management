package testProject;
public class librarian 
{
	private String username;
	private String password;
	librarian(String username, String password)
	{
		this.username=username;
		this.password=password;
	}
	String getUsername()
	{
		return this.username;
	}
	String getPassword()
	{
		return this.password;
	}
}
