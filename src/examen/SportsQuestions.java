package examen;

public class SportsQuestions extends QuestionGenre{
    public SportsQuestions() {
        super("Sports", new int[]{2, 6, 10});
    }

    @Override
    public void setUpQuestions() {
        for (int i = 0; i < 50; i++) {
            questions.addLast("Sports Question " + i);
        }
    }
}
