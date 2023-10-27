public class parent extends Demo1 {

    static {
        System.out.println("Parent: Static Initiallizer");
    }

    static int myParentInt =10;

    static void myMthod(){
        System.out.println("Hello I'm From Parent");
    }

    static {
        System.out.println("Parent: Static Initiallier 2: " + myParentInt);
    }

    public static void main(String[] args) {
        System.out.println("Parent Main Method");
        //Demo1.main(args);
    }

}
