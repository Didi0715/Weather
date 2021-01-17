package ro.mta.se.lab.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.Math.round;

/**
 * It creates the wanted link for the selected country and city to
 * make possible the request to the API.
 *
 * <p>Creates a link, gets the JSON from the OpenWeatherMap API
 * and makes easy getting an element such as temp, wind speed etc.</p>
 *
 * @author Adina-Luiza Ciobanu
 *
 * @see Parser
 */

public class APIData {
    private String JSONContent;
    private Parser parser;

    public APIData(String city, String country) throws IOException {
        parser = new Parser();

        StringBuilder link = new StringBuilder();
        link.append("http://api.openweathermap.org/data/2.5/weather?q=");
        link.append(city + "," + country);
        link.append("&APPID=6cfb067dbcb0061356f40d88194212e3");

        URL url = new URL(link.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        this.JSONContent = content.toString();
    }

    public String getThis(String param) {
        String toReturn;
        toReturn = parser.getParsed(JSONContent, param);
        if(param.equals("temp")){
            toReturn = String.valueOf(round(Double.parseDouble(toReturn) - 272.15));
        }
        if(param.equals("icon")){
            toReturn = toReturn.substring(1, toReturn.length() - 1);
            toReturn = "http://openweathermap.org/img/w/" + toReturn + ".png";
        }
        if(param.equals("description")){
            toReturn = toReturn.substring(1, toReturn.length() - 1);
        }
        return toReturn;
    }
}
