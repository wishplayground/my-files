import java.util.Scanner;

class Demo21 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String name;
        boolean errorname;
        do{
            System.out.print("Enter your Name: ");
            name = scanner.nextLine();
            if(name.isBlank()){
                System.out.println("Invalid name");
                errorname = true;
                continue;
            }else{
                errorname = false;
            }
        }while(errorname);

        int sub =1;
        int marks1 = 0,marks2  = 0,marks3 = 0;

        do{
            System.out.print("Enter your marks for subject "+ sub+" : ");
            int marks = scanner.nextInt();
            scanner.nextLine();
            if (0 <= marks && marks <= 100){
                switch (sub){
                    case 1:
                        marks1 = marks;
                        break;
                    case 2:
                        marks2 = marks;
                        break;
                    case 3:
                        marks3 = marks;
                }
                sub++;
            }else{
                System.out.println("Invalid marks");
                continue;
            }
            


        }while (sub < 4);
        int total = marks1 + marks2 + marks3;
        double avgmarks = (double)total / 3;
        System.out.println("Total is " + total);
        System.out.printf("Average marks is %.2f%%\n",avgmarks);
    }
    
}
