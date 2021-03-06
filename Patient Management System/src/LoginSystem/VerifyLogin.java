package LoginSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;




import AdminSystem.AdminForm;

import DoctorSystem.DoctorForm;
import DoctorSystem.doctor;
import PatientSystem.PatientForm;
import PatientSystem.RequestForm;
import PatientSystem.patient;
import SecretarySystem.SecretaryForm;
import SecretarySystem.secretary;

public class VerifyLogin extends javax.swing.JFrame{
	
	static String temp = "";
	char readChar;
	static String username = "";
	static String checkPassword = "";
	static String checkDepartment = "";
	static String checkNumber = "";
	 
	
	private static Scanner scanLogin;
	
	public void verifyLogin(String user, String password) {
		boolean foundIt = false;
		String filePath = ".txt";
		username = user;
		// grab department letter
		readChar = username.charAt(0);
		checkDepartment = Character.toString(readChar);
		filePath = username + filePath;
		System.out.println(filePath);
		try {
				scanLogin = new Scanner(new File(filePath));
				// scan text file for password at line 9 
				scanLogin.useDelimiter("[\n]");
				
				for (int i = 1; i < 9; i++) {
					temp = scanLogin.next();
				}		
					temp = "";
					checkPassword = scanLogin.next();
					
				if(checkPassword.trim().equals(password.trim()))
					{	
					foundIt = true;
					}else {
							System.out.println("no user found");
							if(foundIt == false) {

								scanLogin.close();
								return;
							}						
						}
				}catch (Exception e) {
				
				return;
			}
	
		scanLogin.close();
		LoginForm.Close();
			
		switch(checkDepartment)
		{
		case "A":	
			
			AdminForm.main(username);
			break;
		case "D":
			DoctorForm.main(username);
			break;
		case "P":
			PatientForm.main(username);
			
			break;
		case "S":
			SecretaryForm.main(username);
			break;
		default:
			System.out.println(username);
			System.exit(0);
			
		}
		}
	
		
	}

		
