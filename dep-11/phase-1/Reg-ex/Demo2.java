import java.util.Scanner;

public class Demo2 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        loop:
        while(true){
            System.out.print("Enter your contact number: ");
            String contact = scanner.nextLine();
            //contact format 077-1234567 or +9477-1234567

            if(!(contact.length() == 11 || contact.length()==13)){
                System.out.println(contact.length());
                System.out.println("Invalid contact len");
                continue;
            }

            //valid 1
            if(!(contact.startsWith("077-") || (contact.startsWith("+9477-")))){
                System.out.println("Invalid contact start");
            }
            for (int i = 0; i < contact.length() ; i++) {
                if(contact.charAt(i) == '-' || contact.charAt(i) == '+') continue;
                if(!Character.isDigit(contact.charAt(i))) {
                    System.out.println("Invalid contact digit"); 
                    continue loop;
                }
            }

            System.out.println("Valid contact number");
        }
        




    }
}
