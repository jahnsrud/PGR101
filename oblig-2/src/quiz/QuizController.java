package quiz;

import quiz.Question.MultipleChoiceQuestion;
import quiz.Question.Question;
import quiz.Question.TextQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizController {

    private List<Question> quizArray;

    private int currentQuestionIndex;
    private int questionLimit;

    private int correctReplies;
    private int totalNumberOfQuestions;

    public QuizController(int questionLimit) {

        quizArray = new ArrayList();
        currentQuestionIndex = 0;
        setQuestionLimit(questionLimit);

        addQuestions();

    }

    /**
     * Midlertidig: burde kanskje leses fra fil?
     */

    private void addQuestions() {

        MultipleChoiceQuestion germany = new MultipleChoiceQuestion("Tyskland", "Berlin", "resources/flag-de.png");
        germany.addChoice("Frankfurt");
        germany.addChoice("Hamburg");
        germany.addChoice("Köln");

        MultipleChoiceQuestion finland = new MultipleChoiceQuestion("Finland", "Helsingfors", "resources/flag-fi.png");
        finland.addChoice("Esbo");
        finland.addChoice("Lahti");
        finland.addChoice("Tampere");

        MultipleChoiceQuestion netherlands = new MultipleChoiceQuestion("Nederland", "Amsterdam", "resources/flag-nl.png");
        netherlands.addChoice("Antwerpen");
        netherlands.addChoice("Brussel");
        netherlands.addChoice("Haag");


        Collections.addAll(quizArray,
                new TextQuestion("Norge", "Oslo", "resources/flag-no.png"),
                new TextQuestion("Sverige", "Stockholm", "resources/flag-se.png"),
                new TextQuestion("Danmark", "København", "resources/flag-dk.png"),
                new TextQuestion("Polen", "Warszawa", "resources/flag-pl.png"),
                germany,
                finland,
                netherlands
        );


    }

    public Question getRandomQuestion() {

        Random random = new Random();
        currentQuestionIndex = random.nextInt(quizArray.size());

        return quizArray.get(currentQuestionIndex);


    }

    private Question getCurrentQuestion() {
        return quizArray.get(currentQuestionIndex);
    }

    public boolean validateReplyForCurrentQuestion(String reply) {

        /**
         * Warning: midlertidig
         */

        Question question = getCurrentQuestion();

        incrementTotalNumberOfQuestions();

        if (reply.trim().equalsIgnoreCase(question.getCorrectReply())) {
            incrementScore();
            return true;
        } else {
            return false;
        }

    }

    public String getCorrectReplyForCurrentQuestion() {

        Question question = getCurrentQuestion();
        return question.getCorrectReply();

    }

    public void setQuestionLimit(int questionLimit) {
        this.questionLimit = questionLimit;
    }

    public int getQuestionLimit() {
        return questionLimit;
    }

    public void incrementTotalNumberOfQuestions() {
        totalNumberOfQuestions++;
    }

    public void incrementScore() {
        correctReplies++;
    }

    public int getCorrectReplies() {
        return correctReplies;
    }

    public int getTotalNumberOfQuestions() {
        return totalNumberOfQuestions;
    }

}
