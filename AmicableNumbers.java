package devjava;

import java.util.HashMap;
import java.util.Map;

public class AmicableNumbers {

	static int d(int number) {
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		int d = 0;
		int sum = 0;
		for (int i = 1; i <= 10000; i++) {
			d = d(i);
			if (!map.containsKey(i)) {
				map.put(i, d);
				map.put(d, i);
			} else {
				if (d == map.get(i)) {
					sum += i + d;
				} else {
					map.put(i, d);
				}
			}
		}
		System.out.println(sum);
	}
}
