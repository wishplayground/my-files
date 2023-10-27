package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitiallizer extends Application {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws  Exception {
        System.out.println(Thread.currentThread().getName());
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/AboutScene.fxml")); // locate designed scene file
        Scene mainScene =new Scene(root);
        //Created mainscene
        primaryStage.setScene(mainScene);//set scene to the stage(means window.
        primaryStage.setTitle("Hello JAVAFX-4"); //name the scene

        //primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

    }
}
