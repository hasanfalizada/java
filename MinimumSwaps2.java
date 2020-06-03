package devjava;

public class MinimumSwaps2 {
	static int minimumSwaps(int[] arr) {
		int min_index = 0;
		int min = arr[0];
		int swaps = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min_index = i;
				min = arr[i];
			}
		}

		if (min_index != 0) {
			int temp = arr[0];
			arr[0] = arr[min_index];
			arr[min_index] = temp;
			swaps++;
		}

		for (int cur = 1; cur < arr.length - 1; cur++) {
			int pos = arr[cur] - arr[0];
			while (arr[pos] != arr[cur]) {
				int temp = arr[pos];
				arr[pos] = arr[cur];
				arr[cur] = temp;
				swaps++;
				pos = arr[cur] - arr[0];
			}
			cur = pos;
		}
		return swaps;
	}
}
