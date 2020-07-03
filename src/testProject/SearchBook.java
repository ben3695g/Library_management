package testProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	Book book = new Book();
	private static controller myController = new controller();
	private JTextField book_name;
	private JTextField author;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField location;
	private JLabel lblNewLabel_5;
	private JTextField borrow;
	private JLabel lblNewLabel_6;
	private JTextField year;
	private JLabel lblNewLabel_7;
	private JTextField student;
	private JTextField error;
	private JButton menu_to_add_book;
	private JButton menu_to_add_student;
	private JButton menu_to_borrow_book;
	private JButton menu_to_return_book;
	private JButton menu_to_update_student_items;
	private JButton menu_to_search_student;
	private JLabel lblNewLabel_8;
	private final JLabel label = new JLabel("/");
	private JTextField day;
	private JTextField month;
	private JButton menu_to_unreturnbookreport;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook frame = new SearchBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		JLabel lblNewLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel, 256, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E1\u05E4\u05E8-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 24, SpringLayout.NORTH, contentPane);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, name, 6, SpringLayout.SOUTH, lblNewLabel);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 21, SpringLayout.EAST, name);
		layout.putConstraint(SpringLayout.WEST, name, 217, SpringLayout.WEST, contentPane);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton search = new JButton("\u05D7\u05E4\u05E9 \u05E1\u05E4\u05E8");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				List<Book> read = myController.loadBookList();
				for (Book tBook : read)
				{
			    if (tBook.getBookName().equals(name.getText()))
				{
			    	book_name.setText(tBook.getBookName());
			    	author.setText(tBook.getauthor());
			    	location.setText(tBook.getlocation());
			    	if(tBook.getborrow()==true)
			    	{
				    	borrow.setText("כן");			    		
			    	}
			    	else
			    	{
				    	borrow.setText("לא");			    		
			    	}
			    	day.setText(tBook.get_borrow_date_day());
			    	month.setText(tBook.get_borrow_date_month());
			    	year.setText(tBook.get_borrow_date_year());
			    	student.setText(tBook.getstudent());
			    	return;
				}
				}
				error.setText("!שם הספר אינו קיים במערכת");
			}
		});
		contentPane.add(search);
		
		book_name = new JTextField();
		layout.putConstraint(SpringLayout.SOUTH, search, -6, SpringLayout.NORTH, book_name);
		layout.putConstraint(SpringLayout.NORTH, book_name, 73, SpringLayout.NORTH, contentPane);
		contentPane.add(book_name);
		book_name.setColumns(10);
		
		author = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, author, 2, SpringLayout.SOUTH, book_name);
		layout.putConstraint(SpringLayout.WEST, author, 179, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.WEST, book_name, 0, SpringLayout.WEST, author);
		contentPane.add(author);
		author.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\u05E9\u05DD \u05E1\u05E4\u05E8-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, book_name);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u05E9\u05DD \u05DB\u05D5\u05EA\u05D1-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, author);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\u05DE\u05D9\u05E7\u05D5\u05DD-");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_4);
		
		location = new JTextField();
		layout.putConstraint(SpringLayout.EAST, location, -71, SpringLayout.WEST, lblNewLabel_4);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, location);
		layout.putConstraint(SpringLayout.NORTH, location, 1, SpringLayout.SOUTH, author);
		contentPane.add(location);
		location.setColumns(10);
		
		lblNewLabel_5 = new JLabel("\u05D4\u05D0\u05DD \u05DE\u05D5\u05E9\u05D0\u05DC-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 6, SpringLayout.SOUTH, lblNewLabel_4);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_5, -244, SpringLayout.EAST, contentPane);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_5);
		
		borrow = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, borrow, -3, SpringLayout.NORTH, lblNewLabel_5);
		layout.putConstraint(SpringLayout.WEST, borrow, 0, SpringLayout.WEST, book_name);
		layout.putConstraint(SpringLayout.EAST, borrow, 0, SpringLayout.EAST, book_name);
		contentPane.add(borrow);
		borrow.setColumns(10);
		
		lblNewLabel_6 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05E9\u05D0\u05DC\u05D4-");
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lblNewLabel_6);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_6);
		
		year = new JTextField();
		layout.putConstraint(SpringLayout.WEST, search, 0, SpringLayout.WEST, year);
		layout.putConstraint(SpringLayout.NORTH, year, -3, SpringLayout.NORTH, lblNewLabel_6);
		layout.putConstraint(SpringLayout.WEST, year, 229, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, year, 0, SpringLayout.EAST, book_name);
		contentPane.add(year);
		year.setColumns(10);
		
		lblNewLabel_7 = new JLabel("\u05E1\u05D8\u05D5\u05D3\u05E0\u05D8 \u05DE\u05E9\u05D0\u05D9\u05DC-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 6, SpringLayout.SOUTH, lblNewLabel_7);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 6, SpringLayout.SOUTH, lblNewLabel_5);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_7, -243, SpringLayout.EAST, contentPane);
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_7);
		
		student = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, student, -3, SpringLayout.NORTH, lblNewLabel_7);
		layout.putConstraint(SpringLayout.EAST, student, 0, SpringLayout.EAST, book_name);
		contentPane.add(student);
		student.setColumns(10);
		
		error = new JTextField();
		layout.putConstraint(SpringLayout.WEST, error, -1, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, error, -316, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, error, -1, SpringLayout.EAST, contentPane);
		contentPane.add(error);
		error.setColumns(10);
		
		menu_to_add_book = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_book, 6, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_book, 0, SpringLayout.EAST, book_name);
		menu_to_add_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_new_book = new add_new_book();
				add_new_book.setVisible(true);
			}
		});
		contentPane.add(menu_to_add_book);
		
		menu_to_add_student = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_student, 0, SpringLayout.NORTH, menu_to_add_book);
		menu_to_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_student = new add_student();
				add_student.setVisible(true);
			}
		});
		contentPane.add(menu_to_add_student);
		
		menu_to_borrow_book = new JButton("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_borrow_book, 6, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_borrow_book, -2, SpringLayout.WEST, menu_to_add_book);
		menu_to_borrow_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame borrowBook = new borrowBook();
				borrowBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_borrow_book);
		
		menu_to_return_book = new JButton("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.EAST, menu_to_return_book, 0, SpringLayout.EAST, error);
		menu_to_return_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame ReturnBook = new ReturnBook();
				ReturnBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_return_book);
		
		menu_to_update_student_items = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.EAST, menu_to_update_student_items, -219, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.WEST, menu_to_add_student, 6, SpringLayout.EAST, menu_to_update_student_items);
		layout.putConstraint(SpringLayout.NORTH, menu_to_update_student_items, 6, SpringLayout.SOUTH, error);
		menu_to_update_student_items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UpdataStudentItems = new UpdateStudentItems();
				UpdataStudentItems.setVisible(true);
			}
		});
		contentPane.add(menu_to_update_student_items);
		
		menu_to_search_student = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_return_book, 6, SpringLayout.SOUTH, menu_to_search_student);
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_student, 6, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_search_student, 0, SpringLayout.EAST, error);
		menu_to_search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchStudent = new SearchStudent();
				SearchStudent.setVisible(true);
			}
		});
		contentPane.add(menu_to_search_student);
		
		lblNewLabel_8 = new JLabel("/");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, lblNewLabel_6);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_8, -6, SpringLayout.WEST, year);
		contentPane.add(lblNewLabel_8);
		contentPane.add(label);
		
		day = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, day, -3, SpringLayout.NORTH, lblNewLabel_6);
		layout.putConstraint(SpringLayout.WEST, day, 131, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, day, -6, SpringLayout.WEST, label);
		contentPane.add(day);
		day.setColumns(10);
		
		month = new JTextField();
		layout.putConstraint(SpringLayout.EAST, label, -11, SpringLayout.WEST, month);
		layout.putConstraint(SpringLayout.EAST, month, 210, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, month, -3, SpringLayout.NORTH, lblNewLabel_6);
		layout.putConstraint(SpringLayout.WEST, month, 0, SpringLayout.WEST, book_name);
		contentPane.add(month);
		month.setColumns(10);
		
		menu_to_unreturnbookreport = new JButton("\u05E1\u05E4\u05E8\u05D9\u05DD \u05E9\u05DC\u05D0 \u05D4\u05D5\u05D7\u05D6\u05E8\u05D5 \u05D1\u05D6\u05DE\u05DF");
		menu_to_unreturnbookreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UnRetuenBookReport = new UnRetuenBookReport();
				UnRetuenBookReport.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, menu_to_unreturnbookreport, 6, SpringLayout.SOUTH, menu_to_add_student);
		layout.putConstraint(SpringLayout.EAST, menu_to_unreturnbookreport, -6, SpringLayout.WEST, menu_to_return_book);
		contentPane.add(menu_to_unreturnbookreport);
	}

}
