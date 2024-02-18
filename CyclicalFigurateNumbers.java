package dev;

import java.util.*;

public class CyclicalFigurateNumbers {
    public static void main(String[] args) {
        int[] ranges = {1000, 9999};

        int[][] arrays = {
                generatePolygonalNumbers(3, ranges),
                generatePolygonalNumbers(4, ranges),
                generatePolygonalNumbers(5, ranges),
                generatePolygonalNumbers(6, ranges),
                generatePolygonalNumbers(7, ranges),
                generatePolygonalNumbers(8, ranges)
        };
        ArrayList<int[]> permutations = new ArrayList<>();

        ArrayList<int[][]> arraysPermutations = new ArrayList<>();

        generateArraysPermutations(arrays, 0, arraysPermutations);

        for (int[][] permutation : arraysPermutations) {
            for (int i = 0; i < permutation[0].length; i++) {
                for (int j = 0; j < permutation[1].length; j++) {
                    if (isCyclical(permutation[0][i], permutation[1][j])) {
                        for (int k = 0; k < permutation[2].length; k++) {
                            if (isCyclical(permutation[1][j], permutation[2][k])) {
                                for (int l = 0; l < permutation[3].length; l++) {
                                    if (isCyclical(permutation[2][k], permutation[3][l])) {
                                        for (int m = 0; m < permutation[4].length; m++) {
                                            if (isCyclical(permutation[3][l], permutation[4][m])) {
                                                for (int n = 0; n < permutation[5].length; n++) {
                                                    if (isCyclical(permutation[4][m], permutation[5][n]) && isCyclical(permutation[5][n], permutation[0][i])) {
                                                        System.out.println(permutation[0][i] + " " + permutation[1][j] + " " + permutation[2][k] + " " + permutation[3][l] + " " +
                                                                permutation[4][m] + " " + permutation[5][n]);
                                                        return;
                                                    }

                                                }
                                            }

                                        }
                                    }

                                }
                            }

                        }
                    }

                }
            }
        }
    }

    public static int[] generatePolygonalNumbers(int sides, int[] range) {
        ArrayList<Integer> polygonalNumbers = new ArrayList<>();
        int n = 1;
        int currentNumber = 0;
        while (true) {
            currentNumber = (sides - 2) * n * (n - 1) / 2 + n;
            if (currentNumber > range[1]) break;
            if (currentNumber >= range[0]) {
                polygonalNumbers.add(currentNumber);
            }
            n++;
        }
        // Convert ArrayList to int array
        return polygonalNumbers.stream().mapToInt(i -> i).toArray();
    }

    public static boolean isCyclical(int a, int b) {
        return (a % 100) == (b / 100);
    }

    public static void generateArraysPermutations(int[][] elements, int index, ArrayList<int[][]> permutations) {
        if (index == elements.length - 1) {
            permutations.add(elements.clone());
            return;
        }

        for (int i = index; i < elements.length; i++) {
            swapArrays(elements, index, i);
            generateArraysPermutations(elements, index + 1, permutations);
            swapArrays(elements, index, i); // Backtrack
        }
    }

    public static void swapArrays(int[][] elements, int i, int j) {
        int[] temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

}
