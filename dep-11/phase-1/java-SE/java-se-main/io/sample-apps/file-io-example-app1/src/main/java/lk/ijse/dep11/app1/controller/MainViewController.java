package lk.ijse.dep11.app1.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.app1.tm.Employee;

import java.io.*;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class MainViewController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtContact;
    public Button btnSave;
    public Button btnDelete;
    public TableView<Employee> tblEmployee;
    public TextField txtSearch;
    public Button btnNew;
    public AnchorPane root;
    private ArrayList<Employee> employeList = new ArrayList<>();

    public void initialize(){
        for (Control control : new Control[]{txtId, txtName, txtContact, btnSave, btnDelete}) {
            control.setDisable(true);
        }

        tblEmployee.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmployee.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmployee.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((o, old, current)->{
            if (current == null){
                btnDelete.setDisable(true);
            }else{
                txtId.setText(current.getId());
                txtName.setText(current.getName());
                txtContact.setText(current.getContact());
                btnDelete.setDisable(false);
            }
        });

        tblEmployee.setOnKeyPressed(event ->  {
            if (event.getCode() == KeyCode.DELETE) btnDelete.fire();
        });

        Platform.runLater(()->{
            root.getScene().getWindow().setOnCloseRequest(event -> {
                saveEmployeeList();
            });
        });

        //EmployList (arrayList) <- File read
        employeList = readEmployeeList();


        ObservableList<Employee> observableEmployList = FXCollections.observableList(employeList);
        tblEmployee.setItems(observableEmployList);
    }
    private ArrayList<Employee> readEmployeeList(){
        File dataBaseFile = new File("employee.db");
        if(!dataBaseFile.exists()) return new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(dataBaseFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            try {
                return (ArrayList<Employee>) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                ois.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    private void saveEmployeeList(){
        File databaseFIle = new File("employee.db");

        try{
            FileOutputStream fos = new FileOutputStream(databaseFIle);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            try{
                oos.writeObject(employeList);
            }finally{
                oos.close();
            }
            databaseFIle.createNewFile();
        }catch(Throwable e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to save employee details");
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        /* Data Validation */
        if (!isDataValid()) return;

        List<Employee> employeeList = getEmployeeList();

        /* Business Validation */
        for (Employee employee : employeeList) {
            if (tblEmployee.getSelectionModel().getSelectedItem() == employee) continue;
            if (employee.getContact().equals(txtContact.getText())){
                new Alert(Alert.AlertType.ERROR, "Contact number already exists").show();
                txtContact.requestFocus();
                txtContact.selectAll();
                return;
            }
        }

        if (tblEmployee.getSelectionModel().isEmpty()){
            /* New Record */
            Employee newEmployee = new Employee(txtId.getText(),
                    txtName.getText().strip(), txtContact.getText().strip());
            employeeList.add(newEmployee);
            btnNew.fire();
        } else {
            /* Update */
            Employee selectedEmployee = tblEmployee.getSelectionModel().getSelectedItem();
            selectedEmployee.setName(txtName.getText().strip());
            selectedEmployee.setContact(txtContact.getText().strip());
            tblEmployee.refresh();
            btnNew.fire();
        }

    }

    private List<Employee> getEmployeeList(){
        return tblEmployee.getItems();
    }

    private boolean isDataValid(){
        if (!txtName.getText().strip().matches("^[A-Za-z ]+")){
            txtName.requestFocus();
            txtName.selectAll();
            return false;
        } else if (!txtContact.getText().strip().matches("\\d{3}-\\d{7}")){
            txtContact.requestFocus();
            txtContact.selectAll();
            return false;
        }
        return true;
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Employee selectedEmployee = tblEmployee.getSelectionModel().getSelectedItem();
        getEmployeeList().remove(selectedEmployee);
        if (getEmployeeList().isEmpty()) btnNew.fire();
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        txtId.setText(getNewEmployeeId());
        for (Control control : new Control[]{txtName, txtContact, btnSave}) {
            if (control instanceof TextField) ((TextField) control).clear();
            control.setDisable(false);
        }
        txtName.requestFocus();
        tblEmployee.getSelectionModel().clearSelection();
    }

    private String getNewEmployeeId(){
        if (getEmployeeList().isEmpty()) return "E-001";

        String lastEmployeeId = getEmployeeList().get(getEmployeeList().size() - 1).getId();
        int newEmployeeId = Integer.parseInt(lastEmployeeId.substring(2)) + 1 ;
        return String.format("E-%03d", newEmployeeId);
    }

    private  void saveEmployeeDetails(){
        File databaseFIle = new File("employee.db");

        try{
            FileOutputStream fos = new FileOutputStream(databaseFIle);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            try{
                oos.writeObject(employeList);
            }finally{
                oos.close();
            }
            databaseFIle.createNewFile();
        }catch(Throwable e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to save employee details");
        }

    }
    //finish     search implement
    //.csv file format identify and when it drag and drop to tabale view that data needs tobe imported
}
