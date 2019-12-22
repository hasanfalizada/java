import java.util.HashMap;
import java.util.Map;

class Test {

	public int maxSpan(int[] nums) {

		Map<Integer, int[]> spans = new HashMap<Integer, int[]>(); // 0 - leftmost, 1 - rightmost;

		for (int i = 0; i < nums.length; i++) {
			if (spans.get(nums[i]) != null) {
				spans.get(nums[i])[1] = i;
			} else {
				int[] initialIndexes = { i, i };
				spans.put(nums[i], initialIndexes);
			}

		}

		int maxSpan = 0;
		int currentSpan = 0;
		for (Map.Entry<Integer, int[]> m : spans.entrySet()) {
			currentSpan = m.getValue()[1] - m.getValue()[0] + 1;
			if (currentSpan > maxSpan) {
				maxSpan = currentSpan;
			}
		}
		return maxSpan;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 2, 1, 4, 4, 4 };
		System.out.println(new Test().maxSpan(nums));
	}
}