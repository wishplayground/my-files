class Demo18 {
    
    public static void main(String[] args) {
        //Identity Conversion
        //Widenning primitive conversion
        //Boxing, Unboxing Conversion
        
        //myMethod1(10);
        myMethod1((byte)10);
        myMethod2(10); //Auto Boxing conversion ()
        myMethod3(20); //Identity Conversion (method defines and pass same data type)


        byte myByte = 10;
        int num = 20;     //identity conversion
        myMethod1(myByte);
        myMethod3(myByte);//widening primitive Conversion

        Integer num1 = 20;
        myMethod2(num1);//identity Conversion
        myMethod3(num1); //Unboxiing Conversion

        Byte b1 = 60;
        myMethod1(b1);//Identity Conversion
        //myMethod2(b1);
        myMethod3(b1);//Unboxing followed by widening
        
    }

    static void myMethod1(Byte myByte){
        System.out.println("My Method1");
    }


    
    static void myMethod2(Integer myInt){
        System.out.println("My Method 2");
    }

    static void myMethod3(int myInt){
        System.out.println("My Method 3");
    }

}
