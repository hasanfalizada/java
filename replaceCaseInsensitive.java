class Test {

	public static String withoutString(String base, String remove) {
		return base.replaceAll("(?i)" + remove, "");
	}

	public static void main(String[] args) {
		System.out.println(Test.withoutString("THIS is a FISH", "iS"));
	}
}