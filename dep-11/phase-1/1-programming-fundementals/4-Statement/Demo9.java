import java.util.Scanner;

class Demo9 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter yor age: ");
        char grade = scanner.nextLine().strip().charAt(0);

        /*if (grade == 'A') System.out.println("Distinguished pass");
        else if (grade == 'B') System.out.println("Credit pass");
        else if (grade == 'C') System.out.println("Pass");
        else if (grade == 'W') System.out.println("Fail");
        else System.out.println("Invalid grade");*/
        final int myGrade = 60;
        switch(grade){
        case 60+5 : System.out.println("Distinguished pass"); break;
        case 'B' :System.out.println("Credit pass"); break;
        case 'C' : System.out.println("Pass"); break;
        case 'W' : System.out.println("Fail"); break;
       default : System.out.println("Invalid grade");
        }

        switch(grade +1){
        case myGrade+5 : 
            System.out.println("Distinguished pass"); break;
        case 'B' :
            System.out.println("Credit pass");
            System.out.println("Credit pass");
            System.out.println("Credit pass");
            break;
        case 'C' : 
            System.out.println("Pass"); break;
        case 'W' :
            System.out.println("Fail"); break;
       default : System.out.println("Invalid grade");
        }
    }
}
