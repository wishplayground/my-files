public class Demo30 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        String result = (++a == b) ? "Dep - " + (10+1) : "IJSE";
        System.out.println(result); 

        System.out.println();
        
        b = ++b > a ? (b = ++a + b) : (a = a++ + b);
        System.out.println("b = " + b);
        System.out.println("a = " + a);
        System.out.println();

        int x1;
        int y1;
    
        x1 = (y1 = 5);
        System.out.println(x1);
        System.out.println(y1);
        


    }
}
