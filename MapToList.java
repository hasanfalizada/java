import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Hasan");
		map.put(2, "Alizada");

		// 1. List of keys.
		List<Integer> listOfKeys = new ArrayList<>();
		listOfKeys = map.keySet().stream().collect(Collectors.toList());
		System.out.println(listOfKeys);

		// 2. List of values.
		List<String> listOfValues = new ArrayList<>();
		listOfValues = map.values().stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(listOfValues);

		// 3. List of entries.
		List<Map.Entry<Integer, String>> listOfEntries = new ArrayList<>();
		listOfEntries = map.entrySet().stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(listOfEntries);

	}
}
