package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO  extends SuperBO {
    public  boolean AddEmployee(EmployeeDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updateEmployee(EmployeeDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean DeleteEmployee(String id) throws ClassNotFoundException, SQLException;
    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<EmployeeDTO> getAllEmployee() throws ClassNotFoundException, SQLException;

}
