class Demo16 {
    public static void main(String[] args) {
        byte x = 2;
        int y = x << 1;
        y = y + x;
        System.out.println(y);

        System.out.println("---------------------------");

        byte a = 5;
        int b = a>>>2;
        b = a +b;
        System.out.println(b);
    }
}
