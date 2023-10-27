package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dep11.db.SingleConnectionDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AppInitializer extends Application {

    public static void main(String[] args)  {
        try (var connection = SingleConnectionDataSource.getInstance().getConnection()){
            launch(args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"))));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login view");
        primaryStage.centerOnScreen();
        primaryStage.show();

    }
}
