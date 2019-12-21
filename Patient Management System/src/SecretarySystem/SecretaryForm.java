package SecretarySystem;
//test save
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.MainDate;
import LoginSystem.Person;
import LoginSystem.uniqueNumber;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
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
import java.awt.Font;
import java.awt.Color;

public class SecretaryForm {
// need to work on searching for temp files
	private JLabel lblTimeTaken;
	public static String userId;
	private String firstname, surname, uniqueNumber, filename;
	public String doctor, medicine, quantity, dosage, description, prescription, orderFile, orderStock;
	public String time, date, patient, notes, quantityOfPrescription, quantityInStock, newQuantityInStock;
	private String fileRequest = "";
	private String beginWith = "temp";
	private String nums = "";
	private String temp,terminatedFileToRemove;	
	public static JFrame frame;
	public static File[] request;
	
	private String[] times = new String[] {"0900","0930","1000","1030","1100","1200","1230","1400","1430","1500","1530","1600","1630"};
	private final String filepath = "terminationRequest.txt";
	public static File[] newOrder;
	public static File[] newStock;
	public static File[] requests;
	public static String [] temps;
	public static String [] file;
		
	
	
	private JDateChooser dateChooser;
	private JButton btnApproveAccRemoval;
	private JButton btnCreateAppointment;
	private JButton btnNotApproved;
	private JButton btnStock;
	private JButton btnGiveMedicines;
	private JButton btnApproveNewAccounts;
	private JTextArea txtPrescription;
	private JTextArea txtPatientRequest;
	private JLabel lblError;
	
	private static JTextField txtFirstname;
	private static JTextField txtSurname;
	private static JTextField txtAddress;
	private static JTextField txtCity;
	private static JTextField txtPostcode;
	private static JTextField txtGender;
	private static JTextField txtAge;
	private static JTextField txtUsername;
	private JComboBox<String> cbPatientAppointments;
	private JComboBox<String> cbDoctor;
	private JComboBox cbRequests;
	private JComboBox cbOrder;
	private JComboBox cbPrescriptions;
	private JComboBox<String> cbTermination;
	private JComboBox cbStock;
	private JComboBox cbTime;
	private JComboBox cbMedicineInStock;
	public int number, prescriptionQuantity = 0, medicineInStock = 0, newMedicineInStock = 0, sum;
	//the TextField for typing the date
	JFormattedTextField  textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
	public void restockMedicines()
	{	//get midicine name		
		temp = cbStock.getSelectedItem().toString().trim();
		orderStock = temp;
		orderStock = orderStock.replace("stock 1000 ", "").trim();
	Scanner populate;
		// get stock add 1000 and save
			filename = orderStock;	
			System.out.println(filename + " medicine to update");
	
			try {
				populate = new Scanner(new File(filename));
				populate.useDelimiter("[\n]");					
				quantityInStock = populate.next().toString().trim();			
				populate.close();												
			} catch (FileNotFoundException e1) {	
				System.out.println(filename + " failed");
					e1.printStackTrace();
			}
			//sum it
			medicineInStock = Integer.parseInt(quantityInStock.trim());			
			newMedicineInStock = medicineInStock + 1000;
			// edit file
			newQuantityInStock = Integer.toString(newMedicineInStock);
			secretary stockUpdate = new secretary();						
			stockUpdate.amendFile(quantityInStock, newQuantityInStock, filename);
			
		//delete file
		secretary restock = new secretary();
		restock.deleteFile(temp);
		getStock();
		getMedicine();
		
	}
	public void givePrescription()
	{
		//get medicine qty in stock
		filename = medicine + ".txt";	
		System.out.println(filename + " medicine to update");
		
		Scanner populate;
		try {
			populate = new Scanner(new File(filename));
			populate.useDelimiter("[\n]");					
			quantityInStock = populate.next().toString().trim();			
			populate.close();												
		} catch (FileNotFoundException e1) {	
			System.out.println(filename + " failed");
				e1.printStackTrace();
		}
		//sum it
		medicineInStock = Integer.parseInt(quantityInStock.trim());
		prescriptionQuantity = Integer.parseInt(quantityOfPrescription.trim());
		newMedicineInStock = medicineInStock - prescriptionQuantity;
		//use int to create order file
		if(newMedicineInStock < 500) {
		try
		{		
			orderFile = ("order 1000 " + medicine.trim() + ".txt");
			FileWriter fw = new FileWriter(orderFile);
			PrintWriter pw = new PrintWriter(fw);  
            pw.println(medicine.trim());           
            pw.flush();
            pw.close();		            
            fw.close(); 
            getOrders();
            }
		catch (IOException e) {
            System.out.println("fail" + orderFile);									
		}
		}
		//update medicine text file
		//System.out.println(newMedicineInStock + " new stock" + quantityInStock + " old stock");
		newQuantityInStock = Integer.toString(newMedicineInStock);
		//System.out.println(newMedicineInStock + " new stock" + quantityInStock + " old stock");		
		secretary stockUpdate = new secretary();						
		stockUpdate.amendFile(quantityInStock, newQuantityInStock, filename);
		prescription = cbPrescriptions.getSelectedItem().toString();
		prescription = (prescription.trim() + ".txt");
		String renamePrescription = ("old" + prescription);
		secretary approve = new secretary();
		File oldfile = new File(prescription);
		File newfile = new File(renamePrescription);
		approve.renameFile(oldfile, newfile);
		
		getPrescriptions();
		getMedicine();
		txtPrescription.setText("");
		
	}
	
	
	public void populatePrescription()
	{
		
		prescription = cbPrescriptions.getSelectedItem().toString();
		
		
		System.out.println(filename);	
		patient = prescription.substring(13, 19);
		System.out.println(patient);
		Scanner populate;
			try {
				populate = new Scanner(new File(filename));
				populate.useDelimiter("[\n]");		
				txtPrescription.setText("");
				doctor = populate.next();
				txtPrescription.append("Prescription is for patient " + patient +"\n");
				//txtPrescription.append(doctor+"/n");
				medicine = populate.next().trim();
				txtPrescription.append(medicine +"\n");
				quantityOfPrescription = populate.next();
				txtPrescription.append(quantityOfPrescription +"\n");
				while(populate.hasNext()) {
					txtPrescription.append(populate.next() + "\n");	
				}
				populate.close();												
			} catch (FileNotFoundException e1) {				
					e1.printStackTrace();
				}
		}	
	public void getPrescriptions()
	{
		for(int i = cbPrescriptions.getItemCount()-1;i>=1;i--) {
			cbPrescriptions.removeItemAt(i);			
			}	
		
		secretary getTemps = new secretary();	
		requests = getTemps.FindFiles(temps, "prescription");		
		for (File file: requests)
		{
			filename = file.getName();
			medicine = filename;
			medicine = medicine.replace(".txt", "");
			cbPrescriptions.addItem(medicine);
		}
	}
			
		
	
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
	
