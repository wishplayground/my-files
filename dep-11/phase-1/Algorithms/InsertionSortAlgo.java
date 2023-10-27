import java.util.Arrays;

class InsertionSortAlgo {
    
    public static void main(String[] args) {
        //1. using linear search
        int[] nums = {3, -2, -5, 4, 2, 4, 6, -3};
        //{3 | -2, -5, 4, 2, 4, 6, -3}
        //sorted              unsorted side
        

        //find insert position
        int index =0;
        for (int i = 1; i < nums.length; i++) {
            int insert = nums[i];
            for (int j = 0; j <i ; i++) {
                if(insert > nums[j] ) index = j;
            }
        }

        //shifting
        
        int temp = nums[index];
        for (int k = i; k >= 0; k++) {
            
        }
        
        //System.out.println(Arrays.toString(nums));

        //2. binary search
    }
    
}
