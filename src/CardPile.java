/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

/**
 * Class CardPile, creates a new card that acts as the top of a card pile for a game.
 */
public class CardPile {
    private int numCards = 0;
    private Card topCardPile;

    /**
     * constructor, assigns the new card value to the top card parameter,
     * increments the amount of cards in the pile by 1.
     *
     * @param topCard
     */
    public CardPile(Card topCard) {
        topCardPile = topCard;
        numCards++;
    }

    /**
     * checks if a card is null,
     * then checks if the card is greater than or equal to the top card,
     * or if the suit is the same as the top card
     *
     * @param card
     * @return if so returns true, if not false.
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        } else if (card.getRankNum() >= topCardPile.getRankNum() || card.getSuitName() == topCardPile.getSuitName()) {
            return true;
        }

        return false;
    }

    /**
     * checks if the canplay method was true,
     * if so replaces the top card with the new card
     * increments the amount of cards in the card pile.
     * otherwise prints an error message.
     *
     * @param card
     */
    public void play(Card card) {
        if (canPlay(card) == true) {
            topCardPile = card;
            numCards++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * @return the amount of cards in the card pile.
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * @return the top card.
     */
    public Card getTopCard() {
        return topCardPile;
    }
}