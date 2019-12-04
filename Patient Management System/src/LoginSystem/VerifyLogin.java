package LoginSystem;
import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;


import AdminSystem.AdminForm;
import AdminSystem.admin;
import DoctorSystem.DoctorForm;
import DoctorSystem.doctor;
import PatientSystem.PatientForm;
import PatientSystem.RequestForm;
import PatientSystem.patient;
import SecretarySystem.SecretaryForm;
import SecretarySystem.secretary;

public class VerifyLogin extends javax.swing.JFrame{
	
	static String checkUsername = "";
	static String checkPassword = "";
	static String checkDepartment = "";
	static String checkNumber = "";
	static String filePath = "login.txt";
	static String idNumber;
	private static Scanner scanLogin;
	
	public void verifyLogin(String username, String password) {
		boolean foundIt = false;
		
		
		try {
				scanLogin = new Scanner(new File(filePath));
				// scan text file username,password new line \n
				scanLogin.useDelimiter("[,\n]");
				
				while(scanLogin.hasNext() && !foundIt) {	
					
					checkUsername = scanLogin.next();
					checkPassword = scanLogin.next();
					
				if(checkUsername.trim().equals(username.trim()) && checkPassword.trim().equals(password.trim()))
							{								
								foundIt = true;								
							}				
				}
				
			}
		catch(Exception e) {
			System.out.println("error");
		}
		
		if(foundIt == false) {
			return;
		}
		
		
		checkDepartment = scanLogin.next();
		checkNumber = scanLogin.next();
		idNumber = checkDepartment + checkNumber;
		foundIt = false;
		LoginForm.Close();
		switch(checkDepartment)
		{
		case "A":	
			
			AdminForm.main(idNumber);
			break;
		case "D":
			DoctorForm.main(idNumber);
			break;
		case "P":
			PatientForm.main(idNumber);
			
			break;
		case "S":
			SecretaryForm.main(idNumber);
			break;
		default:
			System.out.println(username+password+checkUsername+checkPassword + foundIt +checkDepartment+checkNumber);
			System.exit(0);
			
		}
		
		
	}
}
		
