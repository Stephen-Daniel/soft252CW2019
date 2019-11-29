package AdminSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminForm extends javax.swing.JFrame{

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm admin = new AdminForm();
					admin.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	public static void Close() {
		frame.dispose();
		return;
	}
	public AdminForm() {
		initialize();
	}
	/**
	 * Create the application.
	 */
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
		btnCreateAdmin.setBounds(12, 75, 146, 25);
		frame.getContentPane().add(btnCreateAdmin);
		
		JButton btnAddDoctor = new JButton("Add Doctor");
		btnAddDoctor.setBounds(12, 113, 146, 25);
		frame.getContentPane().add(btnAddDoctor);
		
		JButton btnAddSecretary = new JButton("Add Secretary");
		btnAddSecretary.setBounds(12, 189, 146, 25);
		frame.getContentPane().add(btnAddSecretary);
		
		JButton btnNewButton = new JButton("Remove Doctor");
		btnNewButton.setBounds(12, 151, 146, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRemoveSecretary = new JButton("Remove Secretary");
		btnRemoveSecretary.setBounds(12, 227, 146, 25);
		frame.getContentPane().add(btnRemoveSecretary);
		
		JButton btnViewRatings = new JButton("View Ratings");
		btnViewRatings.setBounds(12, 265, 146, 25);
		frame.getContentPane().add(btnViewRatings);
		
		JButton btnSendFeedback = new JButton("Send Feedback");
		btnSendFeedback.setBounds(12, 303, 146, 25);
		frame.getContentPane().add(btnSendFeedback);
		
	}

//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}
