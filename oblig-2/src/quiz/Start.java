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

        welcomeLabel = new Label("Europeiske hovedsteder");
        welcomeLabel.getStyleClass().add("titleLabel");

        subtitleLabel = new Label("Velg antall spørsmål");

        playButton = new Button("START");
        playButton.getStyleClass().addAll("playButton", "button");
        playButton.setOnAction(e -> {
            startGame();
        });
        playButton.setPadding(new Insets(10, 90, 10, 90));

        // Horizontal layout for our radio buttons

        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);

        addRadioButton("10", 10, hBox, true);
        addRadioButton("25", 25, hBox, false);
        addRadioButton("45", 45, hBox, false);


        //
        // Collect them all in layouts
        //

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

    }

    private void startGame() {

        Scene startScene = playButton.getScene();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Quiz.fxml"));

            // Use Controller with the constructor to pass parameters
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

    /**
     * Helper method for adding radio buttons
     */

    private void addRadioButton(String title, int limit, HBox hBox, boolean selected) {

        RadioButton radioButton = new RadioButton(title);
        radioButton.setToggleGroup(quizGroup);
        radioButton.setSelected(selected);
        radioButton.setOnAction(e -> {
            setQuestionLimit(limit);
        });

        hBox.getChildren().add(radioButton);
    }


    private int getQuestionLimit() {
        return questionLimit;
    }

    private void setQuestionLimit(int questionLimit) {
        this.questionLimit = questionLimit;
    }


}
