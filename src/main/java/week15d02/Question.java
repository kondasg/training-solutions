package week15d02;

public class Question {

    private final String question;
    private final int answer;
    private final int point;
    private final String category;

    public Question(String question, int answer, int point, String category) {
        this.question = question;
        this.answer = answer;
        this.point = point;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public int getPoint() {
        return point;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                ", point=" + point +
                ", category='" + category + '\'' +
                '}';
    }
}
