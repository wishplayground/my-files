package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.security.auth.login.AccountNotFoundException;

public class AppInitiallizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       AnchorPane root = FXMLLoader.load(getClass().getResource("/view/LoggingScene.fxml"));

        Scene logingScene = new Scene(root);
        primaryStage.setScene(logingScene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Logging Screen");
        primaryStage.centerOnScreen();
        primaryStage.show();



    }
}
