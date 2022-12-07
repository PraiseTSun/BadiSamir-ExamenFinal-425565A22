package examen;

import java.util.ArrayList;

public class PopQuestions extends QuestionGenre {
    public PopQuestions() {
        super("Pop", new int[]{0, 4, 8});
    }

    @Override
    public void setUpQuestions() {
        for (int i = 0; i < 50; i++) {
            questions.addLast("Pop Question " + i);
        }
    }
}
