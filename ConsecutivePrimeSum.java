package dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConsecutivePrimeSum {
    static int[] primes(int n) {
        boolean prime[] = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        ///////////////
        int limit = 1_000_000;
        int[] primesArray = primes(limit);
        int counter = 0;
        int sum = 0;

        int maxSum = 0;
        int maxCount = 0;

        for (int i = 0; i < primesArray.length; i++) {
            for (int j = i; j < primesArray.length; j++) {
                if (sum >= limit) {
                    break;
                }
                sum += primesArray[j];
                counter++;

                if (Arrays.binarySearch(primesArray, sum) >= 0 && counter > maxCount) {
                    maxSum = sum;
                    maxCount = counter;
                }
            }
            counter = 0;
            sum = 0;
        }

        System.out.println(maxSum + " (" + maxCount + ")");

        //////////////;

        long endTime = System.nanoTime();

        System.out.println("Took " + ((endTime - startTime) / 1000000) + " milliseconds to run.");

    }
}
