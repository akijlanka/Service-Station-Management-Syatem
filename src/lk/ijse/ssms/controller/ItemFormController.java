package lk.ijse.ssms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.ssms.Common.IDGenerator;
import lk.ijse.ssms.bo.custom.ItemBO;
import lk.ijse.ssms.bo.custom.impl.ItemBOImpl;
import lk.ijse.ssms.model.ItemDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    @FXML
    private JFXTextField txtitemCode;

    @FXML
    private JFXTextField txtItemname;

    @FXML
    private JFXTextField txtitembrand;

    @FXML
    private JFXTextField txtitemprice;

    @FXML
    private Label txtitemid;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<ItemDTO> tblItem;

    private static ItemBO itemBO=new ItemBOImpl();




    public void AddItem(ActionEvent actionEvent) {
        String itemid = txtitemid.getText();
        String itemname = txtItemname.getText();
        String itembrand = txtitembrand.getText();
        double itemprice = Double.parseDouble(txtitemprice.getText());


        ItemDTO itemDTO=new ItemDTO(itemid,itemname,itembrand,itemprice);
        boolean result = false;
        try {
            result=itemBO.addItem(itemDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK);
            alert.show();
            Clear();
            GetAllItem();
            ItemID();


        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Added Fail", ButtonType.OK);
            alert.show();

        }
    }

    public void UpdateItem(ActionEvent actionEvent) {
        String itemid = txtitemid.getText();
        String itemname = txtItemname.getText();
        String itembrand = txtitembrand.getText();
        double itemprice = Double.parseDouble(txtitemprice.getText());


        ItemDTO itemDTO=new ItemDTO(itemid,itemname,itembrand,itemprice);
        boolean result = false;
        try {
            result=itemBO.updateItem(itemDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update", ButtonType.OK);
            alert.show();
            Clear();
            GetAllItem();
            ItemID();


        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update Fail", ButtonType.OK);
            alert.show();

        }
    }

    public void DeleteItem(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String itemid = txtitemid.getText();

        ItemDTO itemDTO=new ItemDTO(itemid);

        boolean result=itemBO.DeleteItem(itemid);
        if (result) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK);
            alert.show();
            GetAllItem();
            Clear();
            ItemID();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete Fail", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    void selectOn(MouseEvent event) {

        ItemDTO selectitem=tblItem.getSelectionModel().getSelectedItem();
        txtitemid.setText(selectitem.getItemid());
        txtItemname.setText(selectitem.getName());
        txtitembrand.setText(selectitem.getBrand());
        txtitemprice.setText(selectitem.getPrice()+"");
    }


    @FXML
    void moveAdd(ActionEvent event) {
        btnAdd.requestFocus();
    }

    @FXML
    void moveName(ActionEvent event) {
        txtItemname.requestFocus();
    }

    @FXML
    void movePrice(ActionEvent event) {
        txtitemprice.requestFocus();
    }

    @FXML
    void movebrand(ActionEvent event) {
        txtitembrand.requestFocus();
    }

    public void ItemID(){
        try {
            String ItemId;
            ItemId = IDGenerator.getNewID("Item", "Itemid", "I");
            txtitemid.setText(ItemId);
        } catch (SQLException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ItemID();
        GetAllItem();
    }

    public void GetAllItem(){

        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Itemid"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Brand"));
        tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        ArrayList<ItemDTO> allitem=null;
        try {
            allitem=itemBO.getAllItem();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblItem.setItems(FXCollections.observableArrayList(allitem));

    }

    public void Clear(){
        txtitemid.setText("");
        txtItemname.setText("");
        txtitembrand.setText("");
        txtitemprice.setText("");
    }
}
