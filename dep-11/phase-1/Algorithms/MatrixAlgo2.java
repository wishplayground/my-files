import java.util.Arrays;

class MatrixAlgo2 {
    public static void main(String[] args) {
        
        int[][] m1 = {
                    {2, 3, -1, 2},
                    {4, -2, 7, 3},
                    {-8, 2, 1, -4}
                    }; 
        int[][] m2 = {
                    {1, 7, -8, 2},
                    {-4, 6, 2, 3},
                    {2, 3, -1, 2}
                    };

        int[][] result = new int[m1.length][m1[0].length];

        //result = m1 + 2m2

        //2m2
        for(int row = 0;row < m2.length; row++){
                int[] temprow = m2[row];
                for (int i = 0; i < temprow.length; i++) {
                    temprow[i] *= 2; 
                }
                System.out.println(Arrays.toString(m2[row]));
        }
        System.out.println();
        
        for(int row = 0;row < m1.length; row++){
                int[] m1row = m1[row];
                for (int i = 0; i < m1row.length; i++) {
                    result[row][i]=(m1row[i] + m2[row][i]);
                }
                System.out.println(Arrays.toString(result[row]));
        }
        
    }
}
