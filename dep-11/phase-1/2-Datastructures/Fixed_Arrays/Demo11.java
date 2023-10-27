class Demo11 {
    public static void main(String[] args) {
        
        int[] array1 = {2,-3,1},array2 = {5,7,8};
        int[][][] my3DArray = {null,null};
        int[][] my2Drepeat_array = {array1,null,array1}, my2Drepeat2 = {array1,null,array2};

        int[][][][] my4DArray = {my3DArray,my3DArray,null,{my2Drepeat_array,null,my2Drepeat2}, {{{10,20,30},array1,array1},null,my2Drepeat2,null}, 
                                null};

        System.out.println(my4DArray.length == 6);
        System.out.println(my4DArray[0]== my4DArray[1]);
    }    
}
