import java.util.Arrays;

class InsertionSort {
    public static void main(String[] args) {

        int[] intArray = new int[] { 5, 3, 7, 9, 2 };
        int key;
        int j;

        System.out.println(Arrays.toString(intArray));

        for (int i = 1; i < intArray.length; i++) {
            key = intArray[i];
            j = i - 1;
            while (j >= 0 && intArray[j] > key) {
                intArray[j + 1] = intArray[j];
                j -= 1;

            }
            intArray[j + 1] = key;

        }

        System.out.println(Arrays.toString(intArray));
    }
}