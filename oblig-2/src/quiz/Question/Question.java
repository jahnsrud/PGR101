package quiz.Question;

public class Question {

    private String question;
    private String correctCapital;
    private String imageLocation;

    public Question(String question, String correctCapital, String imageLocation) {
        this.question = question;
        this.correctCapital = correctCapital;
        this.imageLocation = imageLocation;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectCapital() {
        return correctCapital;
    }

    public void setCorrectCapital(String correctCapital) {
        this.correctCapital = correctCapital;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
