package SecretarySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.Person;
import LoginSystem.uniqueNumber;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class SecretaryForm {

	private static JFrame frame;
	public static String requests;
	private String nums = "";
	private int number;
	public static String userId;
	/**
	 * Launch the application.
	 */
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
	public static void sentRequest(String request)
	{
		requests = request;
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
		
		JLabel lblTitle = new JLabel("Secretary");
		lblTitle.setBounds(12, 13, 164, 14);
		frame.getContentPane().add(lblTitle);
		
		
		
		
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
		
		lblTitle.setText("Secretary " + userId);
		
		JComboBox cbRequests = new JComboBox();
		cbRequests.addItem(requests);
		cbRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		cbRequests.setBounds(262, 74, 153, 22);
		frame.getContentPane().add(cbRequests);
	}
}
