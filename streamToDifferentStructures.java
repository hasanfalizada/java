package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 78, 9, 10, 3, 2, 34, 5, 3);

		List<Integer> listOfIntegers = input.stream().collect(Collectors.toList());
		ArrayList<Integer> aList = input.stream().collect(Collectors.toCollection(ArrayList::new));
		LinkedList<Integer> linkedList = input.stream().collect(Collectors.toCollection(LinkedList::new));
		Set<Integer> aSet = input.stream().collect(Collectors.toSet());
		HashSet<Integer> anHashSet = input.stream().collect(Collectors.toCollection(HashSet::new));
		LinkedHashSet<Integer> aLinkedHashSet = input.stream().collect(Collectors.toCollection(LinkedHashSet::new));
		TreeSet<Integer> aTreeSet = input.stream().collect(Collectors.toCollection(TreeSet::new));
		Map<Integer, String> aMap = input.stream()
				.collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1));
		HashMap<Integer, String> anHashMap = input.stream()
				.collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1, HashMap::new));

		LinkedHashMap<Integer, String> aLinkedHashMap = input.stream()
				.collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1, LinkedHashMap::new));

		TreeMap<Integer, String> aTreeMap = input.stream()
				.collect(Collectors.toMap(Function.identity(), String::valueOf, (k1, k2) -> k1, TreeMap::new));
		ConcurrentMap<Integer, String> aConcurrentMap = input.parallelStream()
				.collect(Collectors.toConcurrentMap(Function.identity(), String::valueOf, (k1, k2) -> k1));

		ConcurrentHashMap<Integer, String> aConcurrentHashMap = input.parallelStream().collect(Collectors
				.toConcurrentMap(Function.identity(), String::valueOf, (k1, k2) -> k1, ConcurrentHashMap::new));

	}
}
