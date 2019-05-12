package lk.ijse.ssms.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.ssms.bo.custom.BikeBO;
import lk.ijse.ssms.bo.custom.MakeServiceBO;
import lk.ijse.ssms.bo.custom.impl.BikeBOImpl;
import lk.ijse.ssms.bo.custom.impl.MakeServiceBOImpl;
import lk.ijse.ssms.model.BikeDTO;
import lk.ijse.ssms.model.ServiceDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ServiceBikeDetailController implements Initializable {

    @FXML
    private TableView<ServiceDTO> tblSrvice;

    @FXML
    private TableView<BikeDTO> tblBike;


    private static MakeServiceBO makeServiceBO=new MakeServiceBOImpl();
    private static BikeBO bikeBO=new BikeBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      lodeService();
      lodeBike();
    }

    private void lodeService(){
        tblSrvice.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Sid"));
        tblSrvice.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Aid"));
        tblSrvice.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("BikeNum"));
        tblSrvice.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Intime"));
        tblSrvice.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Outtime"));
        tblSrvice.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Platform"));
        ArrayList<ServiceDTO> allservice=null;
        try{
            allservice=makeServiceBO.getAllService();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tblSrvice.setItems(FXCollections.observableArrayList(allservice));
    }

    private void lodeBike(){
        tblBike.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Bid"));
        tblBike.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("BikeNum"));
        tblBike.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Cusname"));
        tblBike.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("TpNum"));
        tblBike.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Model"));

        ArrayList<BikeDTO> allBike=null;
        try{
            allBike=bikeBO.getAllbike();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tblBike.setItems(FXCollections.observableArrayList(allBike));
    }
}
