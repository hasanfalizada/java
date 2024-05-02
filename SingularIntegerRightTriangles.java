package dev;

import java.util.HashMap;

public class SingularIntegerRightTriangles {
    public static void main(String[] args) {
        int limit = 1500000;
        HashMap<Integer, Integer> perimeterCount = new HashMap<>();

        // Generate Pythagorean triples
        int m_limit = (int) Math.sqrt(limit / 2);
        for (int m = 2; m <= m_limit; m++) {
            for (int n = 1; n < m; n++) {
                if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                    int a = m * m - n * n;
                    int b = 2 * m * n;
                    int c = m * m + n * n;
                    int p = a + b + c;
                    while (p <= limit) {
                        perimeterCount.put(p, perimeterCount.getOrDefault(p, 0) + 1);
                        p += (a + b + c);
                    }
                }
            }
        }

        // Count perimeters that occur exactly once
        int count = 0;
        for (int countValue : perimeterCount.values()) {
            if (countValue == 1) {
                count++;
            }
        }

        System.out.println("Number of unique perimeters: " + count);
    }

    // Helper function to compute GCD
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
