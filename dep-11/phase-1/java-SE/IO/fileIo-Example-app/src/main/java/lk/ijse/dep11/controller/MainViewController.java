package lk.ijse.dep11.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.Employee;

import java.io.*;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;

public class MainViewController {
    public AnchorPane root;
    public TextField txtId;
    public TextField txtName;
    public TextField txtContact;
    public Button btnSave;
    public Button btnDelete;
    public TableView<Employee> tblEmploy;
    public Button btnNew;
    private ArrayList<Employee> employeesList = new ArrayList<>();

    public void initialize(){
        for (Control control : new Control[] {txtName,txtContact,btnSave,btnDelete}) {
            control.setDisable(true);

        }
        tblEmploy.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmploy.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmploy.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));

        tblEmploy.getSelectionModel().selectedItemProperty().addListener((o,next,current)->{
            btnDelete.setDisable(current==null);
            txtId.setText(tblEmploy.getSelectionModel().getSelectedItem().getId());
            txtName.setText(tblEmploy.getSelectionModel().getSelectedItem().getName());
            txtContact.setText(tblEmploy.getSelectionModel().getSelectedItem().getContact());
        });

        tblEmploy.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.DELETE) btnDelete.fire();
        });
        Platform.runLater(() -> {
            root.getScene().getWindow().setOnCloseRequest(event ->{
                saveOnFile();
            });
        });
        employeesList = readFile();
        ObservableList<Employee> employeesObservableList = FXCollections.observableList(employeesList);
        tblEmploy.setItems(employeesObservableList);

    }
    public void btnSaveOnAction(ActionEvent event) {
        //data validation
        if(!isDataValid()) return;
        List<Employee> employeeList = getEmployeeList();
        //Bussiness validation
        for (Employee employee : employeeList) {
            if (tblEmploy.getSelectionModel().getSelectedItem() == employee) continue;
            if(txtContact.getText().equals(employee.getContact())){
                new Alert(Alert.AlertType.ERROR,"Contact Number ALready Exist").show();
                txtContact.requestFocus();
                txtContact.selectAll();
                return;
            }
        }

        if(tblEmploy.getSelectionModel().isEmpty()) getEmployeeList().add(new Employee(txtId.getText(),txtName.getText(),txtContact.getText()));
        else {
            //update item
            txtId.setText(tblEmploy.getSelectionModel().getSelectedItem().getId());
            txtName.setDisable(false);
            txtContact.setDisable(false);
            if(!isDataValid()) return;
            tblEmploy.getSelectionModel().getSelectedItem().setName(txtName.getText());
            tblEmploy.getSelectionModel().getSelectedItem().setContact(txtContact.getText());
            tblEmploy.refresh();

        }
        btnNew.fire();
    }

    public ArrayList<Employee> readFile(){
        File dataFle = new File("employeeData.db");
        if(!dataFle.exists()) return new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(dataFle);
            BufferedInputStream bis = new BufferedInputStream(is);
            ObjectInputStream ois = new ObjectInputStream(bis);
            try {
                return (ArrayList<Employee>) ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }finally {
                ois.close();
            }
        }catch (IOException e){
            new Alert(Alert.AlertType.ERROR,"Failed to read file");
        }
        return new ArrayList<>();

    }
    public void saveOnFile(){
        File dataFile = new File("employeeData.db");
        try{
            dataFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(dataFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            try {
                oos.writeObject(employeesList);
            }finally {
                oos.flush();
                oos.close();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnDeleteOnAction(ActionEvent event) {
        tblEmploy.getItems().remove(tblEmploy.getSelectionModel().getSelectedItem());
        tblEmploy.refresh();
        if(tblEmploy.getItems().isEmpty()) btnNew.fire();
    }

    public void btnNewOnAction(ActionEvent event) {
        txtId.setText(getNewId());
        for (Control control : new Control[] {txtName,txtContact,btnSave}) {
            if(control instanceof TextField) {
                control.setDisable(false);
                ((TextField) control).clear();
            }
            control.setDisable(false);
        }
        txtName.requestFocus();
    }
    public List<Employee> getEmployeeList(){
        return tblEmploy.getItems();
    }

    public String getNewId(){
        if(tblEmploy.getItems().isEmpty()) return "E-001";
        int nextNum = Integer.parseInt(getEmployeeList().get(getEmployeeList().size()-1).getId().substring(2)) +1;
        return String.format("E-%03d",nextNum);
    }

    public boolean isDataValid(){
        if(!txtName.getText().matches("[A-Za-z ]+")){
            txtName.requestFocus();
            txtName.selectAll();
            return false;
        }else if(!txtContact.getText().matches("0\\d{2}-\\d{7}")){
            txtContact.requestFocus();
            txtContact.selectAll();
            return false;
        }
        return true;
    }
}
