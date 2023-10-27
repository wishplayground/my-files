package lk.ijse.dep11;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDetails implements Serializable {
    private String barcode;
    private String name;
    private int Stock;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;

    public ItemDetails(String barcode, String name, int stock, BigDecimal buyingPrice, BigDecimal sellingPrice) {
        this.barcode = barcode;
        this.setName(name);
        Stock = stock;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }



    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
