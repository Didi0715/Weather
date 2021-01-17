# WeatherApp

**Didi Weather Prediction** is a weather prediction application that 
stands out through its warm and cute interface. 🧁

## Diagrams 📉

Are located in `diagrams` folder and contain the class diagram, and the use case diagram.

## Folders 📁

I have used the MVC architecture when implementing the application.
- `Model` and `Controller` are located in `java` and `View` is located in `resources`
- In `resources` I also have a folder `data` that contains the input file `input.txt` 
the histroy file `history.txt`

## How it works 🧝

The user selects a country from the ChoiceBox, which is populated with content from `input.txt`.
Only then can he select a city from the other ChoiceBox. When pressing Search, a request is made
to the [OpenWeatherMap API](https://openweathermap.org/). The user interface is updated with 
information about the selected city as: temperature, humidity, wind speed etc.

