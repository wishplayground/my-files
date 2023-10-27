class Demo17 {
    public static void main(String[] args) {
        int x = -2;
        int y  = x >>>30;
        int result = x + y;

        System.out.println("----------------------------------------\n");

        byte a = (byte) ~x;
        int b = a <<2,c;
        c = b++ +a;
        System.out.println(c+"\n"+b);
    
    }    
}
