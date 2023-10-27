class Demo8 {
    
    public static void main(String[] args) {
        System.out.println("Enter into Main");
        myMethod1();
        System.out.println("Exit from Main");
        
    }

    static void myMethod1(){
        System.out.println("Enter into MyMethod1");
        myMethod2();
        System.out.println("Exit from myMethod1");
    }

    static void myMethod2() {
        System.out.println("Enter into myMethod2");
        try{
            Class.forName("Crazy");
        } catch(ClassNotFoundException e){
            System.out.println("Class not Found");
        }
        
        System.out.println("Exit from myMethod2");
    }
}
