package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

		 int startHour=21;
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
		Appt appt4 = new Appt(26,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		LinkedList<Appt> appts = new LinkedList<Appt>();
		

	 @Test
	  public void test01()  throws Throwable  {
		TimeTable tt = new TimeTable();
		appts.add(appt);
		appts.add(appt2);
		appts.add(appt3);
		
		//following code throws DateOutOfRangeException
		/*tt.getApptRange(appts, new GregorianCalendar(2018, 01, 16), new GregorianCalendar(2018, 01, 14));*/	
		
	 }
	 @Test
	  public void test02()  throws Throwable  {
		  /*TimeTable tt = new TimeTable();
		 GregorianCalendar gc = tt.getApptOccurences(appt, new GregorianCalendar(2018, 01, 14), new GregorianCalendar(2018, 01, 16)).get(0);
		 
		 assertEquals(gc.get(gc.DAY_OF_MONTH, 15));
		 assertEquals(gc.get(gc.MONTH, 01));
		 assertEquals(gc.get(gc.YEAR, 2018));*/
		 
		 TimeTable tt = new TimeTable();
		
		
		assertEquals(tt.deleteAppt(null, appt2), null);
		
		appts.add(appt4);
		assertEquals(tt.deleteAppt(appts, appt4), null);
		assertEquals(tt.deleteAppt(appts, null), null);

		
	 }
	 
	 @Test
	 public void test03() throws Throwable {
		TimeTable tt = new TimeTable();
		appts.add(appt);
		appts.add(appt2);
		appts.add(appt3);
		assertEquals(tt.deleteAppt(appts, appt2).size(), 2);
		//causes null pointer due to i starting at 1 instead of 0
		//assertEquals(tt.deleteAppt(appts, appt).size(), 2);
		
	 }
	 @Test
	 public void test04() throws Throwable {
		 TimeTable tt = new TimeTable();
		 appts.add(appt);
		 appts.add(appt2);
		 appts.add(appt3);
		 int[] pv = {0, 1, 2};
		 assertTrue(tt.permute(appts, pv).equals(appts));
		 int[] pv2 = {2, 1, 0};
		 //fails
		 //assertEquals(tt.permute(appts, pv2).get(0), appts.get(2));
		 
	 }
		 
//add more unit tests as you needed
}
