# UnoWar Card Game Simulator

A strategic blend of the traditional card games, Uno and War, realized in a Java simulation to determine optimal playing strategies.

## Game Overview

UnoWar is played with a standard 52-card deck. Each player holds a hand of 5 cards, drawing from a shared deck. The game unfolds over a series of rounds, where players lay cards according to rules until one emerges as the round's winner. The overarching goal is to win 10 rounds.

**General Flow:**
1. The deck is shuffled.
2. Two players are dealt 5 cards each.
3. Player 1 kicks off the initial round.
4. Rounds are played consecutively until a player wins 10 of them.

### Round Dynamics

A round initiates by dealing a card to form the central pile. Players then alternately play a card into this pile based on the following criteria:
- Card of the same suit as the one in the center.
- Card of equal or greater rank.

A player loses the round if they:
- Lay a card violating the above conditions.
- Can't play any card abiding by the conditions.

### Game Simulation

This Java-based simulator is structured to incorporate:
- **Card Representation**: Involving standard Java objects and arrays.
- **Strategy Implementation & Analysis**: Using inheritance and polymorphism.

## AI Strategies

While numerous strategies are conceivable, this simulation primarily focuses on three:

1. **Random Card AI**: Plays the first valid card from its hand. This strategy serves as a baseline.
2. **Smallest Card AI**: Always lays the lowest-ranked valid card. Aims to preserve maximum future options.
3. **Biggest Card AI**: Always chooses the highest-ranked valid card. Designed to constrict opponent's choices for swift victories.

The main purpose of this simulation is to evaluate the efficacy of these AI strategies against one another.

## Expected Output

The program yields the win rates for every pair of AIs. A snippet from a test run:

1. Random Card AI vs. Random Card AI winRate: 0.499 
2. Random Card AI vs. Smallest Card AI winRate: 0.002 
3. Random Card AI vs. Biggest Card AI winRate: 0.842 
4. Smallest Card AI vs. Random Card AI winRate: 0.998 
5. Smallest Card AI vs. Smallest Card AI winRate: 0.499 
6. Smallest Card AI vs. Biggest Card AI winRate: 0.999 
7. Biggest Card AI vs. Random Card AI winRate: 0.156 
8. Biggest Card AI vs. Smallest Card AI winRate: 0.0 
9. Biggest Card AI vs. Biggest Card AI winRate: 0.491


*Note*: Exact outputs might differ since win rates are subject to randomness. For accurate results, it's recommended to set `nTrails` to at least 1000.

---

Feel free to delve into the code and perhaps even introduce your own strategies to see how they fare against the predefined ones. Enjoy the strategic showdown!
