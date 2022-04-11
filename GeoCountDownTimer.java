
import java.io.*;
import java.util.Scanner;


/************************************************************************************
 * This class is a GeoCountDownTimer that simulates dates in the future and tests the
 * validity of the date and whether or not if it is a leap year.
 *
 * @author Mohamed Abdirahman
 ************************************************************************************/

public class GeoCountDownTimer {

	private int month;

	private int year;

	private int day;

	private static final int MIN_YEAR = 2022;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}


	public GeoCountDownTimer() {
		this.month = 1;
		this.year = MIN_YEAR;
		this.day = 1;
	}

	/**
	 * Default constructor that sets the GeoCountDownTimer to zero.
	 * @param year
	 * @param month
	 * @param day
	 */
	public GeoCountDownTimer(int year, int month, int day) {
		if(month < 1 || month > 12){
			throw new IllegalArgumentException();
		}
		if(day < 1 || day > 31){
			throw new IllegalArgumentException();
		}
		if(year < MIN_YEAR){
			throw new IllegalArgumentException();
		}
		this.month = month;
		this.year = year;
		this.day = day;

	}

	/**
	 * A constructor that
	 * initializes the instance variables with the provided values
	 * @param other
	 */
	public void GeoCountDownTimer (GeoCountDownTimer other)
	{
		this.day = other.day;
		this.month = other.month;
		this.year = other.year;
	}

	/**
	 * A constructor that initializes
	 * the instance variables with the other GeoCountDownTimer parameter.
	 * @param geoDate
	 */
	public GeoCountDownTimer(String geoDate) {

		if(geoDate.indexOf(",") >= 0 || geoDate.indexOf(" ") >= 0 || geoDate.indexOf("_") >= 0  )
		{
			throw new IllegalArgumentException();
		}

		String [] split = geoDate.split("/");

		if((Integer.parseInt(split[2]))%4 == 0)
		{
			if(Integer.parseInt(split[1]) > 29)
			{
				throw new IllegalArgumentException();
			}
		}
		else {
			if(Integer.parseInt(split[1]) > 28)
			{
				throw new IllegalArgumentException();
			}
		}

		setMonth(Integer.parseInt(split[0]));
		setDay(Integer.parseInt(split[1]));
		setYear(Integer.parseInt(split[2]));

	}

	/**
	 * A method that returns true if “this”
	 * GeoCountDownTimer object is exactly the same as the other object
	 * @param other
	 * @return
	 */
	public boolean equals(Object other)
	{
		GeoCountDownTimer oth = (GeoCountDownTimer) other;

		if((this.month == oth.month ) &&  (this.day == oth.day) && (this.year == oth.year)) {
			return true;
		}
		else
			return false;

	}

	/**
	 *  A method that returns 1 if “this”
	 * GeoCountDownTimer object is greater than the other GeoCountDownTimer object; returns -1 if the
	 * “this” GeoCountDownTimer object is less than the other GeoCountDownTimer; returns 0 if the “this”
	 * GeoCountDownTimer object is equal to the other GeoCountDownTimer object.
	 * @param other
	 * @return
	 */
	public int compareTo(GeoCountDownTimer other)
	{
		if(this.equals(other))
			return 0;
		if (this.year < other.year)
			return -1;
		else if (this.year == other.year){
			if(this.month < other.month)
				return -1;
			else if(this.month > other.month)
				return 1;
			else if (this.month == other.month)
			{
				if(this.day < other.day)
					return -1;
				else if (this.day > other.day)
					return 1;
			}

		}
		return 0;

	}

	/**
	 *  A method that subtracts the number of days from the “this”
	 * GeoCountDownTimer object This will adjust the timer date down the number of days.
	 * @param days
	 */
	public void dec(int days)
	{
		for(int i = days; i > 0; i--)
		{
			dec();
		}

	}

	/**
	 * A method that subtracts 1 day from the “this” GeoCountDownTimer object.
	 */
	public void dec () {

		if (this.month == 1 || this.month == 2 || this.month == 4 || this.month == 6 || this.month == 8 || this.month == 9 || this.month == 11){
			if((this.month) == 1 && (this.day == 1)){

				setDay(31);
				setMonth(12);
				this.year -= 1;
			}
			else if(getDay() == 1){

				setDay(31);
				this.month -= 1;
			}

			else{

				this.day -= 1;
			}
		}

		else if( this.month ==5 || this.month == 7 || this.month ==10 || this.month == 12)
		{
			if(getDay() == 1){
				this.month -= 1;
				setDay(30);
			}
			else
			{
				this.day -= 1;
			}
		}
		else if(this.month == 3){

			if(getDay() == 1)
			{
				setMonth(2);

				if((getYear()%4) == 0){

					setDay(29);
				}

				else{

					setDay(28);
				}
			}
			else{

				this.day -= 1;
			}

		}

	}

	/**
	 * A method that adds the number of days to the “this”
	 * GeoCountDownTimer object This will adjust the timer date up the number of days.
	 * @param days
	 */
	public void inc(int days)
	{
		for(int i = days; i > 0; i--)
		{
			inc();
		}
	}
	//MODIFY DATES, +=, SET -> Get

	/**
	 * A method that adds 1 day from the “this” GeoCountDownTimer object.
	 * Remember to consider the rolling of month and year and remember to check for a leap year when
	 * necessary
	 */
	public void inc() {
		if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)
		{

			if((this.month) == 12 && (this.day == 31)){

					setDay(1);
					setMonth(1);
				this.year += 1;
			}
			else if(getDay() == 31){

					setDay(1);
				this.month += 1;
			}

			else{

				this.day += 1;
			}
		}
		else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			if(getDay() == 30){

					this.month += 1;
				setDay(1);
			}

			else
			{

				this.day += 1;
			}
		}
		else if (this.month == 2) {

			if((getYear()%4) == 0){

				if(getDay() == 29){

					setMonth(3);

					setDay(1);
				}

				else{

					this.day += 1;
				}
			}

			else if(getDay() == 28)
			{

				setMonth(3);

					setDay(1);
			}
			else
				this.day++;
		}

	}

	/**
	 *  Method that returns a string that represents a
	 * GeoCountDownTimer with the following format: “month day, year”.
	 * @return
	 */
	public String toString() {
		String Month = "";
		String Date;
		if (this.month == 1)
			Month = "January";
		else if (this.month == 2)
			Month = "February";
		else if (this.month == 3)
			Month = "March";
		else if (this.month == 4)
			Month = "April";
		else if (this.month == 5)
			Month = "May";
		else if (this.month == 6)
			Month = "June";
		else if (this.month == 7)
			Month = "July";
		else if (this.month == 8)
			Month = "August";
		else if (this.month == 9)
			Month = "September";
		else if (this.month == 10)
			Month = "October";
		else if (this.month == 11)
			Month = "November";
		else if (this.month == 12)
			Month = "December";
		Date = Month + "" + this.day + "," + this.year;
		return Date;
	}

	/**
	 *Method that returns a string that represents a
	 * GeoCountDownTimer with the following format: “month/day/year”.
	 * @return
	 */
	public String toDateString()
	{
		String str = "";
		str += (this.month + "/" + this.day + "/" + this.year);
		return str;

	}

	/**
	 * )A method that saves the “this” GeoCountDownTimer
	 * to a file; use the parameter filename for the name of the file.
	 * @param fileName
	 */
	public void save(String fileName)
	{
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String s = this.month + " " + this.day + " " + this.year;
		out.println(s);
		out.close();
	}

	/**
	 * A method that loads the “this” GeoCountDownTimer
	 * object from a file; use the parameter filename for the name of the file.
	 * @param fileName
	 */
	public void load(String fileName)
	{
		try{
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName));
			// read one String in of data and an int
			month = fileReader.nextInt();
			day = fileReader.nextInt();
			year = fileReader.nextInt();

			System.out.println (month + " " + day +" " + year );
		}
		// could not find file
		catch(Exception error) {
			System.out.println("File not found ");
		}
	}

	/**
	 *  A method that returns the number of days to go
	 * from the parameter “fromDate” (typically today’s date, but not always) to the “this” object.
	 * @param fromDate
	 * @return
	 */
	public int daysToGo(String fromDate)
	{
		int count = 0;
		String [] splits = fromDate.split("/");

		int month = (Integer.parseInt(splits[0]));
		int day = (Integer.parseInt(splits[1]));
		int year = (Integer.parseInt(splits[2]));

		GeoCountDownTimer hold = new GeoCountDownTimer(year,month,day);

		for (int i = 0; i < fromDate.length(); i++)
		{
			if(!(hold.equals(this)))
			{
				hold.inc();
				count++;
			}
			else
			{
				break;
			}
		}
		if(count == 0)
		{
			return 0;
		}
		return count;


	}

	/**
	 * A method that returns a
	 * GeoCountDownTimer given a number of days in the future (if n < 0, then return a
	 * GeoCountDownTimers given the number of days in the past).
	 * @param n
	 * @return
	 */
	public GeoCountDownTimer daysInFuture(int n)
	{
		GeoCountDownTimer t1 = new GeoCountDownTimer(this.toDateString());

		t1.inc(n);

		return t1;
	}
}


