package lk.ijse.dep11.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep11.pos.db.ItemDatabaseAccess;
import lk.ijse.dep11.pos.tm.Item;
import org.w3c.dom.Node;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class ManageItemFormController {
    public AnchorPane root;
    public JFXTextField txtCode;
    public JFXTextField txtDescription;
    public JFXTextField txtQtyOnHand;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public TableView<Item> tblItems;
    public JFXTextField txtUnitPrice;
    public JFXButton btnAddNewItem;

    public void initialize(){
        tblItems.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("code"));
        tblItems.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblItems.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblItems.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        loadAllItems();

        tblItems.getSelectionModel().selectedItemProperty().addListener((val,prev,cur)->{
            if(cur != null){
                btnSave.setText("Update");
                txtCode.setText(cur.getCode());
                txtDescription.setText(cur.getDescription());
                txtQtyOnHand.setText(String.valueOf(cur.getQty()));
                txtUnitPrice.setText(cur.getUnitPrice().toString());
            }
        });

    }
    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(primaryStage::sizeToScene);
    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        for (TextField textField : new TextField[]{txtCode, txtDescription, txtQtyOnHand, txtUnitPrice}) {
            textField.clear();
        }
        tblItems.getSelectionModel().clearSelection();
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        String qty = txtQtyOnHand.getText();
        String unitPrice = txtUnitPrice.getText();
        if(!isDataValid()) return;
        Item item = new Item(code, description, Integer.parseInt(qty), new BigDecimal(unitPrice));
        if(btnSave.getText().equals("Save")){
            ItemDatabaseAccess.saveItems(item);
            tblItems.getItems().add(item);
        }else {
            ItemDatabaseAccess.updateItems(item);
            tblItems.getItems().set(tblItems.getItems().indexOf(item),item);
            tblItems.refresh();
        }
        btnAddNewItem.fire();
    }

    private boolean isDataValid() {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        String qty = txtQtyOnHand.getText();
        String unitPrice = txtUnitPrice.getText();
        String regex = "\\d+";
        if(!code.matches("\\d{5,}")){
            return false;
        } else if (!description.matches("[A-Z a-z0-9,]{2,}")) {
            return false;
        } else if (!(qty.matches(regex) && unitPrice.matches("\\d+"))) {
            return false;
        }
        return true;
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
        ItemDatabaseAccess.deleteItems(tblItems.getSelectionModel().getSelectedItem().getCode());
        tblItems.getItems().remove(tblItems.getSelectionModel().getSelectedItem());
    }
    public void loadAllItems(){
        try {
            tblItems.getItems().addAll(ItemDatabaseAccess.itemList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
