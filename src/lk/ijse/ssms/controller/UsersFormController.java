package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.Common.NotificationController;
import lk.ijse.ssms.bo.custom.UserBO;
import lk.ijse.ssms.bo.custom.impl.UserBOImpl;
import lk.ijse.ssms.model.UserDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class UsersFormController implements Initializable {

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXComboBox<String> cmbPosition;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<UserDTO> tblUser;

    private static Alert alert;

    private static UserBO userBO=new UserBOImpl();

    @FXML
    void AddUser(ActionEvent event) {

        String uid = txtid.getText();
        String uname = txtname.getText();
        String position = cmbPosition.getSelectionModel().getSelectedItem();
        String uemail = txtemail.getText();
        String username = txtUsername.getText();
        String upassword = txtPassword.getText();



        UserDTO userDTO=new UserDTO(uid,uname,position,uemail,username,upassword);


        Boolean result=false;

        try {
            result=userBO.addUser(userDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       NotificationController.massege(result,"Added","Added Faild");
        getall();
    }

    @FXML
    void DeleteUser(ActionEvent event) {
        String uid = txtid.getText();

        UserDTO userDTO=new UserDTO(uid);

        boolean result = false;
        try {
            result = userBO.deleteUser(uid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        NotificationController.massege(result,"Delete","Delete Faild");
        getall();
    }

    @FXML
    void UpdateUser(ActionEvent event) {
        String uid = txtid.getText();
        String uname = txtname.getText();
        String position = cmbPosition.getSelectionModel().getSelectedItem();
        String uemail = txtemail.getText();
        String username = txtUsername.getText();
        String upassword = txtPassword.getText();

        UserDTO userDTO=new UserDTO(uid,uname,position,uemail,username,upassword);


        Boolean result=false;

        try {
            result=userBO.updateUser(userDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       NotificationController.massege(result,"Upadte","Update Faild");
        getall();
    }

    @FXML
    void select(MouseEvent event) {
 UserDTO selectuser=tblUser.getSelectionModel().getSelectedItem();
 txtid.setText(selectuser.getUserid());
 txtname.setText(selectuser.getUname());
 cmbPosition.setPromptText(selectuser.getPosition());
 txtemail.setText(selectuser.getEmail());
 txtUsername.setText(selectuser.getUsername());
 txtPassword.setText(selectuser.getUpassword());
    }


    private void UserID(){
        String userid;
        try {
            userid= IDGenerator.getNewID("User","Userid","U");
            txtid.setText(userid);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbPosition.getItems().addAll("Admin","User","Other");
        cmbPosition.setPromptText("Select User Position");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserID();
        getall();
    }

    private void getall(){
        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Userid"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Uname"));
        tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Position"));
        tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Email"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Username"));
        tblUser.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Upassword"));
        ArrayList<UserDTO> alluser=null;
        try {
            alluser=userBO.getAllUser();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblUser.setItems(FXCollections.observableArrayList(alluser));
    }
}
