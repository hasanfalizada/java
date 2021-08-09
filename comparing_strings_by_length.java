package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("aaaaaaaaa");
		list.add("cc");
		list.add("bbbbb");

		System.out.println(list);

		Collections.sort(list);

		System.out.println(list);

		list.sort((a, b) -> (Integer.compare(a.length(), b.length())));

		System.out.println(list);

	}
}
