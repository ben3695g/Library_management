package testProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {
	Book book = new Book();
	private static controller myController = new controller();
	private JPanel contentPane;
	private JTextField book_name;
	private JTextField id;
	private JLabel lblNewLabel_2;
	private JTextField error;
	private JButton menu_to_add_book;
	private JButton menu_to_add_student;
	private JButton menu_to_borrow_book;
	private JButton menu_to_update_student_items;
	private JButton menu_to_search_book;
	private JButton menu_to_search_student;
	private JButton menu_to_unreturnbookreport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				System.out.println();
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel, -275, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		book_name = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, book_name, 26, SpringLayout.SOUTH, lblNewLabel);
		layout.putConstraint(SpringLayout.EAST, book_name, -308, SpringLayout.EAST, contentPane);
		contentPane.add(book_name);
		book_name.setColumns(10);
		
		id = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, id, 6, SpringLayout.SOUTH, book_name);
		layout.putConstraint(SpringLayout.EAST, id, 0, SpringLayout.EAST, book_name);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E1\u05E4\u05E8-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, book_name);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -192, SpringLayout.EAST, contentPane);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA \u05E9\u05DC \u05DE\u05D7\u05D6\u05D9\u05E8-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				List<Book> read = myController.loadBookList();
				List<student> reads = myController.loadStudentList();
				for (Book tBook : read)
				{
					for (student tstudent : reads)
					{
						if (tBook.getBookName().equals(book_name.getText()) && tBook.getborrow()==false)
						{
							error.setText("!ספר זה אינו מושאל");
							return;
						}
				        if (tBook.getBookName().equals(book_name.getText()) && tBook.getborrow()==true && tBook.getstudent().equals(id.getText()))
				        {
					    book = new Book(tBook.getBookName(),tBook.getauthor(), tBook.getlocation(),false,"","","","");
					    read.remove(tBook);
					    read.add(book);
					    myController.saveToBookFileFromList(read);
					    myController.writeToBookTextFileFromList(read);
					    error.setText("!הספר הוחזר בהצלחה");
					    return;
				        }
				     }
				}				
				error.setText("!שם ספר או ת.ז אינו קיים במערכת או שסטודנט זה אינו השאיל ספר זה");
				}
		});
		contentPane.add(btnNewButton);
		error = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, error, 143, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, error, 0, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, error, -417, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, error, -5, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, btnNewButton, -12, SpringLayout.NORTH, error);
		contentPane.add(error);
		error.setColumns(10);
		
		menu_to_add_book = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_book, 15, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_book, 0, SpringLayout.EAST, error);
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
		layout.putConstraint(SpringLayout.EAST, menu_to_add_student, -5, SpringLayout.WEST, menu_to_add_book);
		contentPane.add(menu_to_add_student);
		menu_to_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_student = new add_student();
				add_student.setVisible(true);
			}
			});
		menu_to_borrow_book = new JButton("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_borrow_book, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_borrow_book, -6, SpringLayout.WEST, menu_to_add_student);
		contentPane.add(menu_to_borrow_book);
		
		menu_to_update_student_items = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_update_student_items, 0, SpringLayout.NORTH, menu_to_add_book);
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
		layout.putConstraint(SpringLayout.EAST, menu_to_update_student_items, -6, SpringLayout.WEST, menu_to_search_book);
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
		layout.putConstraint(SpringLayout.EAST, menu_to_search_student, -9, SpringLayout.WEST, menu_to_borrow_book);
		menu_to_search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchStudent = new SearchStudent();
				SearchStudent.setVisible(true);	
			}
		});
		contentPane.add(menu_to_search_student);
		
		menu_to_unreturnbookreport = new JButton("\u05E1\u05E4\u05E8\u05D9\u05DD \u05E9\u05DC\u05D0 \u05D4\u05D5\u05D7\u05D6\u05E8\u05D5 \u05D1\u05D6\u05DE\u05DF");
		layout.putConstraint(SpringLayout.NORTH, menu_to_unreturnbookreport, 11, SpringLayout.SOUTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_unreturnbookreport, 0, SpringLayout.EAST, error);
		menu_to_unreturnbookreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UnRetuenBookReport = new UnRetuenBookReport();
				UnRetuenBookReport.setVisible(true);
			}
		});
		contentPane.add(menu_to_unreturnbookreport);
		menu_to_borrow_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame borrowBook = new borrowBook();
				borrowBook.setVisible(true);
			}
		});
	}
	}
