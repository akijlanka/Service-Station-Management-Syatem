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

public class ServicesController implements Initializable {

    @FXML
    private Pane btnWaitapp;

    @FXML
    private Pane btnOngoing;

    @FXML
    private Pane btnEnd;

    @FXML
    private Pane lodePane;

    @FXML
    void lodeAppointment(MouseEvent event){
        WaitApp();
    }

    @FXML
    void lodeEnd(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/invoiceForm.fxml"));
        lodePane.getChildren().setAll(pane);
    }

    @FXML
    void lodeOngoing(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/onGoingForm.fxml"));
        lodePane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WaitApp();
    }

    private void WaitApp(){
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/waitAppointmentForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lodePane.getChildren().setAll(pane);
        btnWaitapp.setStyle("-fx-background-color: #053843");


    }

    public void change(MouseEvent mouseEvent) {
        btnWaitapp.setStyle("-fx-background-color: #053843");
        btnOngoing.setStyle("-fx-background-color: #277283");
        btnEnd.setStyle("-fx-background-color: #277283");

    }

    public void change3(MouseEvent mouseEvent) {
        btnEnd.setStyle("-fx-background-color: #053843");
        btnWaitapp.setStyle("-fx-background-color: #277283");
        btnOngoing.setStyle("-fx-background-color: #277283");

    }

    public void change2(MouseEvent mouseEvent) {
        btnOngoing.setStyle("-fx-background-color: #053843");
        btnWaitapp.setStyle("-fx-background-color: #277283");
        btnEnd.setStyle("-fx-background-color: #277283");

    }
}
