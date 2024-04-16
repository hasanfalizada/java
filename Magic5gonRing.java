package dev;

public class Magic5gonRing {
    private static final int SIZE = 5;
    private static String max16DigitString = "";
    private static String max17DigitString = "";

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        permute(numbers, 0);
        System.out.println("Maximum 16-digit string: " + max16DigitString);
        System.out.println("Maximum 17-digit string: " + max17DigitString);
    }

    private static void permute(int[] array, int k) {
        if (k == array.length) {
            checkAndSetMaxString(array);
        } else {
            for (int i = k; i < array.length; i++) {
                swap(array, i, k);
                permute(array, k + 1);
                swap(array, k, i); // backtrack
            }
        }
    }

    private static void checkAndSetMaxString(int[] array) {
        // Assuming array[0] to array[4] are the external nodes
        // and array[5] to array[9] are the internal nodes
        int sum = array[0] + array[5] + array[6]; // first group sum

        for (int i = 1; i < SIZE; i++) {
            if (array[i] + array[(i % SIZE) + 5] + array[(i + 1) % SIZE + 5] != sum)
                return; // not a valid magic ring
        }

        // Build the string representation starting with the smallest external node
        int minExternalIndex = 0;
        for (int i = 1; i < SIZE; i++) {
            if (array[i] < array[minExternalIndex]) {
                minExternalIndex = i;
            }
        }

        StringBuilder ringString = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            int idx = (minExternalIndex + i) % SIZE;
            ringString.append(array[idx]);
            ringString.append(array[(idx % SIZE) + 5]);
            ringString.append(array[(idx + 1) % SIZE + 5]);
        }

        String currentString = ringString.toString();
        if (currentString.length() == 16 && currentString.compareTo(max16DigitString) > 0) {
            max16DigitString = currentString;
        } else if (currentString.length() == 17 && currentString.compareTo(max17DigitString) > 0) {
            max17DigitString = currentString;
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
