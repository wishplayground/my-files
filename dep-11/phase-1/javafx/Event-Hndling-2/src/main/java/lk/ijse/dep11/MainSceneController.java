package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {

    public Button btnRemove;
    public Label lblcount;
    @FXML
    private Button btnAdd;

    @FXML
    private ListView<String> lvItems;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtSomething;


    public void initialize(){
        btnAdd.setDefaultButton(true);

        lblcount.setText("Count: 0");
        btnRemove.setDisable(true);
        //works on (mouse clicked, Enter,space,tab,touch for touch screens

        lvItems.getSelectionModel().selectedItemProperty().addListener((value, prev, current) -> {
            /*
            *to disable a control => setDisable(true);
             */
            System.out.printf("Previous = %s, Current = %s \n",prev,current);
            btnRemove.setDisable(current == null); //activate = false, deactivate = true
        });



    }

    public void btnAddOnaction(ActionEvent e) {
        String text = txtSomething.getText();
        if(text.strip().isBlank()) {
            txtSomething.requestFocus();
            txtSomething.selectAll();
            return; //end
        }
        lvItems.getItems().add(text);
        lblcount.setText("Count: " + lvItems.getItems().size());
        txtSomething.clear();

        txtSomething.requestFocus();
    }

    public void lvlItemsOnKeyPressed(KeyEvent e) {
        System.out.println(e.getCode());
        if(e.getCode() == KeyCode.DELETE) btnRemove.fire(); //trigger action listner for btnremove method
    }

    public void btnRemoveOnAtion(ActionEvent e) {
        int selectedIndex = lvItems.getSelectionModel().getSelectedIndex();
        lvItems.getItems().remove(selectedIndex);
        lblcount.setText("Count: " + lvItems.getItems().size());
        lvItems.getSelectionModel().clearSelection();
    }
}

