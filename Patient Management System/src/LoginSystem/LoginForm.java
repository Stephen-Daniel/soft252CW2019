package LoginSystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import PatientSystem.RequestForm;
import SecretarySystem.secretary;
import java.awt.event.InputMethodListener;
import java.io.File;
import java.awt.event.InputMethodEvent;

public class LoginForm extends javax.swing.JFrame{

	private static JFrame frmPatientManagementSystem;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JPasswordField txtPassword;
	private String date;
	public String time;
	JLabel lblTime;
	JLabel lblMessage;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginForm login = new LoginForm();
					login.frmPatientManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public LoginForm() {
		initialize();
		showTime();
		
	}
	
	void showTime() {
		new Timer(0, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date d = new Date();
				SimpleDateFormat s = new SimpleDateFormat("hh:mm a");
				
				lblTime.setText("Time: " + s.format(d));
								
				//throw new UnsupportedOperationException("Not supported");
			}			
		}).start();		
	}
	
	public static void Close() {
		frmPatientManagementSystem.dispose();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPatientManagementSystem = new JFrame();
		frmPatientManagementSystem.setType(Type.POPUP);
		frmPatientManagementSystem.setTitle("Patient Management System");
		frmPatientManagementSystem.setBounds(100, 100, 900, 600);
		frmPatientManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatientManagementSystem.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("LOGIN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setBounds(250, 30, 100, 30);
		frmPatientManagementSystem.getContentPane().add(lblTitle);
		
		txtUsername = new JTextField("A10000001");
		txtUsername.setFont(new Font("Arial", Font.BOLD, 20));
		txtUsername.setBounds(250, 90, 300, 40);
		frmPatientManagementSystem.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
		lblUsername.setBounds(100, 100, 100, 20);
		frmPatientManagementSystem.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblPassword.setBounds(100, 200, 100, 20);
		frmPatientManagementSystem.getContentPane().add(lblPassword);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			System.exit(0);
			}
		});
		btnExit.setFont(new Font("Arial", Font.BOLD, 15));
		btnExit.setBounds(500, 300, 100, 30);
		frmPatientManagementSystem.getContentPane().add(btnExit);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = txtPassword.getText();
			
				VerifyLogin checkLogin = new VerifyLogin();
				checkLogin.verifyLogin(username, password);
				// error message for in correct username and or password
				lblMessage.setText("Incorrect Username and or Password. Please try again.");
				
			}
		});
		btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogin.setBounds(100, 300, 100, 30);
		frmPatientManagementSystem.getContentPane().add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		// clear text windows and the message label		
				txtUsername.setText(null);
				txtPassword.setText(null);
				lblMessage.setText(null);
				
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 15));
		btnClear.setBounds(300, 300, 100, 30);
		frmPatientManagementSystem.getContentPane().add(btnClear);
		
		txtPassword = new JPasswordField("password");
		txtPassword.setFont(new Font("Arial", Font.BOLD, 20));
		txtPassword.setBounds(250, 190, 300, 40);
		frmPatientManagementSystem.getContentPane().add(txtPassword);
		
		JButton btnCreatePatient = new JButton("Apply for an account");
		btnCreatePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RequestForm.main(null);
				LoginForm.Close();
				
//				System.out.println("want an account");
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				System.exit(0);
			}
		});
		btnCreatePatient.setFont(new Font("Arial", Font.BOLD, 15));
		btnCreatePatient.setBounds(487, 11, 190, 23);
		frmPatientManagementSystem.getContentPane().add(btnCreatePatient);
		
		// to make the label change declare at the beginning
		lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Arial", Font.BOLD, 18));
		lblMessage.setBounds(100, 360, 500, 20);
		frmPatientManagementSystem.getContentPane().add(lblMessage);
		
		DateTime d = new DateTime();
		date = d.showDate(date);
		
		JLabel lblDate = new JLabel("Date: " + date);
		lblDate.setBounds(744, 16, 111, 14);
		frmPatientManagementSystem.getContentPane().add(lblDate);
		
		lblTime = new JLabel("Time: ");
		
		
		lblTime.setBounds(744, 45, 111, 14);
		frmPatientManagementSystem.getContentPane().add(lblTime);
		
	}
}
