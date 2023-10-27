public class emo16 {
    public static void main(String[] args) {
        try{
            System.out.println("Entering try Block");
            //System.out.println(5/0);
            System.out.println(5/1);
            System.out.println("Exiting try block");
        }catch (ArithmeticException e){
            System.out.println("Arithmetic Exception");
        }finally{
            System.out.println("Finally Executed");
        }
    }
}
