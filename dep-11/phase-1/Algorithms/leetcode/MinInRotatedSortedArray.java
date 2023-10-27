class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int index = 0;
        int min = nums[index];
        while(index < nums.length){
            if(index < nums.length-1){
                if(nums[index] > nums[index+1]) {
                    min = nums[index+1]; index++;
                }else index++;
            }else break;
            
        }
        return min;
    }
}
