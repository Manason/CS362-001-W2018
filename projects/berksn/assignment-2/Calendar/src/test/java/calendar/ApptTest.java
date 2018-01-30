package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());  


		 startHour=24;
		 startMinute=30;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(!appt.getValid());
		 
		 startHour=21;
		 startMinute=60;
		 startDay=15;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(!appt.getValid());
		 
		 startHour=21;
		 startMinute=30;
		 startDay=32;
		 startMonth=01;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(!appt.getValid());
		 
		 /* BUG, startMonth must be valid or array index out of bounds exception occurs
		 startHour=21;
		 startMinute=30;
		 startDay=15;
		 startMonth=13;
		 startYear=2018;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(!appt.getValid());
		*/
		
		startDay = 0;
		assertTrue(!appt.getValid());
		startDay = 2;
		startMinute = -1;
		assertTrue(!appt.getValid());
		startMinute = 30;
		startHour = -1;
		assertTrue(!appt.getValid());
	 }

	 @Test
	  public void test02()  throws Throwable  {
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
		
		int[] recur = {2,3,4};
		//test setRecurrence
		appt.setRecurrence(recur, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		
		//assertions
		assertEquals(recur, appt.getRecurDays());
		assertEquals(Appt.RECUR_BY_WEEKLY, appt.getRecurBy());
		assertEquals(2, appt.getRecurIncrement());
		assertEquals(Appt.RECUR_NUMBER_FOREVER, appt.getRecurNumber());
		assertTrue(appt.isRecurring());
		
		
	 }
	 
	  @Test
	  public void test03()  throws Throwable  {
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
		
		assertEquals(appt.toString(), "\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n");
		
		appt.setStartHour(9);
		assertEquals(appt.toString(), "\t1/15/2018 at 9:30am ,Birthday Party, This is my birthday party.\n");
		
		appt.setStartHour(0);
		assertEquals(appt.toString(), "\t1/15/2018 at 12:30am ,Birthday Party, This is my birthday party.\n");
		
		appt.setStartHour(25);
		
		assertEquals(appt.toString(), null);
	 }
	 
	 
	   @Test
	  public void test04()  throws Throwable  {
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
				 
		appt.setStartMinute(10);
		appt.setStartDay(10);
		appt.setStartMonth(10);
		appt.setStartYear(2010);
		appt.setTitle("Title");
		appt.setDescription("Description");
		
		 assertEquals(10, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(10, appt.getStartMonth());
		 assertEquals(2010, appt.getStartYear());
		 assertEquals("Title", appt.getTitle());
		 assertEquals("Description", appt.getDescription());

		appt.setTitle(null);
		appt.setDescription(null);
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
		
	 }
//add more unit tests as you needed
	
}
