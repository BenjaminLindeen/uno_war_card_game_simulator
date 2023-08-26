/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

/**
 * Class AI, algorithm for playing the first viable card.
 */
public class AI {
    /**
     * passes in a hand, and a card pile that are being used in the game.
     * iterates over the whole hand to check for the first viable card.
     *
     * @param hand
     * @param cardPile
     * @return the card at index of i, if no card is playable, returns null.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i)) == true) {
                return hand.get(i);
            }
        }

        return null;
    }

    /**
     * @return the name of the AI
     */
    public String toString() {
        return "Random Card AI";
    }
}