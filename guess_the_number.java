package development_project;

import java.util.Scanner;

public class GuessTheNumber {
	static void say(String sentence) {
		System.out.println(sentence);
	}

	public static void main(String[] args) {
		int min = 0;
		int max = 100;
		int div = min + ((max - min) / 2);
		Scanner s = new Scanner(System.in);
		while (true) {
			say("Is your number bigger than " + div + " ?");
			if (s.next().equals("Y")) {
				min = div;

			} else {
				max = div;
			}
			div = min + ((max - min) / 2);
			if (min == div) {
				say("Your number is " + max);
				s.close();
				return;
			}
			;
		}
	}
}
