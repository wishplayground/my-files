class MajorityElementAlgo {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,1,2,1};
        System.out.println(majorityElement(nums));
        
         
    }


    /* public static int majorityElement(int[] nums) {
        int maxcountIndex = 0,previousCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int number = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(i ==j ) continue;
                if(number == nums[j]) {
                    count++;
                   
                }
                
            }
            if(count > previousCount){
                previousCount = count;
                maxcountIndex = i;
            }
        }
        return nums[maxcountIndex];
    } */

    
    //to avoid time complexity Boyer-Moore Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 0;
        int selctedNum = 0;
        for (int number : nums) {
            if(count == 0){
                selctedNum = number;
                count = 1;
            }else if (number == selctedNum) count++;
            else count--;
        }
        return selctedNum;
    }

}
