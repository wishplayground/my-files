public class Demo33 {
    public static void main(String[] args) {
        AweSomeClass aweSomeClass = new AweSomeClass();
        System.out.println(aweSomeClass instanceof MyMarkerInterface);
        MyFun myFun = x -> x *x + 2* x + 1;
        System.out.println(myFun.something(10));

        SecondFun newFun = (x ,y) -> x * x + y*y;
        System.out.println(newFun.solve(2, 8));
    }
}


interface MyFun{
    int something(int x);
}

interface SecondFun{
    int solve(int x, int y);
}

interface MyMarkerInterface{
    //marker Interface

}

class AweSomeClass implements MyMarkerInterface{

   

    

}

@FunctionalInterface  //lamdas
interface MyFunctionalInterface{
    void myOnlyAbstractMethod();

    static void myStaticVoid(){

    }
}
