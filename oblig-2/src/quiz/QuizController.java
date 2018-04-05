package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizController {

    private List<Question> quizArray;

    private int currentQuestionIndex;

    public QuizController() {

        quizArray = new ArrayList();
        currentQuestionIndex = 0;

        Collections.addAll(quizArray,
                new Question("Norge", "Oslo", "resources/flag-norway.png"),
                new Question("Sverige", "Stockholm", "resources/flag-sweden.png"),
                new Question("Danmark", "København", "resources/flag-denmark.png")

        );


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

    public boolean isReplyCorrectForCurrentQuestion(String reply) {

        /**
         * Warning: midlertidig
         */
        Question question = quizArray.get(currentQuestionIndex);

        if (reply.equalsIgnoreCase(question.getCorrectCapital())) {
            return true;
        } else {
            return false;
        }

    }



}
