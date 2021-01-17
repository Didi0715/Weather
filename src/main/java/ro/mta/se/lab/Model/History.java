package ro.mta.se.lab.Model;

import java.io.*;

/**
 * Short class used to write to a history file.
 *
 * @author Adina-Luiza Ciobanu
 */

public class History {
    public void writeToFile(String city, String country, String temp, String description) {
        DateTime dateTime = new DateTime();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/data/history.txt",true));
             bw.write(dateTime.getYearMonthDay() + " " + dateTime.getTime() + " : " + city +
                    " " + country + " " + temp + "℃ " + description + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
