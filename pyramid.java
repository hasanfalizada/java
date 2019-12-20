package main;

public class Pyramid {

	static void printPyramidRightLine(int high) {
		for (int i = 2; i <= high; i++) {
			System.out.print(i);
		}
	}

	static void printPyramidLeftLine(int high) {
		for (int i = high; i >= 2; i--) {
			System.out.print(i);
		}
	}

	static void printPyramid(int high) {
		for (int j = 1; j <= high - 1; j++) {
			System.out.print(" ");
		}
		System.out.println(1);
		for (int i = 2; i <= high; i++) {
			for (int j = 1; j <= high - i; j++) {
				System.out.print(" ");
			}
			printPyramidLeftLine(i);
			System.out.print(1);
			printPyramidRightLine(i);
			System.out.println();
		}

	}

	public static void main(String[] args) {
		printPyramid(6);
	}
}
