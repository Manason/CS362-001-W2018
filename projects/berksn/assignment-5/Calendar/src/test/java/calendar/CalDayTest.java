package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
			CalDay calDay = new CalDay();
			assertTrue(!calDay.isValid());
			assertEquals(calDay.getAppts(), null);
	 }
	 @Test
	  public void test02()  throws Throwable  {
			CalDay calDay = new CalDay(new GregorianCalendar(2018, 01, 15));
			
		 int startHour=10;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		Appt appt2 = new Appt(startHour+2,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		Appt appt3 = new Appt(startHour-2,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
				
		Appt appt4 = new Appt(startHour+3,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		calDay.addAppt(appt4);
		calDay.addAppt(appt);
		calDay.addAppt(appt2);
		calDay.addAppt(appt3);
		calDay.addAppt(appt2);
		
		assertEquals(calDay.getAppts().get(1), appt); 
		assertEquals(calDay.getAppts().get(2), appt2); 
		assertEquals(calDay.getAppts().get(0), appt3);
		assertEquals(calDay.getAppts().get(3), appt2);
		assertEquals(calDay.getAppts().get(4), appt4);
		assertEquals(calDay.getDay(), 15);
		assertEquals(calDay.getSizeAppts(), 5);
		
		
	 }
	 
	  @Test
	  public void test03()  throws Throwable  {
			CalDay calDay = new CalDay(new GregorianCalendar(2018, 5, 20, 8, 30));
			
			
			 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
			 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		Appt appt2 = new Appt(startHour+2,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	
		
		calDay.addAppt(appt);
		calDay.addAppt(appt2);
			
			assertEquals(calDay.toString(), "\t --- 5/20/2018 --- \n --- -------- Appointments ------------ --- \n\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \t1/15/2018 at 11:30pm ,Birthday Party, This is my birthday party.\n \n");
		
		calDay = new CalDay();
		assertEquals(calDay.toString(), "");
	 }
	 
	  @Test
	  public void test04()  throws Throwable  {
			CalDay calDay = new CalDay();
			assertEquals(calDay.iterator(), null);
			calDay = new CalDay(new GregorianCalendar(2018, 01, 15));
			
			
		  int startHour=10;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		Appt appt2 = new Appt(startHour+2,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		calDay.addAppt(appt);
		calDay.addAppt(appt2);
	
		assertEquals(calDay.iterator().next(), calDay.getAppts().iterator().next());
			
		
	  }
//add more unit tests as you needed	
}
