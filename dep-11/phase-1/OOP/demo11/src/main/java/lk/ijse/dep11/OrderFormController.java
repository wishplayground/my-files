package lk.ijse.dep11;

import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class OrderFormController {
    public AnchorPane root;
    public TextField txtCode;
    public TextField txtDis;
    public TextField txtStock;
    public TextField txtBuy;
    public TextField txtSell;
    public Button btnAdd;
    public Button btnNew;
    public Label lblTotal;
    public Label lblProfit;
    public Spinner<Integer> txtQty;
    public TableView<Table> tvDetails;

    ArrayList<Item> itemList = new ArrayList<>();
    int stockValue;
    Item selectedItem;
    double netTotal=0;
    double netProfit = 0;

    public void initialize(){
        txtQty.setEditable(true);
        txtQty.setDisable(true);
        btnAdd.setDisable(true);
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,0,1));

        Item item1 = new Item("123", "Atlas Whiteboard Marker", 15, 150.0, 170.0);

        Item item2 = new Item("678", "Atlas CR Book", 18, 226.0, 250.0);
        Item item3 = new Item("234", "Atlas Pencil", 60, 40.0, 55.0);
        Item item4 = new Item("345", "Nataraja Eraser", 85, 30.0, 40.0);
        Item item5 = new Item("456", "Dunlop Ball", 27, 400.0, 470.0);
        Item item6 = new Item("567", "SF Bat", 10, 15000.0, 16750.0);

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        //table view set parameter
        tvDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tvDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tvDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tvDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        tvDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        //spinner action listner
        txtQty.valueProperty().addListener(e ->{

            btnAdd.setDisable((txtQty.getValue() > stockValue));

        });





    }

    public void btnAddOnAction(ActionEvent event) {
        //initialize data to table view
        double total = Double.parseDouble(txtSell.getText()) * txtQty.getValue();
        netTotal +=total;



        //int profit = Integer.parseInt(txtBuy.getText()) * txtQty.getValue();
        if(exist(txtCode.getText()) !=-1){
            int index = exist(txtCode.getText());
            int newQty = tvDetails.getItems().get(index).getQty() + txtQty.getValue();
            double newTotal = tvDetails.getItems().get(index).getTotal() + total;
            System.out.println(newQty+ " " + newTotal);
            tvDetails.getItems().get(index).setQty(newQty);
            tvDetails.getItems().get(index).setTotal(newTotal);
            tvDetails.refresh();
        }else {
            tvDetails.getItems().add(new Table(txtCode.getText(),txtDis.getText(),txtQty.getValue(),Double.parseDouble(txtSell.getText()),total));
        }
        netProfit +=(txtQty.getValue() * (selectedItem.getSellingPrice() - selectedItem.getBuyingPrice()));
        selectedItem.changeStock(txtQty.getValue());
        lblTotal.setText(String.format("Total = Rs.%.2f/=",netTotal));
        lblProfit.setText(String.format("Total = Rs.%.2f/=",netProfit));

        btnNew.requestFocus();

    }


    public void btnNewOnAction(ActionEvent event) {
        txtCode.clear();
        txtDis.clear();
        txtStock.clear();
        txtBuy.clear();
        txtSell.clear();
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,0,1));//start ,end, default, step
        txtCode.requestFocus();
    }

    public void txtCodeOnAction(ActionEvent event) {
        String inputCode = txtCode.getText().strip();
        for (Item item : itemList) {
            if(inputCode.equals(item.getBarcode())){
                selectedItem = item;
                txtDis.setText(item.getDiscription());
                txtBuy.setText(String.valueOf(item.getBuyingPrice()));
                txtSell.setText(String.valueOf(item.getSellingPrice()));

                stockValue = item.getStock();
                txtStock.setText(String.valueOf(item.getStock()));
                txtQty.setDisable(false);
                txtQty.requestFocus();
                return;
            }

        }
    }

    public int exist(String code){
        int index =0;
        for (Table item : tvDetails.getItems()) {
            if(item.getCode().equals(code)) return index;
            index++;
        }
        return -1;
    }
}
