import java.util.Scanner;

public class ReverseIntegerAlgo {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println(Integer.MAX_VALUE+" rev "+reverse(number));

        
    }
    public static int reverse(int number){
        double rev=0;
        
        
        while(number != 0){
            rev += (number%10);
            number /=10;
            if(rev > Integer.MAX_VALUE || rev <Integer.MIN_VALUE) return 0;
            rev*=10;
            
        }
        rev /= 10;
        
        return (int)rev;
    }
}
