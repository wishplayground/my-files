class Demo1{
    public static void main(String[] args) throws Exception {
        //class loading

        //1. Explicitly
        //Class.forName("Full qualified class name")
        //Class.forName("Customer");

        //Implicitly
        //1. acceccing static members (initiallizer is not a member)
        System.out.println(Customer.something);
        Customer.doSomething();

        //2. Creating new instances class loads only once to the RAM
        new Customer();
        new Customer();
        new Customer();
        new Customer();
        new Customer();
    }
}