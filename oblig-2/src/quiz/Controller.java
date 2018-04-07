package quiz;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import quiz.Question.Question;

public class Controller {

    public GridPane gridPane;
    public Label questionLabel;
    public ImageView imageView;
    public TextField replyTextField;
    public Button replyButton;
    public Label statusLabel;

    public ToggleGroup multipleChoiceGroup;


    private QuizController controller;

    public Controller() {
        controller = new QuizController();

    }

    @FXML
    public void initialize() {

        questionLabel = new Label("Spørsmål");
        questionLabel.getStyleClass().add("titleLabel");

        imageView = new ImageView();

        replyTextField = new TextField();
        replyTextField.setPromptText("Ditt svar...");
        replyTextField.setOnAction(e -> {
            replyAction();
        });

        replyButton = new Button("Svar");
        replyButton.getStyleClass().add("replyButton");
        replyButton.setOnAction(e -> {
            replyAction();
        });

        statusLabel = new Label();

        RadioButton choice1 = new RadioButton();
        choice1.setText("Hovedstad 1");
        choice1.setToggleGroup(multipleChoiceGroup);

        RadioButton choice2 = new RadioButton();
        choice2.setText("Hovedstad 2");
        choice2.setToggleGroup(multipleChoiceGroup);

        RadioButton choice3 = new RadioButton();
        choice3.setText("Hovedstad 3");
        choice3.setToggleGroup(multipleChoiceGroup);

        RadioButton choice4 = new RadioButton();
        choice4.setText("Hovedstad 4");
        choice4.setToggleGroup(multipleChoiceGroup);

        // multipleChoiceGroup.getToggles().add()

        HBox choicesBox = new HBox(10);
        choicesBox.getChildren().addAll(choice1, choice2, choice3, choice4);
        // choicesBox.getChildren().add(multipleChoiceGroup);

        gridPane.add(questionLabel, 0, 0);
        gridPane.add(imageView, 0, 1);
        gridPane.add(replyTextField, 0, 2);
        gridPane.add(replyButton, 1, 2);
        gridPane.add(choicesBox, 0, 3);
        gridPane.add(statusLabel, 0, 4);

        loadNextQuestion();

    }

    /**
     * Display new question
     */

    private void loadNextQuestion() {
        Question question = controller.getRandomQuestion();
        displayQuestion(question);
    }

    private void displayQuestion(Question question) {

        questionLabel.setText("Hva er hovedstaden i " + question.getQuestion() + "?");
        imageView.setImage(new Image(question.getImageLocation()));

        replyTextField.clear();



        updateStatus();

    }

    /**
     * Update current score
     */

    private void updateStatus() {

        statusLabel.setText("" + controller.getCorrectReplies() + " / " + controller.getTotalNumberOfQuestions());

    }

    private void replyAction() {
        String reply = replyTextField.getText().trim();

        validateReply(reply);


        // Remove comment to disallow empty text replies
        /*
        if (reply.length() > 0) {

            System.out.println(reply);



        } else {
            System.out.println("String is empty");
        }
        */


    }

    private void validateReply(String reply) {

        System.out.println("Validating: " + reply);

        if (controller.validateReplyForCurrentQuestion(reply)) {
            System.out.println("Korrekt!");
        } else {
            System.out.println("Feil :(");

            alert("Feil! Riktig svar er:", controller.getCorrectReplyForCurrentQuestion());


        }

        loadNextQuestion();

    }

    public void alert(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();

    }

}
