import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class T {

    String[] newNumeralSystem(char number) {

        int elementNo = 0;
        List<String> list = new ArrayList();
        char[] numeralSystem = new char[26];
        for (int i = 65, j = 0; i < 65 + 26; i++, j++) {
            numeralSystem[j] = (char) i;
        }

        for (int i = 0; i < numeralSystem.length; i++) {
            if (numeralSystem[i] == number) {
                elementNo = i;
                break;
            }
        }

        for (int i = 0; i <= elementNo / 2; i++) {
            list.add(numeralSystem[i] + " + " + numeralSystem[elementNo - i]);
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T().newNumeralSystem('D')));
    }
}