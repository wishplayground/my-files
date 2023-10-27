import java.util.Scanner;

class Demo8 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /*Syntax 1
         * if(boolean expression);
         * 
         * syntax 2
         * else if(boolean expression){}     
         * else if(boolean expresion){}
         * 
         * else statement;
         * 
         * Syntax 3
         * if (booleand expression){
         *      statement(s);
         * }
         * 
         * Syntax 4
         * 
         * if(boolean expression){
         *      Statement;
         * }else if (Boolean expeasion){
         *      Statement(s)
         * }else{
         *      Statement(s)
         * }
         */

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        //bad practice
        /*if (name.length() >0) 
        System.out.printf("Name is %s",name); */
        if (name.length() >0) System.out.printf("Name is %s\n",name); //good practice when there is one statement
        else System.out.println("Invalid name");
        
    }
}
