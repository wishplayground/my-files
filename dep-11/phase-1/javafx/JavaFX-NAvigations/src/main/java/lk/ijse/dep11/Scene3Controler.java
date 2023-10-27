package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene3Controler {
    public AnchorPane root3;
    public Button btnGotoScene1;
    public Button btnGotoScene3;

    public void btnGotoScene1OnAction(ActionEvent actionEvent) throws IOException {

        AnchorPane root1 = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene1 = new Scene(root1);

        Stage primaryStage = (Stage) root1.getScene().getWindow();
        primaryStage.setScene(scene1);
        primaryStage.sizeToScene();
    }

    public void btnGotoScene3OnAction(ActionEvent actionEvent) throws IOException{

        AnchorPane root2 = FXMLLoader.load(getClass().getResource("/view/Scene2.fxml"));
        Scene scene2 = new Scene(root2);

        Stage primaryStage = (Stage) root2.getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.sizeToScene();
    }
}
