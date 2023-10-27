public class SingleNumberAlgo {

    //find unique number from given number set
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7, 2, -1, 3, -1};
        int out= findDuplicate(nums);
        System.out.println(out);
    }

    public static int findDuplicate(int[] nums){
        // find unique num
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            boolean duplicate = false;
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(number==nums[j]){
                    duplicate = true;
                    
                }    
            }
            if(!duplicate) index = i;
        }
        return nums[index];
    
    }
}
