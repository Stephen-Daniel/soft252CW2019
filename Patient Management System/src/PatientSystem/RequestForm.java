package PatientSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import LoginSystem.LoginForm;
import LoginSystem.Person;
import LoginSystem.uniqueNumber;
import SecretarySystem.SecretaryForm;

import javax.swing.JRadioButton;

public class RequestForm extends javax.swing.JFrame{

	public static JFrame frame;
	public int number;
	public  String request;
	public  JTextField txtFirstname;
	public  JTextField txtSurname;
	public  JTextField txtAddress;
	public  JTextField txtCity;
	public  JTextField txtPostcode;
	public  JTextField txtAge;
	public  JTextField txtUsername;
	public  JTextField txtPassword;
	public  boolean female;
	public  boolean male;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestForm newRequest = new RequestForm();
					newRequest.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RequestForm() {
		initialize();
	}

	public static void Close() {
		frame.dispose();
		return;
	}
	 public void Clear()
	 {
		txtFirstname.setText("");
		txtSurname.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtPostcode.setText("");
		txtAge.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
		
	 }
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RequestForm.Close();
				LoginForm.main(null);
			}
		});
		frame.getContentPane().setLayout(null);
		btnExit.setFont(new Font("Arial", Font.BOLD, 20));
		btnExit.setBounds(570, 500, 100, 30);
		frame.getContentPane().add(btnExit);
		
		JButton btnSubmit = new JButton("Submit Request");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uniqueNumber requestNumber = new uniqueNumber();				
				number = requestNumber.uniqueNumber();	
				//create unique temp file for Patient
				
				request = "tempP" + Integer.toString(number) + ".txt";
				System.out.println(request);
				File newRequest = new File(request);
				
				// grab the users input and write to new temp file.
				
				try
				{					
					FileWriter fw = new FileWriter(request);
					PrintWriter pw = new PrintWriter(fw);
		            	 
		            pw.println(txtFirstname.getText());
		            pw.println(txtSurname.getText());
		            pw.println(txtAddress.getText());
		            pw.println(txtCity.getText());
		            pw.println(txtPostcode.getText());
		            if (male == true)
		            {
		            	pw.println("Male");
		            }else {
		            	pw.println("Female");
		            }
		            pw.println(txtAge.getText());
		            pw.println(txtUsername.getText());
		            pw.println(txtPassword.getText());
		            pw.flush();
		            pw.close();		            
		            fw.close(); 
		            SecretaryForm.sentRequest(request);
		            RequestForm.Close();
					LoginForm.main(null);
					
				}
				catch (IOException e) {
		            e.printStackTrace();
									
				}
//				
			}
		});
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 20));
		btnSubmit.setBounds(360, 500, 200, 30);
		frame.getContentPane().add(btnSubmit);
		
		JRadioButton btnMale = new JRadioButton("Male");
		JRadioButton btnFemale = new JRadioButton("Female");
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear();
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 20));
		
		btnClear.setBounds(250, 500, 100, 30);
		frame.getContentPane().add(btnClear);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setFont(new Font("Arial", Font.BOLD, 20));
		lblFirstname.setBounds(40, 55, 150, 20);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Arial", Font.BOLD, 20));
		lblSurname.setBounds(40, 95, 150, 20);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial", Font.BOLD, 20));
		lblAddress.setBounds(40, 135, 150, 20);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Arial", Font.BOLD, 20));
		lblCity.setBounds(40, 175, 150, 20);
		frame.getContentPane().add(lblCity);
		
		JLabel lblPostCode = new JLabel("Post Code");
		lblPostCode.setFont(new Font("Arial", Font.BOLD, 20));
		lblPostCode.setBounds(40, 215, 150, 20);
		frame.getContentPane().add(lblPostCode);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Arial", Font.BOLD, 20));
		lblGender.setBounds(40, 255, 150, 20);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Arial", Font.BOLD, 20));
		lblAge.setBounds(40, 295, 150, 20);
		frame.getContentPane().add(lblAge);
		
		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFirstname.setBounds(200, 45, 500, 30);
		frame.getContentPane().add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSurname.setColumns(10);
		txtSurname.setBounds(200, 85, 500, 30);
		frame.getContentPane().add(txtSurname);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Arial", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(200, 125, 500, 30);
		frame.getContentPane().add(txtAddress);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCity.setColumns(10);
		txtCity.setBounds(200, 165, 500, 30);
		frame.getContentPane().add(txtCity);
		
		txtPostcode = new JTextField();
		txtPostcode.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPostcode.setColumns(10);
		txtPostcode.setBounds(200, 205, 150, 30);
		frame.getContentPane().add(txtPostcode);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Arial", Font.PLAIN, 15));
		txtAge.setColumns(10);
		txtAge.setBounds(200, 285, 93, 30);
		frame.getContentPane().add(txtAge);
		
		btnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFemale.isSelected())
				{
					female = true;
					male = false;
					btnMale.setSelected(false);
				}
			}
		});
		btnFemale.setBounds(196, 252, 71, 23);
		frame.getContentPane().add(btnFemale);
		
		//JRadioButton btnMale = new JRadioButton("Male");
		btnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMale.isSelected())
				{
					female = false;
					male = true;
					btnFemale.setSelected(false);
				}
			}
		});
		btnMale.setBounds(270, 252, 109, 23);
		frame.getContentPane().add(btnMale);
		
		JLabel lblNewLabel = new JLabel("Request Form");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(200, 20, 150, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Arial", Font.BOLD, 20));
		lblusername.setBounds(40, 381, 123, 16);
		frame.getContentPane().add(lblusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblpassword.setBounds(40, 418, 144, 16);
		frame.getContentPane().add(lblpassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUsername.setBounds(200, 376, 500, 30);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPassword.setBounds(200, 413, 500, 30);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		
		
	}
	
}
