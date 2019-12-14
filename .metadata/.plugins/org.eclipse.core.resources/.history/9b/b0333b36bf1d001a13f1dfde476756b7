package PatientSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.Person;
import SecretarySystem.secretary;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class PatientForm extends javax.swing.JFrame{

	private static JFrame frame;
	public static String userId;
	public static String [] temps;
	public static File[] requests;
	public String beginsWith = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		userId = id;
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					PatientForm patient = new PatientForm();
					patient.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Person doctor = new Person();
				doctor.setID(userId);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatientForm() {
		initialize();
	}
	
	
//	public void populateDoctors() {
//	secretary getDoctors = new secretary();
//	beginsWith = "D";
//	
//	requests = getDoctors.FindFiles(temps, beginsWith);
//	
//	for (File file: requests)
//	{
//		String i = file.getName();
//		cbRequests.addItem(i);
//	}
//	}

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
		
		JLabel lblPatientTitle = new JLabel("");
		lblPatientTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblPatientTitle.setBounds(350, 30, 120, 30);
		frame.getContentPane().add(lblPatientTitle);
		
		JButton btnRateDoctor = new JButton("Rate Doctor");
		btnRateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRateDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRateDoctor.setBounds(40, 94, 200, 25);
		frame.getContentPane().add(btnRateDoctor);
		
		JButton btnViewRate = new JButton("View Ratings");
		btnViewRate.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewRate.setBounds(40, 130, 200, 25);
		frame.getContentPane().add(btnViewRate);
		
		JButton btnRequestApp = new JButton("Request an Appointment");
		btnRequestApp.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRequestApp.setBounds(40, 166, 200, 25);
		frame.getContentPane().add(btnRequestApp);
		
		JButton btnViewHistory = new JButton("View History");
		btnViewHistory.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewHistory.setBounds(40, 202, 200, 25);
		frame.getContentPane().add(btnViewHistory);
		
		JButton btnViewAppointment = new JButton("View Appointment");
		btnViewAppointment.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewAppointment.setBounds(40, 238, 200, 25);
		frame.getContentPane().add(btnViewAppointment);
		
		JButton btnViewPrescription = new JButton("View Prescription");
		btnViewPrescription.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewPrescription.setBounds(40, 274, 200, 25);
		frame.getContentPane().add(btnViewPrescription);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PatientForm.Close();
				LoginForm.main(null);
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout.setBounds(350, 572, 200, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btnRequestTermination = new JButton("Request Termination");
		btnRequestTermination.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRequestTermination.setBounds(40, 346, 200, 25);
		frame.getContentPane().add(btnRequestTermination);
		
		JLabel lblTitle = new JLabel("Patient");
		lblTitle.setBounds(40, 13, 159, 16);
		frame.getContentPane().add(lblTitle);
		lblTitle.setText("Patient " + userId);
	}
}
