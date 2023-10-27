 class Customer {
    public static String something = "Hello";//static member & variable

    //Instance variable
    public int batch = 11;


    //object/ instance initiallizer
    {
        System.out.println("Non-Static Initiallizer 1");
    }

    //customer Constructor
    public Customer(){
        super();//implicitly created and run constructor in supper class
        //Initiallizer non Static variables,methods, initiallizers         AND OBJECT INITIALIZER HERE
        System.out.println("Customer() constructor");
    }

    //Static initiallizer
    static {
        System.out.println("Customer class has been initiallized");
    }

    //Static Method
    public static void doSomething(){ //static member
        System.out.printf("%s World! \n",something);
    }

    {
        System.out.println("Instance Initiallizer 2");
    }

    //instace Method
    public void print(){
        System.out.println("Direct Entry programe " + batch);
    }
}
