import java.util.Arrays;
import java.util.Scanner;

class MatrixAlgo3 {
    
    public static void main(String[] args) {
        int[][] m = {
                    {2, 3, -1, 2},
                    {4, -2, 7, 3},
                    {-8, 2, 1, -4},
                    {3, -5, 6, 7}
                    }; 
        //transpose
        int[][] trans = new int[4][4]; //new int[size][] when assigning value null pointer exception come. need to new int[size][size]
        for (int i = 0; i < m.length; i++) {
            //int[] temp = m[i];
            for (int j = 0; j < m.length; j++) {
                trans[i][j] = m[j][i]; 
            }
            System.out.println(Arrays.toString(trans[i]));
            
        }

        
        
    }
}
