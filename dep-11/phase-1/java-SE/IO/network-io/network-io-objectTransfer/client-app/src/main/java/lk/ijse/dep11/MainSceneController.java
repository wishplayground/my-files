package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep11.Shared.to.Customer;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainSceneController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSubmit;
    public AnchorPane root;
    private ObjectOutputStream oos;

    public void initialize(){
        try {
            Socket remoteSocket = new Socket("localhost", 5050);
            OutputStream outputStream = remoteSocket.getOutputStream();
            oos = new ObjectOutputStream(outputStream);
            BufferedOutputStream bos = new BufferedOutputStream(oos);
            System.out.println("Connected....!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btnSubmitOnAction(ActionEvent event) {
        if(!txtId.getText().matches("C\\d{3}")){
            txtId.requestFocus();
            txtId.selectAll();
            return;
        }else if(!txtName.getText().matches("[A-Za-z ]+")){
            txtName.requestFocus();
            txtName.selectAll();
            return;
        }else if(txtAddress.getText().isBlank() || txtAddress.getText().strip().length()<3){
            txtAddress.requestFocus();
            txtAddress.selectAll();
            return;
        }

        var customer = new Customer(txtId.getText() ,txtName.getText(),txtAddress.getText());
        try {
            oos.writeObject(customer);
            oos.flush();
            txtId.clear();
            txtName.clear();
            txtAddress.clear();
            txtId.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
