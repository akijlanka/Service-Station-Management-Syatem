package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.bo.custom.EmployeeBO;
import lk.ijse.ssms.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.ssms.model.EmployeeDTO;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmpFormController implements Initializable {



    @FXML
    private JFXTextField txtempid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtAdd;

    @FXML
    private JFXTextField txttrakNo;

    @FXML
    private JFXButton btnadd;

    @FXML
    private TableView<EmployeeDTO> tblemp;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private JFXButton btndelete;

    @FXML
    private DatePicker txtJoindate;

    private static EmployeeBO employeeBO=new EmployeeBOImpl();

    @FXML
    void Add(MouseEvent event) throws SQLException, ClassNotFoundException {
        String empid = txtempid.getText();
        String ename = txtname.getText();
        String address = txtAdd.getText();
        String jdate = txtJoindate.getValue().toString();
        int trakno =Integer.parseInt(txttrakNo.getText());

        EmployeeDTO employeeDTO=new EmployeeDTO(empid,ename,address,jdate,trakno);
        boolean result=employeeBO.AddEmployee(employeeDTO);

        if (result){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK);
            alert.show();
            Getall();
            clear();
            Empid();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Fail", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    void Delete(MouseEvent event) {
        String empid = txtempid.getText();

        EmployeeDTO employeeDTO=new EmployeeDTO(empid);

        boolean result = false;
        try {
            result = employeeBO.DeleteEmployee(empid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK);
            alert.show();
            clear();
            Getall();
            Empid();

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Fail", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    void Update(MouseEvent event) throws SQLException, ClassNotFoundException {
        String empid = txtempid.getText();
        String ename = txtname.getText();
        String address = txtAdd.getText();
        String jdate = txtJoindate.getValue().toString();
        int trakno =Integer.parseInt(txttrakNo.getText());

        EmployeeDTO employeeDTO=new EmployeeDTO(empid,ename,address,jdate,trakno);
        boolean result=employeeBO.updateEmployee(employeeDTO);

        if (result){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update", ButtonType.OK);
            alert.show();
            clear();
            Getall();
            Empid();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update Fail", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void moveAdd(ActionEvent event) {
btnadd.requestFocus();
    }

    @FXML
    void moveAddress(ActionEvent event) {
txtAdd.requestFocus();
    }

    @FXML
    void movedate(ActionEvent event) {
txtJoindate.requestFocus();
    }

    @FXML
    void moveempname(ActionEvent event) {
txtname.requestFocus();
    }

    @FXML
    void movetrakno(ActionEvent event) {
txttrakNo.requestFocus();
    }

    public void Empid(){

        try {
            String EmpId;
            EmpId = IDGenerator.getNewID("Employee", "Empid", "E");
            txtempid.setText(EmpId);
        } catch (SQLException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Getall() {
        tblemp.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Empid"));
        tblemp.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblemp.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblemp.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Joindate"));
        tblemp.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("TrakeNo"));
        ArrayList<EmployeeDTO> allapp=null;
        try{
            allapp=employeeBO.getAllEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tblemp.setItems(FXCollections.observableArrayList(allapp));



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Getall();
        Empid();
    }

    public void selectOn(MouseEvent mouseEvent) {

        EmployeeDTO selectedItem=tblemp.getSelectionModel().getSelectedItem();
        txtempid.setText(selectedItem.getEmpid());
        txtname.setText(selectedItem.getName());
        txtAdd.setText(selectedItem.getAddress());
        String date = selectedItem.getJoindate();
        String[] split = date.split("-");
        LocalDate of = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        txtJoindate.setValue(of);
        txttrakNo.setText(selectedItem.getTrakeNo()+"");
    }


    public void clear(){


        txtempid.setText("");
        txtname.setText("");
        txtAdd.setText("");
        txttrakNo.setText("");
        txtJoindate.getEditor().clear();



    }


    public void movetrakNo(ActionEvent actionEvent) {
        txttrakNo.requestFocus();
    }
}
