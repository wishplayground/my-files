import java.util.Arrays;

public class Demo5 {
    
    public static void main(String[] args) {
        int a = 5;
        int [] b = {5};

        myMethod1(a);//copy a value to num argument ==> num = 5  --> num = 10;
        System.out.println(a); //
        myMethod2(b); //copy array b memory location to nums --> nums[0] = 10
        System.out.println(Arrays.toString(b));

    }

    public static void myMethod1(int num){
        num = 10;
    }

    public static void myMethod2(int[] nums){
        nums[0] = 10;
    }
}
