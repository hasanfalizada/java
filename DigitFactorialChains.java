package dev;

import java.util.HashMap;
import java.util.Map;

public class DigitFactorialChains {
    private static final int[] factorial = new int[10];

    static {
        factorial[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        int limit = 1000000;
        int exactChainCount = 0;

        for (int i = 1; i < limit; i++) {
            if (calculateNonRepeatingChainLength(i) == 60) {
                exactChainCount++;
            }
        }

        System.out.println("Number of starting numbers below " + limit + " with exactly 60 non-repeating terms: " + exactChainCount);
    }

    private static int calculateNonRepeatingChainLength(int start) {
        Map<Integer, Integer> seen = new HashMap<>();
        int current = start;
        int count = 0;

        while (!seen.containsKey(current)) {
            seen.put(current, count);
            count++;
            current = factorialDigitSum(current);
        }

        // We need the total number of unique terms before any repetition
        int nonRepeatingLength = count;

        return nonRepeatingLength;
    }

    private static int factorialDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += factorial[number % 10];
            number /= 10;
        }
        return sum;
    }
}
