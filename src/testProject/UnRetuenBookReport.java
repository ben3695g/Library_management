package testProject;
import java.awt.EventQueue;
import java.lang.String;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;

public class UnRetuenBookReport extends JFrame {
	/**
	 * 
	 */
	private int c=0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField year;
	Book book = new Book();
	private static controller myController = new controller();
	private JTextField month;
	private JTextField day;
	private JTextField error;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnRetuenBookReport frame = new UnRetuenBookReport();
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
	public UnRetuenBookReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		

		
		JLabel lblNewLabel = new JLabel("\u05D4\u05E6\u05D2\u05EA \u05E1\u05E4\u05E8\u05D9\u05DD \u05E9\u05DC\u05D0 \u05D4\u05D5\u05D7\u05D6\u05E8\u05D5 \u05D1\u05D6\u05DE\u05DF");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05E9\u05DC \u05D4\u05D9\u05D5\u05DD-");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		year = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, year, 21, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, year);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 23, SpringLayout.EAST, year);
		layout.putConstraint(SpringLayout.EAST, year, -208, SpringLayout.EAST, contentPane);
		contentPane.add(year);
		year.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_2, -291, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.WEST, year, 22, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(lblNewLabel_2);
		
		month = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, month, 21, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, month, -19, SpringLayout.WEST, lblNewLabel_2);
		contentPane.add(month);
		month.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -409, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.WEST, month, 6, SpringLayout.EAST, lblNewLabel_3);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		
		day = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, day, -3, SpringLayout.NORTH, lblNewLabel_1);
		layout.putConstraint(SpringLayout.WEST, day, 183, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, day, -10, SpringLayout.WEST, lblNewLabel_3);
		contentPane.add(day);
		day.setColumns(10);
	
		
		JButton search = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9");
		layout.putConstraint(SpringLayout.NORTH, search, 6, SpringLayout.SOUTH, month);
		layout.putConstraint(SpringLayout.EAST, search, -10, SpringLayout.EAST, month);
		JTextArea text_Report = new JTextArea();
		layout.putConstraint(SpringLayout.NORTH, text_Report, 108, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, text_Report, -80, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, text_Report, 17, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, text_Report, -10, SpringLayout.EAST, contentPane);
		contentPane.add(text_Report);
		text_Report.setEditable(false);
		JScrollPane scrollPane = new JScrollPane();
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, scrollPane);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel, 238, SpringLayout.EAST, scrollPane);
		scrollPane.setBounds(34, 53, 766, 488);
		//scrollPane.setViewportView(text_Report);
		contentPane.add(scrollPane);
		text_Report.setFont(new Font("Tahoma", Font.BOLD, 14));
		search.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				List<Book> read = myController.loadBookList();
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
				int year3 = year1;
				if(year3<2020)
				{
					error.setText("שנה לא חוקית");
					return;	
				}
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
				if((month3==4 || month3==6 || month3==9 || month3==11) && day3>30)
				{
					error.setText("תאריך לא תקין");
					return;
				}
				for (Book tBook : read)
				{
					if(tBook.getborrow()==true)
					{
					boolean value= myController.biggerdate(tBook.get_borrow_date_day(),tBook.get_borrow_date_month(), tBook.get_borrow_date_year(),day.getText(), month.getText(), year.getText());
					if(value==true)
					{
						error.setText("");
						String oldText = text_Report.getText();
						String newText = tBook.getBookName() + " -שם ספר" + System.getProperty("line.separator") +
						tBook.getauthor() + " -מחבר" + System.getProperty("line.separator") +
						tBook.getlocation() + " -מיקום" + System.getProperty("line.separator") +
						"האם מושאל- כן" + System.getProperty("line.separator") +
						tBook.getstudent() + " -סטודנט משאיל" + System.getProperty("line.separator") +
						tBook.get_borrow_date_day() + "." + tBook.get_borrow_date_month() + "." + tBook.get_borrow_date_year() + " -תאריך השאלה" + System.getProperty("line.separator") +
						"----------------------------------" + System.getProperty("line.separator");
						text_Report.setText(oldText + newText);
						c++;
					}
					}
				}
				if(c==0)
				{
					error.setText("אין ספרים להצגה");
					return;	
				}
			}
		});
		contentPane.add(search);
		
		JButton menu_to_add_new_book = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_new_book, 1, SpringLayout.SOUTH, text_Report);
		menu_to_add_new_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_new_book = new add_new_book();
				add_new_book.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.EAST, menu_to_add_new_book, 0, SpringLayout.EAST, contentPane);
		contentPane.add(menu_to_add_new_book);
		
		JButton menu_to_add_student = new JButton("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_add_student, 1, SpringLayout.SOUTH, text_Report);
		menu_to_add_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame add_student = new add_student();
				add_student.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.EAST, menu_to_add_student, -6, SpringLayout.WEST, menu_to_add_new_book);
		contentPane.add(menu_to_add_student);
		
		JButton menu_to_borrow_book = new JButton("\u05D4\u05E9\u05D0\u05DC\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_borrow_book, 1, SpringLayout.SOUTH, text_Report);
		menu_to_borrow_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame borrowBook = new borrowBook();
				borrowBook.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.EAST, menu_to_borrow_book, 0, SpringLayout.EAST, year);
		contentPane.add(menu_to_borrow_book);
		
		JButton menu_to_return_book = new JButton("\u05D4\u05D7\u05D6\u05E8\u05EA \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_return_book, 1, SpringLayout.SOUTH, text_Report);
		menu_to_return_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame ReturnBook = new ReturnBook();
				ReturnBook.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.EAST, menu_to_return_book, 0, SpringLayout.EAST, month);
		contentPane.add(menu_to_return_book);
		
		JButton menu_to_search_book = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05E4\u05E8");
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_book, 1, SpringLayout.SOUTH, text_Report);
		menu_to_search_book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchBook = new SearchBook();
				SearchBook.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.EAST, menu_to_search_book, 0, SpringLayout.EAST, lblNewLabel_3);
		contentPane.add(menu_to_search_book);
		
		JButton menu_to_search_student = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		menu_to_search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame SearchStudent = new SearchStudent();
				SearchStudent.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, menu_to_search_student, 0, SpringLayout.NORTH, menu_to_add_new_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_search_student, -6, SpringLayout.WEST, menu_to_search_book);
		contentPane.add(menu_to_search_student);
		
		JButton menu_to_update_student_items = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF \u05E4\u05E8\u05D8\u05D9 \u05E1\u05D8\u05D5\u05D3\u05E0\u05D8");
		menu_to_update_student_items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				Frame UpdataStudentItems = new UpdateStudentItems();
				UpdataStudentItems.setVisible(true);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, menu_to_update_student_items, 4, SpringLayout.SOUTH, menu_to_add_new_book);
		layout.putConstraint(SpringLayout.EAST, menu_to_update_student_items, 0, SpringLayout.EAST, menu_to_add_new_book);
		contentPane.add(menu_to_update_student_items);
		
		JButton clear = new JButton("clear");
		layout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -9, SpringLayout.NORTH, clear);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				error.setText("");
				String newText1="";
				text_Report.setText(newText1);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, clear, 6, SpringLayout.SOUTH, year);
		layout.putConstraint(SpringLayout.WEST, clear, 6, SpringLayout.EAST, search);
		contentPane.add(clear);
		
		error = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, error, 6, SpringLayout.SOUTH, search);
		layout.putConstraint(SpringLayout.WEST, error, 0, SpringLayout.WEST, menu_to_search_student);
		layout.putConstraint(SpringLayout.EAST, error, -44, SpringLayout.EAST, contentPane);
		contentPane.add(error);
		error.setColumns(10);
	}
}
