/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

/**
 * Class Hand, creates an array of cards that can be used as a players hand.
 */
public class Hand {
    private Deck handDeck;
    private int handSize;
    private Card[] hand;

    /**
     * constructor, initiates a new hand given a deck and size of the hand, and a new array of cards acting as the hand.
     * loops over the amount of the hand size to draw new cards into the hand at array index of i.
     *
     * @param deck
     * @param size
     */
    public Hand(Deck deck, int size) {
        handDeck = deck;
        handSize = size;
        hand = new Card[handSize];

        for (int i = 0; i < handSize; i++) {
            hand[i] = handDeck.draw();
        }
    }

    /**
     * @return the size of the hand
     */
    public int getSize() {
        return handSize;
    }

    /**
     * checks if the index give is out of bounds of the handsize.
     *
     * @param i
     * @return if so returns index of 0, otherwise returns index of i.
     */
    public Card get(int i) {
        if (i > handSize || i < 0) {
            System.out.println("Invalid hand index!");
            i = 0;
            return hand[i];
        }

        return hand[i];
    }

    /**
     * loops over the size of the hand, finds the index at which the card is found.
     * replaces the card with a newly drawn card
     *
     * @param card
     * @return true if successful, false if not.
     */
    public boolean remove(Card card) {
        for (int i = 0; i < handSize; i++) {
            if (hand[i] == card) {
                hand[i] = handDeck.draw();

                return true;
            }
        }

        return false;
    }
}