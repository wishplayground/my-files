public class Demo21 {
    public static void main(String[] args) {
        myMethod(10);
        myMethod(true);
        
    }

    static void myMethod(int x){
        System.out.println("myMethod(int)");
    }

    static void myMethod(boolean x){
        System.out.println("myMEthod(boolean)");
    }
}
