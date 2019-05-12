package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.bo.custom.AppointmentBO;
import lk.ijse.ssms.bo.custom.impl.AppointmentBOImpl;
import lk.ijse.ssms.model.AppointmentDTO;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AppointmentFormController implements Initializable {

    public void initialize(URL url, ResourceBundle rb){
        Getall();
        AppointmentID();
        setdateTime();
        Clear();
    }

    @FXML
    private JFXTextField txtCusName;

    @FXML
    private JFXDatePicker txtDate;

    @FXML
    private JFXTextField txtTPN;

    @FXML
    private JFXTextField txtBikeNumber;

    @FXML
    private JFXButton btnadd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnChange;

    @FXML
    private TableView<AppointmentDTO> tblAppointment;

    @FXML
    private TableColumn<AppointmentDTO, String> columnAid;

    @FXML
    private TableColumn<AppointmentDTO, String> coloumnCusname;

    @FXML
    private TableColumn<AppointmentDTO, String> columnDate;

    @FXML
    private TableColumn<AppointmentDTO, Integer> columnTPnum;

    @FXML
    private TableColumn<AppointmentDTO, String> columnBikenum;

    @FXML
    private JFXTextField txtappid;


    @FXML
    private ImageView btnrefresh;

    @FXML
    private Label labCusname;

    @FXML
    private Label labCustp;

    private String time;

    private static AppointmentBO appointmentBO=new AppointmentBOImpl();
    private static Alert alert;

    private void setdateTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                time=new SimpleDateFormat("hh:mm a").format(new Date());
            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }




    public void MakeApp(ActionEvent actionEvent) {


        if(txtCusName.getText().isEmpty()) {

            txtCusName.requestFocus();

            return;
        }
        if(txtDate.getValue().toString().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Select Date", ButtonType.OK);
            alert.show();
            return;
        }
        if(txtTPN.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Mobile Number", ButtonType.OK);
            alert.show();
            txtTPN.requestFocus();
            return;
        }
        if(txtBikeNumber.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Bike Number", ButtonType.OK);
            alert.show();
            txtBikeNumber.requestFocus();
            return;
        }

        String aid =txtappid.getText();
        String cusname = txtCusName.getText();
        String date = txtDate.getValue().toString();
        int tpnum = Integer.parseInt(txtTPN.getText());
        int status = 0;
        String bnum = txtBikeNumber.getText();

        AppointmentDTO appointmentDTO=new AppointmentDTO(aid, cusname, date, tpnum, bnum, status,time);

        boolean result = false;
        try {
            result = appointmentBO.makeappintment(appointmentDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
             alert = new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK);
            alert.show();
            Getall();
            Clear();
            AppointmentID();



        } else {
             alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Fail", ButtonType.OK);
            alert.show();

        }
    }





    public void Update(ActionEvent actionEvent) {

        if(txtCusName.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Customer Name", ButtonType.OK);
            alert.show();
            txtCusName.requestFocus();

            return;
        }
        if(txtDate.getValue().toString().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Select Date", ButtonType.OK);
            alert.show();
            return;
        }
        if(txtTPN.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Mobile Number", ButtonType.OK);
            alert.show();
            txtTPN.requestFocus();
            return;
        }
        if(txtBikeNumber.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Bike Number", ButtonType.OK);
            alert.show();
            txtBikeNumber.requestFocus();
            return;
        }

        String aid = txtappid.getText();
        String cusname = txtCusName.getText();
        String date = txtDate.getValue().toString();
        int tpnum = Integer.parseInt(txtTPN.getText());
        String bnum = txtBikeNumber.getText();

        AppointmentDTO appointmentDTO=new AppointmentDTO(aid, cusname, date, tpnum, bnum);

        boolean result = false;
        try {
            result = appointmentBO.updateappintment(appointmentDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update", ButtonType.OK);
            alert.show();
            Getall();
            Clear();
            AppointmentID();

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update Fail", ButtonType.OK);
            alert.show();
        }
    }

    public void Delete(ActionEvent actionEvent) {
        String aid = txtappid.getText();
        boolean result = false;
        try {
            result = appointmentBO.cancelappointment(aid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK);
            alert.show();
            Getall();
            Clear();
            AppointmentID();

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Fail", ButtonType.OK);
            alert.show();
        }
    }

    private void Getall() {
        tblAppointment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Aid"));
        tblAppointment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("CusName"));
        tblAppointment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Date"));
        tblAppointment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("TpNum"));
        tblAppointment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("BNum"));
        ArrayList<AppointmentDTO> allapp=null;
        try{
            allapp=appointmentBO.getAllAppointment();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tblAppointment.setItems(FXCollections.observableArrayList(allapp));



    }

    public void moveDate(ActionEvent actionEvent) {
        String cusname = txtCusName.getText();
        if(Pattern.compile("^[a-z]{4,}$").matcher(cusname).matches()){
            txtDate.requestFocus();
            labCusname.setText("");
        }else{
            labCusname.setText("Invalide Customer Name Type");
        }


    }

    public void moveTpn(ActionEvent actionEvent) {
        txtTPN.requestFocus();



    }

    public void moveBikeNum(ActionEvent actionEvent) {

        String custp = txtTPN.getText();
        if(Pattern.compile("^[0-9]{10,}$").matcher(custp).matches()){
            txtTPN.requestFocus();
            labCustp.setText("");
        }else{
            labCustp.setText("Invalide Telephone Number Type");
        }

        txtBikeNumber.requestFocus();
    }

    public void moveAdd(ActionEvent actionEvent) {
        btnadd.requestFocus();
    }

    public void moveCusname(ActionEvent actionEvent) {
        txtCusName.requestFocus();



    }


    public void selectOn(MouseEvent mouseEvent) {
        AppointmentDTO selectedItem = tblAppointment.getSelectionModel().getSelectedItem();
        txtappid.setText(selectedItem.getAid());
        txtCusName.setText(selectedItem.getCusName());
        String date = selectedItem.getDate();
        String[] split = date.split("-");
        LocalDate of = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        txtDate.setValue(of);
        txtTPN.setText(selectedItem.getTpNum()+"");
        txtBikeNumber.setText(selectedItem.getBNum());

        btnadd.setDisable(true);
        txtCusName.requestFocus();


    }

    private void AppointmentID() {
        try {
            String AppintmentId;
            AppintmentId = IDGenerator.getNewID("Appointment", "Aid", "A");
            txtappid.setText(AppintmentId);
        } catch (SQLException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Clear(){

        txtCusName.clear();
        txtTPN.clear();
        txtBikeNumber.clear();
        txtCusName.requestFocus();
        txtDate.getEditor().clear();


    }

    public void Refresh(MouseEvent mouseEvent) {
        AppointmentID();
        Getall();
        Clear();
        btnadd.setDisable(false);

    }




}
