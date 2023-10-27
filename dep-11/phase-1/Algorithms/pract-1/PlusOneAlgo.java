import java.util.Arrays;

class PlusOneAlgo {

    //given number set {1,2,3,0} make them as intiger like 1230  and add one to them and return 1231
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOneAlgo(nums)));
    }  
    
    public static int[] plusOneAlgo(int[] nums){

        int power = 0,newnum =0;
        for (int i = nums.length-1; i >= 0; i--) {
            newnum += nums[i] * Math.pow(10, power);
            power++;
        }

        newnum++;
        int[] output = new int[(newnum +"").length()];
        int iter = 0;
        for (int i = (newnum+"").length() -1; i >= 0; i--) {
            output[i]=newnum%10;
            newnum /=10;
            iter++;
        }
        return output;
    }
    
}
