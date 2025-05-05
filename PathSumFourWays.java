package dev;

import java.util.*;

public class PathSumFourWays {
    static class Cell implements Comparable<Cell> {
        int row, col, cost;

        Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        public int compareTo(Cell other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static int minimalPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(0, 0, matrix[0][0]));
        dist[0][0] = matrix[0][0];

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Cell current = pq.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dRow[i];
                int newCol = current.col + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    int newCost = dist[current.row][current.col] + matrix[newRow][newCol];
                    if (newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        pq.offer(new Cell(newRow, newCol, newCost));
                    }
                }
            }
        }

        return dist[n - 1][n - 1];
    }

    public static void main(String[] args) throws Exception {
        // Load the matrix from a file or define it directly here
        // Here's an example for loading a matrix from a file:

        Scanner scanner = new Scanner(new java.io.File("C:\\Users\\ha\\Desktop\\0083_matrix.txt"));
        List<int[]> matrixList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            int[] row = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
            matrixList.add(row);
        }
        scanner.close();

        int[][] matrix = matrixList.toArray(new int[0][0]);

        int result = minimalPathSum(matrix);
        System.out.println("Minimal path sum: " + result);
    }
}