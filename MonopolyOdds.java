package dev;

import java.util.*;

public class MonopolyOdds {
    // Board positions mapping
    private static final Map<String, Integer> BOARD_POSITIONS = new HashMap<>();
    private static final String[] BOARD = {
            "GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
            "JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
            "FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
            "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"
    };

    static {
        for (int i = 0; i < BOARD.length; i++) {
            BOARD_POSITIONS.put(BOARD[i], i);
        }
    }

    // Community Chest cards
    private static final List<String> COMMUNITY_CHEST = Arrays.asList(
            "GO", "JAIL", null, null, null, null, null, null,
            null, null, null, null, null, null, null, null
    );

    // Chance cards
    private static final List<String> CHANCE = Arrays.asList(
            "GO", "JAIL", "C1", "E3", "H2", "R1",
            "NEXT_R", "NEXT_R", "NEXT_U", "BACK_3",
            null, null, null, null, null, null
    );

    private int currentPosition = 0;
    private int ccCardIndex = 0;
    private int chanceCardIndex = 0;
    private int consecutiveDoubles = 0;

    public MonopolyOdds() {
        // Shuffle the decks
        Collections.shuffle(COMMUNITY_CHEST);
        Collections.shuffle(CHANCE);
    }

    private void moveToPosition(String position) {
        currentPosition = BOARD_POSITIONS.get(position);
    }

    private void moveToNextRailway() {
        // Find next railway from current position
        int[] railways = {5, 15, 25, 35}; // R1, R2, R3, R4
        for (int r : railways) {
            if (r > currentPosition) {
                currentPosition = r;
                return;
            }
        }
        currentPosition = railways[0]; // Wrap around to R1
    }

    private void moveToNextUtility() {
        // Find next utility from current position
        int[] utilities = {12, 28}; // U1, U2
        for (int u : utilities) {
            if (u > currentPosition) {
                currentPosition = u;
                return;
            }
        }
        currentPosition = utilities[0]; // Wrap around to U1
    }

    private void moveBackThree() {
        currentPosition = (currentPosition - 3 + BOARD.length) % BOARD.length;
    }

    private void processSpecialSquare() {
        String currentSquare = BOARD[currentPosition];

        if (currentSquare.equals("G2J")) {
            moveToPosition("JAIL");
        } else if (currentSquare.startsWith("CC")) {
            // Community Chest
            String card = COMMUNITY_CHEST.get(ccCardIndex);
            ccCardIndex = (ccCardIndex + 1) % COMMUNITY_CHEST.size();

            if (card != null) {
                moveToPosition(card);
            }
        } else if (currentSquare.startsWith("CH")) {
            // Chance
            String card = CHANCE.get(chanceCardIndex);
            chanceCardIndex = (chanceCardIndex + 1) % CHANCE.size();

            if (card != null) {
                if (card.equals("NEXT_R")) {
                    moveToNextRailway();
                } else if (card.equals("NEXT_U")) {
                    moveToNextUtility();
                } else if (card.equals("BACK_3")) {
                    moveBackThree();
                    processSpecialSquare(); // Process the new square
                } else {
                    moveToPosition(card);
                }
            }
        }
    }

    private void rollDice(int die1, int die2) {
        if (die1 == die2) {
            consecutiveDoubles++;
            if (consecutiveDoubles == 3) {
                moveToPosition("JAIL");
                consecutiveDoubles = 0;
                return;
            }
        } else {
            consecutiveDoubles = 0;
        }

        int roll = die1 + die2;
        currentPosition = (currentPosition + roll) % BOARD.length;
        processSpecialSquare();
    }

    public static void simulateGame(int numRolls, int diceSides) {
        MonopolyOdds game = new MonopolyOdds();
        int[] visitCount = new int[BOARD.length];

        Random rand = new Random();

        for (int i = 0; i < numRolls; i++) {
            int die1 = rand.nextInt(diceSides) + 1;
            int die2 = rand.nextInt(diceSides) + 1;
            game.rollDice(die1, die2);
            visitCount[game.currentPosition]++;
        }

        // Calculate probabilities and find most visited squares
        System.out.println("Simulation with " + diceSides + "-sided dice:");
        System.out.println("Number of rolls: " + numRolls);
        System.out.println("\nSquare visit probabilities:");

        // Create list of squares with their probabilities
        List<SquareProb> probs = new ArrayList<>();
        for (int i = 0; i < BOARD.length; i++) {
            double probability = (double) visitCount[i] / numRolls * 100;
            probs.add(new SquareProb(BOARD[i], i, probability));
        }

        // Sort by probability descending
        probs.sort((a, b) -> Double.compare(b.probability, a.probability));

        // Print top 3
        System.out.println("\nTop 3 most visited squares:");
        for (int i = 0; i < 3; i++) {
            SquareProb sp = probs.get(i);
            System.out.printf("%d. %s (Square %02d): %.2f%%\n",
                    i + 1, sp.name, sp.position, sp.probability);
        }

        // Generate modal string
        StringBuilder modalString = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            modalString.append(String.format("%02d", probs.get(i).position));
        }
        System.out.println("\nSix-digit modal string: " + modalString.toString());
    }

    static class SquareProb {
        String name;
        int position;
        double probability;

        SquareProb(String name, int position, double probability) {
            this.name = name;
            this.position = position;
            this.probability = probability;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Standard 6-sided dice ===");
        simulateGame(1000000, 6);

        System.out.println("\n=== 4-sided dice ===");
        simulateGame(1000000, 4);
    }
}