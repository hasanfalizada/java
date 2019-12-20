import java.time.Instant;

class T {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
    }
}