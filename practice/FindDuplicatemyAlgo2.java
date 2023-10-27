
import java.util.Scanner;
class FindDuplicatemyAlgo2 {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("Enter a word to search duplicate: ");
        char[] input = scanner.nextLine().strip().toLowerCase().toCharArray(); 
        //String input = "we are born to code";
        //char[] letterArray = input.strip().toLowerCase().toCharArray(); 
        boolean flag =false;
        for (int i = 0; i < input.length; i++) {
            char temp = input[i];
            
            if (temp == ' ') continue;
            int duplicate = 1;
            for (int j = i+1; j < input.length; j++) {
                if(temp == input[j]){
                    duplicate++;
                    input[j] = ' ';
                    flag = true;
                }
            }
            if(duplicate >1) System.out.print(temp + " - "+ duplicate+"\n");
        }
        if(!flag) System.out.println("No match found");
    }
}
