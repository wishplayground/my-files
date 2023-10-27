package lk.ijse.dep11.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.db.DbConnection;
import lk.ijse.dep11.tm.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DpartmentManagementController {
    public AnchorPane rootDep;
    public Button btnNewDep;
    public TextField txtDepName;
    public Button btnSaveDep;
    public Button btnDelDep;
    public TableView<Department> tblDep;

    public void initialize(){
        tblDep.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDep.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDep.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("numberOfEmploys"));

        tblDep.getSelectionModel().selectedItemProperty().addListener((val,prev,current) ->{
            btnDelDep.setDisable(current==null);
            if(current != null){
                tblDep.getItems().add(new Department(current.getId(),current.getName(),current.getNumberOfEmploys()));
            }
        });
        loadAllDepartments();
    }

    private void loadAllDepartments() {
        ObservableList<Department> employees = tblDep.getItems();

        try{
            Statement stm = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM Department");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                //int numOfEmployees = resultSet.getInt("number_of_employees");
                Department department = new Department(id, name, 0);
                employees.add(department);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnNewDepOnAction(ActionEvent event) {
        txtDepName.clear();
        tblDep.getSelectionModel().clearSelection();

    }

    public void btnSaveDepOnAction(ActionEvent event) {
        String newDepartment = txtDepName.getText();
        if(!isValid()){
            txtDepName.requestFocus();
            txtDepName.selectAll();
        }

        ObservableList<Department> deps = tblDep.getItems();
        if(deps.stream().anyMatch(d ->d.getName().equals(newDepartment))){
            new Alert(Alert.AlertType.ERROR,"Existing Deparment").show();
            return;
        }

        Connection connection = DbConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sqlCom = String.format("INSERT INTO Department (name) VALUES ('%s')",newDepartment);
            if(statement.executeUpdate(sqlCom,Statement.RETURN_GENERATED_KEYS) ==1){
                new Alert(Alert.AlertType.INFORMATION,"SAVED!").show();
                ResultSet generatedKeys = statement.getGeneratedKeys();
                generatedKeys.next();
                int id = generatedKeys.getInt(1);
                deps.add(new Department(id,newDepartment,0));
                btnNewDep.fire();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went Wrong").show();
            }

            statement.executeQuery(sqlCom);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void btnDelDepOnAaction(ActionEvent event) {
    }
    public boolean isValid(){
        if(txtDepName.getText().matches("[A-Z a-z]{2,}")) return true;
        return false;
    }
}
