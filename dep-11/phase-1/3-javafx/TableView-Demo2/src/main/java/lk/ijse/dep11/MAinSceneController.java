package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.tm.Student;

public class MAinSceneController {
    public AnchorPane root;
    public TextField txtId;
    public TextField txtName;
    public TextField txtNumber;
    public ComboBox<String> cmbProgramme;
    public Button btnSave;
    public Button btnDelete;
    public Button btnNewStu;
    public TableView<Student> tvStud;


    public void initialize(){

        btnDelete.setDisable(true);
        Platform.runLater(() ->{
            btnNewStu.fire();
        });
        txtName.requestFocus();


        //Combo box set
        cmbProgramme.getItems().add("Direct Entry Programme");
        cmbProgramme.getItems().add("Graduated Diploma in Software engineering");
        cmbProgramme.getItems().add("Comprehensive Master Java Developer");
        cmbProgramme.getItems().add("Advanced Business Soluation Developer");
        cmbProgramme.getItems().add("Advance Mobile Application Developer");

        //set table initialize
        tvStud.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tvStud.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tvStud.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("programme"));
        tvStud.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contactNum"));

        tvStud.getSelectionModel().selectedItemProperty().addListener((value,previous,current) ->{
            btnDelete.setDisable(current == null);
            if(current != null){
                txtId.setText(tvStud.getSelectionModel().getSelectedItem().getId());
                txtName.setText(tvStud.getSelectionModel().getSelectedItem().getName());
                txtNumber.setText((tvStud.getSelectionModel().getSelectedItem().getContactNum()));
                cmbProgramme.getSelectionModel().select(tvStud.getSelectionModel().getSelectedItem().getProgramme());
            }
        });


    }
    public void btnSaveOnAction(ActionEvent event) {
        if(txtName.getText().strip().isBlank()){
            new Alert(Alert.AlertType.ERROR,"Name Cannot be Empty");
            txtName.selectAll();
            txtName.requestFocus();

        } else if (txtNumber.getText().strip().isBlank()) {
            new Alert(Alert.AlertType.ERROR,"Contact Number Cannot be Empty");
            txtNumber.selectAll();
            txtNumber.requestFocus();

        } else if (cmbProgramme.getSelectionModel().getSelectedIndex() == -1) {
            new Alert(Alert.AlertType.ERROR,"PLease Select currently Following Programme");
            cmbProgramme.getSelectionModel().clearSelection();
            cmbProgramme.requestFocus();

        }else {
            tvStud.getItems().add(new Student(txtId.getText(),txtName.getText(),cmbProgramme.getSelectionModel().getSelectedItem(),txtNumber.getText()));
            txtNumber.clear();
            txtId.clear();
            txtName.clear();
            cmbProgramme.getSelectionModel().clearSelection();
            btnNewStu.requestFocus();

        }

    }

    public void btnDeleteOnAction(ActionEvent event) {
        if(tvStud.getItems().isEmpty()) btnNewStu.fire();
        tvStud.getItems().remove(tvStud.getSelectionModel().getSelectedItem());
        txtId.clear();
        txtName.clear();
        txtNumber.clear();
        cmbProgramme.getSelectionModel().clearSelection();
        btnNewStu.requestFocus();
    }

    public void btnNewStuOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtNumber.clear();
        cmbProgramme.getSelectionModel().clearSelection();
        btnDelete.setDisable(true);
        generateStudId();
    }

    public void generateStudId(){
        ObservableList<Student> stud = tvStud.getItems();
        if(stud.isEmpty()){
            txtId.setText("S-0001");
        }else {
            int genId = Integer.parseInt(stud.get(stud.size()-1).getId().substring(2))+1;
            String id = String.format("S-%04d",genId);

            txtId.setText(id);
        }
    }


    public void txtNumberOnAction(ActionEvent event) {
        btnSave.fire();
        btnNewStu.fire();
    }
}
