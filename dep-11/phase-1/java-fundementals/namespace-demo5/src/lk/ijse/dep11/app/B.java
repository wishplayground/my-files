package lk.ijse.dep11.app;

public class B {
    public static void doSomething(){
        //A.myPrivateMethod();
        A.myPackagePrivateMethod();
        A.myProtectedMethod();
        A.myPublicMethod();
    }
}
