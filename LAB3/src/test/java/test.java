import static org.junit.Assert.*;

import org.junit.*;

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

    @Test
    public void testCalc4() {
        double result1 = testCalc.RataSt(1231, 10, 12);
        double result2 = testCalc.Odsetki(1231, 1298.69);
        assertNotSame(result1, result2);
    }

    @Test
    public void testCalc5() {
        double result1 = testCalc.Odsetki(1231, 1500);
        double result2 = testCalc.Odsetki(1231, 1298.69);
        assertNotSame(result1, result2);
    }

    @Test
    public void testCalc6() {
        double result = testCalc.Odsetki(5145, 6036);
        assertNotNull("Error", result);
    }

    @Test
    public void testCalc7() {
        double result = testCalc.Odsetki(5000, 5000);
        assertEquals(0, result, 0);
    }

    @Test
    public void testCalc8() {
        double result = testCalc.Odsetki(5000, 6000);
        assertNotEquals(100, result, 0);
    }

    @Test
    public void testCalc9() {
        double result1 = testCalc.Odsetki(4000, 4132);
        double result2 = testCalc.Odsetki(5000, 5132);
        assertEquals(result1, result2, 0);
    }

    @Test
    public void testCalc10() {
        double result1 = testCalc.RataMal(1231, 10, 12);
        double result2 = testCalc.Odsetki(1231, 1298.69);
        assertNotSame(result1, result2);
    }
}