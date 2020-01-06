import java.util.Arrays;

public class Test {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] numsMegred = new int[nums1.length + nums2.length];

		double median = 0.0;

		for (int i = 0; i < nums1.length; i++) {
			numsMegred[i] = nums1[i];
		}

		for (int i = 0; i < nums2.length; i++) {
			numsMegred[i + nums1.length] = nums2[i];
		}

		Arrays.sort(numsMegred);

		if (numsMegred.length % 2 == 0) {
			median = (double) (numsMegred[numsMegred.length / 2 - 1] + numsMegred[numsMegred.length / 2]) / 2;
		} else {
			median = numsMegred[numsMegred.length / 2];
		}

		return median;

	}

	public static void main(String[] args) {

		System.out.println(new Test().findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));

	}

}