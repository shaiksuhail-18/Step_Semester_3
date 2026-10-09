abstract class Question {
    String text;
    String correctAnswer;
    String studentAnswer;
    int points;
    public Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    abstract double getScore();
    abstract String getType();
}
class MCQ extends Question {
    public MCQ(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    double getScore() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    String getType() { return "MCQ"; }
}
class TF extends Question {
    public TF(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    double getScore() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    String getType() { return "TF"; }
}
class Essay extends Question {
    public Essay(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    double getScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String ansLower = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            if (ansLower.contains(kw.trim().toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0;
    }
    String getType() { return "ESSAY"; }
}
public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Question[] qs = {
            new MCQ("What is the capital of France?", "Paris", "Paris", 10),
            new TF("The Earth is flat?", "False", "True", 5),
            new Essay("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20),
            new Essay("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15)
        };
        double total = 0;
        for (Question q : qs) {
            double score = q.getScore();
            total += score;
            System.out.printf("%s: %.2f\n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f\n", total);
    }
}
