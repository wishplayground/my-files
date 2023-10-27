class Demo18 {
 public static void main(String[] args) {
    byte a = -128;
    int b = ~a >>> 28;
    int c = b * 2 + ++a;
    System.out.println(c);

    System.out.println("------------------------------\n");

    byte myByte = ~0;
    int myInt = myByte >> (31-myByte);
    myInt = myInt << 1;
    System.out.println(myInt);

 }
}
