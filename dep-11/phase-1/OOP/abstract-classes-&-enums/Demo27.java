import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Demo27 {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Item Service: ");
        System.out.println("2. Cart Service: ");
        System.out.println("3. Report Service: ");
        
        int choice;
        do {
            System.out.print("Enter the service type: ");
            
            choice = scanner.nextInt(); scanner.nextLine();
            scanner.close();
            if(choice >0 && choice < 4) break;
        } while (true);
        ServiceType serviceType =  ServiceType.getService(choice);
       System.out.printf("Selected service: %s\n",serviceType);
        /* if(choice == 1) serviceType = ServiceType.ITEM;
        else if(choice == 2) serviceType = ServiceType.CART;
        else  serviceType = ServiceType.REPORT; */

        
            

    }
}

enum ServiceType{
    ITEM(),CART(),REPORT();
    int sele;
    /* ServiceType(int sele){
        this.sele = sele;
    } */
    public static ServiceType getService(int index){
        for (ServiceType service : values()) {
            if(service.ordinal() +1== index) return service;
        }
        throw new RuntimeException("Invalid type");
    
    }
}


