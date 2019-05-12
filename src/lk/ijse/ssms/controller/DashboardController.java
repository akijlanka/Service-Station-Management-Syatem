package lk.ijse.ssms.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.ssms.dao.custom.QueryDAO;
import lk.ijse.ssms.dao.custom.impl.QueryDAOImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private JFXButton btnclose;

    @FXML
    private JFXButton btnminimize;

    @FXML
    private Label txtdate;

    @FXML
    private Label txttime;

    @FXML
    private FontAwesomeIconView btndash;

    @FXML
    private Pane btnapp;

    @FXML
    private Pane btnbike;

    @FXML
    private Pane btnemp;

    @FXML
    private Pane btnBikemodel;

    @FXML
    private Pane btnitem;

    @FXML
    private Pane btnreport;

    @FXML
    private Pane btnnote;

    @FXML
    private AnchorPane lodepane;

    @FXML
    private Label txtAppcount;

    @FXML
    private Label txtEmpcount;

    @FXML
    private Label txtBikemcount;

    @FXML
    private Label txtitemCount;

    @FXML
    private Label txtlastDate;

    @FXML
    private Label txtLastTime;

    @FXML
    private Circle btnshape;

    @FXML
    private ImageView btnsetting;




    private static QueryDAO queryDAO=new QueryDAOImpl();
    private static AnchorPane pane;


    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) btnclose.getScene().getWindow();
        stage.close();
    }

    public void minimize(ActionEvent actionEvent) {
    }

    public void appointment(MouseEvent mouseEvent) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/appointmentForm.fxml"));
        lodepane.getChildren().setAll(pane);
        getAppRowCount();
    }

    public void empAdd(MouseEvent mouseEvent) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/employeeForm.fxml"));
        lodepane.getChildren().setAll(pane);
        getEmpcount();
    }

    public void itemAdd(MouseEvent mouseEvent) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/itemForm.fxml"));
        lodepane.getChildren().setAll(pane);
        getItemcount();
    }

    public void viewreport(MouseEvent mouseEvent) {
    }

    public void addnote(MouseEvent mouseEvent) {
    }

    public void addbikemodel(MouseEvent mouseEvent) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/modelForm.fxml"));
        lodepane.getChildren().setAll(pane);
        getBikeModelcount();
    }

    public void viewservice(MouseEvent mouseEvent) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/servicebikedetails.fxml"));
        lodepane.getChildren().setAll(pane);
    }

    private void setdateTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtdate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                txttime.setText(new SimpleDateFormat("hh:mm a").format(new Date()));
            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setdateTime();
        try {
            LodeApp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getAppRowCount();
        getEmpcount();
        getItemcount();
        getBikeModelcount();

    }

    private void LodeApp() throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/servicesDash.fxml"));
        lodepane.getChildren().setAll(pane);
        getAppRowCount();
        getEmpcount();
        getItemcount();
        getBikeModelcount();

    }

    public void lodeSevice(MouseEvent mouseEvent) throws IOException {
       LodeApp();



    }

    private void getAppRowCount() {
        try {
           int rowcount = queryDAO.getRowcount();
            txtAppcount.setText(rowcount+"");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getEmpcount(){
        try {
            int rowcount=queryDAO.getEmpRowcount();
            txtEmpcount.setText(rowcount+"");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String lastdate= null;
        try {
            lastdate = queryDAO.getlastDate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        txtlastDate.setText(lastdate);

        GetLastTime();
    }

    private void getItemcount(){
        try {
            int rowcount=queryDAO.getItemRowcount();
            txtitemCount.setText(rowcount+"");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getBikeModelcount(){
        try {
            int rowcount=queryDAO.getBikemodelRowcount();
            txtBikemcount.setText(rowcount+"");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void GetLastTime(){
        String lastTime= null;
        try {
            lastTime = queryDAO.getlastTime();
            txtLastTime.setText(lastTime);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getServise(MouseEvent mouseEvent) throws IOException {
        LodeApp();
    }

    public void lodepane(MouseEvent mouseEvent) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/lk/ijse/ssms/view/settingDash.fxml"));
        lodepane.getChildren().setAll(pane);
    }
}
