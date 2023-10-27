import java.io.Serializable;

public  class Customer implements Serializable{
    int id;
    String name;
    String address;
    transient String contact;
    //private static final long serialVersionUID = -5453924864518703315l;
    public Customer(int id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        System.out.println("Constructor body works");
    }


}