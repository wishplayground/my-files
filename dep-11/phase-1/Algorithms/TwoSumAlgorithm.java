import java.util.Arrays;
import java.util.Scanner;

class TwoSumAlgorithm {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] nums = {1, 3, -2, -1,4, 5, 7};
        System.out.print("Enter target number: ");
        int target = scanner.nextInt();
        scanner.nextLine();

        int targetnum = 9;
        String targetIndex = "";
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (target == num + nums[j]){
                    targetIndex = i + " " + j;
                    break;
                }else continue;
            }
        }
        if(targetIndex.isBlank()) System.out.println("Combinations can't be done in " + Arrays.toString(nums));
        else System.out.println("Combination to make number " + target + " are " + targetIndex);

    }
    
}
