//public class final abstract Demo13{
public class Demo13{
    static{
        System.out.println("Demo Initializer");
    }
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.x);//x not in the child class but in the 
        
    }
}

class Parent{
    {
        System.out.println("Parent instance Initializer");
    }
    static{
        System.out.println("Parent Initializer");
    }
    static int x;
    int y;
    
    static void myMethod(){

    }
     
    void myInstanceMethod(){

    }


}

//class Child extends String {
class Child extends Parent {
    {
        System.out.println("Chile instance initializer");
    }
    static{
        System.out.println("Child initiallizer");
    }
    int a;
    void myMethod2(){};

}