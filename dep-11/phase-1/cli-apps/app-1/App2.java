import java.util.Arrays;
import java.util.Scanner;

class App2 {
    private final static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        final String clear = "\033[H\033[2J";
        
        final String color_Red = "\033[1;31m",reset = "\033[0m";

        final String DASHBOARD = "Customer Management System";
        final String ADD_CUSTOMER = "Add Customer";
        final String REMOVE_CUSTOMER = "Delete Existing Customer";
        final String PRINT_CUSTOMER = "Print Customer details:";
        String screen = DASHBOARD;
        

        //welcome interface

        String[] customerID = new String[0];
        String[] customerName = new String[0];
        main_loop:
        do{
            final String window_title = String.format("%s%s%s%s\n","\033[1;33m"," ".repeat(22),screen,"\033[0m");
            System.out.println(clear);
        
            System.out.println("-".repeat(60));
            System.out.print(window_title);
            System.out.println("-".repeat(60));
            main_switch:
            switch(screen){
                case DASHBOARD:
                    System.out.println("\033[0;32m1) Add Customer ");
                    System.out.println("2) Remove customer ");
                    System.out.println("3) Print customer details ");
                    System.out.println("4) Exit \033[0m");
                    System.out.print("Select an Option to continue >> ");
                    int select = scanner.nextInt();
                    scanner.nextLine();

                    switch(select){
                        case 1:screen = ADD_CUSTOMER; break;
                        case 2: screen = REMOVE_CUSTOMER;break;
                        case 3: screen = PRINT_CUSTOMER;break;
                        case 4: System.exit(0);
                        default: continue;   
                    }
                    break;
                
                case ADD_CUSTOMER:

                    //ID validation and Input
                    String ID;
                    loop_customer:
                    while(true){
                        System.out.print("Enter Customer ID: ");
                        
                        ID = scanner.nextLine();
                        boolean exist =false;
                        for (int i = 0; i < customerID.length; i++) {
                            if(ID.strip() == customerID[i]) exist = true; break;
                        }
                        if(ID.strip().isBlank()) {
                            System.out.print("Id cannot be Empty. Try Again"); 
                            continue;
                        }else if(!ID.startsWith("C-")){
                            System.out.print("Not a valid ID. Try Again!!\n");
                            continue;
                        }else {
                            for (int i = 0; i < customerID.length; i++) {
                                if(ID.strip() == customerID[i]) exist = true; break;
                            }
                            if(exist){
                                System.out.print("Already Existing Customer ID.");
                                continue;  
                            }else break ;
                        }
                    }
                    String[] newCustomerId = new String[customerID.length+1];
                    for (int i = 0; i < customerID.length; i++) {
                        newCustomerId[i] = customerID[i];
                    }
                    newCustomerId[newCustomerId.length-1] = ID;
                    customerID = newCustomerId;

                    //Name validation and store
                    String name;
                    loop_name:
                    do{
                        System.out.print("Enter Customer Name: ");
                        name = scanner.nextLine();
                        boolean valid =true;
                        char[] validname = name.toCharArray();
                        for (int i = 0; i < validname.length; i++) {
                            char letter = validname[i];
                            if(letter > 128 || letter < 0 ) {
                                valid = false;
                            }
                        }
                        if(name.strip().isBlank()) {
                            System.out.print("Id cannot be Empty"); 
                            continue;
                        
                        }else if(!valid) {
                            System.out.print("Not a valid name.Enter name again");
                            continue loop_name;
                        }else break;
                    
                    }while(true);
                    String[] newCustName = new String[customerName.length+1];
                    for (int i = 0; i < customerName.length; i++) {
                        newCustName[i] = customerName[i];
                    }
                    newCustName[newCustName.length-1] = name;
                    customerName = newCustName;
                    System.out.println("Customer ID"+Arrays.toString(customerID));
                    System.out.println(Arrays.toString(customerName));
                    System.out.printf("Cool %s has been added.Do you want to Add another customer(Y/N): ",name);
                    if(scanner.nextLine().strip().equals("Y")){
                        screen = ADD_CUSTOMER;
                        break;
                    }else {
                        screen = DASHBOARD;
                        break;
                    }
            }
        }while(true);
    }
}
