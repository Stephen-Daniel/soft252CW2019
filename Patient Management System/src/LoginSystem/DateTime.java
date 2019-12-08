package LoginSystem;

import static org.hamcrest.CoreMatchers.startsWith;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;


public class DateTime {
	
	
	public DateTime() {
		
	
	}
	
	public String showDate(String dateNow) {
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		dateNow = s.format(d);
		System.out.println(dateNow);
		return dateNow;
	}
//	public String showTime(String time) {
//		
//		SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
//		Date d = new Date();
//		d.
//		new Timer(0, new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				time = (s.format(d));
//				
//				throw new UnsupportedOperationException("Not supported");
//			}
//			
//		}).start();
//		
//		return time;
//	}


	
	
}
