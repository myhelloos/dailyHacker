class hihocoder_reader{
    public static int[] readIntArray() {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        int[] arr = new int[times];
        // int result = 0;
        for (int i = 0; i < times; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static String readString() {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        int[] arr = new int[times];
        // int result = 0;
        for (int i = 0; i < times; i++) {
            arr[i] = in.nextInt();
        }
    }
}
