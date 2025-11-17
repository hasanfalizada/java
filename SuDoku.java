package dev;

import java.io.*;
import java.util.*;

public class SuDoku {

    public static void main(String[] args) {
        try {
            List<int[][]> puzzles = readPuzzles("sudoku.txt");
            int totalSum = 0;

            for (int i = 0; i < puzzles.size(); i++) {
                int[][] puzzle = puzzles.get(i);
                if (solve(puzzle)) {
                    int topLeftNumber = puzzle[0][0] * 100 + puzzle[0][1] * 10 + puzzle[0][2];
                    totalSum += topLeftNumber;
                    System.out.println("Puzzle " + (i + 1) + " - Top left number: " + topLeftNumber);
                } else {
                    System.out.println("Puzzle " + (i + 1) + " - No solution found");
                }
            }

            System.out.println("\nSum of all top-left 3-digit numbers: " + totalSum);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static List<int[][]> readPuzzles(String filename) throws IOException {
        List<int[][]> puzzles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Grid")) {
                int[][] puzzle = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    line = reader.readLine();
                    for (int j = 0; j < 9; j++) {
                        puzzle[i][j] = line.charAt(j) - '0';
                    }
                }
                puzzles.add(puzzle);
            }
        }
        reader.close();
        return puzzles;
    }

    private static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true; // All cells filled
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num) {
                return false;
            }
        }

        // Check column
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if (j == 2 || j == 5) System.out.print("| ");
            }
            System.out.println();
            if (i == 2 || i == 5) System.out.println("------+-------+------");
        }
    }
}