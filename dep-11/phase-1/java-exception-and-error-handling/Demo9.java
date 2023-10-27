class Demo9 {
    
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Enter into Main");
        myMethod1();
        System.out.println("Exit from Main");
    }

    static void myMethod1() throws ClassNotFoundException{
        System.out.println("Enter into MyMethod1");
        myMethod2();
        System.out.println("Exit from myMethod1");
    }

    static void myMethod2() throws ClassNotFoundException {
        System.out.println("Enter into myMethod2");
        Class.forName("Crazy");
        System.out.println("Exit from myMethod2");
    }
}
