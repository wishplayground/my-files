package lk.ijse.dep11.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;

public class ClientViewController {

    public AnchorPane rootClient;
    public TextArea txtField;
    public Label lblReceiverName;
    public TextField txtMessage;
    public Button btnSend;
    private Socket socket;

    public void initialize(){

            new Thread(()->{
                try {
                    socket = new Socket("localhost",5050);
                    System.out.println("connected to server");
                    InputStream inputStream = socket.getInputStream();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    int read = 0;
                    byte[] buffer = new byte[1024];
                    while ((read = bufferedInputStream.read(buffer))!= -1){
                        Platform.runLater(() -> txtField.setText(new String(buffer) + "\n"));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();



    }
    public void btnSendOnAction(ActionEvent event) {
        writeMessage(txtMessage.getText());
    }
    public void writeMessage(String message){
        if(message.strip().isBlank()) return;
        try {
            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(message.getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
