import java.util.Scanner;

class Demo6 {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //standard output -> screen      -> System.out
        //Standard error  -> Screen      -> System.err
        //Standard input  -> keyboard    -> System.in

        System.out.println("Hello");
        System.err.println("Error");
        System.out.print("Enter the name: ");
        String str = input.nextLine();
        System.out.printf("Hi!! Welcome %s \n",str);
    }
}
