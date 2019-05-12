package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.bo.custom.AppointmentBO;
import lk.ijse.ssms.bo.custom.BikeBO;
import lk.ijse.ssms.bo.custom.ModelBO;
import lk.ijse.ssms.bo.custom.impl.AppointmentBOImpl;
import lk.ijse.ssms.bo.custom.impl.BikeBOImpl;
import lk.ijse.ssms.bo.custom.impl.ModelBOImpl;
import lk.ijse.ssms.model.AppointmentDTO;
import lk.ijse.ssms.model.BikeDTO;
import lk.ijse.ssms.model.ModelDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BikeRegistationFormController implements Initializable {

    @FXML
    private JFXButton btnclose;

    @FXML
    private TableView<?> tblBike;

    @FXML
    private JFXButton btnadd;

    @FXML
    private JFXButton btnupdate;

    @FXML
    private JFXTextField txtbid;

    @FXML
    private JFXTextField txtbikeNum;

    @FXML
    private JFXTextField txtCusname;

    @FXML
    private JFXTextField txtTp;

    @FXML
    private JFXTextField txtModel;

    @FXML
    private JFXComboBox<String> comBikeModel;


    private static Alert alert;
    private static BikeBO bikeBO=new BikeBOImpl();
    private static AppointmentBO appointmentBO=new AppointmentBOImpl();
    private static ModelBO modelBO=new ModelBOImpl();

    @FXML
    void Add(ActionEvent event) {
        if(txtbikeNum.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Bike Number", ButtonType.OK);
            alert.show();
            txtbikeNum.requestFocus();

            return;
        }
        if(txtCusname.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Customer Name", ButtonType.OK);
            alert.show();
            txtCusname.requestFocus();
            return;
        }
        if(txtTp.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Mobile Number", ButtonType.OK);
            alert.show();
            txtTp.requestFocus();
            return;
        }else {
//        if(txtModel.getText().isEmpty()) {
//            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Bike Model", ButtonType.OK);
//            alert.show();
//            txtModel.requestFocus();
//            return;
//        }
            String bid = txtbid.getText();
            String bikenum = txtbikeNum.getText();
            String cusname = txtCusname.getText();
            int tp = Integer.parseInt(txtTp.getText());
            String model = comBikeModel.getSelectionModel().getSelectedItem();

            BikeDTO bikeDTO = new BikeDTO(bid, bikenum, cusname, tp, model);

            boolean result = false;
            try {
                result = bikeBO.AddBike(bikeDTO);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (result) {
                alert = new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK);
                alert.show();


            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Fail", ButtonType.OK);
                alert.show();

            }
        }

    }

    @FXML
    void Update(ActionEvent event) {
        if(txtbikeNum.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Bike Number", ButtonType.OK);
            alert.show();
            txtbikeNum.requestFocus();

            return;
        }
        if(txtCusname.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Customer Name", ButtonType.OK);
            alert.show();
            txtCusname.requestFocus();
            return;
        }
        if(txtTp.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Mobile Number", ButtonType.OK);
            alert.show();
            txtTp.requestFocus();
            return;
        }
        if(txtModel.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.WARNING, "Please Enter Bike Model", ButtonType.OK);
            alert.show();
            txtModel.requestFocus();
            return;
        }
        String bid = txtbid.getText();
        String bikenum = txtbikeNum.getText();
        String cusname = txtCusname.getText();
        int tp = Integer.parseInt(txtTp.getText());
        String model =comBikeModel.getSelectionModel().getSelectedItem();

        BikeDTO bikeDTO=new BikeDTO(bid,bikenum,cusname,tp,model);

        boolean result=false;
        try {
            result=bikeBO.updatebike(bikeDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result) {
            alert = new Alert(Alert.AlertType.CONFIRMATION, "Update", ButtonType.OK);
            alert.show();



        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION, "Update Fail", ButtonType.OK);
            alert.show();

        }
    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) btnclose.getScene().getWindow();
        stage.close();
    }

    public void search(ActionEvent actionEvent) {
        String bikenum = txtbikeNum.getText();

        try {
            AppointmentDTO appointmentDTO = null;
            appointmentDTO = appointmentBO.searchappointment(bikenum);

            if (appointmentDTO != null) {

                txtCusname.setText(appointmentDTO.getCusName());
                txtTp.setText(appointmentDTO.getTpNum()+"");
            } else {
                txtbikeNum.clear();


            }
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "No Details", ButtonType.OK);
            alert.show();
        }
    }

    private void BikeID(){
        try {
            String BikeId;
            BikeId = IDGenerator.getNewID("Bike", "Bid", "B");
            txtbid.setText(BikeId);
        } catch (SQLException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BikeID();
        try {
            getModel();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void select(MouseEvent mouseEvent) {
    }

    private void getModel() throws SQLException, ClassNotFoundException {
        ArrayList<ModelDTO> allmodel=modelBO.getAllmodel();
        ArrayList<String> allm=new ArrayList<>();

        for (ModelDTO m:allmodel) {
            allm.add(m.getMname());
        }
        comBikeModel.getItems().addAll(allm);
    }
}
