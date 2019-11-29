package DoctorSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import LoginSystem.LoginForm;

public class DoctorForm extends javax.swing.JFrame{

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorForm doctor = new DoctorForm();
					doctor.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoctorForm() {
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
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DoctorForm.Close();
				LoginForm.main(null);
			}
			
		});
		btnLogout.setBounds(714, 472, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Doctor");
		lblNewLabel.setBounds(361, 21, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnViewAppointments = new JButton("View Appointments");
		btnViewAppointments.setBounds(12, 88, 214, 25);
		frame.getContentPane().add(btnViewAppointments);
		
		JButton btnMakeNotes = new JButton("Make Notes");
		btnMakeNotes.setBounds(12, 126, 214, 25);
		frame.getContentPane().add(btnMakeNotes);
		
		JButton btnInspectPatientHistory = new JButton("Inspect Patient History");
		btnInspectPatientHistory.setBounds(12, 164, 214, 25);
		frame.getContentPane().add(btnInspectPatientHistory);
		
		JButton btnMakeAppointments = new JButton("Make/Propose Appointments");
		btnMakeAppointments.setBounds(12, 202, 214, 25);
		frame.getContentPane().add(btnMakeAppointments);
		
		JButton btnPrescribeMedicines = new JButton("Prescribe Medicines and Dosage");
		btnPrescribeMedicines.setBounds(12, 240, 214, 25);
		frame.getContentPane().add(btnPrescribeMedicines);
		
		JButton btnMakeNewMedicines = new JButton("Make New Medicines");
		btnMakeNewMedicines.setBounds(12, 278, 214, 25);
		frame.getContentPane().add(btnMakeNewMedicines);
		
		JButton btnOrdersForSecretary = new JButton("Orders For Secretary");
		btnOrdersForSecretary.setBounds(12, 316, 214, 25);
		frame.getContentPane().add(btnOrdersForSecretary);
	}

}
