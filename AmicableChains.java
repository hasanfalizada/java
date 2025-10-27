package dev;

import java.util.*;

public class AmicableChains {
    private static final int LIMIT = 1_000_000;
    private static int[] sumOfProperDivisors;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Precompute sum of proper divisors for all numbers up to LIMIT
        computeSumOfProperDivisors();

        int longestChainLength = 0;
        int smallestInLongestChain = Integer.MAX_VALUE;
        boolean[] visited = new boolean[LIMIT + 1];

        // Check each number as a potential start of an amicable chain
        for (int start = 1; start <= LIMIT; start++) {
            if (visited[start]) continue;

            List<Integer> chain = findAmicableChain(start);

            if (chain.size() > 1) { // Valid amicable chain found
                // Mark all numbers in this chain as visited
                for (int num : chain) {
                    if (num <= LIMIT) {
                        visited[num] = true;
                    }
                }

                // Check if this is the longest chain so far
                if (chain.size() > longestChainLength) {
                    longestChainLength = chain.size();
                    smallestInLongestChain = Collections.min(chain);
                    System.out.println("New longest chain found:");
                    System.out.println("Length: " + chain.size());
                    System.out.println("Chain: " + chain);
                    System.out.println("Smallest member: " + smallestInLongestChain);
                    System.out.println();
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Final Result:");
        System.out.println("Longest amicable chain length: " + longestChainLength);
        System.out.println("Smallest member: " + smallestInLongestChain);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    /**
     * Precompute sum of proper divisors for all numbers up to LIMIT using sieve approach
     */
    private static void computeSumOfProperDivisors() {
        sumOfProperDivisors = new int[LIMIT + 1];

        // For each potential divisor i, add it to all its multiples
        for (int i = 1; i <= LIMIT / 2; i++) {
            for (int j = 2 * i; j <= LIMIT; j += i) {
                sumOfProperDivisors[j] += i;
            }
        }
    }

    /**
     * Find the amicable chain starting from the given number
     * Returns the complete chain if it's valid, or empty list if not amicable
     */
    private static List<Integer> findAmicableChain(int start) {
        List<Integer> chain = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        int current = start;

        // Follow the chain until we either:
        // 1. Return to start (valid amicable chain)
        // 2. Go outside our limit
        // 3. Encounter a cycle that doesn't include start
        // 4. Reach a dead end (number maps to itself or 0)
        while (true) {
            if (current <= 0 || current > LIMIT) {
                return new ArrayList<>(); // Invalid chain
            }

            if (current == start && !chain.isEmpty()) {
                return chain; // Valid amicable chain found
            }

            if (seen.contains(current)) {
                return new ArrayList<>(); // Cycle that doesn't include start
            }

            chain.add(current);
            seen.add(current);

            int next = sumOfProperDivisors[current];

            if (next == current) {
                // Perfect number (maps to itself) - not part of amicable chain
                return new ArrayList<>();
            }

            current = next;

            // Prevent infinite loops by limiting chain length
            if (chain.size() > 100) {
                return new ArrayList<>();
            }
        }
    }
}