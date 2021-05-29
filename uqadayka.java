package test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int highRange = 100;
		int lowRange = 0;
		Scanner s = new Scanner(System.in);
		String userInput;
		while (lowRange != highRange) {
			System.out.println("Is you digit bigger than " + ((lowRange + highRange) / 2) + "?");
			userInput = s.next();
			if (userInput.toLowerCase().equals("yes")) {
				lowRange = (lowRange + highRange) / 2 + 1;
			} else {
				highRange = (lowRange + highRange) / 2;
			}
		}
		System.out.println("Your number is: " + lowRange);
		s.close();
	}
}
