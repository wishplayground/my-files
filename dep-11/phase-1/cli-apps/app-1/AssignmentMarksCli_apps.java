import java.util.Arrays;
import java.util.Scanner;

class AssignmentMarksCli_apps {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        final String clear = "\033[H\033[2J";
        final String color_Blue = "\033[1;34m",color_green = "\033[0;32m",Purple = "\033[0;35m",reset ="\033[0m",Yellow = "\033[0;33m",GREEN_BACKGROUND = "\033[42m";

        final String Dashboard = "welcome to dep-11";
        final String Add_Marks = "Add assignmetn marks";
        final String Print_Marks = "Print Assignment marks";
        
        
        String screen = Dashboard;
        String id ="";
        String name;
        String marks = "";

        //Arrays add dummy datas for checking

        String[][] students = new String[][] {{"DEP-01","sdsds","60.68"},{"DEP-04","dscv","70.99"},
                                                {"DEP-03","vdfd","80.50"},{"DEP-06","svvs","50.11"}};

        main_loop:
        do{
            //Title
            System.out.print(clear);
            String line = String.format("%s%s%s",color_green,"-".repeat(60),reset);
            String title = String.format("%s%s%s%s",color_Blue," ".repeat((60 - screen.length())/2),screen.toUpperCase(),reset);
            System.out.println(line);
            System.out.println(title);
            System.out.println(line);
            lbl_main:
            switch (screen){
                
                case Dashboard:
                    System.out.println("[1]. Add Asignment Marks");
                    System.out.println("[2]. Print Assignment Marks");
                    System.out.println("[3]. Exit");
                    System.out.print("Enter an Option to Continue >> ");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch(option){
                        case 1 : screen = Add_Marks;break;
                        case 2 : screen = Print_Marks;break;
                        case 3 : System.exit(0);break;
                        default : continue;
                    }
                    break;
                
                case Add_Marks:
                    //Marks validation
                    boolean validName = false;
                    
                    loop_id:
                    while(true){
                        System.out.print("Enter Student ID (eg: DEP-01): ");
                        id = scanner.nextLine();

                        boolean exist =false;
                        //empty
                        if(id.strip().isBlank()) {
                            System.out.print("Id cannot be Empty. Try Again"); 
                            continue;
                        }
                        if(!(id.startsWith("DEP-") || id.length() != 6)){
                            System.out.print("Not a valid ID. Try Again!!\n");
                            continue;
                        }else{
                            String digitpart = id.substring(4);
                            for (int i = 0; i < students.length; i++) {
                                if(!Character.isDigit(digitpart.charAt(i))) {
                                    System.out.println("Invalid Id ");
                                    continue loop_id;
                                }
                            }
                        }
                        //check exist
                        for (int i = 0; i < students.length; i++) {
                            String[] tempstu = students[i];
                            if(id.equalsIgnoreCase(tempstu[0])) exist = true;
                        }
                        if(exist){
                            System.out.print("Already Existing Student ID.");
                            continue;  
                        }
                        break;
                    }
                    
                    //name validation
                    
                    loop_name:
                    do{
                        System.out.print("Enter Student name: ");
                        name = scanner.nextLine().strip();
                        if(name.isBlank()) {
                            System.out.println("Name cannot be Empty. Try Again");
                            continue;
                        }else{
                            for (int i = 0; i < name.length() ; i++) {
                                if(!(Character.isLetter(name.toLowerCase().charAt(i)) || Character.isSpaceChar(i))) {
                                    System.out.print("Invalid Name. Do you want Enter a valid name? (Y/N) >> ");
                                    if(scanner.nextLine().strip().toUpperCase().equals("Y")) continue loop_name;
                                    screen = Dashboard;
                                    break loop_name;
                                }
                            }
                        }
                    }while (true); 
                        
                    
                    //marks validate

                    do{
                        System.out.print("Initial Deposit: ");
                        double mrk = scanner.nextDouble();
                        scanner.nextLine();
                        if(mrk > 100 || mrk<0){
                            System.out.print("Marks should be within 0 -100\n Do you want to continue(Y/N): ");
                            if(scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                            else screen = Dashboard; break;
                            
                        }else{
                            System.out.printf("%s%s%s has been Added\n",Yellow,id,reset);
                            marks +=mrk;
                            break;
                        }

                        
                    }while(true);

                    //store data
                    String[][] newStu = new String[students.length +1][3];
                    for (int i = 0; i < students.length; i++) {
                        newStu[i] = students[i];
                    }
                    newStu[newStu.length -1][0] = id;
                    newStu[newStu.length -1][1] = name;
                    newStu[newStu.length -1][2] = marks;
                    students = newStu;

                    System.out.print("Do you want to add another account (Y/N): ");
                        if(scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                        else screen = Dashboard; break;

                case Print_Marks:
                    if( students.length ==0){
                            System.out.println("No Records found:"); 
                            break main_loop;
                    }

                    //sort algorithm find max and place infront of the array
                
                    //find max
                    for (int j = 0; j < students.length; j++) {
                        double max= Double.valueOf(students[j][2]);
                        int index=0;
                        for (int i = 0; i < students.length; i++) {
                            if(Double.valueOf(students[i][2]) > max){
                                max = Double.valueOf(students[i][2]);
                                index = i;
                            }
                        }
                        String[] temp = students[students.length-1 - j];
                        students[students.length -1 - j] = students[index];
                        students[index] = temp;
                        
                    }
                    for (int i = 0; i < students.length; i++) {
                        System.out.println(Arrays.toString(students[i]));
                    }
                   
                    //table create
                    String tblline = String.format("+"+"-".repeat(8) + "+" + "-".repeat(12)+"+" + "-".repeat(33)+"+");
                    System.out.println(tblline);
                    System.out.printf("| %-6s | %-10s | %-32s|\n","ID","Name","Marks");
                    System.out.println(tblline);

                    
                    //String details = String.format("| %s | %-10s | %s %s|\n");//35
                    for (int i = 0; i < students.length; i++) {
                        //arrange marks
                        double mrks = Double.valueOf(students[i][2]);

                        int spaces = (int)mrks/5;
                        String status = mrks >= 75 ? "A": mrks >= 65 ? "B" : mrks >= 55 ? "C" : "F";
                        String color = status == "A" ? "\033[42m" : status == "B" ? "\033[44m" : status == "C" ? "\033[43m" : "\033[41m";
                        System.out.printf("| %6s | %-9s  | %s %s%% [%s%s%s%s] |\n",students[i][0],students[i][1],status,students[i][2],color," ".repeat(spaces),reset," ".repeat(20-spaces));
                    }
                    System.out.println(tblline);
                    break main_loop;
                    
                
            }   
        }while(true);
    }
}
