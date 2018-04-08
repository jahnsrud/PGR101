package quiz;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import quiz.Question.MultipleChoiceQuestion;
import quiz.Question.Question;


public class Controller {

    private QuizController controller;

    public BorderPane borderPane;
    private Label topLabel;
    private Label questionLabel;
    private ImageView imageView;
    private TextField replyTextField;
    private Button replyButton;
    private Label statusLabel;
    private ToggleGroup multipleChoiceGroup;
    private HBox choicesBox;
    private Button quitButton;

    private Scene startScene;

    public Controller (int questionLimit, Scene startScene) {
        controller = new QuizController(questionLimit);
        this.startScene = startScene;
    }

    @FXML
    public void initialize() {

        topLabel = new Label("HVA ER HOVEDSTADEN I");
        topLabel.getStyleClass().add("topLabel");
        topLabel.setTextAlignment(TextAlignment.CENTER);

        questionLabel = new Label("Land");
        questionLabel.getStyleClass().add("titleLabel");
        questionLabel.setTextAlignment(TextAlignment.CENTER);

        imageView = new ImageView();
        imageView.setFitHeight(174);
        imageView.setFitWidth(290);
        imageView.getStyleClass().add("quizImageView");

        replyTextField = new TextField();
        replyTextField.setPromptText("Ditt svar...");
        replyTextField.setOnAction(e -> {
            validateReply(replyTextField.getText());
        });
        replyTextField.setMinHeight(34);

        replyButton = new Button("Svar");
        replyButton.getStyleClass().addAll("replyButton", "button");
        replyButton.setOnAction(e -> {
            validateReply(replyTextField.getText());
        });

        replyButton.setMaxWidth(Double.MAX_VALUE);

        statusLabel = new Label();
        statusLabel.getStyleClass().add("statusLabel");
        statusLabel.setTextAlignment(TextAlignment.CENTER);
        statusLabel.setMaxWidth(Double.MAX_VALUE);

        quitButton = new Button("Avslutt");
        quitButton.getStyleClass().addAll("quitButton", "button");
        quitButton.setOnAction(e -> {
            quitQuiz();

        });

        /**
         * Prepare the layout by adding nodes to panes
         */

        choicesBox = new HBox(15);

        // Top
        BorderPane topPane = new BorderPane();
        topPane.setMargin(statusLabel, new Insets(20, 20, 20, 20));
        topPane.setMargin(quitButton, new Insets(20, 20, 20, 20));

        topPane.setLeft(statusLabel);
        topPane.setRight(quitButton);

        // Quiz area

        VBox quizArea = new VBox(6);
        quizArea.setAlignment(Pos.CENTER);
        quizArea.setMargin(imageView, new Insets(40, 0, 0, 0));
        quizArea.getChildren().addAll(topLabel, questionLabel, imageView);

        // Bottom

        GridPane bottomPane = new GridPane();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setHgap(10);
        bottomPane.getStyleClass().add("bottomPane");
        bottomPane.setMinHeight(90);

        bottomPane.add(choicesBox, 0, 0);
        bottomPane.add(replyTextField, 0, 0);
        bottomPane.add(replyButton, 1, 0);



        borderPane.setCenter(quizArea);
        borderPane.setBottom(bottomPane);
        borderPane.setTop(topPane);

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

        topLabel.setText("Game over");
        questionLabel.setText("Takk for at du spilte!");
        imageView.setImage(null);

        choicesBox.setVisible(false);
        replyButton.setVisible(false);
        replyTextField.setVisible(false);

        quitButton.setMaxWidth(Double.MAX_VALUE);

        updateStatus();


    }

    /**
     * Return to start 
     */

    public void quitQuiz() {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.setScene(startScene);


    }

    private void displayQuestion(Question question) {

        questionLabel.setText(question.getQuestion() + "?");
        imageView.setImage(new Image(question.getImageLocation()));

        replyTextField.clear();
        choicesBox.getChildren().clear();

        if (question instanceof MultipleChoiceQuestion) {

            MultipleChoiceQuestion multi = (MultipleChoiceQuestion) question;

            for (String choice : multi.getChoices()) {
                addRadioButtonWithChoice(choice);
            }

            /**
             * Todo: The correct reply is currently always last:
             */

            addRadioButtonWithChoice(multi.getCorrectReply());

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
     * Helper method for adding choices
     * @param choice
     */

    private void addRadioButtonWithChoice(String choice) {
        RadioButton choiceButton = new RadioButton();
        choiceButton.setText(choice);
        choiceButton.setToggleGroup(multipleChoiceGroup);
        choiceButton.getStyleClass().add("choiceButton");

        choiceButton.setOnAction(e -> {
            validateReply(choiceButton.getText());
        });

        choicesBox.getChildren().add(choiceButton);
    }

    /**
     * Update current score
     */

    private void updateStatus() {

        String status = controller.getCorrectReplies() + "/" + controller.getNumberOfQuestionsAsked();

        if (controller.canGetNewQuestion()) {

            status = status + " " + "(" + controller.getQuestionLimit() + ")";

        }

        statusLabel.setText(status);

    }

    private void validateReply(String reply) {

        if (controller.validateReplyForCurrentQuestion(reply)) {

            // AudioClip sound = new AudioClip(Paths.get("src/sound/right_answer.mp3").toUri().toString());
            // sound.play();


        } else {

            String message = "Riktig svar er: " + controller.getCorrectReplyForCurrentQuestion();
            if (reply.length() > 0) {
                message = message + "\n" + "Du svarte: " + reply;
            }

            alert("Feil!", message);


            // AudioClip sound = new AudioClip(Paths.get("src/sound/wrong_answer.mp3").toUri().toString());
            // sound.play();


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
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();

    }

}
