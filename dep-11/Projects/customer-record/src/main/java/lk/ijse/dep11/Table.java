package lk.ijse.dep11;

public class Table {
    private String id;
    private String name;
    private String contactNo;
    private String Address;

    public Table(String id, String name, String contactNo, String address) {
        this.setId(id);
        this.setName(name);
        this.setContactNo(contactNo);
        setAddress(address);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
