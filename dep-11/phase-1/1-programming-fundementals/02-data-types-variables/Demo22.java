class Demo22{
    public static void main(String[] args) {
        int myInt = 10;//Primitive data type             primitive (int)      = primitive (int)
        Integer myInt2 = 10; //Reference Data Type       refereance (Integer) = primitive (int)

        //primitive (byte) = primitive(int)
        byte myByte = 10;

        //reference (Byte) = primitive (int)
        //Byte myByte2 = new Byte(10);         this is Boxing(wrap up)
        //byte myBytevar = 10(narrowing primitive conversion)
        //Byte myByte2 = new Byte(myBytevar)
        Byte myByte2 = 10;                     //Auto Boxing

        Integer myInt3 = 30;
        int myInt4 = myInt3.intValue();      //Unboxing
        int myInt5 = myInt3;                 //this is Auto Unboxing

        System.out.println(myInt + myInt3 + myInt5); //Auto Unboxing occure on numeric context


        //myByte.byteValue() <- Unwrap(Auto Unboxing)
        //(int) myByte2.byteValue() <- widenning primitive conversion
        System.out.println(myInt2 + myByte2);

    }
}