package devjava;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
	static String twoStrings(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return "NO";
		}

		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();

		for (Character c : s1.toCharArray()) {
			set1.add(c);
		}
		for (Character c : s2.toCharArray()) {
			set2.add(c);
		}

		for (Character c : set1) {
			for (Character c2 : set2) {
				if (c.equals(c2)) {
					return "YES";
				}
			}
		}
		return "NO";
	}
}
