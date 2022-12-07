package examen;

import java.util.Random;

public class GameRunner {
    private static boolean notAWinner;

    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.canAddPlayer("Mathieu");
        aGame.canAddPlayer("Samir");
        aGame.canAddPlayer("Manolo");

        Random rand = new Random();

        do {
            aGame.makeARollAttemp(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
        } while (notAWinner);
    }
}
