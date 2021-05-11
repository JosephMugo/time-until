import java.util.Scanner;

// public class Row that is available to other classes in the same folder
public class Row { // class declaration
    // constructor
    public Row(String row) {
        //System.out.println("Row received: " + row); // output method for console
        try (Scanner rowReader = new Scanner(row)) { // Scanner - input method for console
            rowReader.useDelimiter(",");
            int index = 0;
            // While loop
            while (rowReader.hasNext()) {
                String val = rowReader.next();
                //System.out.println("Current value is: " + val);
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
    }

    ;

    // getter method
    public int getYear() {
        return year;
    }

    // setter method
    private void setYear(int yr) {
        year = yr;
    }

    // getter method
    public int getMonth() {
        return month;
    }

    // setter method
    private void setMonth(int m) {
        month = m;
    }

    // getter method
    public int getDay() {
        return day;
    }

    // setter method
    private void setDay(int d) {
        day = d;
    }

    // getter method
    public int getHour() {
        return hour;
    }

    // setter method
    private void setHour(int hr) {
        hour = hr;
    }

    // getter method
    public int getMinute() {
        return minute;
    }

    // setter method
    private void setMinute(int min) {
        minute = min;
    }

    // getter method
    public int getSecond() {
        return seconds;
    }

    // setter method
    private void setSecond(int secos) {
        seconds = secos;
    }

    // getter method
    public String getDescription() {
        return eventDescription;
    }

    // setter method
    private void setDescription(String desc) {
        eventDescription = desc;
    }

    // int declaration
    // member variables for the class Row
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int seconds;
    String eventDescription;
}
