package LoginSystem;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import PatientSystem.RequestForm;

public class LoginForm extends javax.swing.JFrame{


	private static final long serialVersionUID = 1L;
	private static JFrame frmPatientManagementSystem;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JPasswordField txtPassword;
	private String date;
	private String newDate;
	
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
		frmPatientManagementSystem.setBounds(100, 100, 669, 482);
		frmPatientManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatientManagementSystem.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("LOGIN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setBounds(100, 24, 100, 30);
		frmPatientManagementSystem.getContentPane().add(lblTitle);
		
		txtUsername = new JTextField("D1003");
		txtUsername.setFont(new Font("Arial", Font.BOLD, 20));
		txtUsername.setBounds(250, 90, 300, 40);
		frmPatientManagementSystem.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
		lblUsername.setBounds(100, 100, 100, 20);
		frmPatientManagementSystem.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
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
		btnExit.setBounds(543, 391, 100, 30);
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
		btnLogin.setBounds(450, 241, 100, 30);
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
		btnClear.setBounds(340, 241, 100, 30);
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
				
			}
		});
		btnCreatePatient.setFont(new Font("Arial", Font.BOLD, 15));
		btnCreatePatient.setBounds(10, 409, 190, 23);
		frmPatientManagementSystem.getContentPane().add(btnCreatePatient);
		
		// to make the label change declare at the beginning
		lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Arial", Font.BOLD, 18));
		lblMessage.setBounds(100, 360, 500, 20);
		frmPatientManagementSystem.getContentPane().add(lblMessage);
		
		MainDate getDate = new MainDate();
		date = getDate.sendDate(newDate);
		
		JLabel lblDate = new JLabel("Date: " + date);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(386, 24, 257, 14);
		frmPatientManagementSystem.getContentPane().add(lblDate);
		
		JButton btnCal = new JButton("calender");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(getDate.sendDate(newDate));
			}
		});	
		btnCal.setBounds(10, 289, 89, 23);
		frmPatientManagementSystem.getContentPane().add(btnCal);
		
	}
}
