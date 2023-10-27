package lk.ijse.dep11.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep11.pos.db.CustomerDataBaseAccess;
import lk.ijse.dep11.pos.tm.Customer;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;

public class ManageCustomerFormController {
    public AnchorPane root;
    public JFXTextField txtCustomerId;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public TableView<Customer> tblCustomers;
    public JFXButton btnAddNewCustomer;

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(primaryStage::sizeToScene);
    }

    public void initialize(){
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        btnDelete.setDisable(true);
        txtCustomerId.setEditable(false);
        btnAddNewCustomer.fire();
        for (TextField textField : new TextField[]{txtCustomerName, txtCustomerAddress}) {
            textField.clear();
        }

        loadAllCustomers();
        tblCustomers.getSelectionModel().selectedItemProperty().addListener((val,prev,cur)->{
            if(cur != null){
                btnSave.setText("Update");
                btnDelete.setDisable(false);
                txtCustomerId.setText(cur.getId());
                txtCustomerId.setEditable(false);
                txtCustomerName.setText(cur.getName());
                txtCustomerAddress.setText(cur.getAddress());
            }
        });

    }

    public void btnAddNew_OnAction(ActionEvent actionEvent) {
        btnDelete.setDisable(true);
        for (TextField textField : new TextField[]{txtCustomerId, txtCustomerName, txtCustomerAddress}) {
            textField.clear();

        }
        txtCustomerId.setText(generateId());
        tblCustomers.getSelectionModel().clearSelection();
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        if(!isDataValid()) return;
        Customer customer=null;
        if(btnSave.getText().equals("Save")){
            customer = new Customer(txtCustomerId.getText(), txtCustomerName.getText(), txtCustomerAddress.getText());
            try {
                CustomerDataBaseAccess.saveCustomer(customer);
                tblCustomers.getItems().add(customer);
            } catch (SQLException e) {
                new Alert(Alert.AlertType.INFORMATION,String.format("Customer %s Failed to save",txtCustomerId.getText())).show();
                throw new RuntimeException(e);
            }
        }else {
            /*if(!(txtCustomerName.getText().equals(tblCustomers.getSelectionModel().getSelectedItem().getName())|| txtCustomerAddress.getText().equals(tblCustomers.getSelectionModel().getSelectedItem().getAddress()))){*/
            customer = new Customer(txtCustomerId.getText(), txtCustomerName.getText(), txtCustomerAddress.getText());

            try {
                CustomerDataBaseAccess.updateCustomer(Objects.requireNonNull(customer,"Cannot be null"));
                tblCustomers.getItems().set(tblCustomers.getItems().indexOf(tblCustomers.getSelectionModel().getSelectedItem()),customer);
                tblCustomers.refresh();
            } catch (SQLException e) {
                new Alert(Alert.AlertType.INFORMATION,String.format("Customer %s Failed to Update",txtCustomerId.getText())).show();
                throw new RuntimeException(e);
            }
        }
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
    }
    public String generateId(){
        try {
            if(CustomerDataBaseAccess.getLastId()==0){
                return "C001";
            }else {
                return String.format("C%03d",CustomerDataBaseAccess.getLastId()+1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isDataValid(){
        String nameText = txtCustomerName.getText();
        String addressText = txtCustomerAddress.getText();
        if(!nameText.matches("[A-Z a-z]{2,}")){
            new Alert(Alert.AlertType.ERROR,"Invalid name characters").show();
            txtCustomerName.requestFocus();
            txtCustomerName.selectAll();
            return false;
        } else if (!addressText.matches("[A-Za-z 0-9,/]{2,}")) {
            new Alert(Alert.AlertType.ERROR,"Invalid Address characters").show();
            txtCustomerAddress.requestFocus();
            txtCustomerAddress.selectAll();
            return false;
        }
        return true;
    }

    public void loadAllCustomers(){
        try {
            tblCustomers.getItems().addAll(CustomerDataBaseAccess.getAllCustomers());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"Customer %s Failed to Load Customers").show();
            throw new RuntimeException(e);
        }
    }


}
