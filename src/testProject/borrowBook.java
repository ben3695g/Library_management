package testProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;

public class borrowBook extends JFrame {
	boolean a=true;
    Book book = new Book();
	private static controller myController = new controller();
	private JPanel contentPane;
	private JTextField borrow_book_name;
	private JTextField error;
	private JTextField student_id;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton menu_to_add_book;
	private JButton menu_to_add_student;
	private JButton menu_to_return_book;
	private JButton menu_to_update_student_items;
	private JButton menu_to_search_book;
	private JButton menu_to_search_student;
	private JTextField year;
	private final JTextField month = new JTextField();
	private final JTextField day = new JTextField();
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton menu_to_unreturnbookreport;
	
	
	/**
	 * Launch the application.
	 */
	//public void addbook(Book a)
	//{
		//System.out.println(v.data);
		//data1.add(a);
		//myModel1.saveToBookFileFromList(data1);
		//myModel1.writeToBookTextFileFromList(data1);
		//System.out.println(data1);
	//}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				System.out.println();
				try {
					borrowBook frame = new borrowBook();
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
	public borrowBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		layout.putConstraint(SpringLayout.WEST, day, 210, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, month, -342, SpringLayout.EAST, contentPane);
		contentPane.setLayout(layout);
		
		borrow_book_name = new JTextField();
		contentPane.add(borrow_book_name, BorderLayout.NORTH);
		borrow_book_name.setColumns(10);
		
		JButton btnNewButton = new JButton("\u05D4\u05E9\u05D0\u05DC \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.WEST, btnNewButton, 264, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, btnNewButton, -257, SpringLayout.EAST, contentPane);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				List<Book> read = myController.loadBookList();
				List<student> reads = myController.loadStudentList();
				if(day.getText().length()!=2 || month.getText().length()!=2)
				{
					error.setText("יום וחודש צריכים לכלול שני תווים כל אחד");
					return;
				}
				Integer day1 = Integer.parseInt(day.getText()); 
				Integer month1 = Integer.parseInt(month.getText()); 
				Integer year1 = Integer.parseInt(year.getText()); 
				int day3 = day1;
				int month3 = month1; 
				int year3= year1;
				if(year.getText().length()==0)
				{
					error.setText("חייב למלא שדה שנה");
					return;	
				}
				if(day3<1 || day3>31)
				{
					error.setText("יום לא תקין");
					return;	
				}
				if(month3<1 || month3>12)
				{
					error.setText("חודש לא תקין");
					return;	
				}
				if(day3>28 && month3==2)
				{
					error.setText("תאריך לא תקין");
					return;
				}
				if(day3>28 && month3==2)
				{
					error.setText("תאריך לא תקין");
					return;
				}
				if((month3==4 || month3==6 || month3==9 || month3==11) && day3>30)
				{
					error.setText("תאריך לא תקין");
					return;
				}
				if(year3<2020)
				{
					error.setText("שנה לא חוקית");
					return;	
				}
				for (Book tBook : read)
				{
				for (student tstudent : reads)
				{
			    if (tBook.getBookName().equals(borrow_book_name.getText()) && tBook.getborrow()==true)
				{
					error.setText("!ספר זה כבר מושאל");
					return;
				}
				if (tBook.getBookName().equals(borrow_book_name.getText()) && tBook.getborrow()==false && tstudent.getId().equals(student_id.getText()))
				{
					book = new Book(tBook.getBookName(),tBook.getauthor(), tBook.getlocation(),a, day.getText(),month.getText(),year.getText(), student_id.getText());
					read.remove(tBook);
					read.add(book);
					myController.saveToBookFileFromList(read);
					myController.writeToBookTextFileFromList(read);
					error.setText("!הספר הושאל בהצלחה");
					return;
				}
				}
			    }
				error.setText("!שם הספר או תעודת זהות של סטודנט שהוקלד אינו קיים במערכת");
			}
		});
		contentPane.add(btnNewButton, BorderLayout.CENTER);
		
		error = new JTextField();
		layout.putConstraint(SpringLayout.SOUTH, btnNewButton, -9, SpringLayout.NORTH, error);
		layout.putConstraint(SpringLayout.NORTH, error, 173, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, error, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, error, -10, SpringLayout.EAST, contentPane);
		contentPane.add(error, BorderLayout.EAST);
		error.setColumns(10);
		
		student_id = new JTextField();
		layout.putConstraint(SpringLayout.WEST, borrow_book_name, 0, SpringLayout.WEST, student_id);
		contentPane.add(student_id, BorderLayout.WEST);
		student_id.setColumns(10);
		
		lblNewLabel = new JLabel("\u05E9\u05DD \u05E1\u05E4\u05E8 \u05DC\u05D4\u05E9\u05D0\u05DC\u05D4-");
		layout.putConstraint(SpringLayout.NORTH, borrow_book_name, -3, SpringLayout.NORTH, lblNewLabel);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 39, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel, 402, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05E9\u05D0\u05DC\u05D4-");
		layout.putConstraint(SpringLayout.NORTH, month, -3, SpringLayout.NORTH, lblNewLabel_1);
		layout.putConstraint(SpringLayout.NORTH, day, -3, SpringLayout.NORTH, lblNewLabel_1);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 19, SpringLayout.SOUTH, lblNewLabel);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA \u05E9\u05DC \u05DE\u05E9\u05D0\u05D9\u05DC-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 20, SpringLayout.SOUTH, lblNewLabel_1);
		layout.putConstraint(SpringLayout.NORTH, student_id, -3, SpringLayout.NORTH, lblNewLabel_2);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -157, SpringLayout.EAST, contentPane);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.EAST, student_id, 0, SpringLayout.EAST, lblNewLabel_3);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -274, SpringLayout.EAST, contentPane);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		menu_to_add_book = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.WEST, menu_to_add_book, 476, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_book, 6, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_book, 0, SpringLayout.EAST, error);
		menu_to_add_book.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(menu_to_add_book);
		menu_to_add_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_new_book = new add_new_book();
				add_new_book.setVisible(true);
			}
		});
		menu_to_add_student = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_student, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_student, -6, SpringLayout.WEST, menu_to_add_book);
		contentPane.add(menu_to_add_student);
		menu_to_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_student = new add_student();
				add_student.setVisible(true);
			}
			});
		menu_to_return_book = new JButton("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_return_book, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_return_book, -6, SpringLayout.WEST, menu_to_add_student);
		contentPane.add(menu_to_return_book);
		
		menu_to_update_student_items = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_update_student_items, 7, SpringLayout.SOUTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_update_student_items, -10, SpringLayout.EAST, contentPane);
		menu_to_update_student_items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UpdataStudentItems = new UpdateStudentItems();
				UpdataStudentItems.setVisible(true);
			}
		});
		contentPane.add(menu_to_update_student_items);
		
		menu_to_search_book = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_book, 0, SpringLayout.NORTH, menu_to_add_book);
		menu_to_search_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchBook = new SearchBook();
				SearchBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_search_book);
		
		menu_to_search_student = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.EAST, menu_to_search_book, -6, SpringLayout.WEST, menu_to_search_student);
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_student, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_search_student, -4, SpringLayout.WEST, menu_to_return_book);
		menu_to_search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchStudent = new SearchStudent();
				SearchStudent.setVisible(true);
			}
		});
		contentPane.add(menu_to_search_student);
		
		year = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, year, -3, SpringLayout.NORTH, lblNewLabel_1);
		layout.putConstraint(SpringLayout.WEST, year, 324, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, year, 0, SpringLayout.EAST, student_id);
		contentPane.add(year);
		year.setColumns(10);
		contentPane.add(month);
		month.setColumns(10);
		contentPane.add(day);
		day.setColumns(10);
		
		lblNewLabel_5 = new JLabel("/");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_1);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 3, SpringLayout.EAST, month);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("/");
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 252, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, day, -6, SpringLayout.WEST, lblNewLabel_6);
		layout.putConstraint(SpringLayout.WEST, month, 6, SpringLayout.EAST, lblNewLabel_6);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNewLabel_1);
		contentPane.add(lblNewLabel_6);
		
		menu_to_unreturnbookreport = new JButton("\u05E1\u05E4\u05E8\u05D9\u05DD \u05E9\u05DC\u05D0 \u05D4\u05D5\u05D7\u05D6\u05E8\u05D5 \u05D1\u05D6\u05DE\u05DF");
		menu_to_unreturnbookreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UnRetuenBookReport = new UnRetuenBookReport();
				UnRetuenBookReport.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.SOUTH, menu_to_unreturnbookreport, 0, SpringLayout.SOUTH, menu_to_update_student_items);
		layout.putConstraint(SpringLayout.EAST, menu_to_unreturnbookreport, -6, SpringLayout.WEST, menu_to_update_student_items);
		contentPane.add(menu_to_unreturnbookreport);
		menu_to_return_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame ReturnBook = new ReturnBook();
				ReturnBook.setVisible(true);
			}
			});
	}
}


