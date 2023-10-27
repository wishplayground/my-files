package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.Shared.to.Customer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerController {
    public AnchorPane rootServer;
    public TableView<Customer> tblServer;

    public void initialize(){

        tblServer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblServer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblServer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        new Thread(this::startServer).start();     // = new Thread(() -> startServer()).start();
    }

    private void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            while (true){
                System.out.println("waiting for connection");
                Socket localSocket = serverSocket.accept();
                System.out.println("Client connected: " + localSocket);
                new Thread(() ->{
                    try {
                        InputStream inputStream = localSocket.getInputStream();
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        ObjectInputStream ois = new ObjectInputStream(bufferedInputStream);
                        while (true){
                            try {
                                Customer customer = (Customer)ois.readObject();
                            }catch (EOFException e){
                                e.printStackTrace();
                            }

                            Platform.runLater(() ->{
                                tblServer.getItems().add(customer);
                            });

                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
