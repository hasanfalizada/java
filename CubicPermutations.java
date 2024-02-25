package dev;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CubePermutations {
    public static void main(String[] args) {
        Map<String, Integer> cubeCounts = new HashMap<>();
        Map<String, Long> cubeValues = new HashMap<>();
        int n = 1;

        while (true) {
            long cube = (long) n * n * n;
            char[] digits = Long.toString(cube).toCharArray();
            Arrays.sort(digits);
            String sortedDigits = new String(digits);

            // Count the number of times this permutation of digits has been seen
            cubeCounts.put(sortedDigits, cubeCounts.getOrDefault(sortedDigits, 0) + 1);
            // Store the smallest cube for this set of digits
            if (!cubeValues.containsKey(sortedDigits)) {
                cubeValues.put(sortedDigits, cube);
            }

            if (cubeCounts.get(sortedDigits) == 5) {
                System.out.println("The smallest cube for which exactly five permutations of its digits are cube is: " + cubeValues.get(sortedDigits));
                break;
            }

            n++;
        }
    }
}

