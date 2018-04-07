package quiz.Question;

public class Question {

    private String question;
    private String correctReply;
    private String imageLocation;

    public Question(String question, String correctCapital, String imageLocation) {
        this.question = question;
        this.correctReply = correctCapital;
        this.imageLocation = imageLocation;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectReply() {
        return correctReply;
    }

    public void setCorrectReply(String correctReply) {
        this.correctReply = correctReply;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
