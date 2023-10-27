package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitiallizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Scene MainScene = new Scene(root);

        primaryStage.setScene(MainScene);
        primaryStage.setTitle("Drag and Drop");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
