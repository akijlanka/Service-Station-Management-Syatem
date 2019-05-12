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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.ssms.Common.NotificationController;
import lk.ijse.ssms.bo.custom.ItemBO;
import lk.ijse.ssms.bo.custom.ItemDetailBO;
import lk.ijse.ssms.bo.custom.MakeServiceBO;
import lk.ijse.ssms.bo.custom.PlatformBO;
import lk.ijse.ssms.bo.custom.impl.ItemBOImpl;
import lk.ijse.ssms.bo.custom.impl.ItemDetailBOImpl;
import lk.ijse.ssms.bo.custom.impl.MakeServiceBOImpl;
import lk.ijse.ssms.bo.custom.impl.PlatformBOImpl;
import lk.ijse.ssms.dao.custom.QueryDAO;
import lk.ijse.ssms.dao.custom.impl.QueryDAOImpl;
import lk.ijse.ssms.entity.Platfrom;
import lk.ijse.ssms.entity.Service;
import lk.ijse.ssms.model.*;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class OnGoingFormController implements Initializable {

    @FXML
    private TableView<ServiceDTO> tblService;

    @FXML
    private TableView<EmpDetailDTO> tblemp;

    @FXML
    private TableView<ItemDetailDTO> tblItem;

    @FXML
    private JFXTextField txtsid;

    @FXML
    private JFXTextField txtbikenum;

    @FXML
    private JFXTextField txtintime;

    @FXML
    private JFXTextField txtouttime;

    @FXML
    private JFXComboBox<String> cmbItemname;

    @FXML
    private JFXTextField txtItemid;

    @FXML
    private JFXButton btnadd;

    @FXML
    private JFXButton btnremove;

    @FXML
    private JFXTextField txtqty;

    @FXML
    private JFXTextField txtprice;

    @FXML
    private JFXButton btnFinesh;

    String platformNo;
    String platformID;

    private static ItemBO itemBO=new ItemBOImpl();
    private static MakeServiceBO makeServiceBO=new MakeServiceBOImpl();
    private  static ItemDetailBO itemDetailBO=new ItemDetailBOImpl();
    private static QueryDAO queryDAO=new QueryDAOImpl();
    private static PlatformBO platformBO=new PlatformBOImpl();



    private void setTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtouttime.setText(new SimpleDateFormat("hh:mm a").format(new Date()));

            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

 

    @FXML
    void Finesih(ActionEvent event) {
      updateservice();
      UpdatePlatform();
        getAll();
        clear();
        btnadd.setDisable(true);
        btnFinesh.setDisable(true);


    }



    @FXML
    void selectService(MouseEvent event) throws SQLException, ClassNotFoundException {
        ServiceDTO selectservice=tblService.getSelectionModel().getSelectedItem();
        txtsid.setText(selectservice.getSid());
        txtbikenum.setText(selectservice.getBikeNum());
        txtintime.setText(selectservice.getIntime());
        platformNo=selectservice.getPlatform();

        selectPlatformID();
        getAddEmp();
        getAddItem();
        getAll();
        btnadd.setDisable(false);
        btnFinesh.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getItem();
            getAll();
            setTime();
            btnadd.setDisable(true);
            btnFinesh.setDisable(true);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getItem() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allitem=itemBO.getAllItem();
        ArrayList<String> itemModel=new ArrayList<>();

        for (ItemDTO i:allitem){
            itemModel.add(i.getName());
        }
        cmbItemname.getItems().addAll(itemModel);
    }

    public void AddItem(ActionEvent actionEvent) {

                  addItemd();
                  getAddItem();

    }

    public void selectItem(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String selectedItem = cmbItemname.getSelectionModel().getSelectedItem();
        ArrayList<ItemDTO> allitem=itemBO.getAllItem();
        for (ItemDTO itemDTO: allitem){
            if (selectedItem.equals(itemDTO.getName())){
                txtItemid.setText(itemDTO.getItemid());
                txtprice.setText(itemDTO.getPrice()+"");
            }
        }

        cmbItemname.setStyle("-fx-background-color: white");



    }

    private void getAddItem(){
        String sid = txtsid.getText();

        try {
            ArrayList<ItemDetailDTO> allAddItem=itemDetailBO.getAllItemd();

            ArrayList<ItemDetailDTO> emp=new ArrayList<>();

            for (ItemDetailDTO e: allAddItem){
                if (sid.equals(e.getSid())){
                    ItemDetailDTO itemDetailDTO=new ItemDetailDTO(e.getItemid(),e.getQty(),e.getTotal(),e.getItemname());
                    emp.add(itemDetailDTO);
                }
            }
            tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Itemname"));
            tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Itemid"));
            tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Qty"));
            tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Total"));
            tblItem.setItems(FXCollections.observableArrayList(emp));



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    private void getAddEmp(){
        String sid = txtsid.getText();

        try {
            ArrayList<EmpDetailDTO> empDetailDTO=makeServiceBO.getAllempd();

            ArrayList<EmpDetailDTO> emp=new ArrayList<>();

            for (EmpDetailDTO e: empDetailDTO){
                if (sid.equals(e.getSid())){
                    EmpDetailDTO empDetailDTO1=new EmpDetailDTO(e.getEmpid(),e.getEname());
                    emp.add(empDetailDTO1);
                }
            }
            tblemp.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Empid"));
            tblemp.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Ename"));
            tblemp.setItems(FXCollections.observableArrayList(emp));



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getAll(){
        tblService.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Sid"));
        tblService.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Aid"));
        tblService.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("BikeNum"));
        tblService.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Intime"));
        tblService.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Platform"));
        ArrayList<ServiceDTO> allService=null;
        try {
            allService=makeServiceBO.getAllService();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblService.setItems(FXCollections.observableArrayList(allService));
    }

    private void addItemd(){

        String sid = txtsid.getText();
        String itemname = cmbItemname.getSelectionModel().getSelectedItem();
        String itemid = txtItemid.getText();
        int qty = Integer.parseInt(txtqty.getText());
        double price = Double.parseDouble(txtprice.getText());
        double total;
        total=qty*price;

        boolean result=false;

        ItemDetailDTO itemDetailDTO=new ItemDetailDTO(sid,itemid,qty,total,itemname);
        try {
            result=itemDetailBO.additemd(itemDetailDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        NotificationController.massege(result,"Add","Not add");


    }

    private void getAllitemd(){

    }

    private void updateservice(){
        int status=1;
        String sid = txtsid.getText();
        String outtime = txtouttime.getText();

        Service service=new Service(sid,outtime,status);

        boolean result=false;
        try {
            result=queryDAO.UpServiceSatatus(service);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void UpdatePlatform(){
        String status="A";
        Platfrom platfrom=new Platfrom(platformID,status);
        boolean result=false;
        try {
            result=queryDAO.UpPlatformSatatus(platfrom);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void selectPlatformID() throws SQLException, ClassNotFoundException {

        ArrayList<PlatformDTO> allplat=platformBO.getAllplatform();
        for (PlatformDTO platformDTO: allplat){
            if (platformNo.equals(platformDTO.getPlatformNo())){
                platformID=platformDTO.getPid();
            }
        }
    }
    private void clear(){
        txtsid.clear();
        txtprice.clear();
        txtqty.clear();
        txtintime.clear();
        txtbikenum.clear();
        getAddEmp();
        getAddItem();
    }


}
