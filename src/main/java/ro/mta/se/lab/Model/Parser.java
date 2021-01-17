package ro.mta.se.lab.Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Parser {
    public String getParsed(String jsonString, String element){
        JsonElement jsonElement = new JsonParser().parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if(element.equals("temp") || element.equals("humidity")){
            JsonObject jObj = jsonObject.getAsJsonObject("main");
            return jObj.get(element).toString();
        }
        if(element.equals("description") || element.equals("icon")){
            JsonObject jObj = (JsonObject) jsonObject.getAsJsonArray("weather").get(0);
            return jObj.get(element).toString();
        }
        if(element.equals("speed")){
            JsonObject jObj = jsonObject.getAsJsonObject("wind");
            return jObj.get(element).toString();
        }
        return null;
    }
}
