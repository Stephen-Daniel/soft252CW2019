package LoginSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class uniqueNumber {
	
	private int number;
	private String filePath = "nextNumber.txt";
	private static Scanner read;	
	private String returnNumber ="";
	@SuppressWarnings("resource")
	public int uniqueNumber()
	{			
		try {
			read = new Scanner(new File(filePath));			
			String text = read.next();
			//System.out.println(text + "read the file and this was the number");
			number = Integer.parseInt(text);
			number++;
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}		
		//System.out.println("before the write" + number);		
		 try {
			 	FileWriter typeIt = new FileWriter(filePath);	            
	            returnNumber = Integer.toString(number);	            
	            typeIt.write(returnNumber);	              
	            typeIt.close();            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }    
		 //System.out.println("should have saved new number");
		return number;
	}
}
