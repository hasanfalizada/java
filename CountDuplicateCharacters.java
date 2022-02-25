package devjava;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharacters {
	public static Map<Character, Integer> countDuplicateCharacters(String str) {
		Map<Character, Integer> result = new HashMap<>();
		for (char ch : str.toCharArray()) {
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}

	public static Map<Character, Long> countDuplicateCharactersByStream(String str) {
		Map<Character, Long> result = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return result;
	}

	public static void main(String[] args) {
		Map<Character, Integer> firstMap = countDuplicateCharacters("Hasan");
		Map<Character, Long> secondMap = countDuplicateCharactersByStream("Hasan");

		firstMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		// secondMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " "
		// + entry.getValue()));

	}
}
