import java.util.Scanner;

class Demo2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput(String input){
        
        boolean valid = true;
        String instr;
    
        //validation
        do{
            System.out.printf("Enter %s: ",input);
            instr = scanner.nextLine();
            //Empty
            if(input.isBlank()){
                 valid = false;
                 System.out.printf("%s can't be Empty.\n",input);
                 continue;
            }
            for (int i = 0; i < input.length(); i++) {
                if(!(Character.isLetter(input.charAt(i)) || Character.isSpaceChar(i))){
                    valid = false;
                    System.out.printf("Invalid %s",input);
                    continue;
                }
            }
            
        }while(!valid);
        return instr;
    }
    
    public static void main(String[] args) {
        
        
        String name;
        String city;
        String age;
        
        name = getUserInput("name");
        do{
            city = getUserInput("city");
            age = getUserInput("12");
            System.out.printf("Name = %s   City = %s  Age = %s ",name,city,age);
        }while(true);


    }    
}
