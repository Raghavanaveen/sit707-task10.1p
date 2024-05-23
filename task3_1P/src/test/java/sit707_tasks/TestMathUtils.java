package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class TestMathUtils {
	
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
	public void testAdd(){
		Assert.assertEquals(10,MathUtils(5,5),0);
	}
	
}
