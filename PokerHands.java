package dev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PokerHands {

    public static void main(String[] args) {
        int counter = 0;

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("p054_poker.txt"));
            String line = reader.readLine();

            while (line != null) {
                Hand hand = new Hand(line.substring(0, 14));
                Hand secondHand = new Hand(line.substring(15));
                if (hand.compare(secondHand) == 1) {
                    counter++;
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}

class Hand {
    private boolean isSameSuit = false;
    private boolean isSameValue = false;
    private boolean hasConsecutiveValues = false;
    private boolean hasFourSameValues = false;
    private boolean hasThreeAndTwoSameValues = false;
    private boolean hasThreeSameValues = false;
    private boolean hasTwoPairs = false;
    private boolean hasOnePair = false;

    public int getHighValue() {
        return highValue;
    }

    private int highValue = 0;
    private int rankValue = 0;
    private int highestRankedvalue = 0;

    public String getMyRank() {
        return myRank;
    }

    private String myRank = "";


    public List<Integer> getValues() {
        return values;
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        return map.entrySet().stream()
                .filter(entry -> value.equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);
    }

    private List<Integer> values = new ArrayList();
    private List<Character> suites = new ArrayList();

    Hand(String cardsInput) {
        String cards = cardsInput.replaceAll("\\s", "");
        Map<Integer, Integer> map = new HashMap<>();
        int v0 = cards.charAt(0) == 'T' ? 10
                : cards.charAt(0) == 'J' ? 11
                : cards.charAt(0) == 'Q' ? 12
                : cards.charAt(0) == 'K' ? 13
                : cards.charAt(0) == 'A' ? 14
                : Character.getNumericValue(cards.charAt(0));
        int v2 = cards.charAt(2) == 'T' ? 10
                : cards.charAt(2) == 'J' ? 11
                : cards.charAt(2) == 'Q' ? 12
                : cards.charAt(2) == 'K' ? 13
                : cards.charAt(2) == 'A' ? 14
                : Character.getNumericValue(cards.charAt(2));
        int v4 = cards.charAt(4) == 'T' ? 10
                : cards.charAt(4) == 'J' ? 11
                : cards.charAt(4) == 'Q' ? 12
                : cards.charAt(4) == 'K' ? 13
                : cards.charAt(4) == 'A' ? 14
                : Character.getNumericValue(cards.charAt(4));
        int v6 = cards.charAt(6) == 'T' ? 10
                : cards.charAt(6) == 'J' ? 11
                : cards.charAt(6) == 'Q' ? 12
                : cards.charAt(6) == 'K' ? 13
                : cards.charAt(6) == 'A' ? 14
                : Character.getNumericValue(cards.charAt(6));
        int v8 = cards.charAt(8) == 'T' ? 10
                : cards.charAt(8) == 'J' ? 11
                : cards.charAt(8) == 'Q' ? 12
                : cards.charAt(8) == 'K' ? 13
                : cards.charAt(8) == 'A' ? 14
                : Character.getNumericValue(cards.charAt(8));

        values.add(v0);
        values.add(v2);
        values.add(v4);
        values.add(v6);
        values.add(v8);

        if (map.get(v0) == null) {
            map.put(v0, 1);
        } else {
            map.put(v0, map.get(v0) + 1);
        }

        if (map.get(v2) == null) {
            map.put(v2, 1);
        } else {
            map.put(v2, map.get(v2) + 1);
        }

        if (map.get(v4) == null) {
            map.put(v4, 1);
        } else {
            map.put(v4, map.get(v4) + 1);
        }

        if (map.get(v6) == null) {
            map.put(v6, 1);
        } else {
            map.put(v6, map.get(v6) + 1);
        }

        if (map.get(v8) == null) {
            map.put(v8, 1);
        } else {
            map.put(v8, map.get(v8) + 1);
        }

        suites.add(cards.charAt(1));
        suites.add(cards.charAt(3));
        suites.add(cards.charAt(5));
        suites.add(cards.charAt(7));
        suites.add(cards.charAt(9));

        if (map.containsValue(4)) {
            hasFourSameValues = true;
        }

        if (map.containsValue(3)) {
            hasThreeSameValues = true;
        }

        if (map.containsValue(3) && map.containsValue(2)) {
            hasThreeAndTwoSameValues = true;
        }

        int counter = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                counter++;
            }
        }
        if (counter == 2) {
            hasTwoPairs = true;
        } else if (counter == 1) {
            hasOnePair = true;
        }

        if (cards.charAt(0) == cards.charAt(2) &
                cards.charAt(2) == cards.charAt(4) &
                cards.charAt(4) == cards.charAt(6) &
                cards.charAt(6) == cards.charAt(8)) {
            isSameValue = true;
        }

        if (cards.charAt(1) == cards.charAt(3) &
                cards.charAt(3) == cards.charAt(5) &
                cards.charAt(5) == cards.charAt(7) &
                cards.charAt(7) == cards.charAt(9)) {
            isSameSuit = true;
        }

        Collections.sort(values);

        if ((values.get(4) - values.get(3) == 1) &&
                (values.get(3) - values.get(2) == 1) &&
                (values.get(2) - values.get(1) == 1) &&
                (values.get(1) - values.get(0) == 1)) {
            hasConsecutiveValues = true;
        }

        highValue = values.get(4);

        if (isSameSuit && values.contains(10) && values.contains(11) && values.contains(12) && values.contains(13) && values.contains(14)) {
            myRank = "Royal Flush";
            rankValue = 9;
            highestRankedvalue = values.get(4);
        } else if (isSameSuit && hasConsecutiveValues) {
            myRank = "Straight Flush";
            rankValue = 8;
            highestRankedvalue = values.get(4);
        } else if (hasFourSameValues) {
            myRank = "Four of a Kind";
            rankValue = 7;
            highestRankedvalue = getKey(map, 4);
        } else if (hasThreeAndTwoSameValues) {
            myRank = "Full House";
            rankValue = 6;
            highestRankedvalue = getKey(map, 3) > getKey(map, 2) ? getKey(map, 3) : getKey(map, 2);
        } else if (isSameSuit) {
            myRank = "Flush";
            rankValue = 5;
            highestRankedvalue = values.get(4);
        } else if (hasConsecutiveValues) {
            myRank = "Straight";
            rankValue = 4;
            highestRankedvalue = values.get(4);
        } else if (hasThreeSameValues) {
            myRank = "Three of a Kind";
            rankValue = 3;
            highestRankedvalue = getKey(map, 3);
        } else if (hasTwoPairs) {
            myRank = "Two Pairs";
            rankValue = 2;
            List<Integer> vals = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) {
                    vals.add(entry.getKey());
                }
            }
            highestRankedvalue = Collections.max(vals);
        } else if (hasOnePair) {
            myRank = "One Pair";
            rankValue = 1;
            highestRankedvalue = getKey(map, 2);
        } else {
            myRank = "High Card";
            rankValue = 0;
            highestRankedvalue = values.get(4);
        }
    }

    int compare(Hand hand) {
        if (this.rankValue > hand.rankValue) {
            return 1;
        } else if (this.rankValue < hand.rankValue) {
            return -1;
        } else if (this.rankValue == hand.rankValue) {
            if (this.highestRankedvalue > hand.highestRankedvalue) {
                return 1;
            } else if (this.highestRankedvalue < hand.highestRankedvalue) {
                return -1;
            } else if (this.highestRankedvalue == hand.highestRankedvalue) {
                for (int i = 4; i >= 0; i--) {
                    if (this.values.get(i) == hand.getValues().get(i)) {
                        continue;
                    } else {
                        if (this.values.get(i) > hand.getValues().get(i)) {
                            return 1;
                        } else if (this.values.get(i) < hand.getValues().get(i)) {
                            return -1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
