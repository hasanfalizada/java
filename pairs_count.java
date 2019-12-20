class T {
    static int sockMerchant(int n, int[] ar) {

        int oneColorSocks = 0;
        int pairCount = 0;
        Set<Integer> set = new HashSet();
        for (int a : ar) {
            set.add(a);
        }

        for (int color : set) {
            for (int a : ar) {
                if (a == color) {
                    oneColorSocks++;
                }
            }
            pairCount = pairCount + oneColorSocks / 2;
            oneColorSocks = 0;
        }
        return pairCount;
    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(8, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }
}