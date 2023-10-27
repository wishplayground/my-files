package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller {
    public AnchorPane root2;
    public Button btnGoToScene1;
    public Button btnGoToScene3;

    public void btnGoToScene1OnAction(ActionEvent actionEvent) throws IOException {

        AnchorPane root1 = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene1 = new Scene(root1);

        Stage primaryStage = (Stage) root1.getScene().getWindow();
        primaryStage.setScene(scene1);
        primaryStage.sizeToScene();
    }

    public void btnGoToScene3OnAction(ActionEvent actionEvent) throws  IOException {

        AnchorPane root3 = FXMLLoader.load(getClass().getResource("/view/Scene3.fxml"));
        Scene scene3 = new Scene(root3);
        Stage primaryStage = (Stage) root3.getScene().getWindow();
        primaryStage.setScene(scene3);
        primaryStage.sizeToScene();
    }
}
