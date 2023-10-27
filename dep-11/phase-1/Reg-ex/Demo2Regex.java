import java.util.Scanner;

public class Demo2Regex {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        loop:
        while(true){
            System.out.print("Enter your contact number: ");
            String contact = /* "+9477-1234567"; // */scanner.nextLine();
            //contact format 077-1234567 or 

            if (contact.matches("(0\\d{2}-\\d{7})|([+]94\\d{2}-\\d{7})")){//
                System.out.println("Valid contact");
            }else{
                System.out.println("InValid contact number");
            }

            
        }
        




    }
}
