import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class T {
    public static void main(String[] args) {
        Properties properties1 = new Properties();
        properties1.setProperty("k1", "v1");
        properties1.setProperty("k2", "v2");
        properties1.list(System.out);

        try {
            FileOutputStream out = new FileOutputStream("myProps1.props");
            properties1.store(out, "test-comment");
            out.close();
        } catch (IOException e) {
            System.out.println("exc 1");
        }

        Properties properties2 = new Properties();
        try {
            FileInputStream in = new FileInputStream("myProps1.props");
            properties2.load(in);
            System.out.println(properties2.getProperty("k1"));
            properties2.list(System.out);
            properties2.setProperty("newProp", "newData");
            properties2.list(System.out);
            FileOutputStream out = new FileOutputStream("myProps2.props");
            properties2.store(out, "myUpdate");
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println("exc 2");
        }
    }
}