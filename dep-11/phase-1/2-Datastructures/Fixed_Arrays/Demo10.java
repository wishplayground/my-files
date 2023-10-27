class Demo10 {
    public static void main(String[] args) {
        

        /*int[][][][] my3DArrays = { 
                                { {{10,20},{10,20},{5,7,8}} ,null, {{10,20}, null, {-2,3,5}}},
                                null,
                                null, 
                                { {{10,20}, null, {-2,3,5}}, null,null, {{10,20}, null, {-2,3,5}}}};*/

        int[] array1 = {10,20};

        int[][] my2Drepeat = {array1,null, {-2,3,5}};

        int[][][][] my4DArray = { {{array1,array1,{5,7,8}},null, my2Drepeat},
                                null,
                                null,
                                {my2Drepeat,null,my2Drepeat}};
    }    
}
