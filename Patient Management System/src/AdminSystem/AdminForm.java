package AdminSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import LoginSystem.LoginForm;
import LoginSystem.Person;
import LoginSystem.uniqueNumber;
import PatientSystem.RequestForm;
import SecretarySystem.secretary;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;

public class AdminForm extends javax.swing.JFrame{

	
	public static File[] requests;
	public static File[] request;
	public static String [] files;
	public static String [] file;
	public String beginWith = "D";
	public static JFrame frame;
	public static String userId;
	public JComboBox<String> cbAdminList;
	
	public JTextArea txtDisplayComments;
	public JTextArea txtDisplayFeedback;
	
	public JButton btnDelete;
	public JButton btnSave;
	private JTextField txtFirstname;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPostcode;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtRating;
	
	public String usernameWithoutTXT = "";
	public String username = "";
	public String userDepartment = "";
	public String temp;
	
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
		
	}
	public void clear()
	{
		//cbAdminList.setSelectedIndex(0);
		txtFirstname.setText("");
		txtSurname.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtPostcode.setText("");				
		txtUsername.setText("");
		txtPassword.setText("");
		txtRating.setText("");
		txtDisplayComments.setText("");	
		txtDisplayFeedback.setText("");
	}
	
	public void populate(String chosen) {
		
		clear(); 
		
			String filename = (String) cbAdminList.getSelectedItem();
			
			
			
			String feedbackOrNotes = "FeedbackOrNotes";
			feedbackOrNotes = filename + feedbackOrNotes + ".txt";
			
			
			filename = (filename + ".txt");
			System.out.println(filename + " name that searches for file then reads to populate");
			
			Scanner populate;
			try {
				populate = new Scanner(new File(filename));
				populate.useDelimiter("[\n]");
				txtFirstname.setText(populate.next());
				txtSurname.setText(populate.next());
				txtAddress.setText(populate.next());
				txtCity.setText(populate.next());
				txtPostcode.setText(populate.next());
				temp = populate.next();//gender and age
				temp = populate.next();				 
				txtUsername.setText(populate.next());				
				txtPassword.setText(populate.next());
				txtRating.setText(populate.next());
				while(populate.hasNext()) {
				txtDisplayComments.append(populate.next() +"\n");
				}
				
				populate.close();
			} catch (FileNotFoundException e1) {				
				e1.printStackTrace();
			}	
			Scanner populateFeedback;
			try {
				populateFeedback = new Scanner(new File(feedbackOrNotes));
				populateFeedback.useDelimiter("[\n]");				
				while(populateFeedback.hasNext()) {
				txtDisplayFeedback.append(populateFeedback.next() + "\n");
				}
				populateFeedback.close();
			} catch (FileNotFoundException e1) {				
				e1.printStackTrace();
			}
			
	}
	public AdminForm() {
		
		initialize();
		//populateFileList("all");
		populateAdminList("all");
	}
	public void getUsername(String department)
	{
		clear();
		
		uniqueNumber requestNumber = new uniqueNumber();				
		int number = requestNumber.uniqueNumber();	
		// add department p tag
		username = department + Integer.toString(number);
		//create unique temp file for Patient
		usernameWithoutTXT = username;
		username = username + ".txt";		
		txtUsername.setText(usernameWithoutTXT);
		txtUsername.setEnabled(false);
		System.out.println("add .txt " + username + " Add clear list!");
		cbAdminList.addItem("Clear List");
		cbAdminList.setEnabled(false);
		btnSave.setEnabled(true);
		
	}
	
	public void saveNewCreatedStaff()
	{
		
		username = txtUsername.getText().trim();
		System.out.println("name taken from txtusername " + username);
		String feedbackOrNotes = "FeedbackOrNotes";
		feedbackOrNotes = username + feedbackOrNotes + ".txt";
		username = username + ".txt";
		
		System.out.println("saving new staff name " + username);
		try
		{					
			FileWriter fw = new FileWriter(username);
			PrintWriter pw = new PrintWriter(fw);
            	 
            pw.println(txtFirstname.getText().trim());
            pw.println(txtSurname.getText().trim());
            pw.println(txtAddress.getText().trim());
            pw.println(txtCity.getText().trim());
            pw.println(txtPostcode.getText().trim().toUpperCase());
            pw.println("spare");
            pw.println("spare");                      
            pw.println(usernameWithoutTXT);
            pw.println(txtPassword.getText().trim());
            pw.println(txtRating.getText().trim());
            pw.println(txtDisplayComments.getText().trim());
            pw.flush();
            pw.close();		            
            fw.close(); 
            						
		}
		catch (IOException e) {
            System.out.println("fail" + username);									
		}
		try
		{					
			FileWriter fw = new FileWriter(feedbackOrNotes);
			PrintWriter pw = new PrintWriter(fw);  
            pw.println(txtDisplayFeedback.getText().trim());           
            pw.flush();
            pw.close();		            
            fw.close(); 
            }
		catch (IOException e) {
            System.out.println("fail" + feedbackOrNotes);									
		}
		cbAdminList.setEnabled(true);
		btnSave.setEnabled(false);
	}
	public void clearList()
	{
		System.out.println("going to clear combo box");
		for(int i = cbAdminList.getItemCount()-1;i>=1;i--) {
			cbAdminList.removeItemAt(i);
			System.out.println(i + "combo index");
		}
		//cbAdminList.removeAllItems();
		System.out.println("cleared ");
		
	}
	//NOW put into one method below
