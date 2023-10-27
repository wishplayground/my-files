package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainSceneController {
    public AnchorPane rootApp;
    public Label txtWelcome;
    public Button btnLogout;


    public void initData(String userFullName, String backgroundColor){    //must be created on destination folder
        txtWelcome.setText(String.format("Welcome %s" ,userFullName));
        rootApp.setBackground(Background.fill(Color.web(backgroundColor)));
    }

    public void btnLogoutOnAction(ActionEvent event) throws Exception {
        System.out.println("Satarted");
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoggingScene.fxml"))));
        stage.setTitle("Navigation: Login");
        stage.setResizable(false);
        stage.show();

        Stage mainStage = (Stage) rootApp.getScene().getWindow();
        mainStage.close();

    }



}
