package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

public class Scene1Controler {

    public AnchorPane root;
    public Button btnGoToScene;
    public Button GoToScene3;
    public AnchorPane root1;
    public Button btnNewStage;

    public void btnGoToSceneOnAction(ActionEvent actionEvent) throws IOException {

        AnchorPane root2 = FXMLLoader.load(getClass().getResource("/view/Scene2.fxml"));

        Scene scene2 = new Scene(root2);

        Stage primaryStage = (Stage) root2.getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.sizeToScene();
    }

    public void GoToScen3OnAction(ActionEvent actionEvent) throws IOException {

        AnchorPane root3 = FXMLLoader.load(getClass().getResource("/view/Scene3.fxml"));

        Scene scene3 = new Scene(root3);

        Stage primaryStage = (Stage) root3.getScene().getWindow();
        primaryStage.setScene(scene3);
        primaryStage.sizeToScene();
    }

    public void btnNewStageOnAction(ActionEvent actionEvent) {

        Stage stage = new Stage();
        stage.setTitle("This is a New Stage");
        stage.show();
    }
}
