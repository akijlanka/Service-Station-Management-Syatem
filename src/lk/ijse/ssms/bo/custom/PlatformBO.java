package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.PlatformDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlatformBO extends SuperBO {
    public  boolean addplatform(PlatformDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updateplatfrom(PlatformDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean deleteplatform(String id) throws ClassNotFoundException, SQLException;
    public PlatformDTO searchplatform(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<PlatformDTO> getAllplatform() throws ClassNotFoundException, SQLException;
}
