public class Demo14 {
    public static void main(String[] args) {
        final int x = 12;
        byte b1 = x; //because x is a compile time constant
        
        //final int x = 12 * (int)Math.random();
        //byte b1 = x; // because x is a runtime constant

        char mychar = 65; //?
        final short myshort = 35;
        short myshort2 = 65;

        mychar = myshort; //

        char mychar1 = myshort; //?
        ch1 = b1;  //?

        long mylng = b1;
        float myfloat6 = mylng; //
    }
}
