public class Demo2 {
    public static void main(String[] args) {
        String mystr = "IJSE";
        int myInt = 10;
        double myDouble = 25.25;
        int myInt2 = 12163435;
        double myDouble2 = 251321.25351;

        /* we can inject any data type inside a string placee holder */
        System.out.printf("|%s|\n", mystr);
        System.out.printf("|%s|\n", myInt);
        System.out.printf("|%s|\n", myDouble);
        System.out.println();

        /* We can specify width with any data type */
        System.out.printf("| %6s |\n", mystr);
        System.out.printf("| %6d |\n", myInt);
        System.out.printf("| %6.2f |\n", myDouble);
        System.out.println();

        /* We can specify flag to align left any data type */
        System.out.printf("|%-6s|\n", mystr);
        System.out.printf("|%-6d|\n", myInt);
        System.out.printf("|%-6.2f|\n", myDouble);
        System.out.println();

        /* We can specify + flag for print sign of the digit with numaric type */
        System.out.printf("|%+-6d|\n", myInt);
        System.out.printf("|%+-6.1f|\n", myDouble);
        System.out.println();

        /* We can specify flag to align left any data type */
        System.out.printf("|%+06d|\n", myInt);
        System.out.printf("|%+06.2f|\n", myDouble);
        System.out.println();

        /* We can specify two flags according to data types */
        System.out.printf("|%0+,19d|\n", myInt2);
        System.out.printf("|%0+,10.2f|\n", myDouble2);
        System.out.println();

        System.out.printf("%s-%s\n", myInt,mystr);
        System.out.printf("%2$6s-%1$6s\n", myInt,mystr);
    }
}
