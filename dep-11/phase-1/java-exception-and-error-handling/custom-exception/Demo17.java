public class Demo17 {
    public static void main(String[] args) {
        System.out.println(divide(3, 0)); //no exception return 5
        //int the end finally code block value will return if catch not exist.
    }

    private static int divide(int num1,int num2){
        try{
            return num1 /num2;
        }
        catch (ArithmeticException e){
            System.out.println("Exception Awooo");
            throw e;
        } finally {
            return 5;
        }
    }
}
