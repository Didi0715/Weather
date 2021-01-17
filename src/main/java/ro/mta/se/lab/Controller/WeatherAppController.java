package ro.mta.se.lab.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ro.mta.se.lab.Model.APIData;
import ro.mta.se.lab.Model.DateTime;
import ro.mta.se.lab.Model.History;

import java.io.IOException;

public class WeatherAppController {
    @FXML
    private Label label1;
    @FXML
    private Label temp;
    @FXML
    private Label description;
    @FXML
    private ImageView icon;
    @FXML
    private Label wind;
    @FXML
    private Label humidity;
    @FXML
    private Label day;
    @FXML
    private Label hour;
    @FXML
    private ChoiceBox country;
    @FXML
    private ChoiceBox city;
    @FXML
    private Label select;
    @FXML
    private Label humidity_head;
    @FXML
    private Label wind_head;


    public void initialize(){
        InputData inputData = new InputData("src/main/resources/data/input.txt");
        ObservableList<String> list = inputData.getCountryList();
        country.setItems(list);

        country.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                city.setItems(inputData.getCityList(country.getItems().get((Integer) number2).toString()));
            }
        });
    }

    public void updateScreen() throws IOException {
        String _city = city.getSelectionModel().getSelectedItem().toString();
        String _country = country.getSelectionModel().getSelectedItem().toString();
        APIData apiData = new APIData(_city, _country);
        DateTime dateTime = new DateTime();
        History history = new History();
        history.writeToFile(_city, _country,apiData.getThis("temp"),
                apiData.getThis("description") );

        wind_head.setVisible(true);
        humidity_head.setVisible(true);
        temp.setText(apiData.getThis("temp") + "℃");
        description.setText(apiData.getThis("description"));
        humidity.setText(apiData.getThis("humidity") + "%");
        wind.setText(apiData.getThis("speed") + " m/s");
        day.setText(dateTime.getDay());
        hour.setText(dateTime.getHour());
        select.setVisible(false);

        Image image = new Image(apiData.getThis("icon"));
        icon.setImage(image);
    }
}
