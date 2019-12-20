import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class T {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Robb");
        names.add("Bran");
        names.add("Rick");
        names.add("Bran");

        names.removeAll(Collections.singleton("Bran")); // Use this it you want to delete all equal elements

        System.out.println(names);
    }
}