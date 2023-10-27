import java.util.Scanner;

class App1{
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final String clear = "\033[H\033[2J";
        
        final String color_Red = "\033[1;31m",reset = "\033[0m";

        final String DASHBOARD = "WELCOME TO SMS";
        final String ADD_STU = "Add Student";
        final String REMOVE_STU = "Remove Student";
        final String PRINT_STU = "Print Student details:";
        String screen = DASHBOARD;
        

        //welcome interface

        String[] student = new String[0];
        
        do{
            System.out.println(clear);
            final String title = String.format("%s%s%s%s\n","\033[1;33m"," ".repeat(22),screen,"\033[0m");
            
            System.out.println("-".repeat(60));
            System.out.print(title);
            System.out.println("-".repeat(60));

            switch(screen){
                case DASHBOARD:
                    System.out.println("\033[0;32m1) Add Student ");
                    System.out.println("2) Remove Student ");
                    System.out.println("3) Print Student details ");
                    System.out.println("4) Exit \033[0m");
                    System.out.print("Select an Option to continue: ");
                    int select = scanner.nextInt();
                    scanner.nextLine();

                    switch(select){
                        case 1:screen = ADD_STU; break;
                        case 2: screen = REMOVE_STU;break;
                        case 3: screen = PRINT_STU;break;
                        case 4: System.exit(0);
                        default: continue;

                        
                    }
                case ADD_STU:
                    System.out.printf("New Student ID: S%03d",student.length +1);

                    boolean valid = true;
                    String name;
                    do{
                        System.out.print("Enter Student Name: ");
                        
                        name = scanner.nextLine();
                        if(!name.strip().isBlank()){
                            System.out.println(String.format("%s Name Can not be Empty %s",color_Red,reset));
                            valid =false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if(!(Character.isLetter(name.charAt(i)) || Character.isSpaceChar(name.charAt(i)))){
                                System.out.println(String.format("%s Invalid Name %s",color_Red,reset));
                            }
                        }

                       
                    }while(valid);

                    String[] newStudent = new String[student.length+1];
                    for (int i = 0; i < student.length; i++) {
                        newStudent[i] = student[i];
                    }
                    newStudent[newStudent.length-1] = name;
                    student = newStudent;

                    System.out.println();
                    System.out.print(name + " added sucessfully. Do you want to add new student (Y/n)? ");
                    if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;
                default:
                    System.exit(0);

                
                case PRINT_STU:
                    if(student.length ==0){
                        System.out.println(String.format("%s No Student Records Found, Please add new student %s",color_Red,reset));
                    }else{
                        final String Line = "+" + "-".repeat(6) + "+" + "-".repeat(15) + "+";
                        System.out.println(Line);
                        //Header
                        System.out.printf("|%-6s|%-15s|\n","ID","NAME");
                        System.out.println();

                    }

                    System.out.print("Do you want to go back? (Y/N)");

                    if(scanner.nextLine().strip().toUpperCase().equals("Y")) screen = DASHBOARD;
                    break;
                
            }

    }while(true);
    }
}