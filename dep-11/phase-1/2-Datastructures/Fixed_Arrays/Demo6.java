class Demo6 {
    public static void main(String[] args) {

        /*
         * Datatype[] identifier;
         * 
         * DataType identifier[];
         *  DataType [] identfier;
         * DataType []identifier;
         * 
         * identifier = new datatype[size]
         * identifier = new DataType[]{value1,value2,value3}
         * 
         * identifier = {value1,value2,value3,value4} wrong
         * 
         * DataType[] identifier = {value1,value2,value3}
         */
        int myInt;
        myInt = 10;

        int[] myarray;
        myarray = new int[]{myInt,20,30,myInt,50};

        int[] nums = {1,2,3,myarray[myarray.length-1]};

        for (int i = 0; i < nums.length; i++) {
            myarray[i] = nums[i];
            
        }
        nums = null;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}