package lk.ijse.dep11;

import java.io.Serializable;

public class Table implements Serializable {
    private String code;
    private String description;
    private int qty;
    private double price;
    private double total;

    public Table(String code, String description, int qty, double price, double total) {
        this.setCode(code);
        this.setDescription(description);
        this.setQty(qty);
        this.setPrice(price);
        this.setTotal(total);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
