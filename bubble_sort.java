package test;

public class Test {

	public static void main(String args[]) {
		int[] pro = { 5, 1, 2, 3, 9, 11, 10, 14 };

///////////////////////////////// BEFORE SORTING //////////////////////////////

		for (int i : pro) {
			System.out.print(i + " ");
		}
		System.out.println();

		int temp = 0;
		boolean swapped = false;

		for (int i = 0; i < pro.length - 1; i++) {
			swapped = false;

			for (int j = 0; j < pro.length - i - 1; j++) {
				if (pro[j] > pro[j + 1]) {
					temp = pro[j];
					pro[j] = pro[j + 1];
					pro[j + 1] = temp;
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}

///////////////////////////////// AFTER SORTING //////////////////////////////

		for (int i : pro) {
			System.out.print(i + " ");
		}

	}
}
