package quiz;

import quiz.Question.Question;

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

        Collections.addAll(quizArray,
                new Question("Norge", "Oslo", "resources/flag-norway.png"),
                new Question("Sverige", "Stockholm", "resources/flag-sweden.png"),
                new Question("Danmark", "København", "resources/flag-denmark.png")

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

        if (reply.equalsIgnoreCase(question.getCorrectCapital())) {
            correctReplies++;
            return true;
        } else {
            return false;
        }

    }

    public int getCorrectReplies() {
        return correctReplies;
    }

    public int getTotalNumberOfQuestions() {
        return totalNumberOfQuestions;
    }

}
