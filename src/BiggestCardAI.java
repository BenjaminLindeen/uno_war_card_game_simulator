/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

/**
 * Class AI, inherits from Class AI, algorithm for playing the biggest viable card.
 */
public class BiggestCardAI extends AI {
    /**
     * passes in a hand, and a card pile that are being used in the game, initiates a placeholder card.
     * iterates over the whole hand to check for viable cards.
     * then checks if the viable card is larger than the placeholder card.
     * loops over the size of the hand to find the index at which the largest viable card was found.
     *
     * @param hand
     * @param cardPile
     * @return the card at index of k, if no card is playable, returns null.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        int tempCard = 0;

        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i)) == true) {
                if (hand.get(i).getRankNum() >= tempCard) {
                    tempCard = hand.get(i).getRankNum();
                }
            }
        }

        for (int k = 0; k < hand.getSize(); k++) {
            if (tempCard == hand.get(k).getRankNum()) {
                if (cardPile.canPlay(hand.get(k)) == true) {
                    return hand.get(k);
                }
            }
        }

        return null;
    }

    /**
     * @return the name of the AI
     */
    public String toString() {
        return "Biggest Card AI";
    }
}