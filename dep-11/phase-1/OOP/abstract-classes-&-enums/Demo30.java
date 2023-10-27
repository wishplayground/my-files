import java.io.Serializable;

public interface Demo30 {
    //we can static methods in interfaces
    //we can have default methods(methods that have implementation) since java 8
    //we can have private methods in interfaces since java 9
    public static void main(String[] args) {
        System.out.println("Hello world");
        
    }

    private void myMethodeka(){

    }

    private static void myMethodDeka(){

    }

    //default methods are like abstract methods
    default void myMethodThuna(){// default method means instance method this is implicitly public cannot use protected or private

    }
}

interface MyInterface{ //IMyInsterface       //only ideas exixst

    public abstract void myMethod(String s);  
    String myMethod2(int i); //still a public abstract method


}

abstract class MyAbstractClass{
    protected abstract void myMethod();  //protected can be use with abstract methods
    abstract void myMethod3();          //package private can be use with abstract method

}

interface MyInterface2 extends MyInterface, Serializable, Cloneable{
    void myMethod4();
    void myMethod5(); 
    default void myMeth(){

    }
}

class MyClass implements MyInterface{

    @Override
    public void myMethod(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'myMethod'");
    }

    @Override
    public String myMethod2(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'myMethod2'");
    }

}

abstract class ConcreteClass implements MyInterface2,MyInterface{//if all the implents cant be implement here class will convert to abstract class

}
