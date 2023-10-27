public class Demo16 {
    public static void main(String[] args) {
        MyA ref = new MyA();
        System.out.println(ref.x);
        ref.print();

    }
}


class MyA{

    int x = 10;

    void print(){}
}

class MyB extends MyA{
    int x = 12;

}

class MyC extends MyB{
    @Override
    void print(){
        System.out.println(x);//access hidden variable
    }
}