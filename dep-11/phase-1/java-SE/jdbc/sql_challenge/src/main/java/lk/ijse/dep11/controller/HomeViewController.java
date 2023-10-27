package lk.ijse.dep11.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.dep11.db.DBConnection;
import lk.ijse.dep11.tm.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeViewController {
    public AnchorPane rootHome;
    public Label lblSelect;
    public Button btnStart;
    public Button btnFinish;
    public Button btnStu;
    private boolean isPressed = false;
    private Thread thread;
    private Task<Void> animatedName;
    public void initialize(){

    }

    public void btnFinishOnAction(ActionEvent event) {
        if(isPressed){
            thread.start();
        }
    }

    public void btnStartOnAction(ActionEvent event) {
        Connection connection = DBConnection.getDbConnection().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");
            String id = "";
            String card = "";
            String name = "";
            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                id = resultSet.getString("id");
                card = resultSet.getString("card");
                card = Objects.equals(card, "null") ? "" : card;
                name = resultSet.getString("name");
                studentList.add(new Student(id, name, card, "Yet to Face"));
            }
            /*protected Void call(){

            }*/
            if(!isPressed){
                animatedName = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        while (true) {
                            for (Student student : studentList) {
                                if (!student.getCard().trim().isBlank()) {
                                    Platform.runLater(() -> lblSelect.setText(student.getName() + " : " + student.getCard()));
                                } else {
                                    Platform.runLater(() -> lblSelect.setText(student.getName()));
                                }
                                Thread.sleep(100);
                            }
                        }
                    }
                };
                thread = new Thread(animatedName);
                thread.start();
                btnStart.setText("Pick");
                isPressed = true;
                btnFinish.setText("Skip");
            }else {
                thread.interrupt();
                //isPressed = false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnStuOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ManageStudent.fxml"))));
        stage.setTitle("Student Challenge");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
