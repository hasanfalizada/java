package dev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathSumThreeWays {
    public static void main(String[] args) throws IOException {
        int[][] matrix = readMatrix("0082_matrix.txt");
        int n = matrix.length;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][n - 1] = matrix[i][n - 1]; // Start from last column
        }

        for (int col = n - 2; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                dp[row][col] = matrix[row][col] + dp[row][col + 1];
            }

            // Move upwards
            for (int row = 1; row < n; row++) {
                dp[row][col] = Math.min(dp[row][col], matrix[row][col] + dp[row - 1][col]);
            }

            // Move downwards
            for (int row = n - 2; row >= 0; row--) {
                dp[row][col] = Math.min(dp[row][col], matrix[row][col] + dp[row + 1][col]);
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int row = 0; row < n; row++) {
            minSum = Math.min(minSum, dp[row][0]);
        }

        System.out.println("Minimal path sum from left to right: " + minSum);
    }

    private static int[][] readMatrix(String filename) throws IOException {
        List<int[]> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            int[] row = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                row[i] = Integer.parseInt(parts[i]);
            }
            lines.add(row);
        }
        br.close();
        return lines.toArray(new int[0][0]);
    }
}
