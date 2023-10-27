import java.util.Arrays;
import java.util.Scanner;

public class TwoSumAlgo {
    private static final Scanner scanner = new Scanner(System.in);

    //find two numbers from a given set that can aquire user input target number adding them
    public static void main(String[] args) {

        int[] nums = {1, 4, 6, 2, 7, 9, 3, -4, -1, -5};
        System.out.print("Enter target number: ");
        int target = scanner.nextInt();
        scanner.nextLine();
        int[] result = findTwoSum(nums, target);

        System.out.println("Summation can be using " + Arrays.toString(result));

    }   
    
    public static int[] findTwoSum(int[] nums, int target){
        int[] temp = new int[2];
        loop:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(target != nums[i] + nums[j]) continue;
                else {
                    temp[0] = nums[i];
                    temp[1] = nums[j];
                    break;
                }
            }
        }
        return temp;
    }
    
}
