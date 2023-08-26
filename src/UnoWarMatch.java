/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

/**
 * Class UnoWarMatch, plays the uno War game, and returns the winrates.
 */
public class UnoWarMatch {
    public static int numRounds = 10;
    public static int handSize = 5;
    private AI gameAI1;
    private AI gameAI2;

    /**
     * constructor, passes in the 2 ais that are going to play eachother.
     *
     * @param ai1
     * @param ai2
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        gameAI1 = ai1;
        gameAI2 = ai2;
    }

    /**
     * initiates a new shuffled deck of cards, and a hand for each AI.
     * initiats a win counter for both of the Ais, and play sequence / loop round booleans conditionals.
     * sets a loop for the game that will run until one of the ais has 10 wins
     * draws a new card for the new game cardpile and sets the win conditional to false.
     * loops over the round until one ai ahs won, and the bool is set to true.
     * checks which AI is setto go first.
     * checks if the card that the current ai is playing is playable,
     * if so plays and removes the card
     * if not counts a win for the other ai, sets has won to true and sets the winning at to go first next round.
     * checks which ai has more wins once the game has been played.
     *
     * @return true if the first ai had more wins, flase if the second ai had more wins.
     */
    public boolean playGame() {
        Deck gameDeck = new Deck();
        Hand ai1Hand = new Hand(gameDeck, handSize);
        Hand ai2Hand = new Hand(gameDeck, handSize);

        int roundWinCounter1 = 0;
        int roundWinCounter2 = 0;
        boolean goesFirst = true;
        boolean hasWon;

        while (roundWinCounter1 <= numRounds - 1 && roundWinCounter2 <= numRounds - 1) {
            hasWon = false;
            CardPile gameCardPile = new CardPile(gameDeck.draw());

            while (hasWon != true) {
                if (goesFirst == true) {
                    if (gameAI1.getPlay(ai1Hand, gameCardPile) != null) {
                        gameCardPile.play(gameAI1.getPlay(ai1Hand, gameCardPile));
                        ai1Hand.remove(gameAI1.getPlay(ai1Hand, gameCardPile));
                    } else {
                        roundWinCounter2++;
                        hasWon = true;
                        goesFirst = false;
                    }

                    if (gameAI2.getPlay(ai2Hand, gameCardPile) != null) {
                        gameCardPile.play(gameAI2.getPlay(ai2Hand, gameCardPile));
                        ai2Hand.remove(gameAI2.getPlay(ai2Hand, gameCardPile));
                    } else {
                        roundWinCounter1++;
                        hasWon = true;
                        goesFirst = true;
                    }
                } else if (goesFirst == false) {
                    if (gameAI2.getPlay(ai2Hand, gameCardPile) != null) {
                        gameCardPile.play(gameAI2.getPlay(ai2Hand, gameCardPile));
                        ai2Hand.remove(gameAI2.getPlay(ai2Hand, gameCardPile));
                    } else {
                        roundWinCounter1++;
                        hasWon = true;
                        goesFirst = true;
                    }

                    if (gameAI1.getPlay(ai1Hand, gameCardPile) != null) {
                        gameCardPile.play(gameAI1.getPlay(ai1Hand, gameCardPile));
                        ai1Hand.remove(gameAI1.getPlay(ai1Hand, gameCardPile));
                    } else {
                        roundWinCounter2++;
                        hasWon = true;
                        goesFirst = false;
                    }
                }
            }
        }

        if (roundWinCounter1 > roundWinCounter2) {
            return true;
        } else if (roundWinCounter2 > roundWinCounter1) {
            return false;
        }

        return false;
    }

    /**
     * initiats a win counter to 0
     * loops over the amount of time that the game is set to be played
     * checks which AI won the game by calling hte playGame method
     * if true, adds to the win counter.
     *
     * @param nTrials
     * @return the percentage of wins by dividing the amount of wins by the total number of trials.
     */
    public double winRate(int nTrials) {
        int gameWinCounter = 0;

        for (int i = 0; i < nTrials; i++) {
            if (playGame() == true) {
                gameWinCounter++;
            }

        }
        return (double) gameWinCounter / (double) nTrials;
    }
}