package lk.ijse.dep11;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.security.Key;

public class ComboBoxSceneController {
    public Label lblStatus;
    public Button btnRemove;
    public Button btnClearCountry;
    public ComboBox<String> cmbCountry;
    public TextField txtCountry;

    public void initialize(){
        btnClearCountry.setDisable(true);
        cmbCountry.setDisable(true);
        btnRemove.setDisable(true);


        cmbCountry.getItems().addListener((Observable o) ->{
            cmbCountry.setDisable(cmbCountry.getItems().isEmpty());
            btnClearCountry.setDisable(cmbCountry.getItems().isEmpty());
        });
        cmbCountry.getSelectionModel().selectedItemProperty().addListener(e ->{
            btnRemove.setDisable(cmbCountry.getItems().isEmpty());
            lblStatus.setText(cmbCountry.getSelectionModel().getSelectedItem());
        });



    }

    public void btnRemoveOnAction(ActionEvent event) {
        ObservableList<String> country = cmbCountry.getItems();
        String temp = cmbCountry.getSelectionModel().getSelectedItem();
        country.remove(temp);
        cmbCountry.getSelectionModel().clearSelection();
        cmbCountry.setPromptText("Select Country");
        txtCountry.setText("-");

    }

    public void txtCountryOnAction(ActionEvent event) {
        String country = txtCountry.getText();
        ObservableList<String> items = cmbCountry.getItems();

        if(country.isBlank()) return;
        if(items.contains(country)){
            new Alert(Alert.AlertType.ERROR,country + " Already exist Country").show();
            txtCountry.selectAll();
            return;
        }
        items.add(country.strip());
        txtCountry.clear();

    }

    public void cmbCountryOnAction(ActionEvent event) {
    }

    public void btnClearCountryOnAction(ActionEvent event) {
        cmbCountry.getItems().clear();
    }

    public void btnRemoveOnKeyPressed(KeyEvent e) {
        if(e.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    public void AnchorPaneOnkeyPressed(KeyEvent e) {
        if(e.getCode() == KeyCode.F12) btnClearCountry.fire();
    }
}
