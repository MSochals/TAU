import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import static org.mockito.BDDMockito.*;

import org.junit.*;

public class test {
    private Calc testCalc;
    public double wczytKwota, odsetki,  doplata, rataSt;

    @Before
    public void beforeTest() {
        testCalc = new Calc();
        System.out.println("Before");
    }

    @After
    public void afterTest() {
        testCalc = null;
        System.out.println("After");
    }

    @Test
    public void testCalc1() {
        double result = testCalc.rataSt(5000, 10, 10);
        assertEquals(5232.02, result, 0);
    }

    @Test
    public void testCalc2() {
        double result1 = testCalc.rataSt(1231, 10, 12);
        double result2 = testCalc.rataMal(1231, 10, 12);
        assertNotSame(result1, result2);
    }

    @Test
    public void testCalc3() {
        double result = testCalc.rataSt(5145, 10, 36);
        assertNotNull("Error", result);
    }

    @Test
    public void testCalc4() {
        double result1 = testCalc.rataSt(1231, 10, 12);
        double result2 = testCalc.odsetki(1231, 1298.69);
        assertNotSame(result1, result2);
    }

    @Test
    public void testCalc5() {
        double result1 = testCalc.odsetki(1231, 1500);
        double result2 = testCalc.odsetki(1231, 1298.69);
        assertNotSame(result1, result2);
    }

    @Test
    public void testCalc6() {
        double result = testCalc.odsetki(5145, 6036);
        assertNotNull("Error", result);
    }

    @Test
    public void testCalc7() {
        double result = testCalc.odsetki(5000, 5000);
        assertEquals(0, result, 0);
    }

    @Test
    public void testCalc8() {
        double result = testCalc.odsetki(5000, 6000);
        assertNotEquals(100, result, 0);
    }

    @Test
    public void testCalc9() {
        double result1 = testCalc.odsetki(4000, 4132);
        double result2 = testCalc.odsetki(5000, 5132);
        assertEquals(result1, result2, 0);
    }

    @Test
    public void testCalc10() {
        double result1 = testCalc.rataMal(1231, 10, 12);
        double result2 = testCalc.odsetki(1231, 1298.69);
        assertNotSame(result1, result2);
    }

    @Deprecated
    @Test
    public void testMockito1() {
        //given
        Calc calc = mock(Calc.class);

        //when + then
        when(calc.odsetki(4000.0, 4132.0)).thenReturn(132.0);

        odsetki = calc.odsetki(4000.0, 4132.0);
        assertEquals(132.0, odsetki);
    }

    @Deprecated
    @Test
    public void testMockito2() {
        //given
        Calc calc = mock(Calc.class);

        //when + then
        when(calc.wczytKwota(4000.0)).thenReturn(4000.0);

        wczytKwota = calc.wczytKwota(4000.0);
        assertEquals(4000.0, wczytKwota);
    }

    @Deprecated
    @Test
    public void testMockito3() {
        Calc calc = Mockito.mock(Calc.class);

        given(calc.odsetki(4000.0, 4132.0)).willReturn(132.0);

        odsetki = calc.odsetki(4000.0, 4132.0);
        assertEquals(132.0, odsetki);
    }

    @Deprecated
    @Test
    public void testMockito4() {
        //given
        Calc calc = Mockito.mock(Calc.class);

        //when + then
        when(calc.rataSt(5000, 10, 10)).thenReturn(5232.02);

        rataSt = calc.rataSt(5000, 10, 10);
        assertEquals(132.0, rataSt);
    }
}