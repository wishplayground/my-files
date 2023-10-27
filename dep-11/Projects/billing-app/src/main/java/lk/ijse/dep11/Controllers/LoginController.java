package lk.ijse.dep11.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.sql.rowset.spi.TransactionalWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
    public AnchorPane rooLogin;
    public TextField txtUserName;
    public Label lblUser;
    public PasswordField txtPassword;
    public Label lblPassword;
    public Button btnLogin;
    public Button btnBack;

    public void initialize(){
        lblUser.setVisible(false);
        lblPassword.setVisible(false);

    }
    public void txtUserNameOnAction(ActionEvent event) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]{5,}$");
        Matcher matcher = pattern.matcher(txtUserName.getText());
        if (!matcher.find()) {
            new Alert(Alert.AlertType.ERROR,"Invalid username").show();
            txtUserName.selectAll();
        }
        txtPassword.requestFocus();

    }

    public void txtPasswordOnAction(ActionEvent event) {
        btnLogin.fire();
    }

    public void btnLoginOnAction(ActionEvent event) throws IOException {
        Pattern patternUser = Pattern.compile("^admin$");
        Matcher matcherUser = patternUser.matcher(txtUserName.getText());

        Pattern patternPw = Pattern.compile("^admin123$");
        Matcher matcherPw = patternPw.matcher(txtPassword.getText());
        if(!(matcherUser.find() && matcherPw.find())) new Alert(Alert.AlertType.ERROR,"Username or PassWord missmatch").show();
        else{
            Stage adminPage = new Stage();
            adminPage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerReg.fxml"))));
            adminPage.setTitle("Administration Control");
            adminPage.centerOnScreen();
            adminPage.setResizable(false);
            adminPage.initModality(Modality.APPLICATION_MODAL);
            adminPage.show();
            ((Stage)(rooLogin.getScene().getWindow())).close();
        }
    }

    public void btnBackOnAction(ActionEvent event) {
        Stage back = (Stage)rooLogin.getScene().getWindow();
        back.close();
    }
}
