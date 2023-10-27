package lk.ijse.dep11;

import java.awt.*;
import java.io.File;
import java.io.Serializable;

public class CustomerDetails implements Serializable {
    private String id;
    private String name;
    private String contactNo;
    private String Address;
    private String imgPath;

    public CustomerDetails(String id, String name, String contactNo, String address, String imgPath) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.Address = address;
        this.imgPath = imgPath;
    }
    public CustomerDetails(String id, String name, String contactNo, String address) {
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
