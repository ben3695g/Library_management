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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SearchStudent extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField id_student;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JTextField student_id;
	private JTextField error;
	private static controller myController = new controller();
	private student student;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchStudent frame = new SearchStudent();
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
	public SearchStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		JLabel lblNewLabel = new JLabel("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel, -265, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA-");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, id, 6, SpringLayout.SOUTH, lblNewLabel);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 6, SpringLayout.EAST, id);
		layout.putConstraint(SpringLayout.WEST, id, 210, SpringLayout.WEST, contentPane);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton search = new JButton("\u05D7\u05E4\u05E9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, search, 1, SpringLayout.SOUTH, id);
		layout.putConstraint(SpringLayout.WEST, search, 233, SpringLayout.WEST, contentPane);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				List<student> read = myController.loadStudentList();
				for (student tStudent : read)
				{
			    if (tStudent.getId().equals(id.getText()))
				{
			    	id_student.setText(tStudent.getId());
			    	name.setText(tStudent.getName());
			    	phone.setText(tStudent.getPhone());
			    	email.setText(tStudent.getEmail());
			    	student_id.setText(tStudent.GetStudent_id());
			    	return;
				}
				}
				error.setText("!שם סטודנט זה אינו קיים במערכת");
			}
		});
		contentPane.add(search);
		
		JLabel lblNewLabel_2 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA-");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		id_student = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, id_student);
		layout.putConstraint(SpringLayout.EAST, id_student, -333, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, id_student, 6, SpringLayout.SOUTH, search);
		contentPane.add(id_student);
		id_student.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u05E9\u05DD-");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3);
		
		name = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, name);
		layout.putConstraint(SpringLayout.NORTH, name, 6, SpringLayout.SOUTH, id_student);
		layout.putConstraint(SpringLayout.EAST, name, 0, SpringLayout.EAST, id_student);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF-");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(lblNewLabel_4);
		
		phone = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, phone);
		layout.putConstraint(SpringLayout.NORTH, phone, 6, SpringLayout.SOUTH, name);
		layout.putConstraint(SpringLayout.WEST, phone, 0, SpringLayout.WEST, id_student);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC-");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_5);
		
		email = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, email);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 55, SpringLayout.EAST, email);
		layout.putConstraint(SpringLayout.NORTH, email, 6, SpringLayout.SOUTH, phone);
		layout.putConstraint(SpringLayout.EAST, email, 0, SpringLayout.EAST, id_student);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 9, SpringLayout.SOUTH, lblNewLabel_5);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_6);
		
		student_id = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, student_id, -3, SpringLayout.NORTH, lblNewLabel_6);
		layout.putConstraint(SpringLayout.EAST, student_id, 0, SpringLayout.EAST, id_student);
		contentPane.add(student_id);
		student_id.setColumns(10);
		
		error = new JTextField();
		layout.putConstraint(SpringLayout.WEST, error, 10, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, error, -317, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, error, -15, SpringLayout.EAST, contentPane);
		contentPane.add(error);
		error.setColumns(10);
		
		JButton menu_to_add_book = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_book, 6, SpringLayout.SOUTH, error);
		menu_to_add_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_new_book = new add_new_book();
				add_new_book.setVisible(true);
			}
		});
		contentPane.add(menu_to_add_book);
		
		JButton menu_to_borrow_book = new JButton("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_borrow_book, 6, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_borrow_book, 0, SpringLayout.EAST, id);
		menu_to_borrow_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame borrowBook = new borrowBook();
				borrowBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_borrow_book);
		
		JButton menu_to_return_book = new JButton("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_return_book, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_return_book, -6, SpringLayout.WEST, menu_to_borrow_book);
		menu_to_return_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame ReturnBook = new ReturnBook();
				ReturnBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_return_book);
		
		JButton menu_to_add_student = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_student, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_student, -6, SpringLayout.WEST, menu_to_add_book);
		menu_to_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_student = new add_student();
				add_student.setVisible(true);
			}
		});
		contentPane.add(menu_to_add_student);
		
		JButton menu_to_update_student_items = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_update_student_items, 6, SpringLayout.SOUTH, menu_to_add_book);
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
		layout.putConstraint(SpringLayout.EAST, menu_to_search_book, -10, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_book, -6, SpringLayout.WEST, menu_to_search_book);
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_book, 6, SpringLayout.SOUTH, error);
		menu_to_search_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchBook = new SearchBook();
				SearchBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_search_book);
		
		JButton menu_to_unreturnbookreport = new JButton("\u05E1\u05E4\u05E8\u05D9\u05DD \u05E9\u05DC\u05D0 \u05D4\u05D5\u05D7\u05D6\u05E8\u05D5 \u05D1\u05D6\u05DE\u05DF");
		menu_to_unreturnbookreport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UnRetuenBookReport = new UnRetuenBookReport();
				UnRetuenBookReport.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, menu_to_unreturnbookreport, 6, SpringLayout.SOUTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_unreturnbookreport, -7, SpringLayout.WEST, menu_to_update_student_items);
		contentPane.add(menu_to_unreturnbookreport);
	}

}
