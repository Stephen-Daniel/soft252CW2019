package PatientSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import LoginSystem.LoginForm;

import javax.swing.JRadioButton;

public class RequestForm extends javax.swing.JFrame{

	private static JFrame frame;
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		btnExit.setBounds(570, 335, 100, 30);
		frame.getContentPane().add(btnExit);
		
		JButton btnSubmit = new JButton("Submit Request");
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 20));
		btnSubmit.setBounds(360, 335, 200, 30);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Arial", Font.BOLD, 20));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClear.setBounds(250, 335, 100, 30);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(200, 45, 500, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(200, 85, 500, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(200, 125, 500, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(200, 165, 500, 30);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(200, 205, 150, 30);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(200, 285, 93, 30);
		frame.getContentPane().add(textField_5);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(196, 252, 71, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(270, 252, 109, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JLabel lblNewLabel = new JLabel("Request Form");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(200, 20, 150, 20);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
