package examen;

public class RockQuestions extends QuestionGenre{
    public RockQuestions() {
        super("Rock", new int[0]);
    }

    @Override
    public void setUpQuestions() {
        for (int i = 0; i < 50; i++) {
            questions.addLast("Rock Question " + i);
        }
    }
}
