public class Demo10 {
    static int num =10; //stores in heap memory speacial place

    public static void main(String[] args) {
        
        System.out.println(num);//10
        num = 20;
        System.out.println(num);//20
        updateValue();
        System.out.println(num);//15
    }

    public static void updateValue(){
        num = 15;
    }
}
