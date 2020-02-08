package devjava;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public Map<String, Integer> wordCount(String[] strings) {
		Map<String, Integer> outMap = new HashMap<>();
		for (String s : strings) {
			if (outMap.get(s) == null) {
				outMap.put(s, 1);
			} else {
				outMap.put(s, outMap.get(s) + 1);
			}
		}
		return outMap;
	}

	public static void main(String[] args) {
		String[] array = new String[] { "a", "b", "a", "c", "b" };
		System.out.println(new Test().wordCount(array));
	}
}
