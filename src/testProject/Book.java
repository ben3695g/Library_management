package testProject;
import java.util.ArrayList;
import javax.swing.JFrame;
public class Book implements java.io.Serializable 
{
	private boolean borrow;
	private String book_name;
	private String author;
	private String location;
	private String borrow_date_day;
	private String borrow_date_month;
	private String borrow_date_year;
	private String student_id;
	static final String fileName = "testFile.dat"; 
	public Book() {}
	public Book(String bookname, String author, String location, boolean a, String day,String month,String year, String s)
	{
		this.borrow=a;
		this.book_name=bookname;
		this.author=author;
		this.location=location;
		this.borrow_date_day=day;
		this.borrow_date_month=month;
		this.borrow_date_year=year;
		this.student_id=s;
	}
	void setBookName(String name)
	{
		this.book_name = name;
	}
	String getBookName()
	{
		return this.book_name;
	}
	String getauthor()
	{
		return this.author;
	}
	String getlocation()
	{
		return this.location;
	}
	boolean getborrow()
	{
		return this.borrow;
	}
	String get_borrow_date_day()
	{
		return this.borrow_date_day;
	}
	String get_borrow_date_month()
	{
		return this.borrow_date_month;
	}
	String get_borrow_date_year()
	{
		return this.borrow_date_year;
	}
	String getstudent()
	{
		return this.student_id;
	}
}