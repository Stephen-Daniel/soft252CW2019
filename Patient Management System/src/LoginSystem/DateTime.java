package LoginSystem;

import static org.hamcrest.CoreMatchers.startsWith;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import AdminSystem.AdminForm;


public class DateTime extends javax.swing.JFrame{
	
	
	

	
	
	public DateTime() {
	
		
	}
	
	
	
	public String sendDate(String getTime)
	{
		Calendar calendar = new GregorianCalendar();
		getTime = calendar.getTime().toString();
		return getTime;
	}

	
}
