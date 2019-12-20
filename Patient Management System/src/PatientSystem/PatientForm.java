package PatientSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginSystem.LoginForm;
import LoginSystem.MainDate;
import LoginSystem.Person;
import SecretarySystem.secretary;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
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
	private JComboBox cbDoctorRate;
	public String beginsWith = "";
	private JTextField txtDisplayHistory;
	private JTextField txtMedicine;
	private JTextField txtQuantity;
	private JTextField txtDosage;
	private JTextField txtAppointment;
	private JButton btnSubmitRequest;
	private JButton btnSubmit;
	private boolean s1,s2,s3,s4,s5;
	private JButton btnRateDoctor;
	private JButton btnRequestApp;
	private JTextArea txtPatientDetails;
	private JTextArea txtPatientRequest;
	private String temp;
	private JRadioButton rbs1;
	private JRadioButton rbs2;
	private JRadioButton rbs3;
	private JRadioButton rbs4;
	private JRadioButton rbs5;
	private JTextArea txtDoctorsDetails;
	private JTextArea txtRatings;
	private String filename;
	
	private String highOrLow;
	private double rating;
	private double newRating;
	private double updatedRating;
	private JComboBox cbDoctorAppointment;
	private JTextArea txtDisplayFeedback;
	private String chosenDoctor;
	private String firstname;
	private String doctor;
	private String surname;
	private String date;
	private String newDate;
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
	public void sendAppointment()
	{
		String patientID = userId;
		MainDate getDate = new MainDate();
		date = getDate.sendDate(newDate).toString();
		date = date.replace(":", "-");
		patientID = ("request " + patientID + " "+ date + ".txt");
		System.out.println(patientID);
		
		try
		{					
			FileWriter fw = new FileWriter(patientID); 
			PrintWriter pw = new PrintWriter(fw); 
			pw.println(cbDoctorAppointment.getSelectedItem());
            pw.println(txtPatientRequest.getText());           
            pw.flush();
            pw.close();		            
            fw.close(); 
            }
		catch (IOException e) {
			System.out.println("fail " + patientID);								
		}
	}
	public void clear()
	{
		for(int i = cbDoctorRate.getItemCount()-1;i>=1;i--) {
			cbDoctorRate.removeItemAt(i);
			cbDoctorAppointment.removeItemAt(i);			
		}
	}
	public void saveRating()
	{
		System.out.println("name taken from txtusername " + filename);
		String feedbackOrNotes = "FeedbackOrNotes";
		String stars = Double.toString(newRating);
		if(newRating > rating)
		{
			highOrLow = "Rating has increased your stars";
		}else {
			highOrLow = "Rating has lowered your stars";
		}
		updatedRating = rating + newRating;
		updatedRating = Math.round((updatedRating/2) * 10.0) / 10.0;
		String id = filename.replace(".txt", "");
		System.out.println(updatedRating);		
		feedbackOrNotes = id + feedbackOrNotes + ".txt";
		//save new rating score
		File doctorRatingUpdate = new File(filename);           
        BufferedReader reader = null;        
        FileWriter writer = null;
        String oldContent = "";
        String patient = ("Patient " + userId + " gave you " + stars + " stars, " + highOrLow);
        try
        {
            reader = new BufferedReader(new FileReader(doctorRatingUpdate));            
            String line = reader.readLine();
            String removeOldRating = "";
            String newRating = Double.toString(updatedRating);
            for(int i=1;i < 9;i++)
            {
                oldContent = oldContent + line + System.lineSeparator();                
                line = reader.readLine();
            }
            
            oldContent = oldContent + line + System.lineSeparator();
            removeOldRating = reader.readLine();
            System.out.println(removeOldRating);
            oldContent = oldContent + newRating + System.lineSeparator();
           
            line = reader.readLine();
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
            
            writer = new FileWriter(doctorRatingUpdate);
            writer.write(oldContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources                
                reader.close();                
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }           
		try
		{	
			MainDate getDate = new MainDate();
			date = getDate.sendDate(newDate);
			FileWriter fw = new FileWriter(doctorRatingUpdate, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println("Date : " + date);
			pw.println("Patient " + userId + " gave you " + newRating + " stars");
			pw.println(highOrLow);
			pw.println("Their comment was:");
            pw.println(txtDisplayFeedback.getText().trim());           
            pw.flush();
            pw.close();		            
            fw.close(); 
            }
		catch (IOException e) {
            System.out.println("fail" + feedbackOrNotes);									
		}
	
		rateDoctors();
		
		
	}
public void rateDoctors()
{
	secretary getTemps = new secretary();	
	requests = getTemps.FindFiles(temps, "D");
	txtRatings.setText("");	
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
				txtRatings.append(firstname + " ");
				surname = populate.next();
				txtRatings.append(surname + "  has ");			
				for (int i=3;i < 10;i++) {					
				temp = (populate.next());
				}				
				txtRatings.append(populate.next() + " Stars\n");				
				populate.close();
				cbDoctorRate.addItem(firstname + " " + surname + " " + doctor);
				cbDoctorAppointment.addItem(firstname + " " + surname + " " + doctor);				
			} catch (FileNotFoundException e1) {				
				e1.printStackTrace();
			}				
	}
	}
	public void selectedDoctorForFeedback()
	{
		chosenDoctor = cbDoctorRate.getSelectedItem().toString();
		chosenDoctor = chosenDoctor.substring(chosenDoctor.lastIndexOf(" ")+1) + ".txt";
		System.out.println(chosenDoctor);
		//grab chosen rating from doctor
		filename = chosenDoctor;
		Scanner populate;
			try {
				populate = new Scanner(new File(filename));
				populate.useDelimiter("[\n]");			
				for (int i=1;i < 10;i++) {					
				temp = (populate.next());
				}							
				rating = Double.parseDouble(populate.next().trim());			
				populate.close();				
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		System.out.println(rating);
	}
	public PatientForm() {
		initialize();
		rateDoctors();
		
	}
	public void starsEnabled(boolean onOff) 
	{
		rbs1.setEnabled(onOff);
		rbs2.setEnabled(onOff);
		rbs3.setEnabled(onOff);
		rbs4.setEnabled(onOff);
		rbs5.setEnabled(onOff);
	}
	public void starsOff()
	{
		rbs1.setSelected(false);
		rbs2.setSelected(false);
		rbs3.setSelected(false);
		rbs4.setSelected(false);
		rbs5.setSelected(false);
	}

	public static void Close() {
		frame.dispose();
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1104, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPatientTitle = new JLabel("");
		lblPatientTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblPatientTitle.setBounds(504, 11, 120, 30);
		frame.getContentPane().add(lblPatientTitle);
		
		btnRateDoctor = new JButton("Rate Doctor with feedback");
		btnRateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbDoctorRate.setEnabled(true);
				starsEnabled(true);
				txtDisplayFeedback.setEnabled(true);
				btnSubmit.setEnabled(true);
				
			}
		});
		btnRateDoctor.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRateDoctor.setBounds(377, 11, 229, 25);
		frame.getContentPane().add(btnRateDoctor);
		
		btnRequestApp = new JButton("Request an Appointment");
		btnRequestApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cbDoctorAppointment.setEnabled(true);
				txtDisplayHistory.setEnabled(true);
				btnSubmitRequest.setEnabled(true);
			}
		});
		btnRequestApp.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRequestApp.setBounds(10, 225, 200, 25);
		frame.getContentPane().add(btnRequestApp);
		
		JButton btnViewHistory = new JButton("View History");
		btnViewHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnViewHistory.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewHistory.setBounds(794, 243, 200, 25);
		frame.getContentPane().add(btnViewHistory);
		
		JButton btnViewAppointment = new JButton("View Appointment");
		btnViewAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnViewAppointment.setFont(new Font("Arial", Font.PLAIN, 15));
		btnViewAppointment.setBounds(393, 271, 200, 25);
		frame.getContentPane().add(btnViewAppointment);
		
		JButton btnViewPrescription = new JButton("View Prescription");
		btnViewPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		btnRequestTermination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				secretary secretary = new secretary();
				secretary.terminationRequest(userId);
				btnRequestTermination.setEnabled(false);
			}
		});
		btnRequestTermination.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRequestTermination.setBounds(552, 623, 200, 25);
		frame.getContentPane().add(btnRequestTermination);
		
		JLabel lblTitle = new JLabel("Patient");
		lblTitle.setBounds(40, 13, 159, 16);
		frame.getContentPane().add(lblTitle);
		lblTitle.setText("Patient " + userId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(716, 35, 335, 197);
		frame.getContentPane().add(scrollPane);
		
		txtDisplayHistory = new JTextField();
		txtDisplayHistory.setEditable(false);
		scrollPane.setViewportView(txtDisplayHistory);
		txtDisplayHistory.setColumns(10);
		
		rbs1 = new JRadioButton("1 Star");
		rbs1.setSelected(true);
		rbs1.setEnabled(false);
		rbs1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				starsOff();
				rbs1.setSelected(true);
				newRating = 1;
			}
		});
		rbs1.setBounds(264, 77, 80, 23);
		frame.getContentPane().add(rbs1);
		
		rbs2 = new JRadioButton("2 Stars");
		
		rbs2.setEnabled(false);
		rbs2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				starsOff();
				rbs2.setSelected(true);
				newRating = 2;
			}
		});
		rbs2.setBounds(264, 103, 80, 23);
		frame.getContentPane().add(rbs2);
		
		rbs3 = new JRadioButton("3 Stars");
		rbs3.setEnabled(false);
		rbs3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				starsOff();
				rbs3.setSelected(true);
				newRating = 3;
			}
		});
		rbs3.setBounds(264, 129, 80, 23);
		frame.getContentPane().add(rbs3);
		
		rbs4 = new JRadioButton("4 Stars");
		rbs4.setEnabled(false);
		rbs4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				starsOff();
				rbs4.setSelected(true);
				newRating = 4;
			}
		});
		rbs4.setBounds(264, 155, 80, 23);
		frame.getContentPane().add(rbs4);
		
		rbs5 = new JRadioButton("5 Stars");
		rbs5.setEnabled(false);
		rbs5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				starsOff();
				rbs5.setSelected(true);
				newRating = 5;
			}
		});
		rbs5.setBounds(264, 182, 80, 23);
		frame.getContentPane().add(rbs5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(363, 75, 300, 130);
		frame.getContentPane().add(scrollPane_1);
		
		txtDisplayFeedback = new JTextArea();
		txtDisplayFeedback.setEnabled(false);
		scrollPane_1.setViewportView(txtDisplayFeedback);
		
		txtRatings = new JTextArea();
		txtRatings.setEditable(false);
		txtRatings.setBounds(20, 64, 217, 128);
		frame.getContentPane().add(txtRatings);
		
		txtPatientDetails = new JTextArea();
		txtPatientDetails.setEditable(false);
		txtPatientDetails.setBounds(45, 444, 270, 120);
		frame.getContentPane().add(txtPatientDetails);
		
		txtDoctorsDetails = new JTextArea();
		txtDoctorsDetails.setEditable(false);
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
		
		txtPatientRequest = new JTextArea();
		scrollPane_3.setViewportView(txtPatientRequest);
		
		cbDoctorAppointment = new JComboBox();
		cbDoctorAppointment.setEnabled(false);
		cbDoctorAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cbDoctorAppointment.setBounds(10, 285, 245, 20);
		frame.getContentPane().add(cbDoctorAppointment);
		
		JLabel lblChooseADoctor = new JLabel("Choose a Doctor");
		lblChooseADoctor.setBounds(10, 261, 95, 14);
		frame.getContentPane().add(lblChooseADoctor);
		
		JLabel lblWriteWhatsWrong = new JLabel("Write whats wrong and some dates to be seen");
		lblWriteWhatsWrong.setBounds(10, 316, 235, 14);
		frame.getContentPane().add(lblWriteWhatsWrong);
		
		txtAppointment = new JTextField();
		txtAppointment.setEditable(false);
		txtAppointment.setBounds(393, 307, 270, 29);
		frame.getContentPane().add(txtAppointment);
		txtAppointment.setColumns(10);
		
		cbDoctorRate = new JComboBox();
		cbDoctorRate.setEnabled(false);
		cbDoctorRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				selectedDoctorForFeedback();
				
			}
		});
		cbDoctorRate.setBounds(282, 47, 245, 20);
		frame.getContentPane().add(cbDoctorRate);
		
		JLabel lblrateDoctor = new JLabel("Choose a Doctor");
		lblrateDoctor.setBounds(272, 23, 95, 14);
		frame.getContentPane().add(lblrateDoctor);
		
		btnSubmit = new JButton("Submit Rating and Feedback");
		btnSubmit.setEnabled(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				saveRating();
				starsEnabled(false);
				cbDoctorRate.setEnabled(false);
				txtDisplayFeedback.setText("");
				txtDisplayFeedback.setEditable(false);
				btnSubmit.setEnabled(false);
	
			}
		});
		btnSubmit.setBounds(425, 216, 172, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblDoctorsratings = new JLabel("Doctors Ratings");
		lblDoctorsratings.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDoctorsratings.setBounds(20, 35, 165, 19);
		frame.getContentPane().add(lblDoctorsratings);
		
		btnSubmitRequest = new JButton("Submit");
		btnSubmitRequest.setEnabled(false);
		btnSubmitRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sendAppointment();
				btnSubmitRequest.setEnabled(false);
				cbDoctorAppointment.setEnabled(false);
				txtDisplayHistory.setText("");
				txtDisplayHistory.setEnabled(false);
				txtPatientRequest.setText("");
				
			}
		});
		btnSubmitRequest.setBounds(10, 412, 89, 23);
		frame.getContentPane().add(btnSubmitRequest);
	}
}
