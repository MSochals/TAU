package test.java;

import static org.junit.Assert.*;

import org.junit.*;

import main.java.calc;

public class test {
	private calc testCalc;
	
	@Before
	public void beforeTest() {
		testCalc = new calc();
		System.out.println("Before");
	}
	
	@After
	public void afterTest() {
		testCalc = null;
		System.out.println("After");
	}
	
	@Test
	public void testCalc1() {
		double result = testCalc.RataSt(5000, 10, 10);
		assertEquals(5232.02, result, 0);
	}
	
	@Test
	public void testCalc2() {
		double result1 = testCalc.RataSt(1231, 10, 12);
		double result2 = testCalc.RataMal(1231, 10, 12);
		assertNotSame(result1, result2);
	}
	
	@Test
	public void testCalc3() {
		double result = testCalc.RataSt(5145, 10, 36);
		assertNotNull("Error", result);
	}
}
