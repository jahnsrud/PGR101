package quiz;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import quiz.Question.MultipleChoiceQuestion;
import quiz.Question.Question;

public class Controller {

    private QuizController controller;

    public GridPane gridPane;
    private Label questionLabel;
    private ImageView imageView;
    private TextField replyTextField;
    private Button replyButton;
    private Label statusLabel;
    private ToggleGroup multipleChoiceGroup;
    private HBox choicesBox;
    private Button quitButton;

    public Controller() {
        controller = new QuizController(10);

    }

    @FXML
    public void initialize() {

        questionLabel = new Label("Spørsmål");
        questionLabel.getStyleClass().add("titleLabel");

        imageView = new ImageView();
        imageView.setFitHeight(174);
        imageView.setFitWidth(290);

        replyTextField = new TextField();
        replyTextField.setPromptText("Ditt svar...");
        replyTextField.setOnAction(e -> {
            validateReply(replyTextField.getText());
        });

        replyButton = new Button("Svar");
        replyButton.getStyleClass().add("replyButton");
        replyButton.setOnAction(e -> {
            validateReply(replyTextField.getText());
        });

        replyButton.setMaxWidth(Double.MAX_VALUE);

        statusLabel = new Label();

        choicesBox = new HBox(15);

        quitButton = new Button("Avslutt");
        quitButton.getStyleClass().add("quitButton");
        quitButton.setOnAction(e -> {
            quitQuiz();

        });


        gridPane.add(questionLabel, 0, 0);
        gridPane.add(imageView, 0, 1);
        gridPane.add(replyTextField, 0, 2);
        gridPane.add(choicesBox, 0, 3);
        gridPane.add(replyButton, 0, 4);
        gridPane.add(statusLabel, 0, 5);
        gridPane.add(quitButton, 0,6);

        loadNextQuestion();

    }

    /**
     * Display new question
     */

    private void loadNextQuestion() {

        if (controller.canGetNewQuestion()) {

            Question question = controller.getRandomQuestion();
            displayQuestion(question);

        } else {
            endGame();
        }


    }

    private void endGame() {

        System.out.println("--- Game over ---");

        questionLabel.setText("Game over");
        imageView.setImage(null);

        gridPane.getChildren().remove(imageView);

        choicesBox.setVisible(false);
        replyButton.setVisible(false);
        replyTextField.setVisible(false);

        quitButton.setMaxWidth(Double.MAX_VALUE);


    }

    /**
     * Todo: fix! Should return to main menu, not quit the app
     */

    public void quitQuiz() {
        Platform.exit();
    }

    private void displayQuestion(Question question) {

        questionLabel.setText("Hva er hovedstaden i " + question.getQuestion() + "?");
        imageView.setImage(new Image(question.getImageLocation()));

        replyTextField.clear();
        choicesBox.getChildren().clear();

        if (question instanceof MultipleChoiceQuestion) {

            MultipleChoiceQuestion multi = (MultipleChoiceQuestion) question;

            for (String choice : multi.getChoices()) {
                RadioButton choiceButton = new RadioButton();
                choiceButton.setText(choice);
                choiceButton.setToggleGroup(multipleChoiceGroup);

                choiceButton.setOnAction(e -> {
                    validateReply(choiceButton.getText());
                });

                choicesBox.getChildren().add(choiceButton);

            }

            /**
             * Todo: The correct reply is now always last:
             */

            RadioButton choiceButton = new RadioButton();
            choiceButton.setText(multi.getCorrectReply());
            choiceButton.setToggleGroup(multipleChoiceGroup);

            choiceButton.setOnAction(e -> {
                validateReply(choiceButton.getText());
            });


            choicesBox.getChildren().add(choiceButton);

            replyTextField.setVisible(false);
            replyButton.setVisible(false);

        } else {
            replyTextField.setVisible(true);
            replyTextField.requestFocus();
            replyButton.setVisible(true);

        }


        updateStatus();

    }

    /**
     * Update current score
     */

    private void updateStatus() {

        statusLabel.setText("" + controller.getCorrectReplies() + " / " + controller.getNumberOfQuestionsAsked() + "\n"
                + "Antall spørsmål totalt: " + controller.getQuestionLimit());

    }

    private void validateReply(String reply) {

        if (controller.validateReplyForCurrentQuestion(reply)) {

        } else {

            alert("Feil!", "Riktig svar er: " + controller.getCorrectReplyForCurrentQuestion() + "\n" + "Du svarte: " + reply);


        }

        loadNextQuestion();

    }

    /*
    public void displayWelcomeScreen() {

        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Start.fxml"));

        try {

            Parent root = loader.load();
            stage.setTitle("Quiz");
            stage.setScene(new Scene(root, 450, 450));
            stage.setMinWidth(400);
            stage.setMinHeight(400);
            stage.show();

        } catch (Exception e) {
            System.out.println("Couldn't load stage");
        }

    }
    */

    public void alert(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();

    }

}
