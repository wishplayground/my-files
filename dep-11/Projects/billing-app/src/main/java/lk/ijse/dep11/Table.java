package lk.ijse.dep11;

import java.math.BigDecimal;

public class Table {
    private String barcode;
    private String item;
    private int qty;
    private BigDecimal unitPrice;
    private BigDecimal total;

    public Table(String barcode, String item, int qty, BigDecimal unitPrice, BigDecimal total) {
        this.setBarcode(barcode);
        this.setItem(item);
        this.setQty(qty);
        this.setUnitPrice(unitPrice);
        this.setTotal(total);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
