import java.util.Arrays;
import java.util.Scanner;

class SearchRangealgo {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] nums = {2,2};
        do{
            System.out.print("Enter target Number: ");
            int target = scanner.nextInt();
            scanner.nextLine();
            int[] output = searchRange(nums,target);
            System.out.println(Arrays.toString(output));
        }while(true);

    }

    public static int[] searchRange(int[] nums, int target) {

        int[] output = {-1,-1};
        int i = 0;
        boolean found = false;
        for (int j = 0; j < nums.length; j++) {
            if(target != nums[j]) {
                continue; 
            }else {
                
                if(found){
                    output[1] = j;
                    
                }else{
                    output[0] = j;
                    output[1] = j;
                    found = true;
                }
                    
                
            }  
        }
        return output;

        
    }
}
