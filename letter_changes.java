class T {

    static String LetterChanges(String str) {

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {

                charArray[i] = (char) ((int) charArray[i] + 1);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (Character.toLowerCase(charArray[i]) == 'a' || Character.toLowerCase(charArray[i]) == 'e'
                    || Character.toLowerCase(charArray[i]) == 'i' || Character.toLowerCase(charArray[i]) == 'o'
                    || Character.toLowerCase(charArray[i]) == 'u') {
                charArray[i] = Character.toUpperCase((char) ((int) charArray[i]));
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(LetterChanges("Hasan!"));
    }
}