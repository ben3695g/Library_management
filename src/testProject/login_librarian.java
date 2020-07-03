package testProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login_librarian extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField error;
    private librarian l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_librarian frame = new login_librarian();
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
	public login_librarian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		username = new JTextField();
		layout.putConstraint(SpringLayout.EAST, username, -332, SpringLayout.EAST, contentPane);
		username.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		layout.putConstraint(SpringLayout.EAST, password, 0, SpringLayout.EAST, username);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, username);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel, 32, SpringLayout.EAST, username);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4-");
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 23, SpringLayout.SOUTH, lblNewLabel);
		layout.putConstraint(SpringLayout.NORTH, password, -3, SpringLayout.NORTH, lblNewLabel_1);
		layout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		layout.putConstraint(SpringLayout.NORTH, username, 19, SpringLayout.SOUTH, lblNewLabel_2);
		layout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 301, SpringLayout.WEST, contentPane);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);
		
		JButton login = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		layout.putConstraint(SpringLayout.NORTH, login, 20, SpringLayout.SOUTH, password);
		layout.putConstraint(SpringLayout.WEST, login, 0, SpringLayout.WEST, lblNewLabel_2);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				l=new librarian("123777", "123777");
				if(l.getUsername().equals(username.getText()) && l.getPassword().equals(password.getText()))
				{
				setVisible(false);
				Frame add_new_book = new add_new_book();
				add_new_book.setVisible(true);
				}
				else
				{
					error.setText("!שם המשתמש או הסיסמה אינם חוקיים");
				}
			}
		});
		contentPane.add(login);
		
		error = new JTextField();
		layout.putConstraint(SpringLayout.NORTH, error, 18, SpringLayout.SOUTH, login);
		layout.putConstraint(SpringLayout.WEST, error, 28, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, error, -15, SpringLayout.EAST, contentPane);
		contentPane.add(error);
		error.setColumns(10);
	}
}
