package lk.ijse.dep11;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class MainViewController {

    public AnchorPane Mainroot;
    public ListView<String> lstsubject;
    public ListView<String> lstSelected;
    public Button btnselect;
    public Button btnback;
    public Button btnRemove;
    public Button btnClear;
    public TextField txtsubject;


    public void initialize(){
        btnselect.setTooltip(new Tooltip("Select Subject"));
        btnback.setTooltip(new Tooltip("click to remove subject"));
        btnselect.getTooltip().setFont(Font.font(12));
        btnback.getTooltip().setFont(btnselect.getTooltip().getFont());

        btnClear.setDisable(true);
        ObservableList<String> subjectList = lstsubject.getItems();
        subjectList.addListener((Observable o) ->{
            btnClear.setDisable(subjectList.isEmpty());
        });

        btnselect.setDisable(true);
        btnRemove.setDisable(true);
        lstsubject.getSelectionModel().selectedItemProperty().addListener(e ->{
            btnselect.setDisable(lstsubject.getSelectionModel().getSelectedItem().isEmpty());
            btnRemove.setDisable(lstsubject.getSelectionModel().getSelectedItem().isEmpty());
        });

        btnback.setDisable(true);
        lstSelected.getSelectionModel().selectedItemProperty().addListener(e ->{
            btnback.setDisable(lstSelected.getSelectionModel().getSelectedItem().isEmpty());
        });



    }

    public void txtsubjectOnAction(ActionEvent event) {
        String subject = txtsubject.getText().strip();
        if(subject.isBlank()) return;

        ObservableList<String> subjects = lstsubject.getItems();
        if(subjects.contains(subject)) {
            new Alert(Alert.AlertType.ERROR,subject + " Already Added").show();
            txtsubject.selectAll();
            return;
        }
        subjects.add(subject);
        txtsubject.clear();
    }
    public void btnselectOnAction(ActionEvent event) {
        ObservableList<String> items = lstSelected.getItems();
        ObservableList<String> subject = lstsubject.getItems();

        String rmItem = lstsubject.getSelectionModel().getSelectedItem();
        items.add(rmItem);
        subject.remove(rmItem);
        lstsubject.getSelectionModel().clearSelection();


    }

    public void btnBackOnAction(ActionEvent event) {
        ObservableList<String> subjectlist = lstsubject.getItems();
        ObservableList<String> selected = lstSelected.getItems();

        String backItem = lstSelected.getSelectionModel().getSelectedItem();
        subjectlist.add(backItem);
        selected.remove(backItem);
        lstSelected.getSelectionModel().clearSelection();


    }

    public void btnRemoveOnAction(ActionEvent event) {
        ObservableList<String> subs = lstsubject.getItems();
        String removeItem = lstsubject.getSelectionModel().getSelectedItem();
        subs.remove(removeItem);
        lstsubject.getSelectionModel().clearSelection();



    }

    public void btnClearOnAction(ActionEvent event) {


    }


}
