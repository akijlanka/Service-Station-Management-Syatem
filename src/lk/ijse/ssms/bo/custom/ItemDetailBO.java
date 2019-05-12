package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.ItemDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDetailBO extends SuperBO {
    public  boolean additemd(ItemDetailDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updateitemd(ItemDetailDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean cancelitemd(String id) throws ClassNotFoundException, SQLException;
    public ArrayList<ItemDetailDTO> getAllItemd() throws ClassNotFoundException, SQLException;

}
