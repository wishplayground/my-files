import java.util.Scanner;

public class Demo1{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        outer:
        while(true){
            System.out.print("Enter your NIC: ");
            String nic = scanner.nextLine();
            //nic format 123456789v
            if(nic.length() !=10){ System.out.println("invalid nic"); continue;}

            for (int i = 0; i < 9; i++) {
                if(Character.isDigit(nic.charAt(i))){
                    System.out.println("Invalid nic");
                    continue outer;
                }
            }

            if(!(nic.endsWith("v")|| nic.endsWith("V"))){
                System.out.println("Invalid nic");
                continue;
            }
        }
        
    }
}