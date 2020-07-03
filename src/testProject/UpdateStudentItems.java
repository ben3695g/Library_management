package testProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdateStudentItems extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField telephone;
	private JTextField email;
	private JTextField error;
	private JTextField student_id;
	private static controller myController = new controller();
	private static ArrayList<Book> data= new ArrayList<Book>();   
	private student s;
	private JButton menu_to_add_book;
	private JButton menu_to_borrow_book;
	private JButton menu_to_return_book;
	private JButton menu_to_add_student;
	private JButton menu_to_search_book;
	private JButton menu_to_search_student;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudentItems frame = new UpdateStudentItems();
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
	public UpdateStudentItems() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		id = new JTextField();
		layout.putConstraint(SpringLayout.EAST, id, -340, SpringLayout.EAST, contentPane);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, name, 6, SpringLayout.SOUTH, id);
		layout.putConstraint(SpringLayout.EAST, name, 0, SpringLayout.EAST, id);
		contentPane.add(name);
		name.setColumns(10);
		
		telephone = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, telephone, 6, SpringLayout.SOUTH, name);
		layout.putConstraint(SpringLayout.WEST, telephone, 0, SpringLayout.WEST, id);
		contentPane.add(telephone);
		telephone.setColumns(10);
		
		email = new JTextField();
		layout.putConstraint(SpringLayout.EAST, email, 0, SpringLayout.EAST, id);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, id, 7, SpringLayout.SOUTH, lblNewLabel);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel, -271, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, id);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 36, SpringLayout.EAST, id);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u05E9\u05DD-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, name);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF-");
		layout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, telephone);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH, email);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8-");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_5);
		
		JButton update = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
		layout.putConstraint(SpringLayout.EAST, update, -309, SpringLayout.EAST, contentPane);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int c=0;
				int c1=0;
				List<student> reads = myController.loadStudentList();
				 for(int i=0; i<name.getText().length(); i++)
				    {
				    if((name.getText().charAt(i)>='א' && name.getText().charAt(i)<='א'+26) || (name.getText().charAt(i)>='a' && name.getText().charAt(i)<='a'+25) || (name.getText().charAt(i)>='A' && name.getText().charAt(i)<='A'+25))
				    {
						c++;
				    }
				    }
				    if(c==0)
				    {
				    	error.setText("שם יכול לכלול רק אותיות");
						return;
				    }
				    c=0;
					    for(int i=0; i<telephone.getText().length(); i++)
					    {
					    if(telephone.getText().charAt(i)>='0' && telephone.getText().charAt(i)<='0'+9)
					    {
				            c++;
					    }
					    }
					    if (telephone.getText().length()!=10 || c!=10 || telephone.getText().charAt(0)!='0' || telephone.getText().charAt(1)!='5')
					    {
					    	error.setText("מספר נייד יכול לכלול רק מספרים צריך להתחיל ב05 ולהיות באורך 10");
							return;
					    }
					    c=0;
					    for(int i=0; i<email.getText().length(); i++)
					    {
					    if(email.getText().charAt(i)=='@')
					    {
				            c++;
					    }
					    if(email.getText().charAt(i)=='.')
					    {
				            c1++;
					    }
					    }
					    if(c!=1 || c1==0)
					    {
					    	error.setText("מבנה אימייל לא תקין");
							return;
					    }
					    c=0;
					    if(email.getText().charAt(0)=='@')
					    {
					    	error.setText("מבנה אימייל לא תקין");
							return;
					    }
					    for(int i=0; i<email.getText().length(); i++)
					    {
					    if(email.getText().charAt(i)=='@' && c==0)
					    {
				            c=i;
					    }
					    }
					    if(email.getText().charAt(email.getText().length()-1)=='@' || email.getText().charAt(email.getText().length()-1)=='.')
					    {
					    	error.setText("מבנה אימייל לא תקין");
							return;
					    }
					    if(email.getText().charAt(c+1)=='@' || email.getText().charAt(c+1)=='.')
					    {
					    	error.setText("מבנה אימייל לא תקין");
							return;
					    }
					    c=0;
					    for(int i=0; i<student_id.getText().length(); i++)
					    {
					    if(student_id.getText().charAt(i)>='0' && student_id.getText().charAt(i)<='0'+9)
					    {
				            c++;
					    }
					    }
					    if (student_id.getText().length()==0 || c!=student_id.getText().length())
					    {
					    	error.setText("מספר סטודנט חייב לכלול רק מספרים");
							return;
					    }
				for (student tstudent : reads)
				{
			    if (tstudent.getId().equals(id.getText()))
				{
					s = new student(id.getText(),name.getText(), telephone.getText(),email.getText(), student_id.getText());
					reads.remove(tstudent);
					reads.add(s);
					myController.saveToStudentFileFromList(reads);
					myController.writeToStudentTextFileFromList(reads);
					error.setText("!פרטי סטודנט עודכנו בהצלחה");
					return;
				}
				}
				error.setText("!תעודת זהות של סטודנט זה אינה קיימת במערכת");
			}
		});
		contentPane.add(update);
		
		error = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, error, 6, SpringLayout.SOUTH, update);
		layout.putConstraint(SpringLayout.WEST, error, 16, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, error, -10, SpringLayout.EAST, contentPane);
		contentPane.add(error);
		error.setColumns(10);
		
		student_id = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, update, 6, SpringLayout.SOUTH, student_id);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, student_id);
		layout.putConstraint(SpringLayout.NORTH, student_id, 129, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, email, -6, SpringLayout.NORTH, student_id);
		layout.putConstraint(SpringLayout.WEST, student_id, 0, SpringLayout.WEST, id);
		contentPane.add(student_id);
		student_id.setColumns(10);
		
		menu_to_add_book = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_book, 12, SpringLayout.SOUTH, error);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_book, -10, SpringLayout.EAST, contentPane);
		menu_to_add_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_new_book = new add_new_book();
				add_new_book.setVisible(true);
			}
		});
		contentPane.add(menu_to_add_book);
		
		menu_to_borrow_book = new JButton("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_borrow_book, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_borrow_book, -6, SpringLayout.WEST, menu_to_add_book);
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
		layout.putConstraint(SpringLayout.NORTH, menu_to_return_book, 0, SpringLayout.NORTH, menu_to_add_book);
		menu_to_return_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame ReturnBook = new ReturnBook();
				ReturnBook.setVisible(true);
			}
		});
		contentPane.add(menu_to_return_book);
		
		menu_to_add_student = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_student, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_add_student, -6, SpringLayout.WEST, menu_to_borrow_book);
		menu_to_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_student = new add_student();
				add_student.setVisible(true);
			}
		});
		contentPane.add(menu_to_add_student);
		
		menu_to_search_book = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.EAST, menu_to_return_book, -6, SpringLayout.WEST, menu_to_search_book);
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_book, 0, SpringLayout.NORTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_search_book, -6, SpringLayout.WEST, menu_to_add_student);
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
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_student, 0, SpringLayout.NORTH, menu_to_add_book);
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
		layout.putConstraint(SpringLayout.NORTH, menu_to_unreturnbookreport, 6, SpringLayout.SOUTH, menu_to_add_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_unreturnbookreport, 0, SpringLayout.EAST, error);
		contentPane.add(menu_to_unreturnbookreport);
		menu_to_search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchStudent = new SearchStudent();
				SearchStudent.setVisible(true);
			}
		});
	}
}
