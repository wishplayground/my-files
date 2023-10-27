public class Parent {
    static{
        System.out.println("parent Static initiallizer 1");
    }

    static int myInt =10;
    int m2 = 20;

    static void print(){
        System.out.println("static method of parent class " + myInt );
    }

    static{
        System.out.println("parent Static initiallizer 2");
    }
}
