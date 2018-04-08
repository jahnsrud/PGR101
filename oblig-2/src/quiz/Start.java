package quiz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Start {

    public GridPane gridPane;

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

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(radioButton1, radioButton2, radioButton3);

        playButton = new Button("Start spill");
        playButton.setOnAction(e -> {
            startGame();
        });

        welcomeLabel = new Label("Europeiske hovedsteder");
        welcomeLabel.getStyleClass().add("titleLabel");

        subtitleLabel = new Label("Velg antall spørsmål");

        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(subtitleLabel, 0, 1);
        gridPane.add(hBox, 0, 2);
        gridPane.add(playButton, 0, 3);




    }

    private void startGame() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Quiz.fxml"));

            Controller quizController = new Controller(getQuestionLimit());
            loader.setController(quizController);

            Parent root = loader.load();

            Stage stage = (Stage) playButton.getScene().getWindow();
            Scene scene = new Scene(root, 550, 650);

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
