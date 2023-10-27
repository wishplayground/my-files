package lk.ijse.dep11.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.db.DBConnection;
import lk.ijse.dep11.tm.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentViewController {
    public AnchorPane rootDep;
    public TextField txtDepName;
    public Button btnSave;
    public Button btnDelete;
    public TableView<Department> tblDep;
    public Button btnNewDep;
    private Department selected;

    public void initialize(){
        tblDep.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDep.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDep.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("numberOfEmployees"));

        loadAllData();
        tblDep.getSelectionModel().selectedItemProperty().addListener((val,prev,current) ->{
            btnDelete.setDisable(current == null);
            if(current != null){
                txtDepName.setText(current.getName());
                selected = current;
            }
        });
        rootDep.setOnMouseClicked(e ->{
            tblDep.getSelectionModel().clearSelection();
            btnNewDep.fire();
            e.consume();
        });

    }
    public void btnSaveOnAction(ActionEvent event) {
        ObservableList<Department> depItems = tblDep.getItems();
        if(!txtDepName.getText().matches("[A-Z 0-9a-z]{2,}")){
            txtDepName.requestFocus();
            txtDepName.selectAll();
            return;
        }
        //Bussiness validation
        if (depItems.stream().anyMatch(d -> d.getName().equals(txtDepName.getText()))){
            new Alert(Alert.AlertType.ERROR,"Already Existing Department").show();
            txtDepName.requestFocus();
            txtDepName.selectAll();
            return;
        }
        try {
            Statement statement = DBConnection.getDBConnection().getConnection().createStatement();
            String sql = String.format("INSERT INTO Department (name) VALUES ('%s')",txtDepName.getText());
            if(statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                generatedKeys.next();
                depItems.add(new Department(generatedKeys.getInt("id"),txtDepName.getText(),0));
                new Alert(Alert.AlertType.INFORMATION,String.format("Department %s Saved!",txtDepName.getText())).show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
            btnNewDep.fire();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void btnDeleteOnAction(ActionEvent event) {
        ObservableList<Department> depItems = tblDep.getItems();
        try {
            Statement statement = DBConnection.getDBConnection().getConnection().createStatement();
            String sql = String.format("DELETE FROM Department WHERE (name='%s')",txtDepName.getText());
            statement.executeUpdate(sql);
            depItems.remove(selected);
            tblDep.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnNewDepOnAction(ActionEvent event) {
        txtDepName.clear();
        btnDelete.setDisable(true);
        btnSave.setDisable(false);
    }

    public void loadAllData(){
        ObservableList<Department> depItems = tblDep.getItems();
        try {
            Statement statement = DBConnection.getDBConnection().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Department");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                depItems.add(new Department( id ,name,0));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
