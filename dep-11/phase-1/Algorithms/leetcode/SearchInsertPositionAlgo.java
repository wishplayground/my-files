import java.util.Scanner;

public class SearchInsertPositionAlgo {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.print("Enter target value: ");
        int target = scanner.nextInt();
        scanner.nextLine();

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int count = 0;
        for (int number : nums) {
            if(number >= target) return count;
            else count++;
        }
        return 0;
    }
}
