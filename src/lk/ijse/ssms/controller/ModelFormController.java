package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.bo.custom.ModelBO;
import lk.ijse.ssms.bo.custom.impl.ModelBOImpl;
import lk.ijse.ssms.model.ModelDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ModelFormController implements Initializable {

    @FXML
    private JFXTextField txtMName;

    @FXML
    private JFXTextField txtManuf;

    @FXML
    private JFXTextField txtcapacity;

    @FXML
    private JFXTextField txtMid;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<ModelDTO> tblModel;

  private static ModelBO modelBO=new ModelBOImpl();

    public void Add(ActionEvent actionEvent) {
        String mid = txtMid.getText();
        String mname = txtMName.getText();
        String manuf = txtManuf.getText();
        String capacity = txtcapacity.getText();


        ModelDTO modelDTO=new ModelDTO(mid,mname,manuf,capacity);

        boolean result = false;
        try {
            result = modelBO.addmodel(modelDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK);
            alert.show();
            GetAllModel();
            Clear();
            ModelId();


        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Fail", ButtonType.OK);
            alert.show();

        }
    }

    public void Update(ActionEvent actionEvent) {
        String mid = txtMid.getText();
        String mname = txtMName.getText();
        String manuf = txtManuf.getText();
        String capacity = txtcapacity.getText();


        ModelDTO modelDTO=new ModelDTO(mid,mname,manuf,capacity);

        boolean result = false;
        try {
            result = modelBO.updatemodel(modelDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update", ButtonType.OK);
            alert.show();
            GetAllModel();
            Clear();
            ModelId();


        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update Fail", ButtonType.OK);
            alert.show();

        }
    }

    public void Delete(ActionEvent actionEvent) {
        String mid = txtMid.getText();

        ModelDTO modelDTO=new ModelDTO(mid);

        boolean result = false;
        try {
            result = modelBO.deletemodel(mid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK);
            alert.show();
            GetAllModel();
             Clear();
             ModelId();


        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Fail", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void moveAdd(ActionEvent event) {
        btnAdd.requestFocus();
    }

    @FXML
    void moveCap(ActionEvent event) {
        txtcapacity.requestFocus();
    }

    @FXML
    void moveManuf(ActionEvent event) {
        txtManuf.requestFocus();
    }

    @FXML
    void selectModel(MouseEvent event) {
      ModelDTO modelselect=tblModel.getSelectionModel().getSelectedItem();
      txtMid.setText(modelselect.getMcode());
      txtMName.setText(modelselect.getMname());
      txtManuf.setText(modelselect.getMBrand());
      txtcapacity.setText(modelselect.getCapacity());
    }

    private void ModelId(){
        try {
            String ModelId;
            ModelId = IDGenerator.getNewID("Model", "Mcode", "M");
            txtMid.setText(ModelId);
        } catch (SQLException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GetAllModel(){
        tblModel.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Mcode"));
        tblModel.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Mname"));
        tblModel.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("MBrand"));
        tblModel.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        ArrayList<ModelDTO> allmodel=null;
        try{
            allmodel=modelBO.getAllmodel();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tblModel.setItems(FXCollections.observableArrayList(allmodel));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ModelId();
        GetAllModel();
    }

    private void Clear(){
        txtcapacity.clear();
        txtManuf.clear();
        txtMName.clear();
        txtMid.clear();
    }
}
