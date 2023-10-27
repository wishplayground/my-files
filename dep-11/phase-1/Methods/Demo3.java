public class Demo3 {
    
    public static void main(String[] args) {
        System.out.println("I'm in the main method");
        myMethod1(1);
        System.out.println("I'm back in the main method");
       
    }

    public static void myMethod1(int count){
        System.out.println("I'm in the myMethod 1");
        myMethod2();
        System.out.println("I'm back in the myMethod1 again");
        myMethod3();
            
    }
    public static void myMethod2(){
        System.out.println("I'm in the myMethod2");
    }

    public static void myMethod3(){
        System.out.println("I'm in the myMethod3");
    }

    //public static void myMethod(double ...nums){}


}
