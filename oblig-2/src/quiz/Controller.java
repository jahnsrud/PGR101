package quiz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;

public class Controller {

    public GridPane gridPane;
    public Label questionLabel;
    public ImageView imageView;
    public TextField replyTextField;
    public Button replyButton;
    public Label statusLabel;

    private QuizController controller;

    public Controller() {
        controller = new QuizController();

    }

    @FXML
    public void initialize() {

        questionLabel = new Label("Spørsmål");
        questionLabel.getStyleClass().add("titleLabel");

        imageView = new ImageView("resources/flag-test.png");

        replyTextField = new TextField();
        replyTextField.setPromptText("Ditt svar...");
        replyTextField.setOnAction(e -> {
            replyAction();
        });

        replyButton = new Button("Svar");
        replyButton.setOnAction(e -> {
            replyAction();
        });

        statusLabel = new Label("0/0");

        gridPane.add(questionLabel, 0, 0);
        gridPane.add(imageView, 0, 1);
        gridPane.add(replyTextField, 0, 2);
        gridPane.add(replyButton, 1, 2);
        gridPane.add(statusLabel, 0, 3);

        displayQuestion(controller.getNextQuestion());

    }

    /**
     * Display new question
     * @param question
     */

    private void displayNextQuestion() {



    }

    private void displayQuestion(Question question) {
        questionLabel.setText(question.getQuestion());
        imageView.setImage(new Image("resources/flag-test.png"));
    }

    /**
     * Update current score
     */

    private void updateStatus() {

    }

    private void replyAction() {
        String reply = replyTextField.getText();

        if (reply.length() > 0) {

            System.out.println(reply);

            /**
             * Todo: fix!
             */
            replyTextField.clear();
            validateReply(reply);

        } else {
            System.out.println("String is empty");
        }


    }

    private void validateReply(String reply) {

        System.out.println("Validating: " + reply);
    }

}
