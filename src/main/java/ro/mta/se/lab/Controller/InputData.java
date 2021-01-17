package ro.mta.se.lab.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputData {
    public ObservableList<String> getCountryList(){
        ObservableList<String> countryList = FXCollections.observableArrayList();
        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            File myObj = new File("src/main/resources/data/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String country = data.split("\t")[4];
                if(countryList.contains(country)){
                    continue;
                }
                countryList.add(country);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return countryList.sorted();
    }

    public ObservableList<String> getCityList(String _country){
        ObservableList<String> cityList = FXCollections.observableArrayList();
        try {
            File myObj = new File("src/main/resources/data/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String country = data.split("\t")[4];
                if(country.equals(_country)){
                    String city = data.split("\t")[1];
                    cityList.add(city);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cityList.sorted();
    }
}
