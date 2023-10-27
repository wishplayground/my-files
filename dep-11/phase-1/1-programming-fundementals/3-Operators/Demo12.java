class Demo12 {
    public static void main(String[] args) {
        byte myByte = 10;
        byte mybyte1 = (byte)  (myByte << 2);
        System.out.println(mybyte1);

         System.out.printf("%08d \n", Integer.valueOf(Integer.toBinaryString(myByte)));
         System.out.printf("%08d \n", Integer.valueOf(Integer.toBinaryString(mybyte1)));
    }
}
