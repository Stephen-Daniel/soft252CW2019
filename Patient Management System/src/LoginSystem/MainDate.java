package LoginSystem;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainDate {
private Calendar calendar;
private Calendar calendars;
private int year, month, day;	
MainDate datePicker;

public MainDate()
{
	
}
	public String sendDate(String getTime)
	{
		calendar = new GregorianCalendar();
		getTime = calendar.getTime().toString();
		return getTime;
		
	}
	public void appointment()
	{
		
		
	}
	
}
	

