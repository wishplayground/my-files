class Demo25 {

    public static void main(String[] args) {
        myMethod(10);
        
    }


    static void myMethod(Integer... x){
        System.out.println("myMethod(...Integer)");
    }

    /* static void myMethod(int x){                        //First Chose this
        System.out.println("myMethod(int)");
    } */

    static void myMethod(Integer x){
        System.out.println("myMethod(Integer)");
    }

    static void myMethod(int... x){
        System.out.println("myMethod(...int)");
    }

    
    
}
