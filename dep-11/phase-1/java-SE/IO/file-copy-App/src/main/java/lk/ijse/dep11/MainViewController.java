package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;

import java.io.*;

public class MainViewController {
    public TextField txtSource;
    public Button btnBrowsSource;
    public TextField txtTarget;
    public Button btnBrowseTarget;
    public Button btnCopy;
    public Label lblBytes;
    public Label lblpro;
    public ProgressBar pbCopy;
    public AnchorPane root;

    public void initialize(){
        btnCopy.setDisable(true);
    }

    public void btnBrowsSourceOnAction(ActionEvent event) {
        FileChooser fileSource = new FileChooser();
        fileSource.setTitle("Select File to Copy");
        File fileRef =  fileSource.showOpenDialog(root.getScene().getWindow());
        if(fileRef != null){
            txtSource.setText(fileRef.getAbsolutePath());
        }else {
            txtSource.clear();
        }
        btnCopy.setDisable(txtSource.getText().isBlank() || txtTarget.getText().isBlank());
    }

    public void btnBrowesTargetOnAction(ActionEvent event) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select destination Folder");
        File file = directoryChooser.showDialog(root.getScene().getWindow());
        if(file != null){
            txtTarget.setText(file.getAbsolutePath());
        }else {
            txtTarget.clear();
        }
        btnCopy.setDisable(txtSource.getText().isBlank() || txtTarget.getText().isBlank());
    }

    public void btnCopyOnAction(ActionEvent event) throws FileNotFoundException {
        Task<Void> copyTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                copy();
                Platform.runLater(() -> btnCopy.setDisable(true));
                return null;
            }
        };
        new Thread(copyTask).start();
    }

    void copy() throws FileNotFoundException{
        File sourceFile = new File(txtSource.getText());

        //File targetFile = new File(txtTarget.getText() + "/" + sourceFile.getName());
        File targetFile = new File(txtTarget.getText(),sourceFile.getName());

        //first create empty file, name having source file name
        try {
            targetFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Failed to Copy");
            e.printStackTrace();
        }

        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        try{
            int read = 0;
            while ((read = inputStream.read()) != -1){
                fileOutputStream.write(read);

            }
            Platform.runLater (() -> new Alert(Alert.AlertType.INFORMATION,"Successfully Copied!").show());
            inputStream.close();
            fileOutputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    void updateProgress(long copied, long total){
        Platform.runLater(() ->{
            lblpro.setText(String.format("%.2f",copied /total * 100).concat("%"));
            lblBytes.setText(String.format("Copied = %d/%d Bytes",copied,total));
            pbCopy.setProgress(copied/(total * 1.0));
        });
    }
}
