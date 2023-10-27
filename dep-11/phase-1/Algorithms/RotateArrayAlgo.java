import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayAlgo {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //if revolution =0 no rotation if revolution is positive clockwise rotation if negative array rotates counterclockwise
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.print("Enter revolutions: ");
        int rev = scanner.nextInt();
        scanner.nextLine();

        if(rev == 0 ){
            System.out.println(Arrays.toString(nums));
        }else if (rev > 0){
            int count =0;
            while(rev < count){
                int store = 0;
                for (int i =nums.length-1; i >= 0; i--) {
                    //can do without if
                    if(i == nums.length-1){
                        store = nums[i];
                        nums[i] = nums[i-1];
                    }else if(i>0){
                        nums[i] = nums[i-1];
                    }else   break;
                }
                nums[0] = store;
                count++;
            }
            System.out.println(Arrays.toString(nums));
        }else{
            int count = rev;
            while(count <0 ){
                int store = 0;
                for (int i =0; i < nums.length; i++) {
                    if(i == 0){
                        store = nums[i];
                        nums[i] = nums[i+1];
                    }else if(i<nums.length-1){
                        nums[i] = nums[i+1];
                    }else   break;
                }
                nums[nums.length -1] = store;
                count++;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
