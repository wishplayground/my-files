package lk.ijse.dep11.first;

public class A {

    private static  void  myMethod1(){
        System.out.println("first.A: myMethod 1");
    }

    static  void myMethod2(){
        myMethod1();
        System.out.println("fist.A: myMethod 2");
    }

    public static void myMethod3(){
        System.out.println("first A: myMethod3");
    }

}
