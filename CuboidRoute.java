package dev;

public class CuboidRoute {

    public static void main(String[] args) {
        // Find the least value of M
        int M = findLeastM(1_000_000);
        System.out.println("The least value of M such that the number of solutions first exceeds 1,000,000 is: " + M);
    }

    static long countSolutions(int M) {
        long count = 0;

        // For a cuboid with dimensions a ≤ b ≤ c, we need one of these to be a perfect square:
        // (a+b)² + c² or (a+c)² + b² or (b+c)² + a²

        // Use a different approach: for each pair (x, y) where x² + y² is a perfect square,
        // count how many valid cuboids can be formed

        // We'll iterate through all Pythagorean triples and their multiples
        for (int m = 2; m * m <= 2 * M; m++) {
            for (int n = 1; n < m; n++) {
                if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                    // Generate primitive Pythagorean triple
                    int a = m * m - n * n;
                    int b = 2 * m * n;
                    int c = m * m + n * n;

                    // Consider all multiples of this triple
                    for (int k = 1; k * c <= 2 * M; k++) {
                        int x = k * a;
                        int y = k * b;

                        // For each way to split x or y into two parts
                        count += countCuboids(x, y, M);
                        if (x != y) {
                            count += countCuboids(y, x, M);
                        }
                    }
                }
            }
        }

        return count;
    }

    static long countCuboids(int sum, int other, int M) {
        long count = 0;

        // sum = a + b, other = c
        // We need a ≤ b ≤ c ≤ M
        if (other <= M) {
            for (int a = 1; 2 * a <= sum && a <= other; a++) {
                int b = sum - a;
                if (b <= M && b >= a && b <= other) {
                    count++;
                }
            }
        }

        // sum = a + c, other = b
        // We need a ≤ b ≤ c ≤ M
        for (int a = 1; a <= other && a <= M; a++) {
            int c = sum - a;
            if (c >= other && c <= M) {
                count++;
            }
        }

        return count;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Optimized approach using dynamic counting
    static long countSolutionsOptimized(int M) {
        long count = 0;

        // For each c from 1 to M
        for (int c = 1; c <= M; c++) {
            // For each possible sum (a+b) where a ≤ b ≤ c
            for (int sum = 2; sum <= 2 * c; sum++) {
                if (isPerfectSquare((long) sum * sum + (long) c * c)) {
                    // Count valid pairs (a,b) where a+b = sum, a ≤ b ≤ c
                    int minA = Math.max(1, sum - c);
                    int maxA = Math.min(sum / 2, c);
                    if (maxA >= minA) {
                        count += (maxA - minA + 1);
                    }
                }
            }
        }

        return count;
    }

    static boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    static int findLeastM(int target) {
        // Binary search for efficiency
        int low = 1, high = 2000;

        while (low < high) {
            int mid = (low + high) / 2;
            long count = countSolutionsOptimized(mid);

            System.out.println("M = " + mid + ", solutions = " + count);

            if (count <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}