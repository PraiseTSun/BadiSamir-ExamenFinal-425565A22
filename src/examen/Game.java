package examen;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    QuestionGenre[] questionGenres = new QuestionGenre[] {
            new PopQuestions(),
            new ScienceQuestions(),
            new SportsQuestions(),
            new RockQuestions(),
    };

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public  Game(){
        Arrays.stream(questionGenres).forEach(questionGenre -> questionGenre.setUpQuestions());
    }

    public boolean canAddPlayer(String playerName) {
        players.add(playerName);
        places[players.size()] = 0;
        purses[players.size()] = 0;
        inPenaltyBox[players.size()] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public void makeARollAttemp(int roll) {
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            PenaltyRoll(roll);
        } else {
            roll(roll);
            askQuestion();
        }
    }

    private void PenaltyRoll(int roll) {
        if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;

            System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
            roll(roll);
            askQuestion();
        } else {
            System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
    }

    private void roll(int roll) {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
    }

    private void askQuestion() {
        for (QuestionGenre questionGenre : questionGenres) {
            if(questionGenre.isGenre(currentCategory())){
                System.out.println(questionGenre.getFirstQuestion());
                return;
            }
        }
    }


    private String currentCategory() {
        for (QuestionGenre questionGenre : questionGenres) {
            if(questionGenre.isCurrentCategory(places[currentPlayer])){
                return questionGenre.GENRE;
            }
        }
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]){
            if (isGettingOutOfPenaltyBox) {
                return correctlyAnsweredCheck();
            } else {
                changeCurrentPlayer();
                return true;
            }
        } else {
            return correctlyAnsweredCheck();
        }
    }

    private boolean correctlyAnsweredCheck() {
        correctAnswerMessage();

        boolean winner = didPlayerWin();
        changeCurrentPlayer();

        return winner;
    }

    private void changeCurrentPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    private void correctAnswerMessage() {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");
    }

    public boolean wrongAnswer(){
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        changeCurrentPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}
