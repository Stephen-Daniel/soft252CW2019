package PatientSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.Person;
import SecretarySystem.secretary;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class PatientForm extends javax.swing.JFrame{

	private static JFrame frame;
	public static String userId;
	public static String [] temps;
	public static File[] requests;
	public String beginsWith = "";
	private JTextField txtDisplay;
	private JTextField txtMedicine;
	private JTextField txtQuantity;
	private JTextField txtDosage;
	private JTextField txtAppointment;
	
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

	public PatientForm() {
		initialize();
	}
	

	public static void Close() {
		frame.dispose();
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 988, 698);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPatientTitle = new JLabel("");
		lblPatientTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblPatientTitle.setBounds(350, 30, 120, 30);
		frame.getContentPane().add(lblPatientTitle);
		
		JButton btnRateDoctor = new JButton("Rate Doctor with feedback");
		btnRateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRateDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRateDoctor.setBounds(265, 35, 229, 25);
		frame.getContentPane().add(btnRateDoctor);
		
		JButton btnViewRate = new JButton("View Ratings");
		btnViewRate.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewRate.setBounds(10, 35, 142, 25);
		frame.getContentPane().add(btnViewRate);
		
		JButton btnRequestApp = new JButton("Request an Appointment");
		btnRequestApp.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRequestApp.setBounds(10, 225, 200, 25);
		frame.getContentPane().add(btnRequestApp);
		
		JButton btnViewHistory = new JButton("View History");
		btnViewHistory.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewHistory.setBounds(665, 248, 200, 25);
		frame.getContentPane().add(btnViewHistory);
		
		JButton btnViewAppointment = new JButton("View Appointment");
		btnViewAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnViewAppointment.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewAppointment.setBounds(324, 234, 200, 25);
		frame.getContentPane().add(btnViewAppointment);
		
		JButton btnViewPrescription = new JButton("View Prescription");
		btnViewPrescription.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewPrescription.setBounds(350, 408, 200, 25);
		frame.getContentPane().add(btnViewPrescription);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PatientForm.Close();
				LoginForm.main(null);
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout.setBounds(762, 623, 200, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btnRequestTermination = new JButton("Request Termination");
		btnRequestTermination.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRequestTermination.setBounds(552, 623, 200, 25);
		frame.getContentPane().add(btnRequestTermination);
		
		JLabel lblTitle = new JLabel("Patient");
		lblTitle.setBounds(40, 13, 159, 16);
		frame.getContentPane().add(lblTitle);
		lblTitle.setText("Patient " + userId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(602, 40, 335, 197);
		frame.getContentPane().add(scrollPane);
		
		txtDisplay = new JTextField();
		scrollPane.setViewportView(txtDisplay);
		txtDisplay.setColumns(10);
		
		JRadioButton rb1 = new JRadioButton("1 Star");
		rb1.setBounds(198, 77, 61, 23);
		frame.getContentPane().add(rb1);
		
		JRadioButton rb2 = new JRadioButton("2 Stars");
		rb2.setBounds(198, 103, 61, 23);
		frame.getContentPane().add(rb2);
		
		JRadioButton rb3 = new JRadioButton("3 Stars");
		rb3.setBounds(198, 129, 61, 23);
		frame.getContentPane().add(rb3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("4 Stars");
		rdbtnNewRadioButton.setBounds(198, 155, 61, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("5 Stars");
		rdbtnNewRadioButton_1.setBounds(198, 181, 61, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(265, 75, 300, 130);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea txtFeedback = new JTextArea();
		scrollPane_1.setViewportView(txtFeedback);
		
		JTextArea txtRatings = new JTextArea();
		txtRatings.setEditable(false);
		txtRatings.setBounds(10, 65, 172, 128);
		frame.getContentPane().add(txtRatings);
		
		JTextArea txtPatientDetails = new JTextArea();
		txtPatientDetails.setEditable(false);
		txtPatientDetails.setBounds(45, 444, 270, 120);
		frame.getContentPane().add(txtPatientDetails);
		
		JTextArea txtDoctorsDetails = new JTextArea();
		txtDoctorsDetails.setBounds(329, 444, 270, 120);
		frame.getContentPane().add(txtDoctorsDetails);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(613, 444, 270, 120);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea textPrescriptionNotes = new JTextArea();
		textPrescriptionNotes.setEditable(false);
		scrollPane_2.setViewportView(textPrescriptionNotes);
		
		txtMedicine = new JTextField();
		txtMedicine.setEditable(false);
		txtMedicine.setBounds(45, 575, 270, 20);
		frame.getContentPane().add(txtMedicine);
		txtMedicine.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setEditable(false);
		txtQuantity.setBounds(329, 575, 86, 20);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtDosage = new JTextField();
		txtDosage.setEditable(false);
		txtDosage.setBounds(425, 575, 458, 20);
		frame.getContentPane().add(txtDosage);
		txtDosage.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 340, 249, 71);
		frame.getContentPane().add(scrollPane_3);
		
		JTextArea textArea = new JTextArea();
		scrollPane_3.setViewportView(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 285, 245, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblChooseADoctor = new JLabel("Choose a Doctor");
		lblChooseADoctor.setBounds(10, 261, 95, 14);
		frame.getContentPane().add(lblChooseADoctor);
		
		JLabel lblWriteWhatsWrong = new JLabel("Write whats wrong and some dates to be seen");
		lblWriteWhatsWrong.setBounds(10, 316, 235, 14);
		frame.getContentPane().add(lblWriteWhatsWrong);
		
		txtAppointment = new JTextField();
		txtAppointment.setBounds(324, 280, 270, 29);
		frame.getContentPane().add(txtAppointment);
		txtAppointment.setColumns(10);
	}
}
