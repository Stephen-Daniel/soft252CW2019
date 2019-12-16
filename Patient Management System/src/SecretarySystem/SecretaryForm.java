package SecretarySystem;
//test save
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.Person;
import LoginSystem.uniqueNumber;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import AdminSystem.AdminForm;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class SecretaryForm {
// need to work on searching for temp files
	
	
	public static JFrame frame;
	public static File[] requests;
	public static String [] temps;
	public String beginWith = "temp";
	private String nums = "";
	private String temp;
	private int number;
	private JButton btnCreateAppointment;
	private JDateChooser dateChooser;
	private String uniqueNumber;
	public static String userId;
	private static JTextField txtFirstname;
	private static JTextField txtSurname;
	private static JTextField txtAddress;
	private static JTextField txtCity;
	private static JTextField txtPostcode;
	private static JTextField txtGender;
	private static JTextField txtAge;
	private String filename;
	private static JTextField txtUsername;
	//the TextField for typing the date
		JFormattedTextField  textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
		
	public static void main(String id) {
		userId = id;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretaryForm secretary = new SecretaryForm();
					secretary.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Person secretary = new Person();
				secretary.setID(userId);
			}
		});
	}
	public void appointment()
	{
		
		DateFormat df = new SimpleDateFormat("EEE dd-MM-yyyy" );
		//lbldate.setText(df.format(dateChooser.getDate()));
	}
	public static void clear()
	{
		txtFirstname.setText("");
		txtSurname.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtPostcode.setText("");
		txtGender.setText("");
		txtAge.setText("");		
		txtUsername.setText("");
		//txtPassword.setText("");
		
	}
	
	public static void sentRequest(String[] request)
	{
		
		
		
	}
	/**
	 * Create the application.
	 */
	public SecretaryForm() {
		initialize();
		
	}
	public static void Close() {
		frame.dispose();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1047, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JComboBox cbRequests = new JComboBox();
		JLabel lblTitle = new JLabel("Secretary");
		lblTitle.setBounds(12, 13, 164, 14);
		frame.getContentPane().add(lblTitle);
		JButton btnNotApproved = new JButton("Not Approved");
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SecretaryForm.Close();
			LoginForm.main(null);
				
			}
		});
		btnLogout.setBounds(924, 626, 97, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btnApproveNewAccounts = new JButton("Approve New Account");
		btnApproveNewAccounts.setEnabled(false);
		btnApproveNewAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnNotApproved.setEnabled(false);
				btnApproveNewAccounts.setEnabled(false);
				
				uniqueNumber = uniqueNumber.trim() + ".txt";
				
				secretary approve = new secretary();
				File oldfile = new File(filename);
				File newfile = new File(uniqueNumber);
				approve.renameFile(oldfile, newfile);
				
				cbRequests.removeItem(filename);
								
				clear();
				btnNotApproved.setEnabled(false);
				btnApproveNewAccounts.setEnabled(false);
			}
		});
		btnApproveNewAccounts.setBounds(780, 76, 175, 25);
		frame.getContentPane().add(btnApproveNewAccounts);
		
		btnCreateAppointment = new JButton("Create Appointment");
		btnCreateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				
			}
		});
		btnCreateAppointment.setBounds(12, 221, 145, 25);
		frame.getContentPane().add(btnCreateAppointment);
		
		JButton btnGiveMedicines = new JButton("Give Medicines");
		btnGiveMedicines.setBounds(12, 308, 229, 25);
		frame.getContentPane().add(btnGiveMedicines);
		
		JButton btnOrder = new JButton("Order Medicines");
		btnOrder.setBounds(500, 396, 153, 25);
		frame.getContentPane().add(btnOrder);
		
		JButton btnApproveAccRemoval = new JButton("Approve account removal");
		btnApproveAccRemoval.setEnabled(false);
		btnApproveAccRemoval.setBounds(780, 146, 175, 25);
		frame.getContentPane().add(btnApproveAccRemoval);
		
		lblTitle.setText("Secretary " + userId);
		
		cbRequests.setModel(new DefaultComboBoxModel(new String[] {"Request List"}));
		
		secretary getTemps = new secretary();
		
		requests = getTemps.FindFiles(temps, beginWith);
		
		for (File file: requests)
		{
			String i = file.getName();
			cbRequests.addItem(i);
		}	
	
		cbRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filename = cbRequests.getSelectedItem().toString();
				if (filename != "Request List")
				{
					Scanner populate;
					try {
						populate = new Scanner(new File(filename));
						populate.useDelimiter("[\n]");
						txtFirstname.setText(populate.next());
						txtSurname.setText(populate.next());
						txtAddress.setText(populate.next());
						txtCity.setText(populate.next());
						txtPostcode.setText(populate.next());
						txtGender.setText(populate.next());
						txtAge.setText(populate.next());
						// for saving patient later
						uniqueNumber = populate.next();
						txtUsername.setText(uniqueNumber);
						//not to show password
						temp =populate.next();
						
						populate.close();
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}
						// buttons ready to use		
					btnApproveNewAccounts.setEnabled(true);
					btnNotApproved.setEnabled(true);
				}else {
					clear();
				}
				
			}
		});
		cbRequests.setBounds(500, 9, 153, 22);
		frame.getContentPane().add(cbRequests);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(400, 75, 100, 16);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(400, 100, 56, 16);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(400, 125, 56, 16);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(400, 150, 56, 16);
		frame.getContentPane().add(lblCity);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setBounds(400, 175, 56, 16);
		frame.getContentPane().add(lblPostcode);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(400, 200, 56, 16);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(400, 225, 56, 16);
		frame.getContentPane().add(lblAge);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(500, 75, 244, 22);
		frame.getContentPane().add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(500, 100, 245, 22);
		frame.getContentPane().add(txtSurname);
		txtSurname.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(500, 125, 244, 22);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBounds(500, 150, 245, 22);
		frame.getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtPostcode = new JTextField();
		txtPostcode.setBounds(500, 175, 116, 22);
		frame.getContentPane().add(txtPostcode);
		txtPostcode.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setBounds(500, 200, 116, 22);
		frame.getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(500, 225, 116, 22);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(400, 250, 83, 16);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(500, 250, 116, 22);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		
		btnNotApproved.setEnabled(false);
		btnNotApproved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secretary notapprove = new secretary();
				
				notapprove.deleteFile(filename);
				//remove from combo box
				cbRequests.removeItem(filename);
				clear();
				btnNotApproved.setEnabled(false);
				btnApproveNewAccounts.setEnabled(false);
			}
		});
		btnNotApproved.setBounds(780, 112, 175, 25);
		frame.getContentPane().add(btnNotApproved);
		
		JLabel lblRequestTitle = new JLabel("Requests");
		lblRequestTitle.setBounds(400, 12, 72, 16);
		frame.getContentPane().add(lblRequestTitle);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(500, 340, 46, 14);
		frame.getContentPane().add(lblOrder);
		
		JComboBox cbOrder = new JComboBox();
		cbOrder.setBounds(500, 365, 153, 20);
		frame.getContentPane().add(cbOrder);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(683, 340, 46, 14);
		frame.getContentPane().add(lblStock);
		
		JComboBox cbStock = new JComboBox();
		cbStock.setBounds(683, 365, 164, 20);
		frame.getContentPane().add(cbStock);
		
		JComboBox cbMedicine = new JComboBox();
		cbMedicine.setBounds(12, 337, 229, 20);
		frame.getContentPane().add(cbMedicine);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 544, 378, 71);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtMessage = new JTextArea();
		scrollPane.setViewportView(txtMessage);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(12, 516, 46, 14);
		frame.getContentPane().add(lblMessage);
		
		JLabel lblTermination = new JLabel("Termination");
		lblTermination.setBounds(400, 45, 83, 14);
		frame.getContentPane().add(lblTermination);
		
		JComboBox cbTermination = new JComboBox();
		cbTermination.setBounds(500, 42, 153, 20);
		frame.getContentPane().add(cbTermination);
		
		JButton btnStock = new JButton("Stock Medicines");
		btnStock.setBounds(683, 397, 164, 23);
		frame.getContentPane().add(btnStock);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("press button");
				
			}
		});
		
		dateChooser.setBounds(188, 171, 95, 20);
		frame.getContentPane().add(dateChooser);
		dateChooser.setMinSelectableDate(new Date());
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(12, 171, 154, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(12, 149, 46, 14);
		frame.getContentPane().add(lblDoctor);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(188, 145, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 71, 153, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPatient = new JLabel("Patients Appointment Request");
		lblPatient.setBounds(12, 45, 164, 14);
		frame.getContentPane().add(lblPatient);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 100, 271, 45);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea txtPatientRequest = new JTextArea();
		scrollPane_1.setViewportView(txtPatientRequest);
		
	}
}
