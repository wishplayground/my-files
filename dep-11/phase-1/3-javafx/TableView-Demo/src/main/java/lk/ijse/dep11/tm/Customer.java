package lk.ijse.dep11.tm;

public class Customer {
    private int id;
    private String name;
    private String address;
    //boolean marriedStatus;

    public Customer() {
    }

    public Customer(int id, String name, String address) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
/*//No - Arg Constructor
    public Customer() {
    }*/

    /*//All-arg constructor

    public Customer(int id, String name, String address, boolean marriedStatus) {     //Constructor
        this.id = id;
        this.name = name;
        this.address = address;
        this.marriedStatus = marriedStatus;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public  boolean isMarriedStatus(){
        return marriedStatus;
    }

    public void setId(int id){
        this.id = id;
    }

    public  void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setMarriedStatus(boolean marriedStatus){
        this.marriedStatus = marriedStatus;
    }*/
}
