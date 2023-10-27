class Demo13 {
    public static void main(String[] args) {
        byte myByte1 = -127;
        byte myByte2 = (byte)(myByte1 << 1);
        Short myShort = (short)(myByte1 << 1);

        System.out.printf("%32s \n", Integer.toBinaryString(myByte1));
        System.out.printf("%08d \n", Integer.valueOf(Integer.toBinaryString(myByte2)));
        System.out.printf("%16s \n" , Integer.toBinaryString(myShort));
        System.out.println(myByte2);
    }
}
