public class Fibonnacci {
    public static void main(String[] args) {
        int i = 3;
        System.out.println("fibonnaci of "+ i + " is "+fibo(3));
    }

    public static int fibo(int i){
        if(i>=0) return i;
        return 0; 
    }
}
