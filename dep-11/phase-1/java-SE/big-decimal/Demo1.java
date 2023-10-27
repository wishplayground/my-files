import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Demo1{
    public static void main(String[] args) {
        
        //IEEE-754
        double d1 = 0.3;
        double d2 = 0.2;
        double d3 = d1 - d2;
        System.out.println(d3);

        //Big Decimal
        /* BigDecimal bd1 = new BigDecimal(0.3);
        BigDecimal bd2 = new BigDecimal(0.2);
        BigDecimal bd3 = bd1.subtract(bd2);
        System.out.println(bd3); *///0.099999999999999977795539507496869191527366638183593750

        //big decimal is also immutable
        BigDecimal bd1 = BigDecimal.valueOf(0.3); //do not derectlyenter to the constructor
        BigDecimal bd2 = BigDecimal.valueOf(0.2);
        BigDecimal bd3 = bd1.subtract(bd2);
        System.out.println(bd3);

        List<CartItem> cartItemsList = new ArrayList<>();
        cartItemsList.add(new CartItem("mouse", 5, BigDecimal.valueOf(2500)));
        cartItemsList.add(new CartItem("monitor", 1, BigDecimal.valueOf(250400)));
        cartItemsList.add(new CartItem("keyboard", 10, BigDecimal.valueOf(2000)));
        /* cartItemsList.add(new CartItem("speaker", 2, BigDecimal.valueOf(6500)));
        cartItemsList.add(new CartItem("headset", 4, BigDecimal.valueOf(2500)));
 */
        String line = String.format("+".concat("-".repeat(10)).concat("+".concat("-".repeat(8))).concat("+".concat("-".repeat(15))).concat("+".concat("-".repeat(15))).concat("+"));
        System.out.println(line);
        System.out.printf("|%-10s|%-8s|%-15s|%-15s|\n","NAME","QTY","UNIT PRICE","TOTAL");
        System.out.println(line);
        BigDecimal nettotal= BigDecimal.ZERO;
        for (CartItem cartItem : cartItemsList) {
            BigDecimal total = new BigDecimal(cartItem.qty).multiply(cartItem.unitPrice);
            System.out.printf("|%-10s|%-8s|Rs.%,-12.2f|Rs.%-12s|\n",cartItem.name,cartItem.qty,cartItem.unitPrice,total);
            nettotal = nettotal.add(total);
        }
        System.out.println(line);
        System.out.printf("|%-10s%-9s|%-15s|Rs.%,-12.2f|\n","","","Net Total = ", nettotal);
        BigDecimal discount = new BigDecimal(10).divide(new BigDecimal(100));
        nettotal = nettotal.subtract(nettotal.multiply(discount));
        System.out.printf("|%-10s%-9s|%-15s|%14.0f%%|\n","","","Discount = ", new BigDecimal(10));
        System.out.println(line);
        System.out.printf("|%-10s%-9s|%-15s|Rs.%,-12.2f|\n","","","Grand Total = ", nettotal);
        System.out.println(line);


    }
}

class CartItem{
    String name;
    int qty;
    BigDecimal unitPrice;

    public CartItem(String name, int qty, BigDecimal unitPrice){
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }


}