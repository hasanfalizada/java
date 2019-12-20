public class RandomNumber {
	public static void main(String[] args) {
		int range_min = 1;
		int range_max = 100;
		int range = (range_max - range_min) + 1;
		int rand = (int) (Math.random() * range) + range_min;
		System.out.println(rand);
	}

}