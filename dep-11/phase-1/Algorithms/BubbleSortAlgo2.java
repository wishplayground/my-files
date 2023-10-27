import java.util.Arrays;

class BubbleSortAlgo2 {
    public static void main(String[] args) {

        //by pushing min
        int[] nums = {-5, 2, 3, 1, -6, 7, -5, 0, 10, 2, 2, 6, 4};
        int count = nums.length-1;
        while(count > 0){ 
            for (int i = nums.length-1; i > 0; i--) {
                int temp = nums[i -1];
                if(nums[i] < nums[i-1]){
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                }
            }
            count--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
