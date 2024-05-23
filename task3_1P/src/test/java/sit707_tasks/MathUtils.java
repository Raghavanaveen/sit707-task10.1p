package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class MathUtils {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s224099224";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "raghava";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		  DateUtil date = new DateUtil(1, 1, 2024);
		    System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
		    date.increment();
		    System.out.println(date);
		    Assert.assertEquals(2, date.getDay());
		    Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		  DateUtil date = new DateUtil(1, 1, 2024);
		    System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		    date.decrement();
		    System.out.println(date);
		    Assert.assertEquals(31, date.getDay());
		    Assert.assertEquals(12, date.getMonth());
	}
	


	    @Test
	    public void testPreviousDate() {
	        DateUtil date = new DateUtil(1, 6, 1994);
	        Assert.assertEquals("31-5-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(2, 6, 1994);
	        Assert.assertEquals("1-6-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 6, 1994);
	        Assert.assertEquals("14-6-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));
	        date = new DateUtil(30, 6, 1994);
	        Assert.assertEquals("29-6-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));
	        try {
	        	
	        	date = new DateUtil(31, 6, 1994);
	        	Assert.assertEquals("Invalid Date", getPreviousDate(date));
	        }catch(RuntimeException e) {
	        	System.out.println("invalid date");
	        }

	        date = new DateUtil(15, 1, 1994);
	        Assert.assertEquals("14-1-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 2, 1994);
	        Assert.assertEquals("14-2-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 11, 1994);
	        Assert.assertEquals("14-11-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 12, 1994);
	        Assert.assertEquals("14-12-1994", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 6, 1700);
	        Assert.assertEquals("14-6-1700", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 6, 1701);
	        Assert.assertEquals("14-6-1701", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 6, 2023);
	        Assert.assertEquals("14-6-2023", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));

	        date = new DateUtil(15, 6, 2024);
	        Assert.assertEquals("14-6-2024", getPreviousDate(date));
	        System.out.println(getPreviousDate(date));
	    }

	    private String getPreviousDate(DateUtil date) {
	        date.decrement();
	        return date.getDay() + "-" + date.getMonth() + "-" + date.getYear();
	    }
	    
	    @Test
	    public void testNextDate() {
	        printNextDate(1, 6, 1994);
	        printNextDate(2, 6, 1994);
	        printNextDate(15, 6, 1994);
	        printNextDate(30, 6, 1994);
	        printNextDate(31, 6, 1994);
	        printNextDate(15, 1, 1994);
	        printNextDate(9, 2, 1994);
	        printNextDate(15, 11, 1994);
	        printNextDate(12, 12, 1994);
	        printNextDate(29, 2, 2024);
	        printNextDate(29, 2, 2023);
	        printNextDate(15, 6, 2023);
	        printNextDate(15, 6, 2024);

	        // Additional test cases for February with leap year
	        printNextDate(28, 2, 2020); // Leap year
	        printNextDate(28, 2, 2021); // Non-leap year
	    }

	    private void printNextDate(int day, int month, int year) {
	        String nextDate = getNextDate(day, month, year);
	        System.out.println( nextDate);
	        Assert.assertNotNull(nextDate);
	    }

	    private String getNextDate(int day, int month, int year) {
	        try {
	            DateUtil date = new DateUtil(day, month, year);
	            date.increment();
	            return date.getDay() + "-" + date.getMonth() + "-" + date.getYear();
	        } catch (RuntimeException e) {
	            
	            return "Invalid Date";
	        }
	    }
	
}
