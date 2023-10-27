import java.util.Arrays;

class MatrixAlgo1 {
    
    public static void main(String[] args) {
        //print negative matrix
        int[][] my2DArray = {{2, 3, -1, 2}, {4, -2, 7, 3}, {-8, 2, 1, -4}};

        for(int row = 0;row < my2DArray.length; row++){
            int[] temprow = my2DArray[row];
            for (int i = 0; i < temprow.length; i++) {
                temprow[i] *= (-1); 
            }
            System.out.println(Arrays.toString(my2DArray[row]));
        }

    }
}
