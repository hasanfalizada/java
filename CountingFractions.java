package dev;

public class CountingFractions {
    public static void main(String[] args) {
        int limit = 1000000;
        long count = 0;

        // Array to store the totient of each number
        int[] totients = new int[limit + 1];
        for (int i = 0; i <= limit; i++) {
            totients[i] = i;
        }

        // Using the Sieve of Eratosthenes to compute totients
        for (int i = 2; i <= limit; i++) {
            if (totients[i] == i) { // i is a prime number
                for (int j = i; j <= limit; j += i) {
                    totients[j] = totients[j] / i * (i - 1);
                }
            }
        }

        // Summing up the totient values to count the reduced proper fractions
        for (int i = 2; i <= limit; i++) {
            count += totients[i];
        }

        System.out.println("Total number of reduced proper fractions with denominators up to " + limit + " is: " + count);
    }
}
