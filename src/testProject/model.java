package testProject;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.ComboBoxModel;

public class model {
	public boolean biggerdate(String borrow_date_day, String borrow_date_month, String borrow_date_year, String a, String b, String c)
	{
		Integer nowday1 = Integer.parseInt(a); 
		Integer nowmonth1 = Integer.parseInt(b); 
		Integer nowyear1 = Integer.parseInt(c); 
		Integer day1 = Integer.parseInt(borrow_date_day); 
		Integer month1 = Integer.parseInt(borrow_date_month); 
		Integer year1 = Integer.parseInt(borrow_date_year); 
		int nowday = nowday1 ;
		int nowmonth = nowmonth1;
		int nowyear = nowyear1;
		int day = day1;
		int month = month1; 
		int year = year1;
		if(day+7<=28)
		{
		day= day+7;
		}
		if(month==2 && day>28)
	    { 
		day= day+7-28;
		month= 3;
	    }
		if((day+7>30) && (month==4 || month==6 || month==9 || month==11))
		{
	    day= day+7-30;
		month= month+1;
		}
		if((day>31) && (month==1 || month==3 || month==5 || month==7 || month==8 || month==9 || month==10))
		{
		day= day+7-31;
		month= month+1;
		}
		if(month==12 && day+7>31)
		{
		day= day+7-31;
		month= 1;
		year= year+1;
		}
		if(year<nowyear)
		{
			return true;
		}
		if(nowyear==year)
		{
		if(month<nowmonth)
		{
			return true;
		}
		}
		if(nowyear==year)
		{
		if(nowmonth==month)
		{
		if(day<nowday)
		{
			return true;
		}
		}
		}
        return false;
	}
	public static ArrayList<Book> readFromfile() {
		List<Book> InvoiceList = new ArrayList<Book>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("testFile.dat"));
		} catch (EOFException e) {
			return (ArrayList<Book>) InvoiceList;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Object object = null;
			try {

				while (ois.available() > 0) {
					object = ois.readObject();
					if (object instanceof Book) {
						Book user = (Book) object;
						InvoiceList.add(user);
						return (ArrayList<Book>) InvoiceList;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return (ArrayList<Book>) InvoiceList;

	}

	@SuppressWarnings("resource")
	public List<Book> loadInvoiceList() {
		List<Book> InvoiceList = new ArrayList<Book>();
		try {
			File customerFile = new File("testFile.dat");
			String filePath = customerFile.getPath();
			FileInputStream fin = new FileInputStream(filePath);
			ObjectInputStream inputStream;
			try {
				if (fin.available() == 0) {
					return InvoiceList;
				}

				inputStream = new ObjectInputStream(fin);
				try {
					while (fin.available() != 0) {
						InvoiceList.add((Book) inputStream.readObject());
					}
				}

				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				catch (IOException e) {
					e.printStackTrace();
				}

				inputStream.close();
			}

			catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return InvoiceList;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Book> loadBookList() {
		ObjectInputStream oin = null;
		try {
			File BookFile = new File("testFile.dat");
			FileInputStream fin = new FileInputStream(BookFile);
			oin = new ObjectInputStream(fin);
			return (List<Book>) oin.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Book>();
		} finally {
			try {
				if (oin !=null) oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 
		 * 
		 * List<Book> BookList = new ArrayList<Book>(); try { File BookFile = new
		 * File("testFile.dat"); String filePath = BookFile.getPath(); FileInputStream
		 * fin = new FileInputStream(filePath); ObjectInputStream inputStream; try { if
		 * (fin.available() == 0) { return BookList; }
		 * 
		 * inputStream = new ObjectInputStream(fin);
		 * 
		 * while (fin.available() != 0) { try { Book obj = (Book)
		 * inputStream.readObject(); BookList.add(obj); } catch (Exception e) {
		 * e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * inputStream.close(); fin.close(); }
		 * 
		 * catch (IOException e1) { e1.printStackTrace(); }
		 * 
		 * }
		 * 
		 * catch (FileNotFoundException e) { e.printStackTrace(); }
		 * 
		 * return BookList;
		 * 
		 **/
	}
	@SuppressWarnings({ "unchecked" })
	public List<student> loadStudentList() {
		ObjectInputStream oin = null;
		try {
			File studentFile = new File("students.dat");
			FileInputStream fin = new FileInputStream(studentFile);
			oin = new ObjectInputStream(fin);
			return (List<student>) oin.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<student>();
		} finally {
			try {
				if (oin !=null) oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	public void saveToBookFileFromList(List<Book> read) {
		try {
			File customerFile = new File("testFile.dat");
			String filePath = customerFile.getPath();
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream outputStream = new ObjectOutputStream(fout);
			for (Book newbook : read) {
				outputStream.writeObject(read);
			}

			outputStream.close();
			fout.close();

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToBookTextFileFromList(List<Book> read) {
		try {
			FileWriter writer = new FileWriter("books.txt");
			for (Book newBook : read) {
				writer.write("שם ספר- " + newBook.getBookName() + "\n");
				writer.write("שם כותב- " + newBook.getauthor() + "\n");
				writer.write("מיקום- " + newBook.getlocation() + "\n");
				writer.write("האם מושאל- " + newBook.getborrow() + "\n");
				writer.write("יום תאריך השאלה- " + newBook.get_borrow_date_day() + "\n");
				writer.write("חודש תאריך השאלה- " + newBook.get_borrow_date_month() + "\n");
				writer.write("שנה תאריך השאלה- " + newBook.get_borrow_date_year() + "\n");
				writer.write("תעודת זהות של משאיל הספר- " + newBook.getstudent() + "\n"); //+ ", " + newBook.getstudent().getId() + ", " + newBook.getstudent().getPhone() + ", " + newBook.getstudent().getEmail() + ", " + newBook.getstudent().GetStudent_id() + "/n"); 
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveToStudentFileFromList(List<student> read) {
		try {
			File customerFile = new File("students.dat");
			String filePath = customerFile.getPath();
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream outputStream = new ObjectOutputStream(fout);
			for (student newStudent : read) {
				outputStream.writeObject(read);
			}

			outputStream.close();
			fout.close();

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToStudentTextFileFromList(List<student> read) {
		try {
			FileWriter writer = new FileWriter("students.txt");
			for (student newStudent : read) {

				writer.write("תעודת זהות- " + newStudent.getId() + "\n");
                writer.write("שם סטודנט- " + newStudent.getName() + "\n");
				writer.write("טלפון- " + newStudent.getPhone() + "\n");
				writer.write("אימייל- " + newStudent.getEmail() + "\n");
				writer.write("מספר סטודנט- " + newStudent.GetStudent_id() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void borrow_book(String name_of_book, ArrayList<Book> data) {
		for (Book newBook1 : data) {

		}
	}
}
