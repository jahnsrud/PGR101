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

    private int correctReplies;
    private int totalNumberOfQuestions;

    public QuizController() {

        quizArray = new ArrayList();
        currentQuestionIndex = 0;

       addQuestions();

    }
    
    private void addQuestions() {

        MultipleChoiceQuestion germany = new MultipleChoiceQuestion("Tyskland", "Berlin", "resources/flag-de.png");
        germany.addChoice("Frankfurt");
        germany.addChoice("Hamburg");
        germany.addChoice("Köln");

        MultipleChoiceQuestion finland = new MultipleChoiceQuestion("Finland", "Helsingfors", "resources/flag-fi.png");
        finland.addChoice("Esbo");
        finland.addChoice("Lahti");
        finland.addChoice("Tampere");

        MultipleChoiceQuestion netherlands = new MultipleChoiceQuestion("Nederland", "Amsterdam", "resources/flag-de.png");
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

        if (reply.trim().equalsIgnoreCase(question.getCorrectReply())) {
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
