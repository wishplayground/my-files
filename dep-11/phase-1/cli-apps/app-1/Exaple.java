import java.util.Scanner;

public class Exaple {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "👷 Welcome to SMS";
        final String ADD_STUDENT = "➕ Add New Student";
        final String PRINT_DETAILS = "🖨 Print Student Details";

        String[] students = new String[0];
        String screen = DASHBOARD;

        do {
            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            // System.out.println("-".repeat(30));
            System.out.println("\t" + APP_TITLE + "\n");
            // System.out.println("-".repeat(30));

            switch(screen){
                case DASHBOARD: 
                    System.out.println("\t[1]. Add New Student");
                    System.out.println("\t[2]. Print Student Details");
                    System.out.println("\t[3]. Exit\n");
                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){
                        case 1: screen = ADD_STUDENT; break;
                        case 2: screen = PRINT_DETAILS; break;
                        case 3: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }
                    break;
                case ADD_STUDENT:
                    System.out.printf("\tNew Student ID: S%03d \n", (students.length + 1));

                    boolean valid;
                    String name;
                    do{
                        valid = true;
                        System.out.print("\tEnter Student Name: ");
                        name = SCANNER.nextLine().strip();
                        if (name.isBlank()){
                            System.out.printf("\t%sName can't be empty%s\n", COLOR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf("\t%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);

                    String[] newStudents = new String[students.length + 1];
                    for (int i = 0; i < students.length; i++) {
                        newStudents[i] = students[i];
                    }
                    newStudents[newStudents.length -1] = name;
                    students = newStudents;

                    System.out.println();
                    System.out.print("\t" + name + " added sucessfully.\n\tDo you want to add new student (Y/n)? ");
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;
                case PRINT_DETAILS:
                    
                    if (students.length == 0){
                        System.out.printf("\t%sNo students records found, please add a new student!%s \n",
                                    COLOR_RED_BOLD, RESET);                        
                    }else {
                         final String LINE = "\t+" + "-".repeat(6) + "+" + "-".repeat(15) + "+";
                         System.out.println(LINE);
                         // Header
                         System.out.printf("\t|%-6s|%-15s|\n", "ID", "NAME");
                         System.out.println(LINE);
                         // Body
                         for (int i = 0; i < students.length; i++) {
                            String id = String.format("S%03d", (i+1));
                            System.out.printf("\t|%-6s|%-15s|\n", id, students[i]);  
                         }
                         System.out.println(LINE);
                    }

                    System.out.print("\tDo you want to go back? (Y/n) ");
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) screen = DASHBOARD;
                    break;
            }
            
        }while(true);
    }
}
