import java.util.Properties;

class T {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.setProperty("myProperty", "myValue");
        properties.list(System.out);
    }
}