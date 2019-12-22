import java.util.HashMap;
import java.util.Map;

class Test {
	static int sockMerchant(int n, int[] ar) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (map.get(ar[i]) != null) {
				map.put(ar[i], map.get(ar[i]) + 1);
			} else {
				map.put(ar[i], 1);
			}
		}
		int pairs = 0;
		for (Map.Entry m : map.entrySet()) {
			pairs = pairs + (int) m.getValue() / 2;
		}
		return pairs;
	}

	public static void main(String[] args) {
		int[] ar = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		System.out.println(Test.sockMerchant(9, ar));
	}
}