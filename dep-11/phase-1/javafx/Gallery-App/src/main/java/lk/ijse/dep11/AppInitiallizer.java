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
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));

        Scene mainScne = new Scene(root);

        primaryStage.setScene(mainScne);
        primaryStage.setTitle("Gallery App");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
