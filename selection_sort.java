public class Dev {
	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}

	public static void printArray(int[] list) {
		for (int i = 0; i <= list.length - 1; i++) {
			System.out.print(list[i] + ",");
		}
	}

	public static void main(String[] args) {
		int[] list = { 8, 3, 1, 5, 7, 1 };
		printArray(list);
		selectionSort(list);
		System.out.println();
		printArray(list);

	}
}