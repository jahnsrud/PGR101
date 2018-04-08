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
    private int questionLimit;

    private int currentQuestionIndex;

    private int correctReplies;
    private int numberOfQuestionsAsked;

    public QuizController(int questionLimit) {

        quizArray = new ArrayList();

        currentQuestionIndex = 0;
        setQuestionLimit(questionLimit);

        addQuestions();

    }

    /**
     * Burde leses fra fil?
     * Tenker også at alle spørsmålene legges inn med 3 alternativer, men at det er random om det blir multiple choice eller tekst
     */

    private void addQuestions() {

        MultipleChoiceQuestion germany = new MultipleChoiceQuestion("Tyskland", "Berlin", "flags/de.png");
        germany.addChoice("Frankfurt");
        germany.addChoice("Hamburg");
        germany.addChoice("Köln");

        MultipleChoiceQuestion finland = new MultipleChoiceQuestion("Finland", "Helsingfors", "flags/fi.png");
        finland.addChoice("Esbo");
        finland.addChoice("Lahti");
        finland.addChoice("Tampere");

        MultipleChoiceQuestion netherlands = new MultipleChoiceQuestion("Nederland", "Amsterdam", "flags/nl.png");
        netherlands.addChoice("Antwerpen");
        netherlands.addChoice("Brussel");
        netherlands.addChoice("Haag");

        MultipleChoiceQuestion iceland = new MultipleChoiceQuestion("Island", "Reykjavik", "flags/is.png");
        iceland.addChoice("Árborg");
        iceland.addChoice("Kópavogur");
        iceland.addChoice("Reykjanesbær");

        MultipleChoiceQuestion poland = new MultipleChoiceQuestion("Polen", "Warszawa", "flags/pl.png");
        poland.addChoice("Krakow");
        poland.addChoice("Gdańsk");
        poland.addChoice("Pionki");

        Collections.addAll(quizArray,
                new TextQuestion("Norge", "Oslo", "flags/no.png"),
                new TextQuestion("Sverige", "Stockholm", "flags/se.png"),
                new TextQuestion("Danmark", "København", "flags/dk.png"),
                germany,
                poland,
                finland,
                netherlands,
                iceland,
                new TextQuestion("Andorra", "Andorra la Vella", "flags/ad.png"),
                new TextQuestion("Hellas", "Aten", "flags/gr.png"),
                new TextQuestion("Serbia", "Beograd", "flags/rs.png"),
                new TextQuestion("Sveits", "Bern", "flags/ch.png"),
                new TextQuestion("Slovakia", "Bratislava", "flags/sk.png"),
                new TextQuestion("Belgia", "Brussel", "flags/be.png"),
                new TextQuestion("Romania", "Bucuresti", "flags/ro.png"),
                new TextQuestion("Ungarn", "Budapest", "flags/hu.png"),
                new TextQuestion("Moldova", "Chisinau", "flags/md.png"), // Chișinău
                new TextQuestion("Irland", "Dublin", "flags/ie.png"),
                new TextQuestion("Ukraina", "Kiev", "flags/ua.png"),
                new TextQuestion("Portugal", "Lisboa", "flags/pt.png"),
                new TextQuestion("Slovenia", "Ljubljana", "flags/si.png"),
                new TextQuestion("Storbritannia", "London", "flags/gb.png"),
                new TextQuestion("Luxembourg", "Luxembourg", "flags/lu.png"),
                new TextQuestion("Spania", "Madrid", "flags/es.png"),
                new TextQuestion("Hviterussland", "Minsk", "flags/by.png"),
                new TextQuestion("Monaco", "Monaco", "flags/mc.png"),
                new TextQuestion("Russland", "Moskva", "flags/ru.png"),
                new TextQuestion("Frankrike", "Paris", "flags/fr.png"),
                new TextQuestion("Montenegro", "Podgorica", "flags/me.png"),
                new TextQuestion("Tsjekkia", "Praha", "flags/cz.png"),
                new TextQuestion("Kosovo", "Pristina", "flags/ks.png"), // Priština
                new TextQuestion("Latvia", "Riga", "flags/lv.png"),
                new TextQuestion("Italia", "Roma", "flags/it.png"),
                new TextQuestion("San Marino", "San Marino", "flags/sm.png"),
                new TextQuestion("Bosnia-Hercegovina", "Sarajevo", "flags/ba.png"),
                new TextQuestion("Makedonia", "Skopje", "flags/mk.png"),
                new TextQuestion("Bulgaria", "Sofia", "flags/bg.png"),
                new TextQuestion("Estland", "Tallinn", "flags/ee.png"),
                new TextQuestion("Albania", "Tirana", "flags/al.png"),
                new TextQuestion("Liectenstein", "Vaduz", "flags/li.png"),
                new TextQuestion("Malta", "Valletta", "flags/mt.png"),
                new TextQuestion("Vatikanstaten", "Vatikanstaten", "flags/va.png"),
                new TextQuestion("Litauen", "Vilnius", "flags/lt.png"),
                new TextQuestion("Østerrike", "Wien", "flags/at.png"),
                new TextQuestion("Kroatia", "Zagreb", "flags/hr.png")

        );


    }

    public Question getRandomQuestion() {

        Random random = new Random();
        currentQuestionIndex = random.nextInt(quizArray.size());

        return quizArray.get(currentQuestionIndex);


    }

    /**
     * Check if new questions can be requested
     * @return
     */

    public boolean canGetNewQuestion() {

        if (getNumberOfQuestionsAsked() >= getQuestionLimit()) {
            return false;
        } else {
            return true;
        }

    }

    private Question getCurrentQuestion() {
        return quizArray.get(currentQuestionIndex);
    }

    public boolean validateReplyForCurrentQuestion(String reply) {

        Question question = getCurrentQuestion();

        incrementNumberOfQuestionsAsked();

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

    public void incrementNumberOfQuestionsAsked() {
        numberOfQuestionsAsked++;
    }

    public void incrementScore() {
        correctReplies++;
    }

    public int getCorrectReplies() {
        return correctReplies;
    }

    public int getNumberOfQuestionsAsked() {
        return numberOfQuestionsAsked;
    }

}
