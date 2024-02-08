package dev;

import java.io.*;

public class XORDecryption {
    public static void main(String[] args) {
        try {
            String encryptedFilePath = "C:\\Users\\ha\\Desktop\\0059_cipher.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ha\\Desktop\\decrypted_output.txt"));
            int[] encryptedText = readEncryptedFile(encryptedFilePath);
            int[] key = {103, 111, 100}; // ASCII values of the key "god"

            // Try all possible combinations of lowercase letters as the key
            for (int i = 97; i <= 122; i++) { // ASCII values for lowercase letters
                for (int j = 97; j <= 122; j++) {
                    for (int k = 97; k <= 122; k++) {
                        key[0] = i;
                        key[1] = j;
                        key[2] = k;

                        int[] decryptedText = decryptMessage(encryptedText, key);

                        int sumOfAscii = calculateAsciiSum(decryptedText);

                        writer.write("Decrypted message: " + arrayToString(decryptedText) + "; " + "Sum of ASCII values: " + sumOfAscii);
                        writer.newLine();

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] readEncryptedFile(String filePath) throws IOException {
        StringBuilder encryptedText = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                encryptedText.append(line);
            }
        }
        String[] encryptedStrArray = encryptedText.toString().split(",");
        int[] encryptedIntArray = new int[encryptedStrArray.length];
        for (int i = 0; i < encryptedStrArray.length; i++) {
            encryptedIntArray[i] = Integer.parseInt(encryptedStrArray[i]);
        }
        return encryptedIntArray;
    }

    private static int[] decryptMessage(int[] encryptedText, int[] key) {
        int[] decryptedText = new int[encryptedText.length];
        for (int i = 0; i < encryptedText.length; i++) {
            decryptedText[i] = encryptedText[i] ^ key[i % key.length];
        }
        return decryptedText;
    }

    private static boolean containsCommonEnglishWords(int[] text) {
        String decryptedStr = arrayToString(text);
        return decryptedStr.matches(".*\\b(the|and|is|are|to|of|in|an)\\b.*");
    }

    private static int calculateAsciiSum(int[] text) {
        int sum = 0;
        for (int i = 0; i < text.length; i++) {
            sum += text[i];
        }
        return sum;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append((char) array[i]);
        }
        return sb.toString();
    }

    public static boolean isEnglishText(int[] textBytes) {
        // Calculate the frequency of each character
        int[] charFreq = new int[256]; // Assuming ASCII characters

        for (int byteVal : textBytes) {
            charFreq[byteVal]++;
        }

        // Calculate the total number of characters in the text
        int totalChars = textBytes.length;

        // Calculate the percentage of alphabetic characters (a-z, A-Z)
        int alphaCount = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            alphaCount += charFreq[i];
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            alphaCount += charFreq[i];
        }
        double alphaPercentage = (double) alphaCount / totalChars;

        // If the percentage of alphabetic characters is above a threshold, consider it English text
        double threshold = 0.5; // Adjust as needed
        return alphaPercentage >= threshold;
    }

//    Decrypted message:
//    An extract taken from the introduction of one of Euler's most celebrated papers,
//    "De summis serierum reciprocarum" [On the sums of series of reciprocals]:
//    I have recently found, quite unexpectedly, an elegant expression for the
//    entire sum of this series 1 + 1/4 + 1/9 + 1/16 + etc., which depends on
//    the quadrature of the circle, so that if the true sum of this series is
//    obtained, from it at once the quadrature of the circle follows. Namely,
//    I have found that the sum of this series is a sixth part of the square
//    of the perimeter of the circle whose diameter is 1; or by putting the
//    sum of this series equal to s, it has the ratio sqrt(6) multiplied by s to
//    1 of the perimeter to the diameter. I will soon show that the sum of this
//    series to be approximately 1.644934066842264364; and from multiplying this
//    number by six, and then taking the square root, the number 3.141592653589793238
//    is indeed produced, which expresses the perimeter of a circle whose diameter is 1.
//    Following again the same steps by which I had arrived at this sum,
//    I have discovered that the sum of the series 1 + 1/16 + 1/81 + 1/256 + 1/625 + etc.
//    also depends on the quadrature of the circle. Namely, the sum of this multiplied by
//    90 gives the biquadrate (fourth power) of the circumference of the perimeter of a
//    circle whose diameter is 1. And by similar reasoning I have likewise been able to
//    determine the sums of the subsequent series in which the exponents are even numbers.;
//    Sum of ASCII values: 129448
}