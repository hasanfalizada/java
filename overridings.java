class Overridings {

    public int hashCode() {
        // use bit-manipulation operators such as ^ to generate close to unique
        // hash codes here we are using the magic numbers 7, 11 and 53,
        // but you can use any numbers, preferably primes
        return (7 * 5) ^ (11 * 6) ^ (53 * 23);
    }


    public static void main(String[] args) {
        System.out.println(new Overridings().hashCode());
    }
}