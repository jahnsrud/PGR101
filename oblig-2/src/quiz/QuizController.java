package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizController {

    private List<Question> quizArray;

    public QuizController() {

        quizArray = new ArrayList();

        Collections.addAll(quizArray,
                new Question("Hvilket land", "Ukjent", "resources/flag-test.png"),
                new Question("Lol", "Test", "resources/flag-test.png"),
                new Question("Lol", "Test", "resources/flag-test.png"),
                new Question("Lol", "Test", "resources/flag-test.png"),
                new Question("Lol", "Test", "resources/flag-test.png"),
                new Question("Lol", "Test", "resources/flag-test.png"),
                new Question("Lol", "Test", "resources/flag-test.png"),
                new Question("Lol", "Test", "resources/flag-test.png")
        );


    }

    public Question getNextQuestion() {

        /**
         * Warning: midlertidig!
         */
        return quizArray.get(0);

    }




}
