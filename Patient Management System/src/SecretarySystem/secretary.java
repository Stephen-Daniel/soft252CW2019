package SecretarySystem;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Scanner;

import LoginSystem.Person;

public class secretary {
		
	public File[] tempFiles;
	public int i = 0;
	
		public secretary()
		{
			
		}
		
		public void renameFile(File approved, File rename)
		{
		
			
			
//			File approved = new File(filename);
//			File rename = new File(uniqueNumber);
			approved.renameTo(rename);
			System.out.println(approved);
			
			if (approved.renameTo(rename)) {  
				System.out.println(approved + " has been changed to " + rename);
				}else{
						System.out.println("error STILL ERROR");
					}
			
		}
		
		public void notApproved(String filename)
		{
			
			File notApproved = new File(filename);
			if (notApproved.exists()) {
			notApproved.delete();
			System.out.println("deleted " + notApproved.getAbsolutePath());
			}else {
				System.out.println("not found file at " + notApproved.getAbsolutePath());
			}
			
		}
			
			
		

		public File[] FindTextFiles(String[] temps)
		{						
				File directoryPath = new File(System.getProperty("user.dir"));			
				
				File[] files=directoryPath.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						
						return name.startsWith("temp");
					}
				});
				
								
					tempFiles = files; 					
				
			
				return tempFiles;
			}
		}

