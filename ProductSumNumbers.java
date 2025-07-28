package dev;

import java.util.*;

public class ProductSumNumbers {
    private static Map<Integer, Integer> minProductSum = new HashMap<>();
    private static final int MAX_K = 12000;

    public static void main(String[] args) {
        // Find all minimal product-sum numbers
        findProductSums(2, 1, 0, 0);

        // Calculate the sum of all unique minimal product-sum numbers
        Set<Integer> uniqueNumbers = new HashSet<>(minProductSum.values());
        long sum = uniqueNumbers.stream().mapToLong(Integer::intValue).sum();

        System.out.println("Minimal product-sum numbers for k = 2 to " + MAX_K + ":");

        // Display some examples for verification
        for (int k = 2; k <= Math.min(20, MAX_K); k++) {
            if (minProductSum.containsKey(k)) {
                System.out.println("k = " + k + ": " + minProductSum.get(k));
            }
        }

        System.out.println("\nNumber of unique minimal product-sum numbers: " + uniqueNumbers.size());
        System.out.println("Sum of all minimal product-sum numbers for 2 ≤ k ≤ " + MAX_K + ": " + sum);
    }

    /**
     * Recursively finds product-sum numbers using depth-first search
     *
     * @param factor  current factor being considered (starts at 2)
     * @param product current product of factors
     * @param sum     current sum of factors
     * @param count   number of factors used so far
     */
    private static void findProductSums(int factor, long product, long sum, int count) {
        // Calculate k: the set size needed for this product-sum number
        // k = count + (product - sum)
        // The (product - sum) represents the number of 1's needed
        long k = count + product - sum;

        // Skip if k is too large or if product becomes too large
        if (k > MAX_K || product > 2 * MAX_K) {
            return;
        }

        // If we have at least 2 factors and k is valid, record this as a candidate
        if (count >= 2 && k >= 2) {
            int kInt = (int) k;
            int productInt = (int) product;

            // Only update if this is the first time we see this k or if we found a smaller product
            if (!minProductSum.containsKey(kInt) || minProductSum.get(kInt) > productInt) {
                minProductSum.put(kInt, productInt);
            }
        }

        // Continue the search by trying larger factors
        // We start from the current factor to avoid duplicate combinations
        for (int nextFactor = factor; nextFactor <= 2 * MAX_K / product; nextFactor++) {
            findProductSums(nextFactor, product * nextFactor, sum + nextFactor, count + 1);
        }
    }
}