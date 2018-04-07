package quiz;

import quiz.Question.Question;
import quiz.Question.TextQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizController {

    private List<Question> quizArray;

    private int currentQuestionIndex;

    private int correctReplies;
    private int totalNumberOfQuestions;

    public QuizController() {

        quizArray = new ArrayList();
        currentQuestionIndex = 0;

       addQuestions();

    }
    
    private void addQuestions() {

        Collections.addAll(quizArray,
                new TextQuestion("Norge", "Oslo", "resources/flag-no.png"),
                new TextQuestion("Sverige", "Stockholm", "resources/flag-se.png"),
                new TextQuestion("Danmark", "København", "resources/flag-dk.png"),
                new TextQuestion("Tyskland", "Berlin", "resources/flag-de.png"),
                new TextQuestion("Polen", "Warszawa", "resources/flag-pl.png")
        );


    }

    public int getNumberOfQuestionsRemaining() {
        return quizArray.size();
    }

    public Question getRandomQuestion() {

        Random random = new Random();
        currentQuestionIndex = random.nextInt(getNumberOfQuestionsRemaining());

        return quizArray.get(currentQuestionIndex);


    }

    public Question getNextQuestion() {

        /**
         * Warning: midlertidig. Veldig midlertidig.
         */

        if (currentQuestionIndex >= quizArray.size()) {
            return quizArray.get(0);

        } else {

            Question newQuestion = quizArray.get(currentQuestionIndex);
            currentQuestionIndex++;
            return newQuestion;

        }

    }

    public boolean validateReplyForCurrentQuestion(String reply) {

        /**
         * Warning: midlertidig
         */
        Question question = quizArray.get(currentQuestionIndex);

        totalNumberOfQuestions++;

        if (reply.equalsIgnoreCase(question.getCorrectReply())) {
            correctReplies++;
            return true;
        } else {
            return false;
        }

    }

    public String getCorrectReplyForCurrentQuestion() {

        Question question = quizArray.get(currentQuestionIndex);
        return question.getCorrectReply();

    }

    public int getCorrectReplies() {
        return correctReplies;
    }

    public int getTotalNumberOfQuestions() {
        return totalNumberOfQuestions;
    }

}
