import java.util.*;
class linearSearchAlgo {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        int[] nums = {1, 2, 45, 10, -2, -5, 0};
        do{            
            System.out.print("Enter number to search: ");
            int search = scanner.nextInt();
            scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < nums.length; i++) {
                if(search == nums[i]){
                    System.out.println("Found at index of: " + i);
                    found = true;
                    break;
                }
            }
            if (found == false) System.out.println("Not in the Data set.");
        }while(true);
    }
}