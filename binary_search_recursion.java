public class Test {

	public static int binarySearch(int[] A, int left, int right, int x) {

		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;

		if (x == A[mid]) {
			return mid;
		} else if (x < A[mid]) {
			return binarySearch(A, left, mid - 1, x);
		} else {
			return binarySearch(A, mid + 1, right, x);
		}
	}

	public static void main(String[] args) {
		int[] list = { 2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79 };
		System.out.println(binarySearch(list, 0, list.length - 1, 50));
	}
}
