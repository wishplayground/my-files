import mypackage.Customer;
public class Demo24 {
    public static void main(String[] args) {
        /* Customer customer = new Customer();
        customer.id = 98;
        customer.name = "Aruna";
        customer.address = "Minuwangoda";
        customer.contact = "023-5616155"; */

        CrazyCustomer customer = new CrazyCustomer();
        /* customer.id = 98;
        customer.name = "Aruna";
        customer.address = "Minuwangoda"; */
        customer.contact = "023-5616155";
    }
}

class CrazyCustomer extends Customer{
    public CrazyCustomer(){
        // id = 1;
        // name = "vidura";
        address = "Kandy";
        contact = "651-6849616";
    }

    public void print(){
        super.print();//call customer print method
    }

}