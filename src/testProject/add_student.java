package testProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Frame;

public class add_student extends JFrame {
	private static controller myController = new controller();
	private JPanel contentPane;
	private JTextField name;
	private JTextField id;
	private JTextField telephone;
	private JTextField email;
	private JTextField student_id;
	private student s;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField error;
	private JButton menu_to_return_book;
	private JButton menu_to_borrow_book;
	private JButton menu_to_add_book;
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
				try {
					add_student frame = new add_student();
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
	public add_student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
	
				
				email = new JTextField();
				email.setBounds(21, 11, 96, 20);
				email.setColumns(10);
				contentPane.add(email);
				
				telephone = new JTextField();
				layout.putConstraint(SpringLayout.WEST, email, 0, SpringLayout.WEST, telephone);
				telephone.setBounds(319, 11, 96, 20);
				telephone.setColumns(10);
				contentPane.add(telephone, BorderLayout.CENTER);
				
				JButton add_student = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
				layout.putConstraint(SpringLayout.WEST, add_student, 0, SpringLayout.WEST, email);
				add_student.setBounds(15, 76, 91, 23);
				add_student.setVerticalAlignment(SwingConstants.TOP);
				contentPane.add(add_student);
				add_student.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						int c=0;
						int c1=0;
						ArrayList<student> data2= (ArrayList<student>) myController.loadStudentList();
						 for(int i=0; i<id.getText().length(); i++)
						    {
						    if(id.getText().charAt(i)>='0' && id.getText().charAt(i)<='0'+9)
						    {
					            c++;
						    }
						    }
						    if (id.getText().length()!=9 || c!=9)
						    {
						    	error.setText("תעודת זהות יכולה לכלול רק מספרים וצריכה להיות באורך 9");
								return;
						    }
						    c=0;
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
						for (student tStudent : data2)
						{
							if (tStudent.getId().equals(id.getText()))
							{
								error.setText("!סטודנט זה כבר קיים במערכת");
								return;
							}
						}
					    s= new student(id.getText(), name.getText(), telephone.getText(), email.getText(),student_id.getText());
						data2.add(s);
						myController.saveToStudentFileFromList(data2);
						myController.writeToStudentTextFileFromList(data2);
						error.setText("!סטודנט נוסף בהצלחה לרשימה");
					}
					});	
						name = new JTextField();
						layout.putConstraint(SpringLayout.NORTH, telephone, 6, SpringLayout.SOUTH, name);
						layout.putConstraint(SpringLayout.WEST, telephone, 0, SpringLayout.WEST, name);
						name.setBounds(170, 38, 96, 20);
						name.setColumns(10);
						contentPane.add(name);
				
				id = new JTextField();
				layout.putConstraint(SpringLayout.EAST, name, 0, SpringLayout.EAST, id);
				id.setBounds(10, 69, 96, 20);
				id.setColumns(10);
				contentPane.add(id);
				
				JLabel lblNewLabel = new JLabel("\u05E9\u05DD \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8-");
				layout.putConstraint(SpringLayout.NORTH, name, -3, SpringLayout.NORTH, lblNewLabel);
				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
				contentPane.add(lblNewLabel);
				
				student_id = new JTextField();
				layout.putConstraint(SpringLayout.NORTH, student_id, 6, SpringLayout.SOUTH, email);
				layout.putConstraint(SpringLayout.EAST, student_id, 0, SpringLayout.EAST, email);
				contentPane.add(student_id);
				student_id.setColumns(10);
				
				lblNewLabel_1 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA-");
				layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 22, SpringLayout.NORTH, contentPane);
				layout.putConstraint(SpringLayout.NORTH, id, -3, SpringLayout.NORTH, lblNewLabel_1);
				layout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
				layout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -154, SpringLayout.EAST, contentPane);
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
				contentPane.add(lblNewLabel_1);
				
				lblNewLabel_2 = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF-");
				layout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -12, SpringLayout.NORTH, lblNewLabel_2);
				layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
				contentPane.add(lblNewLabel_2);
				
				lblNewLabel_3 = new JLabel("\u05D0\u05D9\u05DE\u05D9\u05D9\u05DC-");
				layout.putConstraint(SpringLayout.NORTH, email, -3, SpringLayout.NORTH, lblNewLabel_3);
				layout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -12, SpringLayout.NORTH, lblNewLabel_3);
				layout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 435, SpringLayout.WEST, contentPane);
				layout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel);
				lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
				contentPane.add(lblNewLabel_3);
				
				lblNewLabel_4 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8-");
				layout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 126, SpringLayout.NORTH, contentPane);
				layout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -12, SpringLayout.NORTH, lblNewLabel_4);
				layout.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel);
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
				contentPane.add(lblNewLabel_4);
				
				lblNewLabel_5 = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
				layout.putConstraint(SpringLayout.EAST, id, 0, SpringLayout.EAST, lblNewLabel_5);
				layout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, contentPane);
				layout.putConstraint(SpringLayout.EAST, lblNewLabel_5, -243, SpringLayout.EAST, contentPane);
				lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
				contentPane.add(lblNewLabel_5);
				
				error = new JTextField();
				layout.putConstraint(SpringLayout.NORTH, error, 177, SpringLayout.NORTH, contentPane);
				layout.putConstraint(SpringLayout.SOUTH, add_student, -6, SpringLayout.NORTH, error);
				layout.putConstraint(SpringLayout.WEST, error, 24, SpringLayout.WEST, contentPane);
				layout.putConstraint(SpringLayout.EAST, error, -10, SpringLayout.EAST, contentPane);
				contentPane.add(error);
				error.setColumns(10);
				
				menu_to_return_book = new JButton("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
				contentPane.add(menu_to_return_book);
				menu_to_return_book.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						Frame ReturnBook = new ReturnBook();
						ReturnBook.setVisible(true);	
					}
				});
				
				menu_to_borrow_book = new JButton("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
				layout.putConstraint(SpringLayout.NORTH, menu_to_return_book, 0, SpringLayout.NORTH, menu_to_borrow_book);
				layout.putConstraint(SpringLayout.EAST, menu_to_return_book, -6, SpringLayout.WEST, menu_to_borrow_book);
				layout.putConstraint(SpringLayout.NORTH, menu_to_borrow_book, 6, SpringLayout.SOUTH, error);
				menu_to_borrow_book.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						Frame borrowBook = new borrowBook();
						borrowBook.setVisible(true);	
					}
				});
				contentPane.add(menu_to_borrow_book);
				
				menu_to_add_book = new JButton(" \u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
				layout.putConstraint(SpringLayout.EAST, menu_to_add_book, 0, SpringLayout.EAST, contentPane);
				layout.putConstraint(SpringLayout.EAST, menu_to_borrow_book, -6, SpringLayout.WEST, menu_to_add_book);
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
				
				menu_to_update_student_items = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
				layout.putConstraint(SpringLayout.NORTH, menu_to_update_student_items, 0, SpringLayout.NORTH, menu_to_return_book);
				layout.putConstraint(SpringLayout.WEST, menu_to_update_student_items, 0, SpringLayout.WEST, contentPane);
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
				layout.putConstraint(SpringLayout.NORTH, menu_to_search_book, 6, SpringLayout.SOUTH, error);
				layout.putConstraint(SpringLayout.EAST, menu_to_search_book, -6, SpringLayout.WEST, menu_to_return_book);
				menu_to_search_book.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						Frame SearchBook = new SearchBook();
						SearchBook.setVisible(true);
					}
				});
				contentPane.add(menu_to_search_book);
				
				menu_to_search_student = new JButton("\u05D7\u05D9\u05E4\u05E9\u05D5 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
				layout.putConstraint(SpringLayout.NORTH, menu_to_search_student, 0, SpringLayout.NORTH, menu_to_return_book);
				layout.putConstraint(SpringLayout.EAST, menu_to_search_student, -6, SpringLayout.WEST, menu_to_search_book);
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
				menu_to_unreturnbookreport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						Frame UnRetuenBookReport = new UnRetuenBookReport();
						UnRetuenBookReport.setVisible(true);
					}
				});
				layout.putConstraint(SpringLayout.NORTH, menu_to_unreturnbookreport, 7, SpringLayout.SOUTH, menu_to_add_book);
				layout.putConstraint(SpringLayout.EAST, menu_to_unreturnbookreport, -10, SpringLayout.EAST, menu_to_add_book);
				contentPane.add(menu_to_unreturnbookreport);
	}
	}
