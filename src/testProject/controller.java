package testProject;
import java.util.List;

public class controller {
	private static model myModel = new model();
	public List<Book> loadBookList() 
	{
		return myModel.loadBookList();
	}
	public List<student> loadStudentList() 
	{
		return myModel.loadStudentList();
	}
	public void writeToBookTextFileFromList(List<Book> read)
	{
		myModel.writeToBookTextFileFromList(read);
	}
	public void saveToBookFileFromList(List<Book> read) 
	{
		myModel.saveToBookFileFromList(read);
	}
	public void saveToStudentFileFromList(List<student> read) 
	{
		myModel.saveToStudentFileFromList(read);
	}
	public void writeToStudentTextFileFromList(List<student> read) 
	{
		myModel.writeToStudentTextFileFromList(read);
	}
	public boolean biggerdate(String borrow_date_day, String borrow_date_month, String borrow_date_year, String a, String b, String c)
	{
		return myModel.biggerdate(borrow_date_day, borrow_date_month, borrow_date_year, a, b, c);
	}
}
