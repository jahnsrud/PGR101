package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizController {

    private List<Question> quizArray;

    public QuizController() {

        quizArray = new ArrayList();

        Collections.addAll(quizArray,
                new Question("Hvilket Land", "Ukjent", "country.png"),
                new Question("Lol", "Mordi", "Fardi"),
                new Question("Lol", "Mordi", "Fardi"),
                new Question("Lol", "Mordi", "Fardi"),
                new Question("Lol", "Mordi", "Fardi"),
                new Question("Lol", "Mordi", "Fardi"),
                new Question("Lol", "Mordi", "Fardi"),
                new Question("Lol", "Mordi", "Fardi")
        );


    }




}