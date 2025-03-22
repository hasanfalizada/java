package dev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathSumTwoWays {

    public static void main(String[] args) throws IOException {
        int[][] matrix = loadMatrix("0081_matrix.txt");
        int minimalPathSum = computeMinimalPathSum(matrix);
        System.out.println("Minimal path sum: " + minimalPathSum);
    }

    private static int[][] loadMatrix(String fileName) throws IOException {
        List<int[]> rows = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int[] row = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                row[i] = Integer.parseInt(values[i].trim());
            }
            rows.add(row);
        }
        br.close();
        return rows.toArray(new int[0][]);
    }

    private static int computeMinimalPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = matrix[0][0];

        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
