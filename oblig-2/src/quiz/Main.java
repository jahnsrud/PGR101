package quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        primaryStage.setTitle("Quiz");
        primaryStage.setScene(new Scene(root, 550, 570));
        primaryStage.setMinWidth(450);
        primaryStage.setMinHeight(550);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
