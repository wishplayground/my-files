package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.tm.Customer;

public class MainSceneController {
    public AnchorPane rootpane;
    public TextField txtId;
    public Button btnSave;
    public Button btnDelete;
    public TextField txtName;
    public TextField txtAddress;
    public TableView<Customer> tvDetails;
    public Button btnNewCustomer;

    public void initialize(){
        btnDelete.setDisable(true);
        //Column Mapping done in initialize method
        tvDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
        tvDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tvDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        tvDetails.getSelectionModel().selectedItemProperty().addListener((value,previous,current) ->{

            btnDelete.setDisable(current==null);
            if(current != null){
                txtId.setText(String.valueOf(tvDetails.getSelectionModel().getSelectedItem().getId()));
                txtName.setText(String.valueOf(tvDetails.getSelectionModel().getSelectedItem().getName()));
                txtAddress.setText(String.valueOf(tvDetails.getSelectionModel().getSelectedItem().getAddress()));
            }

            //Customer selectedCustomer = tvDetails.getSelectionModel().getSelectedItem();

        });
        /*btnSave.setCursor(Cursor.HAND);
        btnDelete.setCursor(Cursor.HAND);*/


        /*ObservableList<Customer> customerList = tvDetails.getItems();
        Customer customer1 = new Customer(1, "Wishva", "Kuliyapitiya");
        Customer customer2 = new Customer(2, "Tharinda", "Panadura");
        Customer customer3 = new Customer(3, "Nadun", "Kegalle");
        Customer customer4 = new Customer(4, "Sudeepa", "Madagalle");
        Customer customer5 = new Customer(5, "Kumara", "Midella");
        customerList.addAll(customer1,customer2,customer3,customer4,customer5);//created 5 rows but not show because i does not know where to put details*/




    }

    public void btnSaveOnAction(ActionEvent event) {
        if(txtId.getText().isEmpty() || !isValid(txtId.getText()) || isDuplicate(txtId.getText()) ) {
            txtId.requestFocus();
            txtId.selectAll();
            return;
        }else if(txtName.getText().isEmpty()) {
            txtName.requestFocus();
            txtName.selectAll();
            return;
        }else if(txtAddress.getText().isEmpty()) {
            txtAddress.requestFocus();
            txtAddress.selectAll();
            return;
        }

        //Customer customerx = new Customer(Integer.valueOf(txtId.getText()), txtName.getText(), txtAddress.getText());
        tvDetails.getItems().add(new Customer(Integer.parseInt(txtId.getText()), txtName.getText(), txtAddress.getText()));
        btnNewCustomer.fire();

    }

    public void btnDeleteOnAction(ActionEvent event) {
        tvDetails.getItems().remove(tvDetails.getSelectionModel().getSelectedItem());
        btnNewCustomer.fire();
    }

    public void btnNewCustomerOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
    }

    public boolean isValid(String id){
        for (int i = 0; i < id.length(); i++) {
            if(!Character.isDigit(id.charAt(i))) return false;
        }
        return true;
    }

    public boolean isDuplicate(String id){
        int ID = Integer.parseInt(txtId.getText());
        for (Customer customer1: tvDetails.getItems()) {
            if(customer1.getId() == Integer.parseInt(id)) {
                new Alert(Alert.AlertType.ERROR,"Duplicate ID's are not Allowed").show();
                return true;
            }
        }
        return false;
    }
}
