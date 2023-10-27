package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainSceneController {
    public AnchorPane root;
    public Button btnAnchor;
    public Button btnBoaderpane;
    public Button btnFlowpane;
    public Button btnTitlePane;
    public Button btnGrid;
    public Button btnStack;

    public void btnAnchorOnAction(ActionEvent event) throws Exception{
        AnchorPane anchorRoot = FXMLLoader.load(getClass().getResource("/view/AnchorPaneLayout.fxml"));
        Scene anchorScene = new Scene(anchorRoot);

        Stage stage = new Stage();
        stage.setScene(anchorScene);
        stage.setTitle("Anchor Pane Layout");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnBoaderpaneOnAction(ActionEvent event) throws Exception{

        BorderPane boaderRoot = FXMLLoader.load(getClass().getResource("/view/BoaderPaneLayout.fxml"));
        Scene boaderScene = new Scene(boaderRoot);

        Stage stage1 = new Stage();
        stage1.setScene(boaderScene);
        stage1.setTitle("Boader Pane");
        stage1.centerOnScreen();
        stage1.show();
    }

    public void btnFlowpaneOnAction(ActionEvent event) throws Exception {
        FlowPane flowRoot = FXMLLoader.load(getClass().getResource("/view/FlowPanLayout.fxml"));
        Scene flowScene = new Scene(flowRoot);

        Stage flowStage = new Stage();
        flowStage.setScene(flowScene);
        flowStage.setTitle("Flow Pane");
        flowStage.centerOnScreen();
        flowStage.show();

    }

    public void btnTitlePaneOnAction(ActionEvent event) throws Exception {

        TitledPane titleRoot = FXMLLoader.load(getClass().getResource("/view/TitlePane.fxml"));
        Scene titleScene = new Scene(titleRoot);

        Stage newStage = new Stage();
        newStage.setScene(titleScene);
        newStage.setTitle("Titled Pane");
        newStage.centerOnScreen();
        newStage.show();
    }

    public void btnGridOnAction(ActionEvent event) throws  Exception{

        GridPane gridRoot = FXMLLoader.load(getClass().getResource("/view/GridPane.fxml"));
        Scene gridScene = new Scene(gridRoot);

        Stage stage = new Stage();
        stage.setScene(gridScene);
        stage.setTitle("Grid Pane");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnStackOnAction(ActionEvent event) throws Exception {

        StackPane gridRoot = FXMLLoader.load(getClass().getResource("/view/StackPaneLayout.fxml"));
        Scene gridScene = new Scene(gridRoot);

        Stage stage = new Stage();
        stage.setScene(gridScene);
        stage.setTitle("Stack Pane Layout");
        stage.centerOnScreen();
        stage.show();
    }


}
