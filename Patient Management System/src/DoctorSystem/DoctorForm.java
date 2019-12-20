package DoctorSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
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

import LoginSystem.LoginForm;
import LoginSystem.MainDate;
import LoginSystem.Person;
import SecretarySystem.secretary;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class DoctorForm extends javax.swing.JFrame{

	private static JFrame frame;
	public static String userId;
	
	private JComboBox cbAppointments;
	private JComboBox cbMedicine;
	private JButton btnSubmitNewMedicine;
	private JButton btnSendAppointmentToSecretary;
	private JButton btnCreateMedicine;
	private JButton btnEndAppointment;
	private JButton btnMakeAppointments;
	private JButton btnPrescribeMedicines;
	
	
	private String doctor, medicine, quantity, dosage, description, chosenMedicine, temp, appointment;
	private String patient, date, newDate, patientApp;
	private String filename;
	public static File[] requests;
	public static String [] temps;
	private JTextArea txtNewDescription;
	
	private JTextArea txtNewAppointment;
	private JTextField txtQuantityToGivePatient;
	private JTextField txtNewMedicineName;
	private JTextField txtNewDosage;
	private JTextField txtNewQuantity;
	private JTextArea txtPatientsDetails;
	private JTextArea txtPatientsHistory;
	private JTextArea txtPatientNewNotes;
	private JTextArea txtMedicineDescription;
	private JTextArea txtDosage;
	
	
	public void saveNewMedicine()
	{
		medicine = txtNewMedicineName.getText();
		dosage = txtNewDosage.getText();
		quantity = txtNewQuantity.getText();
		medicine = ("Order " + medicine.trim() + ".txt");
		description = txtNewDescription.getText();
		System.out.println("new medicine is " + medicine);
		try
		{					
			FileWriter fw = new FileWriter(medicine); 
			PrintWriter pw = new PrintWriter(fw); 
			pw.println(quantity);
            pw.println(dosage);
            pw.println(description);
            pw.flush();
            pw.close();		            
            fw.close(); 
            }
		catch (IOException e) {
			System.out.println("fail " + patientApp);								
		}
		
	}
	public void sendAppointment()
	
		{
			MainDate getDate = new MainDate();			
			date = getDate.sendDate(newDate).toString();			
			date = date.replace(":", "-");			
			patientApp = patient.replace(".txt",  "");			
			patientApp = ("request " + patientApp + " "+ date + ".txt");			
			System.out.println(patientApp);							
			System.out.println(userId + " is the doctor now");			
			try
			{					
				FileWriter fw = new FileWriter(patientApp); 
				PrintWriter pw = new PrintWriter(fw); 
				pw.println(userId);
	            pw.println(txtNewAppointment.getText());
	            
	            pw.flush();
	            pw.close();		            
	            fw.close(); 
	            }
			catch (IOException e) {
				System.out.println("fail " + patientApp);								
			}
		}
	
	
	public void clear()
	{
		txtNewAppointment.setText("");
		txtQuantityToGivePatient.setText("");
		txtNewMedicineName.setText("");
		txtNewDosage.setText("");
		txtNewQuantity.setText("");
		txtPatientsDetails.setText("Patient");
		txtPatientsHistory.setText("History");
		txtPatientNewNotes.setText("New Notes");
		txtMedicineDescription.setText("");
		txtDosage.setText("");
	}
	
	public void clearList()
	{		
		for(int i = cbMedicine.getItemCount()-1;i>=1;i--) {
			cbMedicine.removeItemAt(i);			
			}		
		for(int i = cbAppointments.getItemCount()-1;i>=1;i--) {
			cbAppointments.removeItemAt(i);			
			}		
	}
	
	public void getAppointments()
	{	
		secretary getTemps = new secretary();	
		requests = getTemps.FindFiles(temps, "AP " + userId);		
		for (File file: requests)
		{
			filename = file.getName();
			medicine = filename;
			medicine = medicine.replace(".txt", "");
			cbAppointments.addItem(medicine);
		}	
	}
	
	public void getMedicine()
	{	
		secretary getTemps = new secretary();	
		requests = getTemps.FindFiles(temps, "medicine");		
		for (File file: requests)
		{
			filename = file.getName();
			medicine = filename;
			medicine = medicine.replace(".txt", "");
			cbMedicine.addItem(medicine);
		}	
	}
	
	public void populatePatient()
	{
		clear();
		appointment = cbAppointments.getSelectedItem().toString();		
		btnPrescribeMedicines.setEnabled(true);
		getAppointments();		
		for (File file: requests)
		{
			filename = file.getName();
			appointment = filename;
			appointment = appointment.replace(".txt", "");
			if(appointment != "Appointments available")
			{
			Scanner populate;
			try {
				populate = new Scanner(new File(filename));
				populate.useDelimiter("[\n]");		
				txtPatientNewNotes.setText("");
				patient = populate.next();
				patient = (patient.substring(0, 5));
				patient = patient + ".txt";
				temp = populate.next();
				while(populate.hasNext()) {
				txtPatientNewNotes.append(populate.next() + "\n");	
				}
				populate.close();												
			} catch (FileNotFoundException e1) {				
					e1.printStackTrace();
				}
			}			
		}
		// next add read patient file and populate
		
			Scanner populate;
			try {
				
				populate = new Scanner(new File(patient));
				populate.useDelimiter("[\n]");
				txtPatientsDetails.setText("");	
				txtPatientsDetails.append(populate.next()+ "\n");
				
				for(int i = 1;i < 8;i++) {
				txtPatientsDetails.append(populate.next() + "\n");
				}
				temp = populate.next();//password
				txtPatientsHistory.setText("");
				while(populate.hasNext()){
				txtPatientsHistory.append(populate.next()+ "\n");
				}
				populate.close();	
					
			}catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
}
				// buttons ready to use			
		
	public void populateMedicine()
	{
		chosenMedicine = cbMedicine.getSelectedItem().toString();
		btnPrescribeMedicines.setEnabled(true);
		//make sure vars are correct
		clearList();
		getMedicine();
		
		for (File file: requests)
		{
			filename = file.getName();
			medicine = filename;
			medicine = medicine.replace(".txt", "");
			if(chosenMedicine.equals(medicine))
			{			
				Scanner populate;
				try {
					populate = new Scanner(new File(filename));
					populate.useDelimiter("[\n]");
										
					temp = populate.next();	
					txtDosage.setText(populate.next());
					txtMedicineDescription.setText(populate.next());
					populate.close();
													
				} catch (FileNotFoundException e1) {				
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	public void endAppointment()
	{
		try
		{	
			MainDate getDate = new MainDate();
			date = getDate.sendDate(newDate);
			
			FileWriter fw = new FileWriter(patient, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println("Date : " + date);			
            pw.println(txtPatientNewNotes.getText().trim());           
            pw.flush();
            pw.close();		            
            fw.close(); 
            }
		catch (IOException e) {
            System.out.println("fail" + patient);									
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		userId = id;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorForm doctor = new DoctorForm();
					doctor.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Person doctorLogin = new Person();
				doctorLogin.setID(userId);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoctorForm() {
		
		initialize();
		getMedicine();
		getAppointments();
	}
	public static void Close() {
		frame.dispose();
	
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1001, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DoctorForm.Close();
				LoginForm.main(null);
			}
			
		});
		btnLogout.setBounds(886, 587, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JLabel lbldoctorTitle = new JLabel("Doctor");
		lbldoctorTitle.setBounds(183, 11, 144, 14);
		frame.getContentPane().add(lbldoctorTitle);
		lbldoctorTitle.setText("Doctor " + userId);
		
		btnMakeAppointments = new JButton("Make/Propose Appointments");
		btnMakeAppointments.setEnabled(false);
		btnMakeAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnSendAppointmentToSecretary.setEnabled(true);
			}
		});
		btnMakeAppointments.setBounds(12, 74, 235, 25);
		frame.getContentPane().add(btnMakeAppointments);
		
		btnPrescribeMedicines = new JButton("Prescribe Medicines and Dosage");
		btnPrescribeMedicines.setEnabled(false);
		btnPrescribeMedicines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtMedicineDescription.setText("");
				txtQuantityToGivePatient.setText("");
				txtDosage.setText("");
				cbMedicine.setSelectedIndex(0);
				btnPrescribeMedicines.setEnabled(false);
				
			}
		});
		btnPrescribeMedicines.setBounds(350, 566, 214, 25);
		frame.getContentPane().add(btnPrescribeMedicines);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(670, 40, 300, 140);
		frame.getContentPane().add(scrollPane);
		
		txtPatientsDetails = new JTextArea();
		txtPatientsDetails.setEditable(false);
		txtPatientsDetails.setText("Patient");
		scrollPane.setViewportView(txtPatientsDetails);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(670, 213, 300, 287);
		frame.getContentPane().add(scrollPane_1);
		
		txtPatientsHistory = new JTextArea();
		txtPatientsHistory.setEditable(false);
		txtPatientsHistory.setText("Patient History");
		scrollPane_1.setViewportView(txtPatientsHistory);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(350, 40, 300, 200);
		frame.getContentPane().add(scrollPane_2);
		
		txtPatientNewNotes = new JTextArea();
		txtPatientNewNotes.setText("Patients New Notes");
		scrollPane_2.setViewportView(txtPatientNewNotes);
		
		cbMedicine = new JComboBox();
		cbMedicine.setModel(new DefaultComboBoxModel(new String[] {"Medicine available"}));
		cbMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbMedicine.getSelectedItem() != "Medicine available")
				{				
					btnMakeAppointments.setEnabled(true);
					populateMedicine();			
				}else {
				txtMedicineDescription.setText("");
				txtDosage.setText("");
				}
			}
		});
		cbMedicine.setBounds(350, 273, 290, 20);
		frame.getContentPane().add(cbMedicine);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(350, 321, 300, 75);
		frame.getContentPane().add(scrollPane_3);
		
		txtMedicineDescription = new JTextArea();
		txtMedicineDescription.setEditable(false);
		txtMedicineDescription.setText("Medicine Description");
		scrollPane_3.setViewportView(txtMedicineDescription);
		
		btnCreateMedicine = new JButton("Create a new medicine");
		btnCreateMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnSubmitNewMedicine.setEnabled(true);
				
			}
		});
		btnCreateMedicine.setBounds(22, 272, 235, 23);
		frame.getContentPane().add(btnCreateMedicine);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(350, 442, 224, 62);
		frame.getContentPane().add(scrollPane_4);
		
		txtDosage = new JTextArea();
		txtDosage.setEditable(false);
		txtDosage.setText("Dosage");
		scrollPane_4.setViewportView(txtDosage);
		
		JLabel lblDosage = new JLabel("Dosage");
		lblDosage.setBounds(350, 419, 46, 14);
		frame.getContentPane().add(lblDosage);
		
		JLabel lblQuantity = new JLabel("Quantity for patient");
		lblQuantity.setBounds(350, 532, 112, 14);
		frame.getContentPane().add(lblQuantity);
		
		txtQuantityToGivePatient = new JTextField();
		txtQuantityToGivePatient.setBounds(488, 526, 86, 20);
		frame.getContentPane().add(txtQuantityToGivePatient);
		txtQuantityToGivePatient.setColumns(10);
		
		JLabel lblMedicinenewname = new JLabel("Name of new medicine");
		lblMedicinenewname.setBounds(22, 307, 121, 14);
		frame.getContentPane().add(lblMedicinenewname);
		
		txtNewMedicineName = new JTextField();
		txtNewMedicineName.setBounds(20, 332, 237, 20);
		frame.getContentPane().add(txtNewMedicineName);
		txtNewMedicineName.setColumns(10);
		
		JLabel lblMedicineDescription = new JLabel("Medicine description - what is it for.");
		lblMedicineDescription.setBounds(22, 371, 235, 14);
		frame.getContentPane().add(lblMedicineDescription);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(22, 402, 235, 62);
		frame.getContentPane().add(scrollPane_5);
		
		txtNewDescription = new JTextArea();
		scrollPane_5.setViewportView(txtNewDescription);
		
		JLabel lblnewDosage = new JLabel("Medicine dosage");
		lblnewDosage.setBounds(20, 475, 123, 14);
		frame.getContentPane().add(lblnewDosage);
		
		txtNewDosage = new JTextField();
		txtNewDosage.setBounds(22, 500, 235, 20);
		frame.getContentPane().add(txtNewDosage);
		txtNewDosage.setColumns(10);
		
		JLabel lblQuantiyToOrder = new JLabel("Quantity to order");
		lblQuantiyToOrder.setBounds(22, 540, 101, 14);
		frame.getContentPane().add(lblQuantiyToOrder);
		
		txtNewQuantity = new JTextField();
		txtNewQuantity.setBounds(171, 537, 86, 20);
		frame.getContentPane().add(txtNewQuantity);
		txtNewQuantity.setColumns(10);
		
		btnSubmitNewMedicine = new JButton("Create and send to secretary");
		btnSubmitNewMedicine.setEnabled(false);
		btnSubmitNewMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				saveNewMedicine();
				btnSubmitNewMedicine.setEnabled(false);
				
			}
		});
		btnSubmitNewMedicine.setBounds(22, 568, 235, 23);
		frame.getContentPane().add(btnSubmitNewMedicine);
		
		cbAppointments = new JComboBox();
		cbAppointments.setModel(new DefaultComboBoxModel(new String[] {"Appointments available"}));
		cbAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(cbAppointments.getSelectedItem() != "Appointments available")
				{				
					btnMakeAppointments.setEnabled(true);
					populatePatient();				
				}				
			}
		});
		cbAppointments.setBounds(12, 43, 235, 20);
		frame.getContentPane().add(cbAppointments);
		
		JLabel lblAppointments = new JLabel("Appointments");
		lblAppointments.setBounds(12, 21, 99, 14);
		frame.getContentPane().add(lblAppointments);
		
		btnEndAppointment = new JButton("End this appointment");
		btnEndAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear all re run populates
				endAppointment();
				clear();
				clearList();
				btnMakeAppointments.setEnabled(false);
				getAppointments();
				getMedicine();
			}
		});
		btnEndAppointment.setBounds(785, 528, 185, 23);
		frame.getContentPane().add(btnEndAppointment);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(12, 110, 235, 92);
		frame.getContentPane().add(scrollPane_6);
		
		txtNewAppointment = new JTextArea();
		scrollPane_6.setViewportView(txtNewAppointment);
		
		btnSendAppointmentToSecretary = new JButton("Send to Secretary to arrange");
		btnSendAppointmentToSecretary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sendAppointment();
				btnSendAppointmentToSecretary.setEnabled(false);
				txtNewAppointment.setText("");
				
			}});
		btnSendAppointmentToSecretary.setEnabled(false);
		btnSendAppointmentToSecretary.setBounds(12, 213, 235, 23);
		frame.getContentPane().add(btnSendAppointmentToSecretary);
		
		JLabel lblDoctorsNotes = new JLabel("Doctors Notes");
		lblDoctorsNotes.setBounds(350, 21, 144, 14);
		frame.getContentPane().add(lblDoctorsNotes);
	}
}
