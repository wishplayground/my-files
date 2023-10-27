class Demo17{
    public static void main(String[] args) {

        myMethod1((byte)10);
        myMethod2((short)120);
        myMethod3('A');
        myMethod3((char)65);
        myMethod4(1245);
        myMethod5(120);
        myMethod6(11);
        myMethod6(11.0f);
        myMethod7(15);
        myMethod7(13.569);
        
    }

    static void myMethod1(byte myByte){
        System.out.println("My Method 1");
    }

    static void myMethod2(short myShort){
        System.out.println("My Method 2");
    }

    static void myMethod3(char myChar){
        System.out.println("My Method 3");
    }

    static void myMethod4(int myInt){
        System.out.println("My MEthod 4");
    }

    static void myMethod5(long myLong){
        System.out.println("My Method 5");
    }

    static void myMethod6(float myFloat){
        System.out.println("Me Method 6");
    }

    static void myMethod7(double myDouble){
        System.out.println("My Method 7");
    }
}