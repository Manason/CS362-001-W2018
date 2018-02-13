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
		Appt appt5 = new Appt(startHour,
		          startMinute ,
		          startDay+1 ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		Appt appt6 = new Appt(startHour,
		          startMinute ,
		          startDay+1 ,
		          startMonth ,
		          startYear ,
		          title,
		         description);	
		Appt appt7 = new Appt(startHour,
		          startMinute ,
		          startDay+3 ,
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
		int[] recur = {2,3,4};
		appt5.setRecurrence(recur, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		appt6.setRecurrence(recur, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt5);
		appts.add(appt6);
	
		//BUG, getApptRange has to be at least 3 days, 2 days will result in error.
		LinkedList<CalDay> calDays = tt.getApptRange(appts, new GregorianCalendar(2018, 01, 14), new GregorianCalendar(2018, 01, 18));	
		assertEquals(calDays.size(), 4);
		assertEquals(calDays.get(0).getDay(), 14);
		assertEquals(calDays.get(1).getDay(), 15);
		assertEquals(calDays.get(2).getDay(), 16);
		assertTrue(calDays.get(2).getAppts().get(0).getValid());
		assertTrue(calDays.get(2).getAppts().get(1).getValid());
		assertEquals(calDays.get(2).getAppts().get(1).getStartDay(), 15);
		assertEquals(calDays.get(2).getAppts().size(), 3);
		
		int []recur2 = {2, 3, 4, 5, 6};
		appt7.setRecurrence(recur2, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		appts.add(appt7);
		calDays = tt.getApptRange(appts, new GregorianCalendar(2018, 01, 14), new GregorianCalendar(2018, 02, 16));
		
		assertEquals(calDays.size(), 30);
		assertEquals(calDays.get(0).getDay(), 14);
		assertEquals(calDays.get(1).getDay(), 15);
		assertEquals(calDays.get(2).getDay(), 16);
		assertTrue(calDays.get(2).getAppts().get(0).getValid());
		assertTrue(calDays.get(2).getAppts().get(1).getValid());
		assertEquals(calDays.get(2).getAppts().get(1).getStartDay(), 15);
		assertEquals(calDays.get(2).getAppts().size(), 3);
		//assertEquals(calDays.get(2).getAppts(), appts);
		assertTrue(calDays.get(2).getAppts().get(2).getValid());
		assertTrue(calDays.get(8).getAppts().get(0).isRecurring());
		Appt tempAppt = calDays.get(8).getAppts().get(0);
		assertEquals(tempAppt.getRecurNumber(), 1000);
		assertEquals(tempAppt.getRecurBy(), Appt.RECUR_BY_WEEKLY);
		assertEquals(tempAppt.getRecurIncrement(), 2);
		assertEquals(tempAppt.getRecurDays().length, 3);
		
	
		//assertTrue(calDays.get(2).getAppts().get(2).isRecurring());
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
		 int[] pv2 = {1, 0, 2, 3, 4};
		 
		 appts.add(appt5);
		 appts.add(appt6);
		 
		 //BUG, permute does not swap as nexti is is never incremented. Only swaps the 0 element with the 0 element for the number of elements
		 
		 //fails
		 //assertEquals(tt.permute(appts, pv2).get(0).getStartHour(), (appts.get(1).getStartHour()));
		 
		 
		 //fails
		 //assertEquals(tt.permute(appts, pv2).get(0), appts.get(2));
		 
	 }
	 @Test
	 public void test05() throws Throwable{
		 TimeTable tt = new TimeTable();
		 appts.add(appt);
		 appts.add(appt2);
		 appts.add(appt3);
		 appts.add(appt3);
		 //BUG, deleteAppt will not remove the first element or the last element
		 assertEquals(tt.deleteAppt(appts, appt), null);
		 //BUG, deleteAppt only deletes first occurence
		 assertEquals(tt.deleteAppt(appts, appt3).size(), 3);
		 //appts.remove(3);
		 assertEquals(tt.deleteAppt(appts, appt2).size(), 2);
		 
		 
	 }
		 
//add more unit tests as you needed
}
