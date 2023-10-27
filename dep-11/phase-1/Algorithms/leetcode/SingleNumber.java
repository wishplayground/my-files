class SingleNumber{


    public int singleNumber(int[] nums) {
        boolean duplicate = false;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            duplicate =false;
            for (int j = 0; j < nums.length; j++) {
                if (i ==j) continue;
                if(num == nums[j]) {
                    duplicate =true;
                    break;
                }
            }
            int result = nums[i];
            if(!duplicate) return result;
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 6, 2, 3, 6};
        
       System.out.println(SingleNumber(nums));
        
    }
} 