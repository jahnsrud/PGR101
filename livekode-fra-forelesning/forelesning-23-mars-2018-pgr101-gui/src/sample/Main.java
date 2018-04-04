package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    // throws Exception: ansvaret ligger der metoden faktisk brukes, ikke selve metoden
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 550));

        Stage loginStage = new Stage();
        LoginController.showLogin(loginStage, primaryStage);


        // primaryStage.show();
        loginStage.show();


        // Lambda
        /*
        ArrayList<String> list = new ArrayList<>();
        list.forEach(s -> {
            System.out.println(s);
        });

        list.stream().filter(s -> {
            s.contains("A");
        });
        */

    }


    public static void main(String[] args) {
        launch(args);
    }
}
