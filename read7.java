package main;

class T {
    static String string = "Hello World! And this is me, Hasan!";
    static int startIndex = 0;
    static int endIndex = 7;

    static void read7() {
        if (startIndex == endIndex) {
            return;
        }
        System.out.println(string.substring(startIndex, endIndex));
        startIndex = endIndex;
        endIndex = string.length() - endIndex > 7 ? endIndex + 7 : string.length();
    }

    public static void main(String[] args) {
        read7();
        read7();
        read7();
        read7();
        read7();
        read7();
        read7();
        read7();
        read7();
        read7();
        read7();
    }
}