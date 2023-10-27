package lk.ijse.dep11;

public class Item {
    private String barcode;
    private String discription;
    private int stock;
    private double buyingPrice;
    private double sellingPrice;
    //private int qty;

    public Item(String barcode, String discription, int stock, double buyingPrice, double sellingPrice) {
        this.setBarcode(barcode);
        this.setDiscription(discription);
        this.setStock(stock);
        this.setBuyingPrice(buyingPrice);
        this.setSellingPrice(sellingPrice);
    }

    public Item(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    void changeStock(int qty){
        this.stock -= qty;
    }
    double getProfit(){
        return (getSellingPrice() - getBuyingPrice());
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

}
