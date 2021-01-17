package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;


public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(this.getClass().getResource("/View/WeatherAppView.fxml"));
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            primaryStage.getIcons().add(new Image("https://www.n4l.co.nz/wp-content/uploads/2019/03/Cloud-Blog.jpg"));
            primaryStage.setTitle("Didi Weather Prediction");
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}