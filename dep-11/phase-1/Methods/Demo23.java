class Demo23 {
    
    public static void main(String[] args) {
        byte b = 10;
        short s = 5;
        
        myMethod(12,b,s);
    }

    static void myMethod(int x, float y, int z){
        System.out.println("myMethod(int, float, int)");
    }

    static void myMethod(short x, int y, long z){
        System.out.println("myMethod(short, int, long)");
    }

    static void myMethod(int x, short y, int z){
        System.out.println("myMethod(int, short, long)");
    }

    static void myMethod(long x, int y, float f){
        System.out.println("myMethod(long, int, float)");
    }
}
