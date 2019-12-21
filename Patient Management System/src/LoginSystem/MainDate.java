package LoginSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainDate {

private String dates;
MainDate datePicker;

public MainDate()
{
	
}
	public String sendDate(String getTime)
	{
		Date date = new Date();
		SimpleDateFormat formatOfDate =
		new SimpleDateFormat ("EEE dd-MM-yyyy hh:mm a");
		//System.out.println("Current Date: " + formatOfDate.format(date));
		dates = formatOfDate.format(date);
		dates = dates.replace(":", "-");
		return dates;
	}
	
	
}
	

