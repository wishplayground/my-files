public class Factorial{
    public static void main(String[] args) {
        System.out.println(factorialOf(25));
    }

    public static int factorialOf(int i){
        if(i > 0){
            return i *= factorialOf(i-1);
        } 
        return 1;
    }
}