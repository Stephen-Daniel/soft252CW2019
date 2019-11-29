package PatientSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientForm extends javax.swing.JFrame{

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientForm patient = new PatientForm();
					patient.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatientForm() {
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
		
		JButton button_1 = new JButton("View Appointment");
		button_1.setFont(new Font("Arial", Font.PLAIN, 15));
		button_1.setBounds(40, 310, 200, 25);
		frame.getContentPane().add(button_1);
		
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
	}
}
