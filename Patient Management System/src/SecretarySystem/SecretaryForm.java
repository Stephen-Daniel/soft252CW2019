package SecretarySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.uniqueNumber;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecretaryForm {

	private static JFrame frame;
	private String nums = "";
	private int number;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecretaryForm secretary = new SecretaryForm();
					secretary.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecretaryForm() {
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
		frame.setBounds(100, 100, 1047, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Secretary");
		lblNewLabel.setBounds(12, 13, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SecretaryForm.Close();
			LoginForm.main(null);
				
			}
		});
		btnLogout.setBounds(740, 515, 97, 25);
		frame.getContentPane().add(btnLogout);
		
		JButton btnNumber = new JButton("number");
		btnNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				uniqueNumber num = new uniqueNumber();
				
				number = num.uniqueNumber();
				
				System.out.println(number);
				
				nums = Integer.toString(number);
				
				btnNumber.setText(nums);
			
			}
		});
		btnNumber.setBounds(262, 515, 97, 25);
		frame.getContentPane().add(btnNumber);
		
		JButton btnApproveNewAccounts = new JButton("Approve New Accounts");
		btnApproveNewAccounts.setBounds(12, 73, 229, 25);
		frame.getContentPane().add(btnApproveNewAccounts);
		
		JButton btnReceiveRequestAppointments = new JButton("Receive Request for Appointments");
		btnReceiveRequestAppointments.setBounds(12, 111, 229, 25);
		frame.getContentPane().add(btnReceiveRequestAppointments);
		
		JButton btnCreateAppointment = new JButton("Create Appointment");
		btnCreateAppointment.setBounds(12, 148, 229, 25);
		frame.getContentPane().add(btnCreateAppointment);
		
		JButton btnGiveMedicines = new JButton("Give Medicines");
		btnGiveMedicines.setBounds(12, 186, 229, 25);
		frame.getContentPane().add(btnGiveMedicines);
		
		JButton btnOrderStock = new JButton("Order and Stock Medicines");
		btnOrderStock.setBounds(12, 224, 229, 25);
		frame.getContentPane().add(btnOrderStock);
		
		JButton btnRemovePatients = new JButton("Remove Patients");
		btnRemovePatients.setBounds(12, 262, 229, 25);
		frame.getContentPane().add(btnRemovePatients);
		
		JButton btnApproveAccRemoval = new JButton("Approve account removal");
		btnApproveAccRemoval.setBounds(12, 300, 229, 25);
		frame.getContentPane().add(btnApproveAccRemoval);
	}
}
