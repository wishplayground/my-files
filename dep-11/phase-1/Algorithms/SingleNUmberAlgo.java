class SingleNUmberAlgo {
    public static void main(String[] args) {
        //find the unique number in the set
        int[] nums = {2, 6, 4, 5,3 ,7, 4, 2, 5, 1, 6, 1, 6, 4};
        
        int dup = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];//3
            boolean found=false;
            for (int j = 0; j < nums.length; j++) {
                if(i ==j) continue;
                if (number == nums[j]){
                    found =true;
                    dup++;
                    continue;
                }
                    
            }
            if(!found) System.out.println(number +" is a Unique number found at " + i );
            
        }

    }    
}
