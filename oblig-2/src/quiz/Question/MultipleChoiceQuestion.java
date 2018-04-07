package quiz.Question;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {

    private List<String> choices;

    public MultipleChoiceQuestion(String question, String correctReply, String imageLocation) {
        super(question, correctReply, imageLocation);

        choices = new ArrayList<>();

    }

    public void addChoice(String answer) {
        choices.add(answer);
    }

    public List<String> getChoices() {
        return choices;
    }

}
