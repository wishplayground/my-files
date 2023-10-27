class Demo4 {
    
    static int x =10;

    public Demo4(){
        super();
        //invisible Line
        System.out.println("Constructor Ends here");
    }

    static{
        System.out.println("This is static Initiallizer");
    }

    void print(){
        int x = 10;
        System.out.println(x);
    }

    void print(int a){
        
        System.out.println(a);
    }
    static{
        System.out.println("Static initiallier after print");
    }

    public static void main(String[] args) {
        int x = 23;
        //if no constructors created JVM creates No arg Constructor
        new Demo4().print(); //to accese instance methods
        //new Demo4().print(x);

    }
}
