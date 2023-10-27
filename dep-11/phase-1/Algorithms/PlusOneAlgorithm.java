import java.util.Arrays;
import java.util.Scanner;

class PlusOneAlgorithm {
    //private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        String temp ="";
        int pow = 1,num=0;
        for (int i = nums.length -1; i >= 0; i--) {
            num += nums[i] * pow;
            pow *= 10;
        }
        num++;
        String numstring = "" + num ;
        int size =numstring.toCharArray().length;
        System.out.println(size);
        int[] newIntArray = new int[size];
        pow = ;
        for (int i =newIntArray.length -1 ; i >=0 ; i--) {
            newIntArray[i] = num%pow;
            num /= pow;
            pow /=10;
            

        }
        System.out.println(Arrays.toString(newIntArray));
        
    }    
}
