package ro.mta.se.lab.Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Short class used for returning pretty format
 * of multiple type of datetime formats.
 *
 * @author Adina-Luiza Ciobanu
 */

public class DateTime {
    public String getHour() {
        LocalTime localTime = LocalTime.now();
        return String.valueOf(localTime.getHour());
    }

    public String getDay(){
        LocalDate localDate = LocalDate.now();
        return localDate.getDayOfWeek().toString();
    }

    public String getYearMonthDay(){
        LocalDate localDate = LocalDate.now();
        return String.valueOf(localDate.getYear()) + "-" +
                String.valueOf(localDate.getMonth()) + "-" +
                String.valueOf(localDate.getDayOfMonth());
    }

    public String getTime(){
        LocalTime localTime = LocalTime.now();
        return String.valueOf(localTime.getHour()) + ":" + String.valueOf(localTime.getMinute());
    }
}
