package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.Common.NotificationController;
import lk.ijse.ssms.bo.custom.*;
import lk.ijse.ssms.bo.custom.impl.*;
import lk.ijse.ssms.dao.custom.QueryDAO;
import lk.ijse.ssms.dao.custom.impl.QueryDAOImpl;
import lk.ijse.ssms.entity.Appointment;
import lk.ijse.ssms.entity.Service;
import lk.ijse.ssms.model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class InvoiceFormController implements Initializable {

    @FXML
    private TableView<Service> tblSevise;

    @FXML
    private TableView<ItemDetailDTO> tblIteminformation;

    @FXML
    private TableView<EmpDetailDTO> tblEmpinformation;

    @FXML
    private JFXTextField txtbid;
    @FXML
    private JFXTextField txtBikeName;

    @FXML
    private JFXTextField txtBikeModel;

    @FXML
    private JFXTextField txtmile;

    @FXML
    private JFXTextField txtempchage;

    @FXML
    private Label txtdis;

    @FXML
    private JFXButton btnAddBike;

    @FXML
    private JFXButton btnInvoice;

    @FXML
    private JFXTextField txtbalance;

    @FXML
    private Label txtAid;

    @FXML
    private Label txtSid;

    @FXML
    private Label txtDate;

    @FXML
    private Label txtInvNo;

    @FXML
    private Label txtSubtot;

    @FXML
    private Label txtNettot;


    @FXML
    private Label txtgetbalnce;

    private static QueryDAO queryDAO = new QueryDAOImpl();
    private static MakeServiceBO makeServiceBO = new MakeServiceBOImpl();
    private static BikeBO bikeBO=new BikeBOImpl();
    private  static ItemDetailBO itemDetailBO=new ItemDetailBOImpl();
    private static AppDestilBO appDestilBO=new AppDetailBOImpl();
    private static InvoiceBO invoiceBO=new InvoiceBOImpl();

    double subtotal=0;


    @FXML
    void Addbike(ActionEvent event) throws IOException {
       lodebikeform();
    }


    private void getall() {
        tblSevise.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Sid"));
        tblSevise.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Aid"));
        tblSevise.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("BikeNum"));

        try {
            ArrayList<Service> all = null;
            all = queryDAO.endworkservice();
            tblSevise.setItems(FXCollections.observableArrayList(all));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Payment(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (txtmile.getText().isEmpty()) {
            NotificationController.massege(true, "Plz Add Mils", "Add");
        }else if (txtempchage.getText().isEmpty()){
            NotificationController.massege(true, "Plz Add Employee Charge", "Add");

        }else if (txtbalance.getText().isEmpty()){
            NotificationController.massege(true, "Plz Get Balance", "Add");

        }else {
            AddInvoice();
            addAppDetail();
            updateAppstatus();
            updateservicestatus();
            Clear();
            InvoiceNo();
            getall();

            btnAddBike.setDisable(true);
            btnInvoice.setDisable(true);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getall();
        setTime();
        InvoiceNo();
        btnAddBike.setDisable(true);
        btnInvoice.setDisable(true);

    }

    public void select(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException, IOException {
        Service selectservice=tblSevise.getSelectionModel().getSelectedItem();

        txtSid.setText(selectservice.getSid());
        txtAid.setText(selectservice.getAid());
        txtBikeName.setText(selectservice.getBikeNum());

        getemp();
        getAddItem();
        searchbike();
        Cal1();
        btnAddBike.setDisable(false);
        btnInvoice.setDisable(false);

    }

    private void getAddItem(){
        String sid = txtSid.getText();

        try {
            ArrayList<ItemDetailDTO> allAddItem=itemDetailBO.getAllItemd();

            ArrayList<ItemDetailDTO> emp=new ArrayList<>();

            for (ItemDetailDTO e: allAddItem){
                if (sid.equals(e.getSid())){
                    ItemDetailDTO itemDetailDTO=new ItemDetailDTO(e.getItemid(),e.getQty(),e.getTotal(),e.getItemname());
                    emp.add(itemDetailDTO);
                }
            }
            tblIteminformation.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Itemname"));
            tblIteminformation.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Itemid"));
            tblIteminformation.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Qty"));
            tblIteminformation.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Total"));
            tblIteminformation.setItems(FXCollections.observableArrayList(emp));



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void getemp() {
        String sid = txtSid.getText();

        try {
            ArrayList<EmpDetailDTO> empDetailDTO = makeServiceBO.getAllempd();

            ArrayList<EmpDetailDTO> emp = new ArrayList<>();

            for (EmpDetailDTO e : empDetailDTO) {
                if (sid.equals(e.getSid())) {
                    EmpDetailDTO empDetailDTO1 = new EmpDetailDTO(e.getEmpid(), e.getEname());
                    emp.add(empDetailDTO1);
                }
            }
            tblEmpinformation.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Empid"));
            tblEmpinformation.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Ename"));
            tblEmpinformation.setItems(FXCollections.observableArrayList(emp));


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));

            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void InvoiceNo(){
        try {
            String invoice;
            invoice = IDGenerator.getNewID("Invoise", "Ino", "IN");
            txtInvNo.setText(invoice);
        } catch (SQLException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchbike() throws SQLException, ClassNotFoundException, IOException {
      String bikenum = txtBikeName.getText();

      try {
          BikeDTO bikeDTO = null;
          bikeDTO = bikeBO.searchbike(bikenum);

          if (bikeDTO != null) {
              txtbid.setText(bikeDTO.getBid());
              txtBikeModel.setText(bikeDTO.getModel());
          } else {


          }
      }catch (Exception ex){
          NotificationController.createError("Inform", "Plz Add Bike Detail");
          txtbid.clear();
          txtBikeModel.clear();
          lodebikeform();
      }
//
//        ArrayList<BikeDTO> allbike=bikeBO.getAllbike();
//        for (BikeDTO b:allbike){
//            if (bikenum.equals(b.getBikeNum())){
//                txtbid.setText(b.getBid());
//                txtBikeModel.setText(b.getModel());
//            }
//            else {
//                txtbid.clear();
//                txtBikeModel.clear();
////               lodebikeform();
//                NotificationController.createError("Inform","Plz Add Bike Detail");
//
//            }
//        }

    }

    private void lodebikeform() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/ijse/ssms/view/bikeRegistationForm.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void Cal1() throws SQLException, ClassNotFoundException {
        String sid = txtSid.getText();
        ArrayList<ItemDetailDTO> allItemd=itemDetailBO.getAllItemd();
        for (ItemDetailDTO itemDetailDTO: allItemd){
            if (sid.equals(itemDetailDTO.getSid())){
                subtotal+=itemDetailDTO.getTotal();
            }
        }
        txtSubtot.setText(subtotal+"");



    }

    private void addAppDetail(){
        String bid = txtbid.getText();
        String aid = txtAid.getText();
        String date = txtDate.getText();
        String mils = txtmile.getText();

        AppDetailDTO appDetailDTO=new AppDetailDTO(bid,aid,date,mils);

        boolean result=false;

        try {
            result=appDestilBO.makeappDetail(appDetailDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        NotificationController.massege(result,"add","add");


    }

    public void AddEmpcharge(ActionEvent actionEvent) {
        double empch = Double.parseDouble(txtempchage.getText());
        txtNettot.setText(subtotal+empch+"");


    }

//    public void Adddiscount(ActionEvent actionEvent) {
//        double dis =Double.parseDouble(txtdiscount.getText());
//         txtdis.setText(dis+"%");
//        double subTotal = (100 - dis) * subtotal / 100;
//        txtNettot.setText(subTotal + "");
//
//    }

    public void AddBalance(ActionEvent actionEvent) {
        double bal =Double.parseDouble(txtbalance.getText());
        double sub =Double.parseDouble(txtNettot.getText());

        if (sub<bal) {
            double balance = bal-sub;
            txtgetbalnce.setText(balance+"");
        }else{
            NotificationController.massege(true,"Cash is run Short","Inform");
        }
    }

    private void AddInvoice(){

        String invno = txtInvNo.getText();
        String aid = txtAid.getText();
        String bid = txtbid.getText();
        String date = txtDate.getText();
        String nettotal = txtNettot.getText();

        InvoiseDTO invoiseDTO=new InvoiseDTO(invno,aid,bid,date,nettotal);

        boolean result=false;

        try {
            result=invoiceBO.makeInvoice(invoiseDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        NotificationController.createSuccesful("Payment Done","Successful");

    }

    private void updateAppstatus(){
        int status=2;
        Appointment appointment=new Appointment(txtAid.getText(),status);

        boolean result=false;

        try {
            result=queryDAO.UpSatatus(appointment);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void updateservicestatus(){
        int status=2;
        Service service=new Service(txtSid.getText(),status);

        boolean result=false;
        try {
            result=queryDAO.UpServiceSatatus(service);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void Clear(){
        txtbid.clear();
        txtAid.setText("");
        txtBikeModel.clear();
        txtempchage.clear();
        txtSubtot.setText("");
        txtbalance.clear();
        txtNettot.setText("");
        txtmile.clear();
        txtSid.setText("");
        txtBikeName.clear();
        getemp();
        getAddItem();
    }
}
