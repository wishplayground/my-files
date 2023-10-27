import java.util.Arrays;

class Demo8 {
    public static void main(String[] args) {
        
        int[][] matrix = new int[3][3];
        int[] num1 = {2,3,5};
        int[] num2 = {6,2,8};
        int[] num3 = {3,1,2};

        matrix[0] = num1;
        matrix[1] = num2;
        matrix[2] = num3;
        System.out.println(Arrays.toString(matrix));
    }
}
