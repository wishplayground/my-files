import java.util.Arrays;
import java.util.Scanner;

class App3 {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[][] customers = new String[3][];
        
        String name,id, address;
        do{
            for (int i = 0; i < customers.length; i++) {
                System.out.print(Arrays.toString(customers[i]));
            }
            System.out.println();
            System.out.print("Enter Customer ID: ");
            id = scanner.nextLine();


            System.out.print("Enter customer name: ");
            name = scanner.nextLine();
            
            System.out.print("Enter Customer Address: ");
            address = scanner.nextLine();
            
            String[][]  newCustomer = new String[customers.length +1][3];
            for (int i = 0; i < customers.length; i++) {
                newCustomer[i] = customers[i];
            }
            newCustomer[newCustomer.length - 1][0] = id;
            newCustomer[newCustomer.length - 1][1] = name;
            newCustomer[newCustomer.length - 1][2] = address;
            customers = newCustomer;
        }while(true);
    }    
}
