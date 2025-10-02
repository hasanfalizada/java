package dev;

import java.util.*;

public class ArithmeticExpressions {

    public static void main(String[] args) {
        String result = findBestDigitSet();
        System.out.println("Best digit set: " + result);
    }

    public static String findBestDigitSet() {
        int maxConsecutive = 0;
        String bestSet = "";

        // Try all combinations of 4 distinct digits
        for (int a = 0; a <= 9; a++) {
            for (int b = a + 1; b <= 9; b++) {
                for (int c = b + 1; c <= 9; c++) {
                    for (int d = c + 1; d <= 9; d++) {
                        int[] digits = {a, b, c, d};
                        Set<Integer> reachable = getAllReachableNumbers(digits);

                        int consecutive = countConsecutiveFromOne(reachable);

                        if (consecutive > maxConsecutive) {
                            maxConsecutive = consecutive;
                            bestSet = "" + a + b + c + d;
                            System.out.println("Found: " + bestSet + " with " + maxConsecutive + " consecutive");
                        }
                    }
                }
            }
        }

        System.out.println("Maximum consecutive: " + maxConsecutive);
        return bestSet;
    }

    private static int countConsecutiveFromOne(Set<Integer> numbers) {
        int count = 0;
        int current = 1;
        while (numbers.contains(current)) {
            count++;
            current++;
        }
        return count;
    }

    private static Set<Integer> getAllReachableNumbers(int[] digits) {
        Set<Integer> results = new HashSet<>();

        // Generate all permutations of the 4 digits
        List<int[]> perms = generatePermutations(digits);

        // For each permutation, try all expression structures
        for (int[] perm : perms) {
            results.addAll(evaluateAllExpressions(perm));
        }

        return results;
    }

    private static Set<Integer> evaluateAllExpressions(int[] nums) {
        Set<Integer> results = new HashSet<>();

        // Convert to doubles for calculation
        double[] values = new double[4];
        for (int i = 0; i < 4; i++) {
            values[i] = nums[i];
        }

        // Try all expression structures with all operator combinations
        char[] ops = {'+', '-', '*', '/'};

        for (char op1 : ops) {
            for (char op2 : ops) {
                for (char op3 : ops) {
                    // Structure 1: ((a op1 b) op2 c) op3 d
                    addResult(results, evalTree1(values[0], values[1], values[2], values[3], op1, op2, op3));

                    // Structure 2: (a op1 (b op2 c)) op3 d
                    addResult(results, evalTree2(values[0], values[1], values[2], values[3], op1, op2, op3));

                    // Structure 3: (a op1 b) op2 (c op3 d)
                    addResult(results, evalTree3(values[0], values[1], values[2], values[3], op1, op2, op3));

                    // Structure 4: a op1 ((b op2 c) op3 d)
                    addResult(results, evalTree4(values[0], values[1], values[2], values[3], op1, op2, op3));

                    // Structure 5: a op1 (b op2 (c op3 d))
                    addResult(results, evalTree5(values[0], values[1], values[2], values[3], op1, op2, op3));
                }
            }
        }

        return results;
    }

    private static void addResult(Set<Integer> results, Double value) {
        if (value != null && !Double.isNaN(value) && !Double.isInfinite(value)) {
            // Check if it's a positive integer (with small tolerance for floating point errors)
            double rounded = Math.round(value);
            if (rounded > 0 && rounded <= 1000000 && Math.abs(value - rounded) < 1e-9) {
                results.add((int) rounded);
            }
        }
    }

    // ((a op1 b) op2 c) op3 d
    private static Double evalTree1(double a, double b, double c, double d, char op1, char op2, char op3) {
        Double step1 = apply(a, b, op1);
        if (step1 == null) return null;
        Double step2 = apply(step1, c, op2);
        if (step2 == null) return null;
        return apply(step2, d, op3);
    }

    // (a op1 (b op2 c)) op3 d
    private static Double evalTree2(double a, double b, double c, double d, char op1, char op2, char op3) {
        Double step1 = apply(b, c, op2);
        if (step1 == null) return null;
        Double step2 = apply(a, step1, op1);
        if (step2 == null) return null;
        return apply(step2, d, op3);
    }

    // (a op1 b) op2 (c op3 d)
    private static Double evalTree3(double a, double b, double c, double d, char op1, char op2, char op3) {
        Double step1 = apply(a, b, op1);
        if (step1 == null) return null;
        Double step2 = apply(c, d, op3);
        if (step2 == null) return null;
        return apply(step1, step2, op2);
    }

    // a op1 ((b op2 c) op3 d)
    private static Double evalTree4(double a, double b, double c, double d, char op1, char op2, char op3) {
        Double step1 = apply(b, c, op2);
        if (step1 == null) return null;
        Double step2 = apply(step1, d, op3);
        if (step2 == null) return null;
        return apply(a, step2, op1);
    }

    // a op1 (b op2 (c op3 d))
    private static Double evalTree5(double a, double b, double c, double d, char op1, char op2, char op3) {
        Double step1 = apply(c, d, op3);
        if (step1 == null) return null;
        Double step2 = apply(b, step1, op2);
        if (step2 == null) return null;
        return apply(a, step2, op1);
    }

    private static Double apply(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return (b != 0) ? a / b : null;
            default:
                return null;
        }
    }

    private static List<int[]> generatePermutations(int[] arr) {
        List<int[]> result = new ArrayList<>();
        permuteHelper(arr, 0, result);
        return result;
    }

    private static void permuteHelper(int[] arr, int start, List<int[]> result) {
        if (start == arr.length) {
            result.add(arr.clone());
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permuteHelper(arr, start + 1, result);
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}