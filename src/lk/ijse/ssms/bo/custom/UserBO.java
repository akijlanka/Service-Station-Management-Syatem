package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.UserDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    public  boolean addUser(UserDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updateUser(UserDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean deleteUser(String id) throws ClassNotFoundException, SQLException;
    public UserDTO searchaUser(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<UserDTO> getAllUser() throws ClassNotFoundException, SQLException;
}
