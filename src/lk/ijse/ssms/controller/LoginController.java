package lk.ijse.ssms.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.ssms.Common.NotificationController;
import lk.ijse.ssms.main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXPasswordField txtpassword;

    @FXML
    private JFXButton btnlogin;

    @FXML
    private JFXButton btnclose;

    @FXML
    private JFXButton btnmini;




    public void login(ActionEvent actionEvent) throws IOException {
        if (txtusername.getText().equals("admin") && txtpassword.getText().equals("123")){

        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/ssms/view/admindashboard.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.show();



                NotificationController.createSuccesful("Welcome","Login Succesful");

            } catch (Exception e) {


            }

        }else{

            NotificationController.createError("Somthing Wrrong","Check Username Password");


        }


    }

    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void minimize(ActionEvent actionEvent) {
        Main.stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
