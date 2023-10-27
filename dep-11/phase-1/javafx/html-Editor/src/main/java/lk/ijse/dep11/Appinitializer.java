package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.WriteAbortedException;

public class Appinitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        Scene mainScene = new Scene(root);

        primaryStage.setScene(mainScene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("html-Editor");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
