/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

/**
 * Class Deck, creates an array of cards that can be used as a deck of cards.
 */
public class Deck {
    public static int deckSize = 52;
    private int counter;
    private Card[] deck;

    /**
     * constructor, initiates a new deck by creating an array of cards,
     * looping over the amount of suits for as many times as the amount ranks,
     * adds a new card at the loops index to the array, at the overall index.
     * calls shuffle method to shuffle the deck upon call.
     */
    public Deck() {
        counter = deckSize - 1;
        deck = new Card[deckSize];

        for (int i = 0; i < Card.rankLength; i++) {
            for (int k = 0; k < Card.suitLength; k++) {
                deck[(Card.suitLength * i) + k] = new Card(i + 1, k + 1);
            }
        }

        shuffle();
    }

    /**
     * creates a placeholder card, math minimum integer, math maximum integer, and a range integer.
     * loops over the whole deck, creates a random math integer using the range integer as a value range.
     * assigns the placeholder to the array value at index.
     * replaces array value at index to array value at a random integer.
     * replaces array at index random with the placeholder card.
     * resets deck counter
     */
    public void shuffle() {
        Card temp;
        int min = (int) Math.ceil(0);
        int max = (int) Math.floor(deckSize);
        int range = ((max - min) + min);

        for (int i = 0; i < deckSize; i++) {
            int rand = (int) Math.floor(Math.random() * range);

            temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }

        counter = deckSize - 1;
    }

    /**
     * checks if the deck is empty method.
     * if the deck is empty calls shuffle method.
     * else reduces the deck counter.
     *
     * @return card array deck at counter + 1
     */
    public Card draw() {
        if (isEmpty() == true) {
            shuffle();
        }

        counter--;

        return deck[counter + 1];
    }

    /**
     * @return deck counter + 1
     */
    public int cardsRemaining() {
        return counter + 1;
    }

    /**
     * checks if the cardsRemaining method is 0
     *
     * @return returns true if yes, false if no
     */
    public boolean isEmpty() {
        if (cardsRemaining() == 0) {
            return true;
        } else {
            return false;
        }
    }
}