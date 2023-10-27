package lk.ijse.dep11;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ListViewController {
    public AnchorPane root;
    public TextField txtSubject;
    public ListView<String> lvSubject;
    public Button btnNext;
    public Button btnBack;
    public ListView<String> lvSelected;
    public Button btnRemove;
    public Button btnClear;

    public void initialize(){
        btnRemove.setDisable(lvSubject.getItems().isEmpty());
        btnClear.setDisable(lvSubject.getItems().isEmpty());

        Button[] buttons = {btnNext,btnBack,btnClear,btnRemove};
        for (Button button : buttons) {
            button.setDisable(true);
        }


        lvSubject.getSelectionModel().selectedItemProperty().addListener(e ->{
            btnNext.setDisable(lvSubject.getSelectionModel().getSelectedItem().isEmpty());
            btnRemove.setDisable(lvSubject.getSelectionModel().getSelectedItem().isEmpty());
        });

        lvSelected.getSelectionModel().selectedItemProperty().addListener(e ->{
            btnBack.setDisable(lvSubject.getSelectionModel().getSelectedItem().isEmpty());
        });





    }

    public void btnNextOnAction(ActionEvent event) {
        String temp = lvSubject.getSelectionModel().getSelectedItem();
        lvSelected.getItems().add(temp);
        lvSubject.getItems().remove(temp);
    }

    public void btnBackOnAction(ActionEvent event) {
        String temp = lvSelected.getSelectionModel().getSelectedItem();
        lvSubject.getItems().add(temp);
        lvSelected.getItems().remove(temp);
    }

    public void btnRemoveOnAction(ActionEvent event) {
        lvSubject.getItems().remove(lvSubject.getSelectionModel().getSelectedItem());
    }

    public void btnClearOnAction(ActionEvent event) {
        lvSubject.getItems().clear();
    }

    public void txtSubjectOnAction(ActionEvent event) {
        if(txtSubject.getText().isEmpty()){
            txtSubject.selectAll();
            return;
        } else if(lvSubject.getItems().contains(txtSubject.getText())) {
            new Alert(Alert.AlertType.ERROR,txtSubject.getText() + " Already Exist").show();
            txtSubject.clear();
            return;

        }else {
            btnClear.setDisable(false);
            lvSubject.getItems().add(txtSubject.getText());
            txtSubject.clear();
        }
    }
}
