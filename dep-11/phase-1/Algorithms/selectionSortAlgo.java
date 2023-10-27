import java.util.Arrays;

class selectionSortAlgo {
    public static void main(String[] args) {
        int[] nums = {1, 2, -2, 8, 23, -14, 3, 5};
        int end = nums.length;
        
        while(true){
            int max = nums[0],maxIndex=0;
            for (int j = 0; j < end; j++) {
                if(nums[j] > max){
                    max = nums[j];
                    maxIndex = j;
                }
            }
            int prevnum = nums[end -1];
            if(max != nums[end-1]){
                nums[end-1] = max;//
                nums[maxIndex] = prevnum;
                end--;
            }else {
                end--;
                continue;
            }
            if(end == 1) break;
        }
        System.out.println(Arrays.toString(nums));
    }    
}
