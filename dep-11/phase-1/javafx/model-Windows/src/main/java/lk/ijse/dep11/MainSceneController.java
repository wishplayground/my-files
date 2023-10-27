package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainSceneController {
    public Button btnWindowmodel;
    public Button btnNewStage;

    public void btnNewStageOnAction(ActionEvent actionEvent) throws Exception{
        AnchorPane Scene1root1 = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Scene scene1 = new Scene(Scene1root1);

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

    }

    public void btnWindowmodelOnAction(ActionEvent actionEvent) {
    }
}
