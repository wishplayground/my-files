public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int index = 0;
        for (int i : nums) {
            if(i == target) return index;
            index++;
        }
        return -1;
    }
}
