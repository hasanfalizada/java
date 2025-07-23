package dev;

import java.util.*;

public class PrimePowerTriples {
    private static final int LIMIT = 50_000_000;

    public static void main(String[] args) {
        System.out.println("Finding numbers below " + LIMIT + " expressible as prime^2 + prime^3 + prime^4");

        // Generate primes - need different limits for different powers
        // For prime^4 < 50M, we need primes up to (50M)^(1/4) ≈ 236
        // For prime^3 < 50M, we need primes up to (50M)^(1/3) ≈ 368
        // For prime^2 < 50M, we need primes up to (50M)^(1/2) ≈ 7071
        int maxPrime = (int) Math.sqrt(LIMIT) + 100;
        List<Integer> primes = sievePrimes(maxPrime);
        System.out.println("Generated " + primes.size() + " primes up to " + maxPrime);

        // Pre-calculate prime powers to avoid repeated computation
        List<Long> primeSquares = new ArrayList<>();
        List<Long> primeCubes = new ArrayList<>();
        List<Long> primeFourths = new ArrayList<>();

        for (int prime : primes) {
            long square = (long) prime * prime;
            long cube = (long) prime * prime * prime;
            long fourth = (long) prime * prime * prime * prime;

            if (square < LIMIT) primeSquares.add(square);
            if (cube < LIMIT) primeCubes.add(cube);
            if (fourth < LIMIT) primeFourths.add(fourth);
        }

        System.out.println("Prime squares: " + primeSquares.size());
        System.out.println("Prime cubes: " + primeCubes.size());
        System.out.println("Prime fourths: " + primeFourths.size());

        // Use a Set to store unique expressible numbers
        Set<Integer> expressible = new HashSet<>();

        // Generate all combinations
        for (long square : primeSquares) {
            for (long cube : primeCubes) {
                if (square + cube >= LIMIT) continue;

                for (long fourth : primeFourths) {
                    long sum = square + cube + fourth;
                    if (sum >= LIMIT) break;

                    expressible.add((int) sum);
                }
            }
        }

        System.out.println("\nResult: " + expressible.size() + " numbers below " + LIMIT +
                " can be expressed as prime^2 + prime^3 + prime^4");

        // Verify the given examples and show their decompositions
        System.out.println("\nVerifying given examples:");
        verifyAndDecompose(28, primes);
        verifyAndDecompose(33, primes);
        verifyAndDecompose(49, primes);
        verifyAndDecompose(47, primes);

        // Show some of the smallest expressible numbers
        List<Integer> sortedNumbers = new ArrayList<>(expressible);
        Collections.sort(sortedNumbers);

        System.out.println("\nSmallest 20 expressible numbers:");
        for (int i = 0; i < Math.min(20, sortedNumbers.size()); i++) {
            System.out.print(sortedNumbers.get(i) + " ");
        }
        System.out.println();
    }

    private static List<Integer> sievePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static void verifyAndDecompose(int target, List<Integer> primes) {
        System.out.print(target + " = ");
        boolean found = false;

        // Try to find a decomposition
        for (int p1 : primes) {
            long square = (long) p1 * p1;
            if (square >= target) break;

            for (int p2 : primes) {
                long cube = (long) p2 * p2 * p2;
                if (square + cube >= target) break;

                for (int p3 : primes) {
                    long fourth = (long) p3 * p3 * p3 * p3;
                    if (square + cube + fourth == target) {
                        System.out.println(p1 + "² + " + p2 + "³ + " + p3 + "⁴ = " +
                                square + " + " + cube + " + " + fourth);
                        found = true;
                        break;
                    }
                    if (square + cube + fourth > target) break;
                }
                if (found) break;
            }
            if (found) break;
        }

        if (!found) {
            System.out.println("No decomposition found!");
        }
    }
}