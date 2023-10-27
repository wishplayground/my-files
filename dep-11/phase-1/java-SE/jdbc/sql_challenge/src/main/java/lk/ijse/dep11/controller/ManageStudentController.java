package lk.ijse.dep11.controller;

import com.sun.source.tree.WhileLoopTree;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import lk.ijse.dep11.db.DBConnection;
import lk.ijse.dep11.tm.Student;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

public class ManageStudentController {
    public AnchorPane rootStudent;
    public TextField txtId;
    public TextField txtName;
    public TextField txtCard;
    public Button btnSave;
    public Button btnDelete;
    public Button btnNewStu;
    public Button btnLoadCsv;
    public TableView<Student> tblStu;
    Student student;


    public void initialize(){
        btnDelete.setDisable(true);
        tblStu.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStu.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStu.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("card"));
        tblStu.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("challengeStatus"));

        loadAllStudents();
        tblStu.getSelectionModel().selectedItemProperty().addListener((val,prev,current)->{
            //btnSave.setDisable(current==null);
            btnDelete.setDisable(current == null);
            btnSave.setDisable(current != null);
            txtId.setText(current.getId());
            txtName.setText(current.getName());
            txtCard.setText(current.getCard());
            student = current;
        });


    }
    public boolean isDataValid(){
        if(!isValidDepStudentId(txtId.getText())){
            new Alert(Alert.AlertType.ERROR,"Error Student id").show();
            txtId.requestFocus();
            txtId.selectAll();
            return false;
        }else if(!txtName.getText().matches("[A-Z a-z]{2,}")){
            new Alert(Alert.AlertType.ERROR,"Name format error").show();
            txtName.requestFocus();
            txtName.selectAll();
            return false;
        }else if(!(!txtCard.getText().strip().isBlank() && txtCard.getText().matches("[A-za-z]{2,}"))){
            new Alert(Alert.AlertType.ERROR,"Card format error").show();
            txtCard.requestFocus();
            txtCard.selectAll();
            return false;
        }
        return true;
    }
    public void btnSaveOnAction(ActionEvent event) {
        if(!isDataValid()) return;
        try {
            boolean isAdd = addNewStudent(txtId.getText(), txtName.getText(), txtCard.getText().strip().isBlank() ? null :txtCard.getText());
            if (!isAdd) {
                new Alert(Alert.AlertType.ERROR,"Already exixsting student").show();
                return;
            } else{
                tblStu.getItems().add(new Student(txtId.getText(),txtName.getText(),txtCard.getText(),"Yet to Face"));
                new Alert(Alert.AlertType.INFORMATION,"Student saved!").show();
                btnNewStu.fire();
            }
        }catch (Exception e){
            //throw new RuntimeException("Something went wrong");
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent event) {
        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION,"Do you want to Delete Student name " + tblStu.getSelectionModel().getSelectedItem().getName().split(" ")[0].toUpperCase(), ButtonType.YES, ButtonType.NO).showAndWait();
        if(buttonType.get() == ButtonType.YES){
            Student selectedItem = tblStu.getSelectionModel().getSelectedItem();
            try {
                deleteStudent(selectedItem.getId());
                tblStu.getItems().remove(selectedItem);
                tblStu.refresh();
                btnNewStu.fire();
            }catch (Exception e){
                throw new RuntimeException("Something went wrong did not Deleted!");
            }

            
        }
    }

    public void btnNewStuOnAction(ActionEvent event) {
        for (Control cotrol : new Control[]{txtCard, txtId, txtName}) {
            if(cotrol instanceof TextField) ((TextField) cotrol).clear();
        }
        tblStu.getSelectionModel().clearSelection();

    }

    public void btnLoadCsvOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV", "*.csv"));
        fileChooser.setTitle("Select an CSV file to Read");
        File file = fileChooser.showOpenDialog(rootStudent.getScene().getWindow());
        if(!file.exists()) new Alert(Alert.AlertType.ERROR,"File not selected").show();
        try {
            loadFromFile(file);
        }catch (Exception e){
            new Alert(Alert.AlertType.INFORMATION,"None Selected");
            return;
        }


    }

    public boolean addNewStudent(String id, String name, String card){
        if(!isValidDepStudentId(id)) return false;
        //business validation
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT id FROM Student WHERE id='%s'",id);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                //new Alert(Alert.AlertType.ERROR,"Already Existing Student").show();
                txtId.requestFocus();
                txtId.selectAll();
                return false;
            }
            Statement stm2 = connection.createStatement();
            sql = String.format("INSERT INTO Student (id,name,card) VALUES ('%s','%s','%s')",id,name,card);
            int affectedRows = stm2.executeUpdate(sql);
            if(affectedRows == 1){
                return true;
            }else {
                throw new RuntimeException("Something went wrong");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean deleteStudent(String id){
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = String.format("DELETE FROM Student WHERE id='%s'",id);
            int i = statement.executeUpdate(sql);
            if(i == 1){
                return true;
            }else {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean isValidDepStudentId(String id){
        int currentBatch = Integer.parseInt(System.getProperty("dep.batch","11"));
        //2303111001
        if(!id.matches("\\d{2}03\\d{2}1\\d{3}")) return false;
        int year = Integer.parseInt(id.substring(0, 2));
        int currentYear = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("YY")));
        if(!(year >= 18 && year <= currentYear)) return false;

        int batch = Integer.parseInt(id.substring(4, 6));
        if(!(batch > 0 && batch <= currentBatch)) return false;
        int studentNum = Integer.parseInt(id.substring(id.length() - 3));
        return (studentNum > 0 && studentNum < 80);
    }

    public void loadAllStudents(){
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "Select * FROM Student";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                tblStu.getItems().add(new Student(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("card") == "null" ? "" : resultSet.getString("card"),"Yet To face"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void loadFromFile(File file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String[] split = line.split(",");
            int indexId = -1;
            int indexName = -1;
            int indexCard = -1;
            for (int i = 0; i < split.length; i++) {

                if(split[i].equals("id")) indexId = i;
                if(split[i].equals("name")) indexName = i;
                if(split[i].equals("card")) indexCard = 1;
                else {
                    indexCard = -1;
                }
            }
            if(indexId != -1 && indexName != -1){
                String s = "";
                String id = "";
                String name = "";
                String card = "";
                while ( (s= bufferedReader.readLine()) != null){
                    String[] split1 = s.split(",");
                    id = split1[indexId];
                    name = split1[indexName];
                    if(indexCard != -1) card = split1[indexCard];
                    else {
                        card = "null";
                    }
                    tblStu.getItems().add(new Student(id,name,card,"Yet To Face"));
                    addNewStudent(id,name,card);
                }
                //System.out.println("exist");
            }

        } catch (Exception e) {
            throw new RuntimeException("File error");
        }
    }

    public void tblStuOnDragDropped(DragEvent dragEvent) {
        if(!dragEvent.getDragboard().getFiles().isEmpty()){
            File file = dragEvent.getDragboard().getFiles().get(0);
            if(!file.getAbsolutePath().endsWith(".csv")) return;
            loadFromFile(file);
        }
    }

    public void tblStuOnDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }
}
