package quiz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Start {

    public BorderPane borderPane;

    private Label welcomeLabel;
    private Label subtitleLabel;
    private Button playButton;
    private ToggleGroup quizGroup;

    private int questionLimit;

    @FXML
    public void initialize() {

        questionLimit = 10;

        quizGroup = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("10");
        radioButton1.setToggleGroup(quizGroup);
        radioButton1.setSelected(true);
        radioButton1.setOnAction(e -> {
            setQuestionLimit(10);
        });

        RadioButton radioButton2 = new RadioButton("25");
        radioButton2.setToggleGroup(quizGroup);
        radioButton2.setSelected(false);
        radioButton2.setOnAction(e -> {
            setQuestionLimit(25);
        });

        RadioButton radioButton3 = new RadioButton("45");
        radioButton3.setToggleGroup(quizGroup);
        radioButton3.setSelected(false);
        radioButton3.setOnAction(e -> {
            setQuestionLimit(45);
        });

        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(radioButton1, radioButton2, radioButton3);

        playButton = new Button("START");
        playButton.getStyleClass().addAll("playButton", "button");
        playButton.setOnAction(e -> {
            startGame();
        });
        playButton.setPadding(new Insets(10, 90, 10, 90));

        welcomeLabel = new Label("Europeiske hovedsteder");
        welcomeLabel.getStyleClass().add("titleLabel");

        subtitleLabel = new Label("Velg antall spørsmål");

        /**
         * Collect them all in layouts
         */

        // Center

        VBox vBox = new VBox(16);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(welcomeLabel, subtitleLabel, hBox);
        vBox.setMargin(welcomeLabel, new Insets(0, 0, 20, 0));
        vBox.getStyleClass().add("startBackground");

        // Bottom

        GridPane bottomPane = new GridPane();
        bottomPane.setVgap(10);
        bottomPane.setHgap(10);
        bottomPane.setMinHeight(90);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.getStyleClass().add("bottomPane");

        bottomPane.add(playButton, 0, 0);


        borderPane.setCenter(vBox);
        borderPane.setBottom(bottomPane);

        /*
        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(subtitleLabel, 0, 1);
        gridPane.add(hBox, 0, 2);
        gridPane.add(playButton, 0, 3);
*/



    }

    private void startGame() {

        Scene startScene = playButton.getScene();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Quiz.fxml"));

            Controller quizController = new Controller(getQuestionLimit(), startScene);
            loader.setController(quizController);

            Parent root = loader.load();

            Stage stage = (Stage) playButton.getScene().getWindow();
            Scene scene = new Scene(root, 550, 630);

            stage.setScene(scene);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    public int getQuestionLimit() {
        return questionLimit;
    }

    private void setQuestionLimit(int questionLimit) {
        this.questionLimit = questionLimit;
    }


}
