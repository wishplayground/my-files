class Demo14 {
    public static void main(String[] args) {
        byte myByte = 10;
        int myInt = (byte)(myByte >>2);
        System.out.println(myInt);
        String binaryRepofInt = String.format("%32s",
        Integer.toBinaryString(myInt))
        .replaceAll(" ","0");

        System.out.printf(binaryRepofInt);


        System.out.println("\n -------------------------------\n");

        byte myByte2 = -127;
        int myInt2 = myByte2 >> 2;
        String binaryRepofInt2 = String.format("%32s",
        Integer.toBinaryString(myInt))
        .replaceAll(" ","0");
        System.out.println(binaryRepofInt2);
        System.out.println(myInt2);
    }
}
