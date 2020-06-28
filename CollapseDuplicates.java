package devjava;

public class CollapseDuplicates {
	public String collapseDuplicates(String a) {
		int i = 0;
		String result = "";
		while (i < a.length()) {
			char ch = a.charAt(i);
			if (!result.endsWith(String.valueOf(ch)))
				result += ch;
			i++;
		}
		return result;
	}
}
