import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public String[] encoder(String[] raw, String[] code_words) {
		Map<String, String> kv = new HashMap<>();
		String[] outArray = new String[raw.length];

		for (int i = 0; i < raw.length; i++) {
			if (kv.get(raw[i]) == null) {
				kv.put(raw[i], code_words[i]);
				outArray[i] = code_words[i];
			} else {
				outArray[i] = kv.get(raw[i]);
			}
		}
		return outArray;
	}

	public static void main(String[] args) {
		String[] arr1 = new String[] { "a", "b" };
		String[] arr2 = new String[] { "1", "2", "3", "4" };
		System.out.println(Arrays.toString(new Test().encoder(arr1, arr2)));
	}
}
