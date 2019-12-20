import org.apache.commons.text.similarity.JaroWinklerDistance;

public class Main {
	public static void main(String[] args) {
		int counter = 0;
		String example = "Hasan";
		String[] stringsArray = { "Sandeep", "Hasan", "Gupta", "Michael", "Palit", "Scott" };
		JaroWinklerDistance distance = new JaroWinklerDistance();
		double distanceResult = 0.0;
		for (String s : stringsArray) {
			distanceResult = distance.apply(example, s);
			System.out.println(s + " -> " + distanceResult); // More near to 1.0 is the best match
			if (distanceResult == 1.0) {
				counter++;
			}
		}
		System.out.println("Number of mathces: " + counter);
	}
}