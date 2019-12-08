package AdminSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.Person;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextField;

public class AdminForm extends javax.swing.JFrame{

	private static JFrame frame;
	public static String userId;
	private JTextField txtFirstname;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPostcode;
	private JTextField txtUsername;
	private JTextField txtPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		userId = id;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm admin = new AdminForm();
					admin.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				Person adminLogin = new Person();
				adminLogin.setID(userId);
				
				
			}
		});
	}
	public static void Close() {
		frame.dispose();
		return;
	}
	public AdminForm() {
		System.out.println(userId);
		initialize();
		System.out.println("end");
	}
	
	/**
	 * Create the application.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1075, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setBounds(12, 13, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminForm.Close();
				LoginForm.main(null);
			}
		});
		btnLogout.setBounds(948, 556, 97, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btnCreateAdmin = new JButton("Create Admin");
		btnCreateAdmin.setBounds(12, 75, 146, 25);
		frame.getContentPane().add(btnCreateAdmin);
		
		JButton btnAddDoctor = new JButton("Add Doctor");
		btnAddDoctor.setBounds(12, 113, 146, 25);
		frame.getContentPane().add(btnAddDoctor);
		
		JButton btnAddSecretary = new JButton("Add Secretary");
		btnAddSecretary.setBounds(12, 189, 146, 25);
		frame.getContentPane().add(btnAddSecretary);
		
		JButton btnNewButton = new JButton("Remove Doctor");
		btnNewButton.setBounds(12, 151, 146, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRemoveSecretary = new JButton("Remove Secretary");
		btnRemoveSecretary.setBounds(12, 227, 146, 25);
		frame.getContentPane().add(btnRemoveSecretary);
		
		JButton btnViewRatings = new JButton("View Ratings");
		btnViewRatings.setBounds(12, 265, 146, 25);
		frame.getContentPane().add(btnViewRatings);
		
		JButton btnSendFeedback = new JButton("Send Feedback");
		btnSendFeedback.setBounds(12, 303, 146, 25);
		frame.getContentPane().add(btnSendFeedback);
		
		JLabel lbluserID = new JLabel("12345");
		lbluserID.setBounds(57, 12, 101, 16);
		frame.getContentPane().add(lbluserID);
		
		lbluserID.setText(userId);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(594, 75, 100, 16);
		frame.getContentPane().add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(694, 75, 244, 22);
		frame.getContentPane().add(txtFirstname);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(594, 100, 56, 16);
		frame.getContentPane().add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(694, 100, 245, 22);
		frame.getContentPane().add(txtSurname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(594, 125, 56, 16);
		frame.getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(694, 125, 244, 22);
		frame.getContentPane().add(txtAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(594, 150, 56, 16);
		frame.getContentPane().add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(694, 150, 245, 22);
		frame.getContentPane().add(txtCity);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setBounds(594, 175, 56, 16);
		frame.getContentPane().add(lblPostcode);
		
		txtPostcode = new JTextField();
		txtPostcode.setColumns(10);
		txtPostcode.setBounds(694, 175, 116, 22);
		frame.getContentPane().add(txtPostcode);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(594, 200, 83, 16);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(694, 200, 116, 22);
		frame.getContentPane().add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(594, 225, 82, 16);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(694, 225, 245, 22);
		frame.getContentPane().add(txtPassword);
	}
}
