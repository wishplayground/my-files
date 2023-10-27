package lk.ijse.dep11.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.dep11.db.SingleConnectionDataSource;
import org.apache.commons.codec.digest.DigestUtils;

import javax.sql.rowset.spi.TransactionalWriter;
import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginViewController {
    public AnchorPane rooLogin;
    public TextField txtUserName;
    public Label lblUser;
    public PasswordField txtPassword;
    public Label lblPassword;
    public Button btnLogin;
    public Button btnBack;
    private PreparedStatement preparedStatement;

    public void initialize(){
        lblUser.setVisible(false);
        lblPassword.setVisible(false);
        Connection connection = SingleConnectionDataSource.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        String username = txtUserName.getText();
        String passwd = txtPassword.getText();
        Connection connection = SingleConnectionDataSource.getInstance().getConnection();
        try {
            //canbe loging with sql injection
            /*Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM user WHERE username='%s' AND password='%s'",username,passwd);
            ResultSet resultSet = statement.executeQuery(sql);*/
            preparedStatement.setString(1,username);//sanatize data and send to data base
            preparedStatement.setString(2, DigestUtils.sha256Hex(passwd));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                navigateToApp();
            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid Login credentials").show();
                txtPassword.clear();
                txtUserName.selectAll();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent event) {
        Stage back = (Stage)rooLogin.getScene().getWindow();
        back.close();
    }

    private void navigateToApp() throws IOException {
        Stage adminPage = new Stage();
        adminPage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml"))));
        adminPage.setTitle("My App SQL Injection");
        adminPage.centerOnScreen();
        adminPage.setMaximized(true);
        adminPage.initModality(Modality.APPLICATION_MODAL);
        adminPage.show();
        ((Stage)(rooLogin.getScene().getWindow())).close();
    }
}
