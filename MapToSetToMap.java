import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Test {

	public Map<String, Integer> wordLen(String[] strings) {

		Set<String> set = new HashSet<>();
		for (String s : strings) {
			set.add(s);
		}

		Map<String, Integer> outMap = new HashMap<String, Integer>();

		for (String s : set) {
			outMap.put(s, s.length());
		}

		return outMap;

	}

}