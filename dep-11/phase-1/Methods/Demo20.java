class Demo20 {
    public static void main(String[] args) {
        myMethod1(10);//Strinct Invocation

        //Lose Invocation
        myMethod2(20);
        myMethod2(30);
        
    }

    static void myMethod1(int i){
        System.out.println("My method 1");
    }


    //Method OverLOading
    static void myMethod2(int x){
        System.out.println("My method 2(int)");
    }

    static void myMethod2(long x){
        System.out.println("My mEthod 2(long)");
    }
}
