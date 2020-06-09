package devjava;

public class ArrayManipulation {
	static long arrayManipulation(int n, int[][] queries) {
		long max = Integer.MIN_VALUE;
		long[] D = new long[n + 1];
		long[] A = new long[n];
		D[0] = A[0];
		D[n] = 0L;
		for (int i = 1; i < n; i++)
			D[i] = A[i] - A[i - 1];

		for (int i = 0; i < queries.length; i++) {
			int[] q = queries[i];
			int a = q[0];
			int b = q[1];
			int k = q[2];
			update(D, a - 1, b - 1, k);
		}

		for (int i = 0; i < A.length; i++) {

			if (i == 0)
				A[i] = D[i];
			else {
				A[i] = D[i] + A[i - 1];
				if (A[i] > max)
					max = A[i];
			}
		}
		return max;
	}

	static void update(long D[], int l, int r, int x) {
		D[l] += x;
		D[r + 1] -= x;
	}
}