	public void getTempRequests()
	{
		secretary getTemps = new secretary();
		
		requests = getTemps.FindFiles(temps, "temp");
		
		for (File file: requests)
		{
			String i = file.getName();
			cbRequests.addItem(i);
		}	
	}
	public void getStock()
	{
		
		for(int i = cbStock.getItemCount()-1;i>=1;i--) {
			cbStock.removeItemAt(i);			
			}
		secretary getTemps = new secretary();
		
		requests = getTemps.FindFiles(temps, "stock");
		
		for (File file: requests)
		{
			String i = file.getName();
			cbStock.addItem(i);
		}	
	}
	public void getOrders()
	{
		
		for(int i = cbOrder.getItemCount()-1;i>=1;i--) {
			cbOrder.removeItemAt(i);			
			}
		secretary getTemps = new secretary();
		
		requests = getTemps.FindFiles(temps, "order");
		
		for (File file: requests)
		{
			String i = file.getName();
			cbOrder.addItem(i);
		}	
	}
	public void populateRequests()
	{
		filename = cbRequests.getSelectedItem().toString();
		if (filename != "Temp to approve")
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
	public void getMedicine()
	{		
		
		for(int i = cbMedicineInStock.getItemCount()-1;i>=1;i--) {
			cbMedicineInStock.removeItemAt(i);			
			}
		secretary getTemps = new secretary();	
		requests = getTemps.FindFiles(temps, "medicine");		
		for (File file: requests)
		{
			filename = file.getName();
			medicine = filename;
			medicine = medicine.replace(".txt", "");
				Scanner populate;
				try {
					populate = new Scanner(new File(filename));
					populate.useDelimiter("[\n]");
										
					quantityInStock = populate.next();	
					
					populate.close();
					cbMedicineInStock.addItem(medicine + " " + quantityInStock);									
				} catch (FileNotFoundException e1) {				
					e1.printStackTrace();
				}
		}	
	}
	public void getDoctors()
	{		
		secretary getTemps = new secretary();	
		requests = getTemps.FindFiles(temps, "D");		
		for (File file: requests)
		{
			filename = file.getName();
			doctor = filename;
			doctor = doctor.replace(".txt", "");
				Scanner populate;
				try {
					populate = new Scanner(new File(filename));
					populate.useDelimiter("[\n]");
					firstname = populate.next();					
					surname = populate.next();									
					populate.close();
					cbDoctor.addItem(doctor + " " + firstname + " " + surname);									
				} catch (FileNotFoundException e1) {				
					e1.printStackTrace();
				}
		}	
	}
	
	public void clearList()
	{		
		for(int i = cbPatientAppointments.getItemCount()-1;i>=1;i--) {
			cbPatientAppointments.removeItemAt(i);			
			}
		getAppointment();
		for(int i = cbTermination.getItemCount()-1;i>=1;i--) {
			cbTermination.removeItemAt(i);			
			}
		terminationPopulate();
	}
	
	public void saveAppointment()
	{
		
		SimpleDateFormat df = new SimpleDateFormat ("EEE dd-MM-yyyy");
		patient = (String) cbPatientAppointments.getSelectedItem();
		patient = patient.replace("request ", "");
		doctor = (String) cbDoctor.getSelectedItem();
		//nice code
		doctor= doctor.substring(0, doctor.indexOf(" "));
		notes = txtPatientRequest.getText();
		// add code to stop no date or time
		System.out.println("is this the problem before date");
		date = df.format(dateChooser.getDate()).toString();
		System.out.println("is this the problem ");
		time = (String) cbTime.getSelectedItem();
		
		
		filename = ("AP "+doctor+" "+time+" "+date+".txt");
		System.out.println("is this the problem ");
		File directoryPath = new File(System.getProperty("user.dir"));					
		File[] files=directoryPath.listFiles(new FilenameFilter() {			
			public boolean accept(File dir, String name) {	
				return name.equals(filename);
			}}	);
		
		if(files.length == 1) {
			
			lblTimeTaken.setText("Time and or date taken, Try again");
		}else {
			try
			{					
				FileWriter fw = new FileWriter(filename);
				PrintWriter pw = new PrintWriter(fw);  
	            pw.println(patient);
	            pw.println(notes);
	            pw.flush();
	            pw.close();		            
	            fw.close(); 

	            File remove = new File(fileRequest);
	            remove.delete();
	            clearList();
	            
	         }
			catch (IOException e) {
			
	            System.out.println("fail" + filename);									
			}	
		  }	
		}	
		
	public void getAppointment()
	{
		secretary appointments = new secretary();		
		request = appointments.FindFiles(file, "request");		
		for (File file: request)
		{
			String i = file.getName();
			i = i.replace(".txt", "");			
			cbPatientAppointments.addItem(i);
		}	
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
	
	}
	
	public void requestAppointmentPopulate()
	{
		txtPatientRequest.setText("");
		fileRequest = (String) cbPatientAppointments.getSelectedItem();
		if(fileRequest != "Requested Appointments") {
			btnCreateAppointment.setEnabled(true);
		fileRequest = fileRequest + ".txt";
		System.out.println("file to pop " + fileRequest);
		Scanner patient;
		try {
			patient = new Scanner(new File(fileRequest));
			patient.useDelimiter("\n");				
			while(patient.hasNext()) {				
				txtPatientRequest.append(patient.next() +"\n");
			}
			patient.close();
		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		}
		}else {
			btnCreateAppointment.setEnabled(false);
		}
	}
	
	public void updateTerminationList(String removeTerm)
	{	
		
		secretary amend = new secretary();
		amend.amendFile(removeTerm, filepath);
		    
	}
	
	public void terminationPopulate()
	{
		Scanner termination;
		try {
			termination = new Scanner(new File("terminationRequest.txt"));
			termination.useDelimiter("[\n]");				
			while(termination.hasNext()) {
				cbTermination.addItem(termination.next());
			}
			termination.close();			
		} catch (FileNotFoundException e1) {				
			e1.printStackTrace();
		}		
	}
	
	public static void sentRequest(String[] request)
	{
	
	}
	/**
	 * Create the application.
	 */
	public SecretaryForm() {
		initialize();
		terminationPopulate();
		getAppointment();
		getDoctors();
		getTempRequests();
		getMedicine();
		getPrescriptions();
		getStock();
		getOrders();
	}
	public static void Close() {
		frame.dispose();
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1047, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		cbRequests = new JComboBox();
		JLabel lblTitle = new JLabel("Secretary");
		lblTitle.setBounds(12, 13, 164, 14);
		frame.getContentPane().add(lblTitle);
		btnNotApproved = new JButton("Not Approved");
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SecretaryForm.Close();
			LoginForm.main(null);
				
			}
		});
		btnLogout.setBounds(924, 626, 97, 25);
		frame.getContentPane().add(btnLogout);
		
		btnApproveNewAccounts = new JButton("Approve New Account");
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
		btnCreateAppointment.setEnabled(false);
		btnCreateAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try {
					DateFormat df = new SimpleDateFormat("EEE dd-MM-yyyy" );
					date = df.format(dateChooser.getDate()).toString();
					lblError.setText("");
					saveAppointment();
					btnCreateAppointment.setEnabled(false);
				} catch (Exception e) {
					
					lblError.setText("Select a date");
				}			
			}
		});
		btnCreateAppointment.setBounds(109, 363, 174, 25);
		frame.getContentPane().add(btnCreateAppointment);
		
		JButton btnGiveMedicines = new JButton("Give Medicines");
		btnGiveMedicines.setEnabled(false);
		btnGiveMedicines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				givePrescription();
				
				btnGiveMedicines.setEnabled(false);
			}
		});
		btnGiveMedicines.setBounds(161, 626, 229, 25);
		frame.getContentPane().add(btnGiveMedicines);
		
		JButton btnOrder = new JButton("Order Medicines");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				orderFile = (cbOrder.getSelectedItem().toString().trim());
				File newOrder = new File(orderFile);
				orderStock = orderFile.replace("order", "stock").trim();
				File newStock = new File(orderStock);
				secretary rn = new secretary();
				System.out.println(orderFile);
				rn.renameFile(newOrder, newStock);
			}
		});
		btnOrder.setBounds(643, 388, 225, 25);
		frame.getContentPane().add(btnOrder);
		
		btnApproveAccRemoval = new JButton("Approve account removal");
		btnApproveAccRemoval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				secretary terminate = new secretary();
				String terminated = "terminated";
				terminatedFileToRemove = cbTermination.getSelectedItem().toString();
				filename = terminatedFileToRemove;
				terminated = terminated+filename;				
				System.out.println(filename + " change to " + terminated);				
				File reqFile = new File(filename.trim());
				File terminatedfile = new File(terminated.trim());
				
				if (reqFile.renameTo(terminatedfile)) {  
					System.out.println(reqFile + " has been changed to " + terminatedfile);
					}else{
							System.out.println("error STILL ERROR " + reqFile + " not changed to " + terminatedfile);
						 }
				updateTerminationList(filename);				
				clearList();				
				btnApproveAccRemoval.setEnabled(false);
			}
		});
		btnApproveAccRemoval.setEnabled(false);
		btnApproveAccRemoval.setBounds(780, 146, 175, 25);
		frame.getContentPane().add(btnApproveAccRemoval);		
		lblTitle.setText("Secretary " + userId);		
		cbRequests.setModel(new DefaultComboBoxModel(new String[] {"Temp to approve"}));	
		cbRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				populateRequests();
				
			}});
		
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
		
		cbOrder = new JComboBox();
		cbOrder.setModel(new DefaultComboBoxModel(new String[] {"Medicines to order"}));
		cbOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cbOrder.setBounds(500, 357, 368, 20);
		frame.getContentPane().add(cbOrder);
		
		cbPrescriptions = new JComboBox();
		cbPrescriptions.setModel(new DefaultComboBoxModel(new String[] {"Outstanding Prescriptions"}));
		cbPrescriptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbPrescriptions.getSelectedItem() != "Outstanding Prescriptions") {
				populatePrescription();
				btnGiveMedicines.setEnabled(true);
				}else {
					btnGiveMedicines.setEnabled(false);
				}
				
			}
		});
		cbPrescriptions.setBounds(12, 423, 378, 20);
		frame.getContentPane().add(cbPrescriptions);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 479, 378, 136);
		frame.getContentPane().add(scrollPane);
		
		txtPrescription = new JTextArea();
		scrollPane.setViewportView(txtPrescription);
		
		JLabel lblpresciption = new JLabel("Presciption");
		lblpresciption.setBounds(12, 454, 77, 14);
		frame.getContentPane().add(lblpresciption);
		
		JLabel lblTermination = new JLabel("Termination");
		lblTermination.setBounds(400, 45, 83, 14);
		frame.getContentPane().add(lblTermination);
		
		cbTermination = new JComboBox();
		cbTermination.setModel(new DefaultComboBoxModel(new String[] {"Termination Requests"}));
		cbTermination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				btnApproveAccRemoval.setEnabled(true);
				
			}
		});
		cbTermination.setBounds(500, 42, 153, 20);
		frame.getContentPane().add(cbTermination);
		
		btnStock = new JButton("Stock Medicines");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbStock.getSelectedItem() != "Medicine to put into stock") {
				restockMedicines();
				}
			}
		});
		btnStock.setBounds(643, 491, 225, 23);
		frame.getContentPane().add(btnStock);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				lblTimeTaken.setText("");
			}
		});
		
		dateChooser.setBounds(109, 279, 132, 20);
		frame.getContentPane().add(dateChooser);
		dateChooser.setMinSelectableDate(new Date());
		
		cbDoctor = new JComboBox();
		cbDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				
			}
		});
		cbDoctor.setBounds(12, 227, 271, 20);
		frame.getContentPane().add(cbDoctor);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(12, 205, 46, 14);
		frame.getContentPane().add(lblDoctor);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(109, 255, 46, 14);
		frame.getContentPane().add(lblDate);
		
		cbPatientAppointments = new JComboBox();
		cbPatientAppointments.setModel(new DefaultComboBoxModel(new String[] {"Requested Appointments"}));
		cbPatientAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				requestAppointmentPopulate();
			}
		});
		cbPatientAppointments.setBounds(12, 64, 271, 20);
		frame.getContentPane().add(cbPatientAppointments);
		
		JLabel lblPatient = new JLabel("Patients Appointment Request");
		lblPatient.setBounds(12, 38, 164, 14);
		frame.getContentPane().add(lblPatient);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 90, 271, 110);
		frame.getContentPane().add(scrollPane_1);
		
		txtPatientRequest = new JTextArea();
		scrollPane_1.setViewportView(txtPatientRequest);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(109, 310, 46, 14);
		frame.getContentPane().add(lblTime);
		
		cbTime = new JComboBox(times);
		cbTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTimeTaken.setText("");
			}
		});
		cbTime.setBounds(109, 332, 72, 20);
		frame.getContentPane().add(cbTime);
		
		lblTimeTaken = new JLabel("");
		lblTimeTaken.setForeground(Color.RED);
		lblTimeTaken.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTimeTaken.setBounds(191, 310, 275, 25);
		frame.getContentPane().add(lblTimeTaken);
		
		cbStock = new JComboBox();
		cbStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cbStock.setModel(new DefaultComboBoxModel(new String[] {"Medicine to put into stock"}));
		cbStock.setBounds(500, 449, 368, 20);
		frame.getContentPane().add(cbStock);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblError.setForeground(Color.RED);
		lblError.setBounds(255, 274, 135, 25);
		frame.getContentPane().add(lblError);
		
		cbMedicineInStock = new JComboBox();
		cbStock.setModel(new DefaultComboBoxModel(new String[] {"Medicine in stock"}));
		cbMedicineInStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		cbMedicineInStock.setBounds(500, 563, 368, 20);
		frame.getContentPane().add(cbMedicineInStock);
		
		JLabel lblInStock = new JLabel("Medicine and current stock levels");
		lblInStock.setBounds(500, 538, 225, 14);
		frame.getContentPane().add(lblInStock);
		
	}
}
