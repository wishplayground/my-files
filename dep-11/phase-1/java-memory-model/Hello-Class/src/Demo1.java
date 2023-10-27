public class Demo1 {

    static int myInt = 5;
    static {
        System.out.println("Static Initiallizer 1");
        myInt = 10;
    }


    public static void main(String[] args) {

        System.out.println("Main Method " + myInt);
    }


    static {
        System.out.println("Static Initiallizer 2");
        myInt = 20;

    }


}
