package lk.ijse.dep11.app;

public class AppInitiallizer {
    public static void main(String[] args) {
        A.myPackagePrivateMethod();
        A.myProtectedMethod();
        A.myPublicMethod();
    }

}

class A{
    private void myPrivateMethod(){
        System.out.println("lk.ijse.dep11.app.A.myPrivateMethod");
    }

    static void myPackagePrivateMethod(){
        System.out.println("lk.ijse.dep11.app.A.myPackagePrivateMethod");
    }

    protected static void myProtectedMethod(){
        System.out.println("lk.ijse.dep11.app.A.myProtectedMethod");
    }

    public static void myPublicMethod(){
        System.out.println("lk.ijse.dep11.app.A.myPublicMethod");
    }
}
