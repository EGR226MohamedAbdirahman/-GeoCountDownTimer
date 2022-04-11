import jdk.jshell.EvalException;
import org.junit.Test;
import java.util.IllegalFormatException;
import static org.junit.Assert.*;

public class TestGeoCountDownTimer {

    /**
     * The following are simple JUnit test cases... After talking with your instructor, create
     * many, many more that shows that your code is functioning correctly.
     */

    @Test
    public void testConstructor1() {
        GeoCountDownTimer s = new GeoCountDownTimer(2121, 5, 10);
        assertEquals(s.toDateString(), "5/10/2121");

        s = new GeoCountDownTimer(2121, 1, 11);
        assertEquals(s.toDateString(), "1/11/2121");

        //	Create more, many more tests

    }

    @Test
    public void testConstructor2() {
        GeoCountDownTimer s = new GeoCountDownTimer("5/10/2121");
        assertTrue(s.toDateString().equals("5/10/2121"));
        //	Create more, many more tests

    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2121");
        assertTrue(s.toDateString().equals("2/29/2020"));

        //	Create more, many more tests

    }

    // Dates are equal or not
    @Test
    public void testConstructor4() {
        GeoCountDownTimer s = new GeoCountDownTimer("12/17/2578");
        assertTrue(s.toDateString().equals("12/17/2578"));
    }

    @Test
    public void testConstructor5() {
        GeoCountDownTimer s = new GeoCountDownTimer("3/7/3222");
        assertTrue(s.toDateString().equals("3/7/3222"));
    }

    @Test
    public void testConstructor6() {
        GeoCountDownTimer s = new GeoCountDownTimer("12/17/1999");
        assertTrue(s.toDateString().equals("12/17/1999"));
    }

    @Test
    public void testConstructor7() {
        GeoCountDownTimer s = new GeoCountDownTimer("9/23/2789");
        assertTrue(s.toDateString().equals("9/23/2789"));
    }
    //Test Laeap Year
    @Test
    public void testConstructor8() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2020");

    }
    @Test
    public void testConstructor9() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2164");

    }
    @Test
    public void testContuctor3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/6400");
    }

    // Test negative numbers are not valid
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor4() {
        new GeoCountDownTimer(2, -3, -3);
    }


    // Test to make sure no illegal characters can be used
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor6() {
        new GeoCountDownTimer("2,23/3000");
    }


    //Test Letters, IllegalArgumetnException
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1() {
        GeoCountDownTimer s = new GeoCountDownTimer("AA/29/2015");
    }


    // //Test Number formatting, IllegalArgumetnException
    @Test(expected = NumberFormatException.class)
    public void testConstructorException3() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/50000000000");
    }

    // Test Big Month Count
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException4() {
        GeoCountDownTimer s = new GeoCountDownTimer(13,29,2016);
    }

    // tests to see if NumberFormatException is thrown - month too low
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException5() {
       new GeoCountDownTimer(0,29,2016);
    }

    //Increment testing
    @Test(expected = IllegalArgumentException.class)
    public void testIncMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 2016);
        s1.inc(365);

        assertTrue(s1.toDateString().equals("5/8/2017"));

    }


    @Test
    public void testAddMethod() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 10);
        s1.inc(365);
        assertTrue(s1.toDateString().equals("5/10/2122"));

        s1 = new GeoCountDownTimer(2120, 1, 10);

        for (int i = 0; i < 366; i++)
            s1.inc();
        assertTrue(s1.toDateString().equals("1/10/2121"));

        s1 = new GeoCountDownTimer(2022, 5, 10);

        for (int i = 0; i < 31665; i++)
            s1.inc();

        for (int i = 0; i < 31665; i++)
            s1.dec();

        assertTrue(s1.toDateString().equals("5/10/2022"));

    }


    // must have a separate test for each Exception
    @Test(expected = IllegalArgumentException.class)
    public void testContuctor1() {
        new GeoCountDownTimer(2, -3, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContuctor2() {
        new GeoCountDownTimer("2,-3/-3");

    }

    @Test
    public void testEqual() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 5);
        GeoCountDownTimer s4 = new GeoCountDownTimer(3000, 5, 9);
        GeoCountDownTimer s5 = new GeoCountDownTimer(3000, 5, 9);

        assertEquals(s4, s5);
        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s4));


    }

    @Test
    public void testCompareTo() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 5, 9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 6, 1);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2121, 5, 8);
        GeoCountDownTimer s4 = new GeoCountDownTimer(2121, 5, 9);

        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s1) < 0);
        assertTrue(s1.compareTo(s4) == 0);

    }

    @Test
    public void testLoadSave() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 9, 1);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 9, 1);

        s1.save("file1");
        s1 = new GeoCountDownTimer(2111, 1, 1);  // resets to zero
        s1.load("file1");
        assertTrue(s2.equals(s1));

    }

    @Test
    public void testDaysToGo() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 2, 9);
        assertTrue(s1.daysToGo("2/1/2121") == 8);
        assertTrue(s1.daysToGo("2/8/2121") == 1);
        assertTrue(s1.daysToGo("2/9/2121") == 0);

    }

    @Test
    public void testDaysInFuture () {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2121, 12,9);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2121, 12,19);

        assertTrue (s1.daysInFuture(10).equals(s2));

    }
}

