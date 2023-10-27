package lk.ijse.dep11.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.dep11.ItemDetails;
import lk.ijse.dep11.Table;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;


public class MainViewController {
    public AnchorPane root1;
    public TextField txtBarcode;
    public TextField txtItemName;
    public TextField txtStock;
    public TextField txtPrice;
    public Spinner<Integer> txtQty;
    public TableView<Table> tvItems;
    public Button btnNewItem;
    public Button btnPrint;
    public Button btnAdd;
    public Button btnDelete;
    public ArrayList<ItemDetails> items = new ArrayList<>();
    public Button btnCustomerReg;

    private int stock;
    private int qty;
    private BigDecimal total;
    ItemDetails selectedItem;
    public void initialize(){
        btnAdd.setDisable(true);
        btnDelete.setDisable(true);
        btnPrint.setDisable(true);
        txtQty.setDisable(true);
        txtQty.setEditable(false);



        tvItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("barcode"));
        tvItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("item"));
        tvItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tvItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tvItems.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        ItemDetails redpen = new ItemDetails("1234", "redpen", 70, new BigDecimal(50), new BigDecimal(60));
        ItemDetails bluepen = new ItemDetails("2345", "bluepen", 60, new BigDecimal(54), new BigDecimal(61));
        ItemDetails blackpen = new ItemDetails("3456", "blackpen", 30, new BigDecimal(58), new BigDecimal(69));
        ItemDetails pinkpen = new ItemDetails("4567", "pinkpen", 20, new BigDecimal(51), new BigDecimal(70));

        items.add(redpen);
        items.add(blackpen);
        items.add(bluepen);
        items.add(pinkpen);

        tvItems.getSelectionModel().selectedItemProperty().addListener((value,previous,current) ->{
            btnDelete.setDisable(current == null);

        });
        txtBarcode.textProperty().addListener(e ->{
            for (ItemDetails item : items) {
                if(item.getBarcode().equals(txtBarcode.getText())) txtQty.setDisable(false);

            }
        });
        if(!tvItems.getItems().isEmpty()) btnPrint.setDisable(false);



    }
    public void txtBarcode(ActionEvent event) {

        for (ItemDetails item : items) {
            if(txtBarcode.getText().equals(item.getBarcode()) ){
                stock = item.getStock();
                selectedItem = item;
                txtBarcode.setText(item.getBarcode());
                txtPrice.setText(item.getSellingPrice().toString());
                txtItemName.setText(item.getName());
                txtStock.setText(String.valueOf(item.getStock()));
            }
        }
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,selectedItem.getStock() +5,1,1));
        btnAdd.setDisable(false);
        txtQty.valueProperty().addListener(e ->{
            btnAdd.setDisable(txtQty.getValue() >= selectedItem.getStock());
        });
    }


    public void btnNewItemOnAction(ActionEvent event) {
        txtBarcode.clear();
        txtStock.clear();
        txtPrice.clear();
        txtItemName.clear();
        txtQty.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,stock,0,1));
        selectedItem = null;
    }

    public void btnPrintOnAction(ActionEvent event) {
        tvItems.getItems().clear();
    }

    public void btnAddOnAction(ActionEvent event) {
        total = selectedItem.getSellingPrice().multiply(new BigDecimal(txtQty.getValue()));
        tvItems.getItems().add(new Table(txtBarcode.getText(),txtItemName.getText(),txtQty.getValue(),new BigDecimal(txtPrice.getText()),total));
        selectedItem.setStock(selectedItem.getStock() - stock);
        btnNewItem.fire();
    }

    public void btnDeleteOnAction(ActionEvent event) {
        new Alert(Alert.AlertType.CONFIRMATION,"Do you want to delete  Item ".concat(tvItems.getSelectionModel().getSelectedItem().getItem().toUpperCase())).show();
        tvItems.getItems().remove(tvItems.getSelectionModel().getSelectedItem());

    }

    public void btnCustomerRegOnAction(ActionEvent event) throws IOException {
        Stage loginStage = new Stage();
       //Stage loginStage =  (Stage)root1.getScene().getWindow();//otherwise modality cannot be done

       loginStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LogingView.fxml"))));
       loginStage.setTitle("Login");
       loginStage.centerOnScreen();
       loginStage.setResizable(true);
       loginStage.initModality(Modality.APPLICATION_MODAL);
       loginStage.initStyle(StageStyle.UNDECORATED);
       loginStage.show();
    }
}
