/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 2
 * Author: Benjamin Lindeen
 */

/**
 * Class Tournament, runs all the ai simulations for the card games.
 */
public class Tournament {
    /**
     * initiates the amount of times an ai should play.
     * makes 3 new ais, random, smallest, and biggest.
     * makes 9 new unoWarMatches with the designated matchups
     * prints 9 formatted matches.
     *
     * @param args
     */
    public static void main(String[] args) {
        int numTrials = 1000;
        AI aiRandom = new AI();
        AI aiSmallest = new SmallestCardAI();
        AI aiBiggest = new BiggestCardAI();

        UnoWarMatch randomMatch1 = new UnoWarMatch(aiRandom, aiRandom);
        UnoWarMatch randomMatch2 = new UnoWarMatch(aiRandom, aiSmallest);
        UnoWarMatch randomMatch3 = new UnoWarMatch(aiRandom, aiBiggest);
        UnoWarMatch smallestMatch1 = new UnoWarMatch(aiSmallest, aiRandom);
        UnoWarMatch smallestMatch2 = new UnoWarMatch(aiSmallest, aiSmallest);
        UnoWarMatch smallestMatch3 = new UnoWarMatch(aiSmallest, aiBiggest);
        UnoWarMatch biggestMatch1 = new UnoWarMatch(aiBiggest, aiRandom);
        UnoWarMatch biggestMatch2 = new UnoWarMatch(aiBiggest, aiSmallest);
        UnoWarMatch biggestMatch3 = new UnoWarMatch(aiBiggest, aiBiggest);

        System.out.println(aiRandom.toString() + " vs. " + aiRandom.toString() + " winRate: " + randomMatch1.winRate(numTrials));
        System.out.println(aiRandom.toString() + " vs. " + aiSmallest.toString() + " winRate: " + randomMatch2.winRate(numTrials));
        System.out.println(aiRandom.toString() + " vs. " + aiBiggest.toString() + " winRate: " + randomMatch3.winRate(numTrials));
        System.out.println(aiSmallest.toString() + " vs. " + aiRandom.toString() + " winRate: " + smallestMatch1.winRate(numTrials));
        System.out.println(aiSmallest.toString() + " vs. " + aiSmallest.toString() + " winRate: " + smallestMatch2.winRate(numTrials));
        System.out.println(aiSmallest.toString() + " vs. " + aiBiggest.toString() + " winRate: " + smallestMatch3.winRate(numTrials));
        System.out.println(aiBiggest.toString() + " vs. " + aiRandom.toString() + " winRate: " + biggestMatch1.winRate(numTrials));
        System.out.println(aiBiggest.toString() + " vs. " + aiSmallest.toString() + " winRate: " + biggestMatch2.winRate(numTrials));
        System.out.println(aiBiggest.toString() + " vs. " + aiBiggest.toString() + " winRate: " + biggestMatch3.winRate(numTrials));
    }
}