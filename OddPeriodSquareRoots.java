package dev;

public class OddPeriodSquareRoots {
    public static void main(String[] args) {
        int limit = 10000;
        int result = countOddPeriods(limit);
        System.out.println("The number of continued fractions for N <= " + limit + " with an odd period is: " + result);
    }

    public static int countOddPeriods(int limit) {
        int count = 0;
        for (int n = 2; n <= limit; n++) {
            if (!isSquare(n)) {
                if (getPeriod(n) % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private static int getPeriod(int n) {
        int period = 0;
        int a0 = (int) Math.sqrt(n);
        int m = 0;
        int d = 1;
        int a = a0;

        do {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (a0 + m) / d;
            period++;
        } while (a != 2 * a0);

        return period;
    }
}
