package lk.ijse.dep11.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    public Button btnEmployee;
    public Button btnDepartment;
    public AnchorPane rootDash;

    public void btnDepartmentOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DepartmentMangementView.fxml"))));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void btnEmployeeOnAction(ActionEvent event) {
    }
}