//	public void populateFileList()
//	{
//		System.out.println("populatefilelist and clear combo box");
//		clearList();
//		clear();
//		System.out.println("clear");
//		secretary getFileList = new secretary();		
//		String [] letters = {"A","D","S"};		
//		for (String begin:letters) {
//		requests = getFileList.FindFiles(files, begin);
//		
//		for (File file: requests)
//		{
//			String i = file.getName();
//			
//			i = i.replace(".txt", "");
//			
//			cbAdminList.addItem(i);
//		}	
//		}	
//	}
	public void populateAdminList(String option)
	{
		// take out feed back files
		clearList();
		clear();
		String [] choosen;
		secretary getFileListDS = new secretary();
		if(option.equals("all"))
		{
			String [] letter = {"A","D","S"};
			choosen = letter;
		}
		else if(option.equals("rating"))
		{
			String [] letter = {"D"};
			choosen = letter;}
		else 
		{
			String [] letter = {"D","S"};
		choosen = letter;
		}
		
		for (String begin:choosen) {
			
		request = getFileListDS.FindFiles(file, begin);
		
		for (File file: request)
		{
			String i = file.getName();
			i = i.replace(".txt", "");			
			cbAdminList.addItem(i);
		}	
	  }	
	}
	
	
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
		btnCreateAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get username add to text window then stop from altering				
				userDepartment = "A";
				getUsername(userDepartment);
				
			}
		});
		btnCreateAdmin.setBounds(12, 75, 146, 25);
		frame.getContentPane().add(btnCreateAdmin);
		
		JButton btnAddDoctor = new JButton("Add Doctor");
		btnAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDepartment = "D";
				getUsername(userDepartment);
			}
		});
		btnAddDoctor.setBounds(12, 113, 146, 25);
		frame.getContentPane().add(btnAddDoctor);
		
		JButton btnAddSecretary = new JButton("Add Secretary");
		btnAddSecretary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDepartment = "S";
				getUsername(userDepartment);
			}
		});
		btnAddSecretary.setBounds(12, 189, 146, 25);
		frame.getContentPane().add(btnAddSecretary);
		
		JButton btnRemoveStaff = new JButton("Remove Staff");
		btnRemoveStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clear();				
				populateAdminList("delete");				
				btnDelete.setEnabled(true);
							
			}
		});
		btnRemoveStaff.setBounds(12, 227, 146, 25);
		frame.getContentPane().add(btnRemoveStaff);
		
		JButton btnViewRatings = new JButton("View Ratings");
		btnViewRatings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();				
				populateAdminList("rating");
			}
		});
		btnViewRatings.setBounds(12, 265, 146, 25);
		frame.getContentPane().add(btnViewRatings);
		
		JButton btnSendFeedback = new JButton("Send Feedback");
		btnSendFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cbAdminList.removeAll();
				saveNewCreatedStaff();				
				clear();
				//populateFileList();
				populateAdminList("all");
				
			}
		});
		btnSendFeedback.setBounds(185, 469, 146, 25);
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
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(594, 254, 56, 16);
		frame.getContentPane().add(lblRating);
		
		txtRating = new JTextField();
		txtRating.setBounds(694, 251, 116, 22);
		frame.getContentPane().add(txtRating);
		txtRating.setColumns(10);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setHorizontalAlignment(SwingConstants.LEFT);
		lblComments.setBounds(594, 316, 83, 16);
		frame.getContentPane().add(lblComments);
		
		cbAdminList = new JComboBox();
		cbAdminList.addItem("Staff List");
		cbAdminList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbAdminList.getSelectedIndex() != 0) {
				String pick = cbAdminList.getSelectedItem().toString();
				username = pick;
				pick = pick + ".txt";
				System.out.println("click combo" + username + pick);
				//change to username from pick
				populate(username); }
			}
		});
		
		
		
		cbAdminList.setBounds(694, 33, 116, 22);
		frame.getContentPane().add(cbAdminList);
		
		
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				cbAdminList.removeAll();
				saveNewCreatedStaff();				
				clear();
				//populateFileList();
				populateAdminList("all");
			}
		});
		btnSave.setEnabled(false);
		btnSave.setBounds(694, 486, 97, 25);
		frame.getContentPane().add(btnSave);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//String test = txtUsername.getText();
				
				//testing System.out.println("999" + username + "888");
				cbAdminList.removeItem(username);
				//send to delete method with correct name
				secretary delete = new secretary();
				String usernameWithTXT = (username + ".txt");
				delete.deleteFile(usernameWithTXT);
				btnDelete.setEnabled(false);			
			}
			
		});
		btnDelete.setEnabled(false);
		btnDelete.setBounds(803, 486, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane spFeedback = new JScrollPane();
		spFeedback.setBounds(12, 339, 319, 130);
		frame.getContentPane().add(spFeedback);
		//frame.add(spComments);
		
		txtDisplayFeedback = new JTextArea();
		spFeedback.setViewportView(txtDisplayFeedback);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(694, 311, 312, 158);
		frame.getContentPane().add(scrollPane);
		
		txtDisplayComments = new JTextArea();
		scrollPane.setViewportView(txtDisplayComments);
		
		JButton btnClear = new JButton("Clear and Exit");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminForm.main(userId);
			}
		});
		btnClear.setBounds(910, 487, 116, 23);
		frame.getContentPane().add(btnClear);
		//frame.add(spFeedback);
	}
}
