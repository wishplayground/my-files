public class Demo3 {

    /* try catch satement

    uni-catch clause

        try{
            try to execute code lines

        } catch (Exception e)  { //catch exception  


        }

    
    //Multi-catch clause
    try{

    } catch (Exception1 | Exception2 | Exception3 | Exception4){

    }

    //multiple catch cluases
    try{

    }catch(){

    }catch(){

    }catch(){
        
    }
     */
    /* public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((t,e) ->{ //uncaught exception handler
            System.out.println("Ahu unaa");
        });


        System.out.println("Enter into main");
        myMethod1();
        System.out.println("Exit from Main");
        
    }

    static void myMethod1() {
        System.out.println("Enter into myMethod 1");
        try{
            myMethod2();
        } catch(Exception e){
            System.out.println("got it");
            e.printStackTrace();
        }
        
        System.out.println("Exit from myMethod 1");
    }

    static void myMethod2() {
        System.out.println("Enter into myMethod 2");
        try{
            int[]  numbers = new int[5];
            System.out.println(numbers[5]);
            System.out.println("Finalized");
        } catch(ArithmeticException e){ //exception handler
            System.out.println("I can handle");
        }
    
        System.out.println("Exit from myMethod 2");
    } */

    /* static void myMethod3() {
        System.out.println("Enter into myMethod 3");
        System.out.println(5/0);
        System.out.println("Exit from myMethod 3");
    } */

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((t,e) ->{ //uncaught exception handler
            System.out.println("Ahu unaa");
        });


        System.out.println("Enter into main");
        myMethod1();
        System.out.println("Exit from Main");
        
    }

    static void myMethod1() {
        System.out.println("Enter into myMethod 1");
        try{
            myMethod2();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("got it");
         
        }
        
        System.out.println("Exit from myMethod 1");
    }

    static void myMethod2() {
        System.out.println("Enter into myMethod 2");
        try{
            int[]  numbers = new int[5];
            System.out.println(numbers[5]);
            System.out.println("Finalized");
        } catch(ArithmeticException e){ //exception handler
            System.out.println("I can handle");
        }
    
        System.out.println("Exit from myMethod 2");
    }
}
