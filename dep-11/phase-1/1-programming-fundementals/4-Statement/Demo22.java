import java.util.Scanner;

public class Demo22 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int num1 = 0;
        //progress
        do{
            
            System.out.print("Enter a Number between 0-100: ");
            num1 = scanner.nextInt();
            scanner.nextLine();
            if (num1 < 0 || 100 < num1){
                System.out.println("Invalid number");
                continue;
            }else break;
        }while(true);


        //speed 
        System.out.println();
        int speed = 0;
        do{
            System.out.println("1. Fast");
            System.out.println("2. Medium");
            System.out.println("3. Slow");
            System.out.print("Select an Option(1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if(option< 0 || option > 3){
                System.out.println("Invalid Option");
                continue;
            }else{
                switch (option){
                    case 1: 
                        speed = 200;
                        break;
                    case 2:
                        speed = 1000;
                        break;
                    case 3:
                        speed = 1500;
                        break;
                }
                break;
            }
        }while(true);
        System.out.println();
        final int width = 100;
        //progress bar
        int count = 0;
        String percent;
        double parts = (((double)num1/100)*width); 
        do{
            percent = ""+ String.format("%.2f",((double)count/width)*100) +"%";
            //System.out.print("\b".repeat(width+3 + percent.length()));
            System.out.printf("[%s%s%s%s] %s%s","\033[42m"," ".repeat(count),"\033[0m"," ".repeat(width-count),percent,
                                "\b".repeat(width+3 + percent.length()));
            Thread.sleep(speed);
            if (count == parts ){
                break;
            }
            
        }while( count++ < width);
        System.out.println("      Completed!!");
    }
}
