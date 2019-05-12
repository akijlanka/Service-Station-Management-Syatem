package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public  boolean addItem(ItemDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updateItem(ItemDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean DeleteItem(String id) throws ClassNotFoundException, SQLException;
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException;
}
