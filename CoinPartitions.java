package dev;

public class CoinPartitions {
    private static final int MODULO = 1_000_000;

    public static void main(String[] args) {
        int result = findLeastNDivisibleBy(MODULO);
        System.out.println("The least value of n for which p(n) is divisible by one million is: " + result);
    }

    public static int findLeastNDivisibleBy(int divisor) {
        // A reasonably large upper bound, we adjust if necessary
        int upperBound = 60000;
        int[] partition = new int[upperBound + 1];

        partition[0] = 1; // Base case: p(0) = 1

        for (int n = 1; n <= upperBound; n++) {
            int k = 1;
            int partitionSum = 0;

            while (true) {
                int pentagonal1 = k * (3 * k - 1) / 2;
                int pentagonal2 = k * (3 * k + 1) / 2;

                if (pentagonal1 > n) break;

                if ((k & 1) == 1) { // if k is odd
                    partitionSum += partition[n - pentagonal1];
                } else { // if k is even
                    partitionSum -= partition[n - pentagonal1];
                }

                if (pentagonal2 <= n) {
                    if ((k & 1) == 1) { // if k is odd
                        partitionSum += partition[n - pentagonal2];
                    } else { // if k is even
                        partitionSum -= partition[n - pentagonal2];
                    }
                }

                partitionSum %= MODULO;
                k++;
            }

            partition[n] = partitionSum;

            if (partition[n] == 0) {
                return n;
            }
        }

        return -1; // Not found within the given bound
    }
}


