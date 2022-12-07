package examen;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class QuestionGenre {
    protected final int NB_QUESTIONS = 50;
    protected final String GENRE;
    protected final int[] CATEGORY_NUMBER;
    LinkedList questions = new LinkedList();

    public QuestionGenre(String GENRE, int[] CATEGORY_NUMBER) {
        this.GENRE = GENRE;
        this.CATEGORY_NUMBER = CATEGORY_NUMBER;
    }

    public abstract void setUpQuestions();

    public Object getFirstQuestion(){
        if(questions.size() <= 0)
            return questions.removeFirst();
        return "Il ne reste plus de question pour " + GENRE;
    }

    public boolean isGenre(String genre){
        return GENRE.equals(genre);
    }

    public boolean isCurrentCategory(int category){
        return Arrays.stream(CATEGORY_NUMBER).anyMatch(value -> value == category);
    }
}
