public class Demo20 {
    public static void main(String[] args) {
        MyChild2 ref = new MyChild2("Static String");
        ref.doSomething(20);
    }
}

class Super2{
    int x = 10;
}

class MyChild2 extends Super2{

    static String x;
    public MyChild2(String x){
        this.x = x;
    }

    void doSomething( double x){
        System.out.println(x);
        System.out.println(this.x);
        //System.out.println((Super2)this.x);
        Super2 ref2 = this;
        System.out.println(ref2.x);
        System.out.println(((MyChild2)ref2));
        System.out.println();
    }
}
