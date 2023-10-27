import java.io.IOError;
import java.io.IOException;

public class Demo15 {
    /* public static void main(String[] args) {
        C ref = new C();
        System.out.println(ref.x);//30
        //Liskov substitutional principal
        B b = new C();
        System.out.println(b.x);//20
        
        A a = new C();
        System.out.println(a.x);//10

        A a1 = new B();
        System.out.println(a1.x);//10 */

/*         ref.myMethod();
        b.myMethod();
        a.myMethod();
        a1.myMethod();
    }
    
}

class A{
    int x = 10;
    public A(){
        super();
        System.out.println("A Constructor initialized");
    }
    static{
        System.out.println("A static Initiallizer");
    }
    {
        System.out.println("A instance Initiallizer");
    }

    Super myMethod() throws RuntimeException, IOException{
        System.out.println("A");
        return null;
    }
}

class B extends A{
    public B(){
        super();
        System.out.println("B Constructor initialized");
    }

    static{
        System.out.println("B static Initiallizer");
    }
    {
        System.out.println("B instance Initiallizer");
    }
    int x = 20;
    Super myMethod() throws ArrayIndexOutOfBoundsException{
        System.out.println("B");
        return null;
        
    }
}

class C extends B{

    public C(){
        super();
        System.out.println("C Constructor initialized");
    }
    int x =30;
    int y =60;

    static{
        System.out.println("C static Initiallizer");
    }
    {
        System.out.println("C instance Initiallizer");
    }

    /* Super myMethod(){
        System.out.println("C");
        return null;
    } */
}

