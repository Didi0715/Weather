package ro.mta.se.lab.Model;

import ro.mta.se.lab.Controller.InputData;

import java.io.*;

public class History {
    public void writeToFile(String city, String country, String temp, String description) {
        DateTime dateTime = new DateTime();
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/data/history.txt",true));
//            bw.write("Didi are mere");
             bw.write(dateTime.getYearMonthDay() + " " + dateTime.getTime() + " : " + city +
                    " " + country + " " + temp + "℃ " + description + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
