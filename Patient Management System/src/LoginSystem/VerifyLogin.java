package LoginSystem;
import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;


import AdminSystem.AdminForm;
import AdminSystem.admin;
import DoctorSystem.doctor;
import PatientSystem.patient;
import SecretarySystem.secretary;

public class VerifyLogin {
	
	static String checkUsername = "";
	static String checkPassword = "";
	static String checkDepartment = "";
	static String checkNumber = "";
	static String filePath = "login.txt";

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
			System.out.println("Error");
		}
		
		checkDepartment = scanLogin.next();
		checkNumber = scanLogin.next();
		
		switch(checkDepartment)
		{
		case "A":
			admin adminLogin = new admin();
			adminLogin.admin();
		case "D":
			doctor doctorLogin = new doctor();
			doctorLogin.doctor();
		case "P":
			patient patientLogin = new patient();
			patientLogin.patient();
		case "S":
			secretary secretaryLogin = new secretary();
			secretaryLogin.secretary();
		default:
			System.out.println(username+password+checkUsername+checkPassword + foundIt +checkDepartment+checkNumber);
			System.exit(0);
			
		}
		
		
	}
}
		
