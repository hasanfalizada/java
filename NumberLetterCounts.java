package devjava;

public class NumberLetterCounts {

	static String numberToEnglish(int n) {
		String[] ones = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] tens = { "None", "None", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety" };

		if (0 <= n & n < 20) {
			return ones[n];
		} else if ((20 <= n & n <= 90) & (n % 10 == 0)) {
			return tens[Math.floorDiv(n, 10)];
		}

		else if (20 < n & n < 100) {
			return tens[Math.floorDiv(n, 10)] + "-" + ones[n % 10];
		}

		else if ((100 <= n & n <= 900) & (n % 100 == 0)) {
			return ones[Math.floorDiv(n, 100)] + " hundred";
		}

		else if (100 < n & n < 1000) {
			return ones[Math.floorDiv(n, 100)] + " hundred and " + numberToEnglish(n % 100);
		}

		else if (n == 1000) {
			return "one thousand";
		}

		else {
			return "unexpected input";
		}

	}

	public static void main(String[] args) {
		int target = 1000;
		int answer = 0;
		for (int i = 1; i <= target; i++) {
			answer += numberToEnglish(i).replace(" ", "").replace("-", "").length();
		}
		System.out.println(answer);
	}
}
