package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.Common.NotificationController;
import lk.ijse.ssms.bo.custom.AppointmentBO;
import lk.ijse.ssms.bo.custom.EmployeeBO;
import lk.ijse.ssms.bo.custom.MakeServiceBO;
import lk.ijse.ssms.bo.custom.PlatformBO;
import lk.ijse.ssms.bo.custom.impl.AppointmentBOImpl;
import lk.ijse.ssms.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.ssms.bo.custom.impl.MakeServiceBOImpl;
import lk.ijse.ssms.bo.custom.impl.PlatformBOImpl;
import lk.ijse.ssms.dao.custom.QueryDAO;
import lk.ijse.ssms.dao.custom.impl.QueryDAOImpl;
import lk.ijse.ssms.entity.Appointment;
import lk.ijse.ssms.entity.Platfrom;
import lk.ijse.ssms.model.*;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class WaitAppointmentFormController implements Initializable {

    @FXML
    private TableView<AppointmentDTO> tblApp;

    @FXML
    private TableView<EmpDetailDTO> tblemp;

    @FXML
    private JFXTextField txtsid;

    @FXML
    private JFXTextField txtappid;

    @FXML
    private JFXTextField txtbikeNum;

    @FXML
    private JFXTextField txtIntime;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnMakeSer;

    @FXML
    private JFXComboBox<String> cmbname;

    @FXML
    private TableView<Platfrom> tblplatform;

    @FXML
    private JFXComboBox<String> cmbPlatfoem;


    private String date;
    private String empid;
    private String platformNo;


    private static AppointmentBO appointmentBO=new AppointmentBOImpl();
    private static EmployeeBO employeeBO=new EmployeeBOImpl();
    private static MakeServiceBO makeServiceBO=new MakeServiceBOImpl();
    private static QueryDAO queryDAO=new QueryDAOImpl();
    private static PlatformBO platformBO=new PlatformBOImpl();


    @FXML
    void AddEmp(ActionEvent event) {



            String ename = cmbname.getSelectionModel().getSelectedItem();

            EmpDetailDTO empDetailDTO = new EmpDetailDTO(empid, ename);

            tblemp.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Empid"));
            tblemp.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Ename"));
            tblemp.getItems().add(empDetailDTO);
            btnMakeSer.setDisable(false);


    }

    @FXML
    void MakeService(ActionEvent event) throws SQLException, ClassNotFoundException {



        UpdateAppStatus();
        getPlatform();
        SetTabledate();
        UpdatePlatform();
        setTime();
        ServiceID();
        getPlatform();
        getworkingPlatform();
        GetAll();
        getEmp();
        Clear();


        btnAdd.setDisable(true);
        btnRemove.setDisable(true);
        btnMakeSer.setDisable(true);




    }

    @FXML
    void Remove(ActionEvent event) {

    }

    @FXML
    void selectApp(MouseEvent event) {
       AppointmentDTO selectitem=tblApp.getSelectionModel().getSelectedItem();
       txtappid.setText(selectitem.getAid());
       txtbikeNum.setText(selectitem.getBNum());

       btnAdd.setDisable(false);
       btnRemove.setDisable(false);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            GetAll();
            setTime();
            ServiceID();
            getEmp();
            getPlatform();
            getworkingPlatform();

            btnAdd.setDisable(true);
            btnRemove.setDisable(true);
            btnMakeSer.setDisable(true);

            cmbPlatfoem.setStyle("-fx-background-color: white");
            cmbname.setStyle("-fx-background-color: white");



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void GetAll() throws SQLException, ClassNotFoundException {
        tblApp.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Aid"));
        tblApp.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("CusName"));
        tblApp.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Date"));
        tblApp.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("TpNum"));
        tblApp.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("BNum"));
        ArrayList<AppointmentDTO> allapp=null;
        allapp=appointmentBO.getAllAppointment();
        tblApp.setItems(FXCollections.observableArrayList(allapp));

    }

    private void setTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtIntime.setText(new SimpleDateFormat("hh:mm a").format(new Date()));
                date=new SimpleDateFormat("YYYY-MM-dd").format(new Date());
            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void ServiceID(){
        try {
            String ServiceId;
            ServiceId = IDGenerator.getNewID("Service", "Sid", "S");
            txtsid.setText(ServiceId);
        } catch (SQLException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    private void UpdateAppStatus(){
        int status=1;
        Appointment appointment=new Appointment(txtappid.getText(),status);

       boolean result=false;

        try {
            result=queryDAO.UpSatatus(appointment);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void UpdatePlatform(){
        String status="1";
        Platfrom platfrom=new Platfrom(platformNo,status);
        boolean result=false;
        try {
            result=queryDAO.UpPlatformSatatus(platfrom);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getEmp() throws SQLException, ClassNotFoundException {

        ArrayList<EmployeeDTO> allemp=employeeBO.getAllEmployee();
        ArrayList<String> allempM=new ArrayList<>();

        for (EmployeeDTO e: allemp){
            allempM.add(e.getName());
        }
        cmbname.getItems().addAll(allempM);
    }


    @FXML
    private void setEmp(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String ename = cmbname.getSelectionModel().getSelectedItem();
        ArrayList<EmployeeDTO> allemp=employeeBO.getAllEmployee();
        for (EmployeeDTO employeeDTO: allemp){
            if (ename.equals(employeeDTO.getName())){
                empid=employeeDTO.getEmpid();
            }
        }
    }

    private void getPlatform() throws SQLException, ClassNotFoundException {
        ArrayList<PlatformDTO> allplat=platformBO.getAllplatform();
        ArrayList<String> allplatm=new ArrayList<>();
        final String a="A";

        for (PlatformDTO p:allplat){
            if (a.equals(p.getStatus())) {
                allplatm.add(p.getPlatformNo());
            }
        }
        cmbPlatfoem.getItems().addAll(allplatm);
    }

    private void getworkingPlatform() throws SQLException, ClassNotFoundException {
        tblplatform.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("PlatformNo"));
        ArrayList<Platfrom> allplat=queryDAO.getworkingplatform();
        tblplatform.setItems(FXCollections.observableArrayList(allplat));

    }


    private void SetTabledate(){

        String sid = txtsid.getText();
        String aid = txtappid.getText();
        String bikenum = txtbikeNum.getText();
        String intime = txtIntime.getText();
        String outtime="no";
        int st=0;
        String platfoem = cmbPlatfoem.getSelectionModel().getSelectedItem();

        ArrayList<EmpDetailDTO> all=new ArrayList<>();


        boolean result=false;

        for (int i=0; i<tblemp.getItems().size(); i++){
            String empidt = (String) tblemp.getColumns().get(0).getCellObservableValue(i).getValue();
            String empnamet = (String) tblemp.getColumns().get(1).getCellObservableValue(i).getValue();

           EmpDetailDTO empDetailDTO=new EmpDetailDTO(empidt,sid,date,empnamet);
           all.add(empDetailDTO);

        }


        ServiceDTO serviceDTO=new ServiceDTO(sid,aid,bikenum,intime,outtime,st,platfoem,all);

        try {
            result=makeServiceBO.makeService(serviceDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        NotificationController.massege(result,"Make Service", "Make Service Faild");


    }


    public void setPtatform(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String pno = cmbPlatfoem.getSelectionModel().getSelectedItem();
        ArrayList<PlatformDTO> allplat=platformBO.getAllplatform();
        for (PlatformDTO platformDTO: allplat){
            if (pno.equals(platformDTO.getPlatformNo())){
                platformNo=platformDTO.getPid();
            }
        }

    }

    private void Clear(){
        txtappid.clear();
        txtbikeNum.clear();
    }
}
