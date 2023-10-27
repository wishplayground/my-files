public class Demo22 {
    static{
        System.out.println("Demo22 static initialized");
    }
    public static void main(String[] args) {
        System.out.println("Started main Method");
        new MyChildClass();
        /* new MyChildClass(10);
        new MyChildClass(20, "IJSE");
 */
        

    }

}

class MyParentClass{
    {
        System.out.println("Parent class initialized");
    }
    static{
        System.out.println("Parent class Static initializer initialized");
    }

}

class MyChildClass extends MyParentClass{

    {
        System.out.println("MyChildClass being Initialized");
    }

    static{
        System.out.println("MyChildClass static initializer Initialized");
    }

    public MyChildClass(){
        this(15);
        System.out.println("End of first constructor");
    }
    public MyChildClass(int id){
        this(10,"Isuru");
        System.out.println("End of second Constructor body");
    }

    public MyChildClass(int id, String name){
        super();
        //invisible line 
        System.out.println("End of third constructor");
    }
}
