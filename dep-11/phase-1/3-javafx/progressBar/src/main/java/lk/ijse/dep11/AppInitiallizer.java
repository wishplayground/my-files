package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

public class AppInitiallizer extends Application {

    public static void main(String[] args) {
        System.out.println("About to start JAva FX Run Time environment");
        launch(args);  //excute by mainThread
        System.out.println("About to Exit JAva FX Run Time environment");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //execute by JAva fx Application Thread
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        Scene mainSCene = new Scene(root);

        primaryStage.setScene(mainSCene);
        primaryStage.setTitle("Progress Bar");
        primaryStage.centerOnScreen();
        primaryStage.show();

        primaryStage.setOnCloseRequest(e ->{
            /*System.out.println("Stage is about to Close");
            e.consume();//event not valid*/
            Optional<ButtonType> buttonRef = new Alert(Alert.AlertType.CONFIRMATION,"Do you want Exit? ", ButtonType.YES,ButtonType.NO).showAndWait();

            if(buttonRef.get() == ButtonType.NO){
                e.consume();
            }
        });

    }
}
