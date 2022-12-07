package examen;

public class ScienceQuestions extends QuestionGenre{
    public ScienceQuestions() {
        super("Science", new int[]{1, 5, 9});
    }

    @Override
    public void setUpQuestions() {
        for (int i = 0; i < 50; i++) {
            questions.addLast("Science Question " + i);
        }
    }
}
