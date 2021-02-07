package devjava;

public class Permutations {
	public static <T> void printAllRecursive(int n, T[] elements, char delimiter) {

		if (n == 1) {
			printArray(elements);
		} else {
			for (int i = 0; i < n - 1; i++) {
				printAllRecursive(n - 1, elements, delimiter);
				if (n % 2 == 0) {
					swap(elements, i, n - 1);
				} else {
					swap(elements, 0, n - 1);
				}
			}
			printAllRecursive(n - 1, elements, delimiter);
		}
	}

	private static <T> void swap(T[] input, int a, int b) {
		T tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	private static <T> void printArray(T[] input) {
		System.out.print('\n');
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
	}

	public static void main(String[] args) {
		Character[] temp = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		printAllRecursive(9, temp, ',');
	}
}
