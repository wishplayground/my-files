package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoggingFormControoler {
    public TextField txtUser;
    public PasswordField txtPassword;
    public Label lblNameHint;
    public Label lblPasswordHint;
    public Label lblStatus;
    public Button btnLogging;


    public void initialize(){

        /*
        to display a control => setVisible(true)
        to hide a control => setVisible(false);
         */

        lblStatus.setVisible(false);
        lblNameHint.setVisible(false);
        lblPasswordHint.setVisible(false);




    }

    public void btnLoggingOnAction(ActionEvent actionEvent) {
        //name validation
        txtUser.requestFocus();
        String name = txtUser.getText().strip();
        String password = txtPassword.getText().strip();
        boolean valid = true;
        if(name.isBlank()){
            valid= false;
            lblNameHint.setVisible(true);
            lblNameHint.setText("Name Can't be Empty");
            txtUser.selectAll();
            txtUser.clear();
            return;
        }
        for (int i = 0; i < name.length(); i++) {
            if(Character.isDigit(name.charAt(i))) {
                valid = false;
                lblNameHint.setVisible(true);
                lblNameHint.setText("Name Can't include Digits");
                txtUser.clear();
                return;
            }

        }

        if(!validPassword(password)){
            lblPasswordHint.setVisible(true);
            lblPasswordHint.setText("Password mismatch");
            txtPassword.clear();
        }

        //validate Password


    }


    public static boolean validPassword(String password) {
        boolean lowercase =false,uppercase =false;
        for (int i = 0; i < password.length(); i++) {
            if(lowercase && uppercase &&(password.length()>=4)) break;
            if (Character.isUpperCase(password.charAt(i))) uppercase = true;
            if (Character.isLowerCase(password.charAt(i))) lowercase = true;


        }
        return lowercase && uppercase &&(password.length()>=4);
    }

    public static boolean ValidName(String name){

    }
}
