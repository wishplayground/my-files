public class Demo19 {
    public static void main(String[] args) {
        Sub2 s1 = new Sub2();
        s1.print();
    }
}

class Parent2{

    int x =10;
    void print(){
        System.out.println(x);
        System.out.println(this.x);
        System.out.println();
    }
}

class Sub2 extends Parent2{
    int x =20;
}
