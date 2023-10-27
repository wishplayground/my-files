import java.lang.Thread.UncaughtExceptionHandler;

public class Demo2 {
    public static void main(String[] args) {

        /* Thread.currentThread().setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e){
                System.out.println("Mata athi mama yanawa yanna");
            }
            
        }); */

        Thread.setDefaultUncaughtExceptionHandler((t,e)->{  // t yanna hadana thread eka  e => exception object name
            //logging
            System.out.println("Menna meya yanna hadanawa " + t.getName());
            System.out.println("Mata athi mama yanawooooo");
            e.printStackTrace();
        });

        System.out.println("Enter into main");
        myMethod1();
        System.out.println("Exit from Main");
        
    }

    public static void myMethod1(){
        System.out.println("Enter myMethod1");
        myMethod2();
        System.out.println("Exit from myMethod 1");
    }

    public static void myMethod2() {
        System.out.println("Enter into myMethod 2");
        String something = null;
        System.out.println(something.toUpperCase()); // create exception here
        System.out.println("Exit from myMethod 2");
    }
}
