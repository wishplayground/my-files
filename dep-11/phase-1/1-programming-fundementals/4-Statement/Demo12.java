import java.util.Scanner;

class Demo12 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Select an option: ");
        System.out.println("1. proceed");
        System.out.println("2. Exit");

        System.out.print("Enter an option:");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1:
                System.out.println("Select an option: ");
                System.out.println("1. proceed");
                System.out.println("2. Exit");
                System.out.print("Enter an option:");
                option = scanner.nextInt();
                scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Enter your Name here: ");
                    
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    if (name.isBlank()){
                        System.out.println("Name can't be empty");
                        break;
                    }else System.out.println("Welcome" + name);
                        break;
                case 2:
                    System.out.println("You are about to exit");
                    break;
            }
            System.out.println("You are about to exit from final");
            break;

            case 2:
                System.out.println("about to exit");
                break;
        }


    }
}
