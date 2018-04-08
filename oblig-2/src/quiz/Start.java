package quiz;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Start {

    /*
    Add control for setting question limit
     */

    public Label welcomeLabel;
    public Button playButton;
    public ToggleGroup quizGroup;
    public GridPane gridPane;

    @FXML
    public void initialize() {

        System.out.println("Velkommen!");

        quizGroup = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("10");
        radioButton1.setToggleGroup(quizGroup);
        radioButton1.setSelected(true);

        RadioButton radioButton2 = new RadioButton("20");
        radioButton2.setToggleGroup(quizGroup);
        radioButton2.setSelected(false);

        RadioButton radioButton3 = new RadioButton("30");
        radioButton3.setToggleGroup(quizGroup);
        radioButton3.setSelected(false);

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(radioButton1, radioButton2, radioButton3);

        playButton = new Button("Start spill");
        playButton.setOnAction(e -> {
            System.out.println("kommer her");
        });

        welcomeLabel = new Label("Velg antall spørsmål");

        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(hBox, 0, 1);
        gridPane.add(playButton, 0, 2);



    }


}
