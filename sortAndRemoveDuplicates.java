package devjava;

public class Test {
	int[] sort(int[] a) {

		int buffer = 0;
		boolean flag;
		int dublicatesCount = 0;
		int arrayPointer = 0;

		do {
			flag = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					buffer = a[i];
					a[i] = a[i + 1];
					a[i + 1] = buffer;
					flag = true;
				}
			}
		} while (flag);

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] == a[i + 1]) {
				dublicatesCount++;
			}
		}

		if (dublicatesCount == 0) {
			return a;
		} else {

			int[] outArray = new int[a.length - dublicatesCount];

			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] != a[i + 1]) {
					outArray[arrayPointer] = a[i];
					arrayPointer++;
				}
			}

			outArray[arrayPointer] = a[a.length - 1];

			return outArray;
		}

	}

	public static void main(String[] args) {

	}

}