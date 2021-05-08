import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.io.File;

class Row {
	public Row (String row) {
		System.out.println("Row received: " + row);
		try(Scanner rowReader = new Scanner(row)) {
			rowReader.useDelimiter(",");
      int index = 0;
      while (rowReader.hasNext()) {
				String val = rowReader.next();
				System.out.println("Current value is: " + val);
				if (index == 0) setMonth(Integer.parseInt(val));
				if (index == 1) setDay(Integer.parseInt(val));
				if (index == 2) setYear(Integer.parseInt(val));
				if (index == 3) setHour(Integer.parseInt(val));
				if (index == 4) setMinute(Integer.parseInt(val));
				if (index == 5) setSecond(Integer.parseInt(val));
				if (index == 6) setDescription(val);

				++index;
      }
			rowReader.close();
		} catch (Exception e) {
			System.out.println("Something did not go as planned!  Exception info is: " + e);
		}
	};

	public int getYear () { return year; }
	private void setYear (int yr) { year = yr; }
	public int getMonth () { return month; }
	private void setMonth (int m) { month = m; }
	public int getDay () { return day; }
	private void setDay (int d) { day = d; }
	public int getHour () { return hour; }
	private void setHour (int hr) { hour = hr; }
	public int getMinute () { return minute; }
	private void setMinute (int min) { minute = min; }
	public int getSecond () { return seconds; }
	private void setSecond (int secos) { seconds = secos; }
	public String getDescription () { return eventDescription; }
	private void setDescription (String desc) { eventDescription = desc; }

	int year;
	int month;
	int day;
	int hour;
	int minute;
	int seconds;
	String eventDescription;
}

public class TimeUntil { // Oh, here's a class, we've learned about declaring classes
	public static void main(String[] args) {
		System.out.println("Welcome to the Time Until Application");
		LocalDateTime startingDate = LocalDateTime.now();
		//LocalDateTime targetDate = LocalDateTime.of(2021, Month.MAY, 6, 11, 10, 10);

		//Row one = new Row("5,6,2021,10,9,8,Sample event\n");
		//System.out.println("Row year is: " + one.getYear());
		try (Scanner eventsReader = new Scanner(new File("events.csv"));) {
			int rowNum = -1;
			while (eventsReader.hasNextLine()) {
				++rowNum;
			  if (rowNum == 0) {
					String nextLn = eventsReader.nextLine();
					continue; // skip the first row because it has column label information, not actual event data
				}
				String nextRow = eventsReader.nextLine();
				System.out.println("\n\n----------------------------------------------------------------------------------\n");
				Row eventRow = new Row(nextRow);
				LocalDateTime targetDate = LocalDateTime.of(eventRow.getYear(), eventRow.getMonth(), eventRow.getDay(), eventRow.getHour(), eventRow.getMinute(), eventRow.getSecond());
				System.out.println("Processing event #" + rowNum + " :" + eventRow.getDescription());

				long numDaysBetween = ChronoUnit.DAYS.between(startingDate, targetDate);
				System.out.println("Only " + numDaysBetween + " days until event.  Treasure, and make the most, each day!  Because, once again, there's only so much time before that day quickly comes, to be exact one more time, days until event is: " + numDaysBetween);

				long numHoursUntil = ChronoUnit.HOURS.between(startingDate, targetDate);
				System.out.println("Just to break it down a little further, you have only this many hours until the event: " + numHoursUntil);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong locating or processing events.csv file.  Exception information is: " + e);
		}
	}
}

/*
Some of the things we've learned together in class and are applying in this program.  Can you see where? Can you label with comments?
Imports
	Scanner
	Date/Time capabilities
Class definition with:
	constructor,
	member variables,
	member functions,
	getters,
	setters
	public members
	private members
Multiple classes in single file.  (Worth separating).
Loading file with data (a file with comma seperated values, i.e. csv).
Date/Time handling.
System.out.println.
Strings
ints (int)
Casting
Try/Catch error handling.
Loops
Comment blocks
Loop continue statement
New line entries inside System.out.println
---------------------------------------------
Also, some bonus ideas you could try (not today, and maybe not until after finals):
Fix a bug.
Increase error handling (i.e. if improper data provided on one of the rows, or empty file, or date earlier than today, etc)
Apply your FX GUI skills.
Add some tests.
*/
