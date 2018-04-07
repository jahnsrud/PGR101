package quiz;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import quiz.Question.MultipleChoiceQuestion;
import quiz.Question.Question;

public class Controller {

    private QuizController controller;
    
    public GridPane gridPane;
    public Label questionLabel;
    public ImageView imageView;
    public TextField replyTextField;
    public Button replyButton;
    public Label statusLabel;
    public ToggleGroup multipleChoiceGroup;
    public HBox choicesBox;

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

        choicesBox = new HBox(15);

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
        choicesBox.getChildren().clear();
        // multipleChoiceGroup.getToggles().clear();

        if (question instanceof MultipleChoiceQuestion) {

            MultipleChoiceQuestion multi = (MultipleChoiceQuestion)question;

            for (String choice : multi.getChoices()) {
                RadioButton choiceButton = new RadioButton();
                choiceButton.setText(choice);
                choiceButton.setToggleGroup(multipleChoiceGroup);
                choicesBox.getChildren().add(choiceButton);

            }

            /**
             * Todo: The correct reply is now always last:
             */

            RadioButton choiceButton = new RadioButton();
            choiceButton.setText(multi.getCorrectReply());
            choiceButton.setToggleGroup(multipleChoiceGroup);
            choicesBox.getChildren().add(choiceButton);

            replyTextField.setVisible(false);

        } else {
            replyTextField.setVisible(true);
            replyTextField.requestFocus();

        }


        updateStatus();

    }

    /**
     * Update current score
     */

    private void updateStatus() {

        statusLabel.setText("" + controller.getCorrectReplies() + " / " + controller.getTotalNumberOfQuestions());

    }

    private void replyAction() {

        String reply = replyTextField.getText();
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
