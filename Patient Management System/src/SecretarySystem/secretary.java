package SecretarySystem;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import AdminSystem.AdminForm;
import LoginSystem.LoginForm;
import LoginSystem.Person;
import PatientSystem.RequestForm;

public class secretary {
		
	public File[] tempFiles;
	public int i = 0;
	public File[] adminFiles;
	public String firstname, surname, rating;
		public secretary()
		{
			
		}
		public void amendFile(String oldQuantity, String newQuantity, String filepath)
		{
			
			//System.out.println(oldQuantity + " " + newQuantity);
			Scanner paper;
			String tempFile = "amendFileTemp.txt";
			File oldFile = new File(filepath);
			File newFile = new File(tempFile);
			String text = "";
			try
			{
				FileWriter fw = new FileWriter(tempFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				paper = new Scanner(new File(filepath));
				paper.useDelimiter("[\n]");
				
				while(paper.hasNext())
				{
					text = paper.next().trim();
					//System.out.println(text + " read first number");
					if(text.equals(oldQuantity))
					{
						//System.out.println(newQuantity + " to replace");
						pw.println(newQuantity.trim());						
					}else {
						pw.println(text.trim());
					}
				}
				paper.close();
				pw.flush();
				pw.close();
				oldFile.delete();
				File dump = new File(filepath);
				newFile.renameTo(dump);
				
			}catch(IOException e) {
	            e.printStackTrace();
				
			}
		}
		public void amendFile(String removeTerm, String filepath)
		{
			Scanner paper;
			String tempFile = "amendFileTemp.txt";
			File oldFile = new File(filepath);
			File newFile = new File(tempFile);
			String text = "";
			try
			{
				FileWriter fw = new FileWriter(tempFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				paper = new Scanner(new File(filepath));
				paper.useDelimiter("[\n]");
				
				while(paper.hasNext())
				{
					text = paper.next();
					if(!text.equals(removeTerm))
					{
						pw.println(text);						
					}
				}
				paper.close();
				pw.flush();
				pw.close();
				oldFile.delete();
				File dump = new File(filepath);
				newFile.renameTo(dump);
				
			}catch(IOException e) {
	            e.printStackTrace();
				
			}
		}
		
		public void terminationRequest(String patientID)
		{
			try
			{					
				FileWriter fw = new FileWriter("terminationRequest.txt", true);
				PrintWriter pw = new PrintWriter(fw);	            	 
	            pw.println(patientID + ".txt");	           
	            pw.flush();
	            pw.close();		            
	            fw.close(); 	            							
			}
			catch (IOException e) {
	            e.printStackTrace();									
			}
		}
		
		public void renameFile(File approved, File rename)
		{						
			if (approved.renameTo(rename)) {  
				System.out.println(approved + " has been changed to " + rename);
				}else{
						System.out.println("error STILL ERROR " + approved + " not changed to " + rename);
					}			
		}
		
		public void deleteFile(String filename)
		{
			System.out.println("delete method " + filename);
			File deleteTextFile = new File(filename);
			if (deleteTextFile.exists()) {
			deleteTextFile.delete();
			System.out.println("deleted " + deleteTextFile.getAbsolutePath());
			}else {
				System.out.println("not found file at " + deleteTextFile.getAbsolutePath());
			}			
		}

		public File[] FindFiles(String[] temps, String beginsWith)
		{						
				File directoryPath = new File(System.getProperty("user.dir"));			
				String notFeedback = "FeedbackOrNotes.txt";
				File[] files=directoryPath.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {							
						if(name.contains(notFeedback))
						{	return false;				
						}
						return name.startsWith(beginsWith);
					}
				});												
					tempFiles = files; 							
				return tempFiles;
			}
}
		



