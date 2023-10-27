package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoggingSceneController {
    public TextField txtUser;
    public TextField txtPwd;
    public Button btnLoggin;
    public AnchorPane root;

    public void btnLogginOnAction(ActionEvent event) throws Exception {

        String username = txtUser.getText();
        String pass = txtPwd.getText();

        String[][] users = {
                {"admin","admin123","wishva adhikari", "Yellow"},
                {"amal","Amal123","Amal perera","Green"},
                {"hansi","hansi123","hansika dewmini","Pink"} };

        for (String[] user : users) {
            if(user[0].equals(username) && user[1].equals(pass)){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainScene.fxml"));
                AnchorPane mainRoot = fxmlLoader.load();

                MainSceneController mainSceneController = fxmlLoader.getController();
                mainSceneController.initData(user[2],user[3]);

                Scene mainScene = new Scene(mainRoot);
                Stage stage = new Stage();
                stage.setScene(mainScene);
                stage.centerOnScreen();
                stage.show();

                Stage LogingStage = (Stage) root.getScene().getWindow();
                LogingStage.close();
                return;

            }
        }

        new Alert(Alert.AlertType.ERROR,"Invalid Username or Password").show();
        txtUser.requestFocus();


    }
}
