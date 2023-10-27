import java.util.Arrays;

class BubbleSortAlgo {
    public static void main(String[] args) {
        //by pushing max
        int[] nums = {-5, 2, 3, 1, 7, -5, 0, 2, 2, 6, 4};
        int count = nums.length-1;
        while(count >=0){
            for (int i = 0; i < count; i++) {
                int temp = nums[i+1];
                if(nums[i] > nums[i+1]){
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                    
                }else{
                    continue;
                }
            }
            count--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
