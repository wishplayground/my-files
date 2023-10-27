package lk.ijse.dep11.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {
    public AnchorPane rootDash;
    public Button btnDep;
    public Button btnEmployee;

    public void btnDepOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DepartmentView.fxml"))));
        stage.setTitle("Department Management");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/EmployeeManagement.fxml"))));
        stage.setTitle("Department Management");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}
