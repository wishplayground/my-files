class Demo22 {

    public static void main(String[] args) {
        byte b1 = 59;
        myMethod(20, b1);
        
    }

    static void myMethod(int x, int y){
        System.out.println("myMethod(int, int)");
    }

    /* static void myMethod(int x,byte b){
            System.out.println("myMethod(int, byte)");
    } */

    static void myMethod(long x, long y){
        System.out.println("myMethod (long, long)");
    }
    
}
