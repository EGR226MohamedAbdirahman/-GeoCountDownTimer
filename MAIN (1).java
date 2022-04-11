public class MAIN {
public static void main(String [] args){
    GeoCountDownTimer tmr = new GeoCountDownTimer("2/14/2025");
    tmr.dec(5);
    System.out.println(tmr.getMonth() + "/" + tmr.getDay() + "/" + tmr.getYear());

    GeoCountDownTimer s = new GeoCountDownTimer("2/10/2022");
    System.out.println("Date: " + s);

    GeoCountDownTimer s1 = new GeoCountDownTimer(2023, 2, 20);
    System.out.println("Date: " + s1.toDateString());
    s1.inc(365);
    System.out.println("Date: " + s1);

    GeoCountDownTimer s2 = new GeoCountDownTimer(2024, 1, 10);
    for (int i = 0; i < 366; i++) {
        s2.inc();
    }
    System.out.println("Date: " + s2);

    GeoCountDownTimer tmr2 = new GeoCountDownTimer("4/22/2025");
    tmr2.dec(5);
    System.out.println(tmr2.getMonth() + "/" + tmr2.getDay() + "/" + tmr2.getYear());

    GeoCountDownTimer tmr3 = new GeoCountDownTimer("4/22/2025");
    tmr3.dec(5);
    System.out.println(tmr3.getMonth() + "/" + tmr3.getDay() + "/" + tmr3.getYear());

//ADD Tester
    GeoCountDownTimer tmr4 = new GeoCountDownTimer(2120,1,10);
    for(int i =0; i < 366; i++)
    {
        tmr4.inc();
    }

    System.out.println("Dates: " + tmr4.toDateString());

    GeoCountDownTimer tmr5 =  new GeoCountDownTimer("2/10/2022");
    System.out.println("Date: " + tmr5);

    GeoCountDownTimer tmr6 = new GeoCountDownTimer(2023,2,10);
    System.out.println("Date: " + tmr5.toDateString());

    tmr5.inc(365);
    System.out.println("Date: " + tmr5);

    //Testing wrong input for inc()
    GeoCountDownTimer s7 = new GeoCountDownTimer(2121, 5,10);
    try{
        s7.inc(-365);
    }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    try{
        s7.dec(-365);
    }
    catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
//Testing illegal argument for cons
    try{
        GeoCountDownTimer s8 = new GeoCountDownTimer(2121, -2,10);
    }
    catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    try{
        GeoCountDownTimer s9 = new GeoCountDownTimer(2120, 2,30);
    }
    catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    try{
        GeoCountDownTimer s10 = new GeoCountDownTimer(2121, 2,29);
    }
    catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

///////testing equals()

    GeoCountDownTimer s11 = new GeoCountDownTimer(2121,5,5);
    GeoCountDownTimer s12 = new GeoCountDownTimer(2121,5,5);

    System.out.println("Date1: " + s11.toDateString());
    System.out.println("Date2: " + s12.toDateString());

    if(s11.equals(s12))
    {
        System.out.println("Dates are equal");
    }
    else {
        System.out.println("Dates are not equal.");
    }

    s11 = new GeoCountDownTimer(2121,5,5);
    s12 = new GeoCountDownTimer(2122,5,5);

    System.out.println("Date1: " + s11.toDateString());
    System.out.println("Date2: " + s12.toDateString());

    if(s11.equals(s12))
    {
        System.out.println("Dates are equal");
    }
    else {
        System.out.println("Dates are not equal.");
    }

//Test Compare

    s11 = new GeoCountDownTimer(2121,5,5);
    s12 = new GeoCountDownTimer(2122,5,5);

    System.out.println("Date1: " + s11.toDateString());
    System.out.println("Date2: " + s12.toDateString());

    if(s11.compareTo(s12) > 0)
    {
        System.out.println("Date2 > Date1.");
    }
    else if (s11.compareTo(s12) < 0)
    {
        System.out.println("Date1 > Date2.");
    }
    else {
        System.out.println("Date1 == Date2.");

    }

    s11 = new GeoCountDownTimer(2120,5,25);
    s12 = new GeoCountDownTimer(2120,3,5);

    System.out.println("Date1: " + s11.toDateString());
    System.out.println("Date2: " + s12.toDateString());

    if(s12.compareTo(s11) > 0)
    {
        System.out.println("Date2 > Date1.");
    }
    else if (s12.compareTo(s11) < 0)
    {
        System.out.println("Date1 > Date2.");
    }
    else {
        System.out.println("Date1 == Date2.");

        }
    }
}
