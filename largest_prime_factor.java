class T {
    static boolean isPrime(int factor) {
        int counter = 0;
        for (int i = 1; i < factor; i++) {
            if (factor % i == 0) {
                counter++;
            }
            if (counter >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        double val = 600851475143.0;
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0 && isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}