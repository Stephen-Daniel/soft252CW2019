package DoctorSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.Person;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class DoctorForm extends javax.swing.JFrame{

	private static JFrame frame;
	public static String userId;
	private JTextField txtNewMedicine;
	private JTextField textField;
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
		lbldoctorTitle.setBounds(361, 21, 144, 14);
		frame.getContentPane().add(lbldoctorTitle);
		lbldoctorTitle.setText("Doctor " + userId);
		
		JButton btnViewAppointments = new JButton("View Appointments");
		btnViewAppointments.setBounds(12, 41, 214, 25);
		frame.getContentPane().add(btnViewAppointments);
		
		JButton btnMakeAppointments = new JButton("Make/Propose Appointments");
		btnMakeAppointments.setBounds(12, 379, 214, 25);
		frame.getContentPane().add(btnMakeAppointments);
		
		JButton btnPrescribeMedicines = new JButton("Prescribe Medicines and Dosage");
		btnPrescribeMedicines.setBounds(670, 524, 214, 25);
		frame.getContentPane().add(btnPrescribeMedicines);
		
		JButton btnOrdersForSecretary = new JButton("Orders For Secretary");
		btnOrdersForSecretary.setBounds(114, 566, 162, 25);
		frame.getContentPane().add(btnOrdersForSecretary);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(670, 40, 300, 200);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtPatient = new JTextArea();
		txtPatient.setEditable(false);
		txtPatient.setText("Patient");
		scrollPane.setViewportView(txtPatient);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(670, 300, 300, 200);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea txtHistory = new JTextArea();
		txtHistory.setEditable(false);
		txtHistory.setText("Patient History");
		scrollPane_1.setViewportView(txtHistory);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(350, 40, 300, 200);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea txtrPatientNotes = new JTextArea();
		txtrPatientNotes.setText("Patient Notes");
		scrollPane_2.setViewportView(txtrPatientNotes);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setBounds(350, 321, 46, 14);
		frame.getContentPane().add(lblMedicine);
		
		JComboBox cbMedicine = new JComboBox();
		cbMedicine.setBounds(426, 318, 224, 20);
		frame.getContentPane().add(cbMedicine);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(350, 350, 300, 75);
		frame.getContentPane().add(scrollPane_3);
		
		JTextArea txtMedicineDescription = new JTextArea();
		txtMedicineDescription.setText("Medicine Description");
		scrollPane_3.setViewportView(txtMedicineDescription);
		
		txtNewMedicine = new JTextField();
		txtNewMedicine.setEditable(false);
		txtNewMedicine.setBounds(350, 290, 300, 20);
		frame.getContentPane().add(txtNewMedicine);
		txtNewMedicine.setColumns(10);
		
		JButton btnCreateMedicine = new JButton("Create Medicine");
		btnCreateMedicine.setBounds(350, 257, 121, 23);
		frame.getContentPane().add(btnCreateMedicine);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(350, 459, 224, 62);
		frame.getContentPane().add(scrollPane_4);
		
		JTextArea txtDosage = new JTextArea();
		txtDosage.setText("Dosage");
		scrollPane_4.setViewportView(txtDosage);
		
		JLabel lblDosage = new JLabel("Dosage");
		lblDosage.setBounds(350, 436, 46, 14);
		frame.getContentPane().add(lblDosage);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(350, 532, 46, 14);
		frame.getContentPane().add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(406, 529, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
