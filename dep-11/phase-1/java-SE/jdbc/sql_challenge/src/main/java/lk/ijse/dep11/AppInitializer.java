package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dep11.db.DBConnection;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        try(var connection = DBConnection.getDbConnection().getConnection()){
            launch(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomeView.fxml"))));
        primaryStage.setTitle("Home View");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
