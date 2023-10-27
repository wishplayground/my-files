public class Demo15 {
    public static void main(String[] args) {
        try{
            System.out.println("Entering try Block");
            System.out.println(5/0);
        } finally{
            System.out.println("Finally Executed");
        }
    }
}
