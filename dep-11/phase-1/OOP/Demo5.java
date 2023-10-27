class Demo5 {

    int x;

    public Demo5(int x){
        this.x = x;
    }
    void print(){

        System.out.println("X = " + x);
    }

    public static void main(String[] args) {
        Demo5 ref1 = new Demo5(5);
        Demo5 ref2 = new Demo5(10);
        Demo5 ref3 = new Demo5(15);

        Demo4 refd4 = new Demo4();

        ref1.print();
        ref2.print();
        ref3.print();
        System.out.println(ref2 instanceof Demo5);

    }
}
