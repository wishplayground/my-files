package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitiallizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane mainRoot = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Scene mainScene = new Scene(mainRoot);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Dynemic-Controlls");
        primaryStage.centerOnScreen();
        primaryStage.show();


    }
}
