package dev;

public class PrimeSummations {
    public static void main(String[] args) {
        int targetWays = 5000;
        int[] primes = generatePrimesUpTo(targetWays); // Generate primes up to the targetWays

        int[] ways = new int[1000000]; // Assuming the answer is within 1 million
        ways[0] = 1; // Base case: there is one way to make 0 (using no primes)

        for (int prime : primes) {
            for (int i = prime; i < ways.length; i++) {
                ways[i] += ways[i - prime];
            }
        }

        int result = 0;
        while (ways[result] <= targetWays) {
            result++;
        }

        System.out.println("The first value that can be written as the sum of primes in over " + targetWays + " different ways is: " + result);
    }

    private static int[] generatePrimesUpTo(int n) {
        boolean[] isComposite = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        int count = 0;
        for (boolean composite : isComposite) {
            if (!composite) {
                count++;
            }
        }

        int[] primes = new int[count - 2]; // Exclude 0 and 1
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes[index++] = i;
            }
        }

        return primes;
    }
}
