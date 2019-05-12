package lk.ijse.ssms.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingDashboardController implements Initializable {

    @FXML
    private Pane lodePane;

    @FXML
    private Pane btnAdduser;

    @FXML
    private Pane btnaddPlatform;

    private static AnchorPane pane;

    @FXML
    void change1(MouseEvent event) {
        btnAdduser.setStyle("-fx-background-color: #053843");
        btnaddPlatform.setStyle("-fx-background-color: #277283");

    }

    @FXML
    void change2(MouseEvent event) {
        btnaddPlatform.setStyle("-fx-background-color: #053843");
        btnAdduser.setStyle("-fx-background-color: #277283");


    }

    @FXML
    void lodeplatform(MouseEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/platformForm.fxml"));
        lodePane.getChildren().setAll(pane);
    }

    @FXML
    void lodeuser(MouseEvent event) throws IOException {
        userlode();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAdduser.setStyle("-fx-background-color: #053843");
        try {
            userlode();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void userlode() throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/usersForm.fxml"));
        lodePane.getChildren().setAll(pane);
    }
}
