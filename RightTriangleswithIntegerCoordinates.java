package dev;

public class RightTriangleswithIntegerCoordinates {

    public static void main(String[] args) {
        // Test with the given constraints
        int maxCoord = 50;
        int count = countRightTriangles(maxCoord);
        System.out.println("Number of right triangles with coordinates from 0 to " + maxCoord + ": " + count);

        // Test with the example from the problem (coordinates 0 to 2)
        int smallCount = countRightTriangles(2);
        System.out.println("Number of right triangles with coordinates from 0 to 2: " + smallCount);
    }

    /**
     * Counts the number of right triangles that can be formed by connecting
     * two points P(x1, y1) and Q(x2, y2) to the origin O(0, 0).
     *
     * @param maxCoord Maximum coordinate value (inclusive)
     * @return Number of right triangles
     */
    public static int countRightTriangles(int maxCoord) {
        int count = 0;

        // Iterate through all possible combinations of two points
        for (int x1 = 0; x1 <= maxCoord; x1++) {
            for (int y1 = 0; y1 <= maxCoord; y1++) {
                for (int x2 = 0; x2 <= maxCoord; x2++) {
                    for (int y2 = 0; y2 <= maxCoord; y2++) {

                        // Skip if both points are at origin or if points are identical
                        if ((x1 == 0 && y1 == 0) || (x2 == 0 && y2 == 0) ||
                                (x1 == x2 && y1 == y2)) {
                            continue;
                        }

                        // Check if triangle OPQ has a right angle
                        if (hasRightAngle(x1, y1, x2, y2)) {
                            count++;
                        }
                    }
                }
            }
        }

        // Each triangle is counted twice (once for P,Q and once for Q,P)
        return count / 2;
    }

    /**
     * Checks if triangle OPQ has a right angle where O is origin (0,0),
     * P is (x1, y1), and Q is (x2, y2).
     *
     * @param x1, y1 Coordinates of point P
     * @param x2, y2 Coordinates of point Q
     * @return true if triangle has a right angle
     */
    private static boolean hasRightAngle(int x1, int y1, int x2, int y2) {
        // Case 1: Right angle at origin O
        // Vectors OP = (x1, y1) and OQ = (x2, y2)
        // Dot product: x1*x2 + y1*y2
        if (x1 * x2 + y1 * y2 == 0) {
            return true;
        }

        // Case 2: Right angle at point P
        // Vectors PO = (-x1, -y1) and PQ = (x2-x1, y2-y1)
        // Dot product: (-x1)*(x2-x1) + (-y1)*(y2-y1) = -x1*(x2-x1) - y1*(y2-y1)
        if (-x1 * (x2 - x1) - y1 * (y2 - y1) == 0) {
            return true;
        }

        // Case 3: Right angle at point Q
        // Vectors QO = (-x2, -y2) and QP = (x1-x2, y1-y2)
        // Dot product: (-x2)*(x1-x2) + (-y2)*(y1-y2) = -x2*(x1-x2) - y2*(y1-y2)
        if (-x2 * (x1 - x2) - y2 * (y1 - y2) == 0) {
            return true;
        }

        return false;
    }

    /**
     * Alternative method that shows detailed analysis for smaller coordinate ranges
     */
    public static void analyzeSmallRange(int maxCoord) {
        System.out.println("\nDetailed analysis for coordinates 0 to " + maxCoord + ":");
        int count = 0;

        for (int x1 = 0; x1 <= maxCoord; x1++) {
            for (int y1 = 0; y1 <= maxCoord; y1++) {
                for (int x2 = x1; x2 <= maxCoord; x2++) {
                    for (int y2 = (x2 == x1 ? y1 + 1 : 0); y2 <= maxCoord; y2++) {

                        // Skip if both points are at origin
                        if ((x1 == 0 && y1 == 0) || (x2 == 0 && y2 == 0)) {
                            continue;
                        }

                        if (hasRightAngle(x1, y1, x2, y2)) {
                            count++;
                            System.out.printf("Right triangle: O(0,0), P(%d,%d), Q(%d,%d)%n",
                                    x1, y1, x2, y2);
                        }
                    }
                }
            }
        }

        System.out.println("Total right triangles: " + count);
    }
}