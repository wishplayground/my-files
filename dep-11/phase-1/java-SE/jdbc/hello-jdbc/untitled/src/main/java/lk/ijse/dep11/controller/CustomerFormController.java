package lk.ijse.dep11.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.CellSkinBase;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.db.DbConnection;
import lk.ijse.dep11.tm.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerFormController {
    public AnchorPane root;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnNewCustomer;
    public Button btnSave;
    public TableView<Customer> tblCustomer;

    public void initialize(){
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((value,prev,current) ->{
            btnSave.setDisable(current == null);
            if(current !=null){
                txtId.setText(current.getId());
                txtName.setText(current.getName());
                txtAddress.setText(current.getAddress());
            }
        });

        loadAllCustomer();


    }

    private void loadAllCustomer() {
        // protocol://ipaddress:port/path
        //http://google.lk:443/search
        ObservableList<Customer> customerList = tblCustomer.getItems();
        /*try (var connection = DriverManager.getConnection("jdbc:postgresql://localhost:12500/dep11","postgres","Wishva98@")*//*var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dep11","root","mysql")*//*){
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM customer");
            while (resultSet.next()){
                String id = resultSet.getString("id"); // else we can give index of the column
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, name, address);
                customerList.add(customer);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        //using Singleton design pattern
        try{
            Statement stm = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM customer");
            while (resultSet.next()){
                String id = resultSet.getString("id"); // else we can give index of the column
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, name, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnNewCustomerOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        tblCustomer.getSelectionModel().clearSelection();
    }

    public void btnSaveOnAction(ActionEvent event) {
        ObservableList<Customer> customerList = tblCustomer.getItems();
        if (!isValid()) return;
        /*try(var connection = DriverManager.getConnection("jdbc:postgresql://localhost:12500/dep11","postgres","Wishva98@")*//*var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dep11","root","mysql")*//*){
            String id = txtId.getText().strip();
            String name = txtName.getText().strip();
            String address = txtAddress.getText().strip();

            //bussiness validation
            if(customerList.stream().anyMatch(c -> c.getId().equals(id))){
                new Alert(Alert.AlertType.ERROR,"Id Already Exist").show();
                txtId.requestFocus();
                txtId.selectAll();
                return;
            }

            Statement stm = connection.createStatement();
            String str = String.format("INSERT INTO customer (id,name,address) VALUES ('%s','%s','%s')", id, name, address);
            int affectedRows = stm.executeUpdate(str);//return how many rows affeected by the statement
            if(affectedRows ==1) {
                new Alert(Alert.AlertType.INFORMATION,"Customer added").show();
                btnNewCustomer.fire();
                customerList.add(new Customer(id,name,address));
            }else{
                new Alert(Alert.AlertType.ERROR,"Something wend wrong!!").show();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        //Using Singleton design pattern
        try {
            String id = txtId.getText().strip();
            String name = txtName.getText().strip();
            String address = txtAddress.getText().strip();

            //business validation
            if(customerList.stream().anyMatch(c -> c.getId().equals(id))){
                new Alert(Alert.AlertType.ERROR,"Id Already Exist").show();
                txtId.requestFocus();
                txtId.selectAll();
                return;
            }

            Statement stm = DbConnection.getInstance().getConnection().createStatement();
            String str = String.format("INSERT INTO customer (id,name,address) VALUES ('%s','%s','%s')", id, name, address);
            int affectedRows = stm.executeUpdate(str);//return how many rows affeected by the statement
            if(affectedRows ==1) {
                new Alert(Alert.AlertType.INFORMATION,"Customer added").show();
                btnNewCustomer.fire();
                customerList.add(new Customer(id,name,address));
            }else{
                new Alert(Alert.AlertType.ERROR,"Something wend wrong!!").show();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean isValid(){
        String id = txtId.getText().strip();
        String name = txtName.getText().strip();
        String address = txtAddress.getText().strip();

        if(!id.matches("C\\d{3}")){
            txtId.requestFocus();
            txtId.selectAll();
            return false;
        }else if(!name.matches("[A-Za-z]{2,}")){
            txtName.requestFocus();
            txtName.selectAll();
            return false;
        }else if(!address.matches(".{3,}")){
            txtAddress.requestFocus();
            txtAddress.selectAll();
            return false;
        }
        return true;
    }
}
