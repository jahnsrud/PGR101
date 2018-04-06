package quiz.Question;

import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoiceQuestion extends Question {

    private ArrayList<String> choices;

    public MultipleChoiceQuestion() {
        super("Kommer her", "Test", "resources/nei");

        choices = new ArrayList<>();

        choices.add("1");
        choices.add("2");

    }

    public void addChoice(String answer) {
        choices.add(answer);
    }
}
