import java.util.Scanner;

public class Demo1Regex {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.print("Enter nic:");
            String nic = scanner.nextLine();
            if(nic.matches("\\d{9}[Vv]")){
                System.out.println("valid nic");
            }else{
                System.out.println("Invalid nic");
            }
        }
        
        
    }
}
