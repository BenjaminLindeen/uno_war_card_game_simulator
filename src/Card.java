/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

import java.util.Objects;

/**
 * Class Card, creates a playing card, with integer inputs to represent the rank and the suit of the card
 */
public class Card {
    public static int rankLength = 13;
    public static int suitLength = 4;
    private int cardRank;
    private int cardSuit;

    /**
     * constructor checks if the integers passes in are within the valid range of card inputs
     *
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit) {
        cardRank = rank;
        cardSuit = suit;

        if (cardRank > rankLength || cardRank < 0 || cardSuit > suitLength || cardSuit < 0) {
            System.out.println("Invalid Card");

            cardRank = 1;
            cardSuit = 1;
        }
    }

    /**
     * @return the card rank integer
     */
    public int getRankNum() {
        return cardRank;
    }

    /**
     * Creates an array of strings to hold the string ranks of the cards.
     * checks if the card rank integer passes in is valid.
     *
     * @return error statement or the array at index of the rank - 1.
     */
    public String getRankName() {
        String[] rank = new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        if (cardRank > rankLength || cardRank < 0) {
            return "Invalid Card";
        }

        return rank[cardRank - 1];
    }

    /**
     * creates a array of strings with the string suits of the cards.
     * checks if the card suit integer passed in is valid.
     *
     * @return error statement or the array at index of the suit - 1.
     */
    public String getSuitName() {
        String[] suit = new String[]{"Spades", "Hearts", "Clubs", "Diamonds"};

        if (cardSuit > suitLength || cardSuit < 0) {
            return "Invalid Card";
        }

        return suit[cardSuit - 1];
    }

    /**
     * checks if either the rank or suit of the card was invalid.
     *
     * @return either an error message or an appended string with the card's full name of rank and suit.
     */
    public String toString() {
        if (getRankName() == "Invalid Card" || getSuitName() == "Invalid Card") {
            return "Invalid Card";
        } else {
            return getRankName() + " of " + getSuitName();
        }
    }

    /**
     * Passes in an object.
     * checks if the object is equal to a given other object.
     * in this case 2 cards, are checks to have equal rank and suit.
     *
     * @param o
     * @return true if equal false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Card card = (Card) o;

        return cardRank == card.cardRank && cardSuit == card.cardSuit;
    }

    /**
     * @return hash value of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(cardRank, cardSuit);
    }
}