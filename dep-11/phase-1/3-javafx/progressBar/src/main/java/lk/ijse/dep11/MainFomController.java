package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class MainFomController {
    public ProgressBar pgb1;
    public Button btnStart;
    public Label lblValue;
    public ProgressBar pgb2;
    public AnchorPane root;
    public Button btnplatExit;
    public Button btnSystemexit;

    public void btnStartOnAction(ActionEvent event) throws Exception {
        //at progress bar has getProgress(); double
        // setProgress(doubleProgress);  methods
        //progress value = {0 -1}   //know about
        //progress Value = -1    when value is unKnown

        //have a long running task define a task
        Task<Void> myLongRuningTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                //Enter long running task
                pgb1.setProgress(0);
                for (int i = 0; i < 200; i++) {
                    System.out.println("Direct Entry Programme " + i);
                    int k =i;

                    Platform.runLater(() ->{
                        lblValue.setText("value: " + String.format("%.0f",(k/200.0 * 100)));
                        pgb1.setProgress(k/200.0);
                    });
                    Thread.sleep(100);
                }
                Platform.runLater(() ->{
                    pgb1.setProgress(1);
                });

                return null;
            }
        };

        new Thread(myLongRuningTask).start();

    }

    public void btnSystemexitOnAction(ActionEvent event) {
        System.exit(0);
    }

    public void btnplatExitOnAction(ActionEvent event) {
        Platform.exit();
    }
}
