package SecretarySystem;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Scanner;

import AdminSystem.AdminForm;
import LoginSystem.Person;

public class secretary {
		
	public File[] tempFiles;
	public int i = 0;
	public File[] adminFiles;
		public secretary()
		{
			
		}
		
		public void renameFile(File approved, File rename)
		{
			
			approved.renameTo(rename);
			System.out.println(approved);
			
			if (approved.renameTo(rename)) {  
				System.out.println(approved + " has been changed to " + rename);
				}else{
						System.out.println("error STILL ERROR");
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
						
						//System.out.println(name.startsWith(beginsWith) + " hello");
						// takes the feedback out of the files
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
		



