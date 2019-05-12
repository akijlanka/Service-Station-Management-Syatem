package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.bo.custom.PlatformBO;
import lk.ijse.ssms.bo.custom.impl.PlatformBOImpl;
import lk.ijse.ssms.model.PlatformDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlatfomrFormController implements Initializable {

    @FXML
    private JFXTextField txtpid;

    @FXML
    private JFXTextField txtpNo;

    @FXML
    private TableView<PlatformDTO> tblp;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    private static PlatformBO platformBO=new PlatformBOImpl();

    @FXML
    void AddUser(ActionEvent event) {

        String pid = txtpid.getText();
        String pno = txtpNo.getText();
        String status="A";

        PlatformDTO platformDTO=new PlatformDTO(pid,pno,status);

        Boolean result=false;

        try {
            result=platformBO.addplatform(platformDTO);
            PIDno();
            getall();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void DeleteUser(ActionEvent event) {
        String pid = txtpid.getText();
        Boolean result=false;

        try {
            result=platformBO.deleteplatform(pid);
            getall();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void select(MouseEvent event) {
     PlatformDTO select=tblp.getSelectionModel().getSelectedItem();
     txtpid.setText(select.getPid());
     txtpNo.setText(select.getPlatformNo());
    }

    private void getall(){
        tblp.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Pid"));
        tblp.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("PlatformNo"));

        ArrayList<PlatformDTO> allp=null;

        try {
            allp=platformBO.getAllplatform();
            tblp.setItems(FXCollections.observableArrayList(allp));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getall();
        PIDno();
    }

    private void PIDno(){
        String pid;
        try {
            pid= IDGenerator.getNewID("Platform","Pid","P");
            txtpid.setText(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
