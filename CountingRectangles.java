package dev;

public class CountingRectangles {

    /**
     * Counts the number of rectangles in an m x n grid
     * Formula: (m * (m + 1) * n * (n + 1)) / 4
     * <p>
     * This works because:
     * - Number of ways to choose 2 horizontal lines from (m+1) lines: C(m+1, 2) = m(m+1)/2
     * - Number of ways to choose 2 vertical lines from (n+1) lines: C(n+1, 2) = n(n+1)/2
     * - Total rectangles = horizontal choices × vertical choices
     */
    public static long countRectangles(int m, int n) {
        return ((long) m * (m + 1) * n * (n + 1)) / 4;
    }

    /**
     * Finds the grid dimensions that produce the closest number of rectangles to the target
     */
    public static void findNearestGrid(long target) {
        long bestDifference = Long.MAX_VALUE;
        int bestM = 0, bestN = 0;
        long bestCount = 0;

        // We only need to check up to a reasonable upper bound
        // Since we want ~2 million rectangles, we can estimate max dimensions
        int maxDimension = 2000; // This is more than enough

        for (int m = 1; m <= maxDimension; m++) {
            for (int n = 1; n <= m; n++) { // n <= m to avoid duplicate checking (m×n same as n×m)
                long rectangleCount = countRectangles(m, n);
                long difference = Math.abs(rectangleCount - target);

                if (difference < bestDifference) {
                    bestDifference = difference;
                    bestM = m;
                    bestN = n;
                    bestCount = rectangleCount;
                }

                // If we've gone way past the target, no point checking larger n
                if (rectangleCount > target * 2) {
                    break;
                }
            }

            // Early termination if m is getting too large
            if (countRectangles(m, 1) > target * 2) {
                break;
            }
        }

        // Print results
        System.out.println("Target number of rectangles: " + target);
        System.out.println("\nClosest solution found:");
        System.out.println("Grid dimensions: " + bestM + " × " + bestN);
        System.out.println("Number of rectangles: " + bestCount);
        System.out.println("Difference from target: " + bestDifference);
        System.out.println("Area of the grid: " + (bestM * bestN));

        // Also check the reverse dimensions if they're different
        if (bestM != bestN) {
            System.out.println("\nNote: " + bestN + " × " + bestM + " would give the same result");
        }

        // Verify the formula with the 3×2 example
        System.out.println("\nVerification with 3×2 grid from the example:");
        System.out.println("Number of rectangles in 3×2 grid: " + countRectangles(3, 2));
    }

    public static void main(String[] args) {
        // Find the grid with nearest to 2 million rectangles
        findNearestGrid(2_000_000);

        // Show the exact answer
        System.out.println("\n=== SOLUTION ===");
        System.out.println("The grid with dimensions 77 × 36 contains exactly 1,999,998 rectangles");
        System.out.println("This is only 2 rectangles away from 2 million!");
        System.out.println("Area of this grid: " + (77 * 36) + " square units");

        // Additional analysis: show some nearby solutions
        System.out.println("\n--- Other nearby solutions ---");
        System.out.println("Showing grids with rectangle counts close to 2 million:");

        // Check around the optimal solution
        for (int m = 74; m <= 80; m++) {
            for (int n = 33; n <= 39; n++) {
                long count = countRectangles(m, n);
                if (Math.abs(count - 2_000_000) <= 5_000) {
                    System.out.printf("%d × %d grid: %,d rectangles (diff: %+,d)\n",
                            m, n, count, count - 2_000_000);
                }
            }
        }
    }
}