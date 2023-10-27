package mypackage;

public class Customer {
    private int id;
    String name;
    protected String address;
    public String contact;

    protected void print(){
        System.out.printf("id= %s   name = %s   address = %s   Contact= %s\n",id,name,address,contact);
    }
}
