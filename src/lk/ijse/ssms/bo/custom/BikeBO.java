package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.BikeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BikeBO extends SuperBO {

    public  boolean AddBike(BikeDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updatebike(BikeDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean Deletebike(String id) throws ClassNotFoundException, SQLException;
    public BikeDTO searchbike(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<BikeDTO> getAllbike() throws ClassNotFoundException, SQLException;
}
