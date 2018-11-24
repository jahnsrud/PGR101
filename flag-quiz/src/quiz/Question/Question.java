package quiz.Question;

public abstract class Question {

    private String question;
    private String correctReply;
    private String imageLocation;

    public Question(String question, String correctReply, String imageLocation) {
        this.question = question;
        this.correctReply = correctReply;
        this.imageLocation = imageLocation;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectReply() {
        return correctReply;
    }

    public String getImageLocation() {
        return imageLocation;
    }

}
