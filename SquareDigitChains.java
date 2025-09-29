package dev;

public class SquareDigitChains {

    // Method to calculate the sum of squares of digits
    public static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // Method to find the final destination of a number chain (1 or 89)
    public static int findDestination(int n) {
        while (n != 1 && n != 89) {
            n = sumOfSquares(n);
        }
        return n;
    }

    // Brute force approach - count all numbers below limit that arrive at 89
    public static long countNumbersArrivingAt89BruteForce(int limit) {
        long count = 0;
        for (int i = 1; i < limit; i++) {
            if (findDestination(i) == 89) {
                count++;
            }
        }
        return count;
    }

    // Optimized approach using digit combinations
    public static long countNumbersArrivingAt89Optimized(int limit) {
        // For numbers below 10 million, the maximum sum of squares of digits
        // is 7 * 9^2 = 567 (for 9999999)
        int maxSum = 567;

        // Precompute destinations for all possible sums
        boolean[] arrivesAt89 = new boolean[maxSum + 1];
        for (int i = 1; i <= maxSum; i++) {
            arrivesAt89[i] = (findDestination(i) == 89);
        }

        // Count digits in the limit
        String limitStr = String.valueOf(limit - 1);
        int numDigits = limitStr.length();

        // Use dynamic programming to count combinations
        return countCombinations(0, 0, numDigits, arrivesAt89, limitStr, true);
    }

    // Recursive function to count valid digit combinations
    private static long countCombinations(int pos, int sumSq, int maxDigits,
                                          boolean[] arrivesAt89, String limit, boolean tight) {
        // Base case: if we've placed all digits
        if (pos == maxDigits) {
            return (sumSq > 0 && arrivesAt89[sumSq]) ? 1 : 0;
        }

        long count = 0;
        int maxDigit = tight ? (limit.charAt(pos) - '0') : 9;

        // Try each possible digit
        for (int digit = 0; digit <= maxDigit; digit++) {
            boolean newTight = tight && (digit == maxDigit);
            int newSumSq = sumSq + digit * digit;

            // Only continue if the sum of squares is still valid
            if (newSumSq <= 567) {
                count += countCombinations(pos + 1, newSumSq, maxDigits,
                        arrivesAt89, limit, newTight);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test with the examples first
        System.out.println("Testing examples:");
        System.out.println("44 → " + findDestination(44));
        System.out.println("85 → " + findDestination(85));

        // Show the chain for 44
        System.out.println("\nChain for 44:");
        int n = 44;
        System.out.print(n);
        while (n != 1 && n != 89) {
            n = sumOfSquares(n);
            System.out.print(" → " + n);
        }
        System.out.println();

        // Show the chain for 85
        System.out.println("\nChain for 85:");
        n = 85;
        System.out.print(n);
        while (n != 1 && n != 89) {
            n = sumOfSquares(n);
            System.out.print(" → " + n);
        }
        System.out.println();

        // Test with smaller numbers first
        System.out.println("\nCounting numbers below 100 that arrive at 89:");
        long count100 = countNumbersArrivingAt89BruteForce(100);
        System.out.println("Count: " + count100);

        System.out.println("\nCounting numbers below 1000 that arrive at 89:");
        long count1000 = countNumbersArrivingAt89BruteForce(1000);
        System.out.println("Count: " + count1000);

        // For 10 million, use the optimized approach
        System.out.println("\nCounting numbers below 10 million that arrive at 89:");
        long startTime = System.currentTimeMillis();
        long count10M = countNumbersArrivingAt89Optimized(10_000_000);
        long endTime = System.currentTimeMillis();

        System.out.println("Count: " + count10M);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        // Calculate percentage
        double percentage = (count10M * 100.0) / 9_999_999;
        System.out.printf("Percentage: %.2f%%\n", percentage);
    }
}