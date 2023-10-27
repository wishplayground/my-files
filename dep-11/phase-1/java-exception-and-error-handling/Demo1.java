class Demo1{

    public static void main(String[] args) {
        System.out.println("Enter into main");
        myMethod1();
        System.out.println("Exit from Main");
        
    }

    static void myMethod1() {
        System.out.println("Enter into myMethod 1");
        myMethod2();
        System.out.println("Exit from myMethod 1");
    }

    static void myMethod2() {
        System.out.println("Enter into myMethod 2");
        myMethod3();
        System.out.println("Exit from myMethod 2");
    }

    static void myMethod3() {
        System.out.println("Enter into myMethod 3");
        System.out.println(5/0);
        System.out.println("Exit from myMethod 3");
    }

}