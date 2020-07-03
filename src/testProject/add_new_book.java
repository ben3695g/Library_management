package testProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class add_new_book extends JFrame {
	private JPanel contentPane;
	private JTextField book_name;
	private JTextField author;
	private JTextField location;
	private static model myModel = new model();
	private static controller myController = new controller();
	private Book book;
	private JLabel lblNewLabel;
	private JTextField error;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_new_book frame = new add_new_book();
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
	public add_new_book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		
		book_name = new JTextField();
		contentPane.add(book_name, BorderLayout.CENTER);
		book_name.setColumns(10);
		
		author = new JTextField();
		layout.putConstraint(SpringLayout.WEST, book_name, 0, SpringLayout.WEST, author);
		contentPane.add(author, BorderLayout.EAST);
		author.setColumns(10);
		
		location = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, location, 77, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, author, 0, SpringLayout.WEST, location);
		layout.putConstraint(SpringLayout.SOUTH, author, -6, SpringLayout.NORTH, location);
		contentPane.add(location, BorderLayout.SOUTH);
		location.setColumns(10);
		
		JButton add = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.WEST, add, 362, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, add, -393, SpringLayout.SOUTH, contentPane);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int c=0;
			    List<Book> data = myController.loadBookList();
			    for(int i=0; i<author.getText().length(); i++)
			    {
			    if((author.getText().charAt(i)>='א' && author.getText().charAt(i)<='א'+26) || (author.getText().charAt(i)>='a' && author.getText().charAt(i)<='a'+25) || (author.getText().charAt(i)>='A' && author.getText().charAt(i)<='A'+25))
			    {
					c++;
			    }
			    }
			    if(c==0)
			    {
			    	error.setText("שם כותב יכול לכלול רק אותיות");
					return;
			    }
			    if(book_name.getText().length()==0 || author.getText().length()==0 || location.getText().length()==0)
			    {
			    	error.setText("צריך למלא את כל השדות");
					return;
			    }
				for (Book tBook : data)
				{
					if (tBook.getBookName().equals(book_name.getText()))
					{
						error.setText("!הספר שאתה מנסה להוסיף כבר קיים במערכת");
						return;
					}
				}
			    book= new Book(book_name.getText(), author.getText(), location.getText(), false,"","","","");
				data.add(book);
				myController.saveToBookFileFromList(data);
				myController.writeToBookTextFileFromList(data);
				error.setText("!הספר נוסף בהצלחה");
			}
		});
		contentPane.add(add, BorderLayout.CENTER);
		
		JButton remove = new JButton("\u05D4\u05E1\u05E8 \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, remove, 0, SpringLayout.NORTH, add);
		layout.putConstraint(SpringLayout.EAST, remove, -6, SpringLayout.WEST, add);
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			    List<Book> data = myModel.loadBookList();
				for (Book tBook : data)
				{
					if (tBook.getBookName().equals(book_name.getText()))
					{
						data.remove(tBook);
						myModel.saveToBookFileFromList(data);
						myModel.writeToBookTextFileFromList(data);
						error.setText("הספר הוסר בהצלחה!");
						return;
					}		
				}
				error.setText("הספר שאתה מנסה להסיר אינו קיים במערכת!");
			}
		});
		contentPane.add(remove, BorderLayout.WEST);
		
		JButton menu_to_borrow_book = new JButton("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
		contentPane.add(menu_to_borrow_book);
		
		lblNewLabel = new JLabel("\u05E9\u05DD \u05E1\u05E4\u05E8-");
		layout.putConstraint(SpringLayout.NORTH, book_name, -3, SpringLayout.NORTH, lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		layout.putConstraint(SpringLayout.EAST, lblNewLabel, -28, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05DB\u05D5\u05EA\u05D1-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 60, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -18, SpringLayout.NORTH, lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u05DE\u05D9\u05E7\u05D5\u05DD \u05D1\u05E1\u05E4\u05E8\u05D9\u05D4-");
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 522, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -23, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.EAST, location, -129, SpringLayout.WEST, lblNewLabel_2);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 19, SpringLayout.SOUTH, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, book_name);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -246, SpringLayout.EAST, contentPane);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		error = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, error, 14, SpringLayout.SOUTH, add);
		layout.putConstraint(SpringLayout.WEST, error, 25, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, error, 0, SpringLayout.EAST, contentPane);
		contentPane.add(error);
		error.setColumns(10);
		
		JButton menu_to_add_student = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_student, 0, SpringLayout.NORTH, menu_to_borrow_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_student, -6, SpringLayout.WEST, menu_to_borrow_book);
		contentPane.add(menu_to_add_student);
		
		JButton menu_to_return_book = new JButton("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_return_book, 0, SpringLayout.NORTH, menu_to_borrow_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_return_book, -6, SpringLayout.WEST, menu_to_add_student);
		contentPane.add(menu_to_return_book);
		
		JButton menu_to_update_student_items = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_update_student_items, 9, SpringLayout.SOUTH, menu_to_borrow_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_update_student_items, 0, SpringLayout.EAST, error);
		menu_to_update_student_items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UpdataStudentItems = new UpdateStudentItems();
				UpdataStudentItems.setVisible(true);
			}
		});
		contentPane.add(menu_to_update_student_items);
		
		JButton menu_to_search_book = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_borrow_book, 0, SpringLayout.NORTH, menu_to_search_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_borrow_book, -6, SpringLayout.WEST, menu_to_search_book);
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_book, 10, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_search_book, 0, SpringLayout.EAST, error);
		menu_to_search_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchBook = new SearchBook();
				SearchBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_search_book);
		
		JButton menu_to_search_student = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_student, 0, SpringLayout.NORTH, menu_to_borrow_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_search_student, -6, SpringLayout.WEST, menu_to_return_book);
		menu_to_search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchStudent = new SearchStudent();
				SearchStudent.setVisible(true);
			}
		});
		contentPane.add(menu_to_search_student);
		
		JButton menu_to_unreturnbookreport = new JButton("\u05E1\u05E4\u05E8\u05D9\u05DD \u05E9\u05DC\u05D0 \u05D4\u05D5\u05D7\u05D6\u05E8\u05D5 \u05D1\u05D6\u05DE\u05DF");
		menu_to_unreturnbookreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UnRetuenBookReport = new UnRetuenBookReport();
				UnRetuenBookReport.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, menu_to_unreturnbookreport, 0, SpringLayout.NORTH, menu_to_update_student_items);
		layout.putConstraint(SpringLayout.EAST, menu_to_unreturnbookreport, -7, SpringLayout.WEST, menu_to_update_student_items);
		contentPane.add(menu_to_unreturnbookreport);
		menu_to_borrow_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame borrowBook = new borrowBook();
				borrowBook.setVisible(true);
			}
		});
		menu_to_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_student = new add_student();
				add_student.setVisible(true);
			}
			});
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
