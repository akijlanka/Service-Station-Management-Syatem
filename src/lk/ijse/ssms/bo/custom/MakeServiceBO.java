package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.EmpDetailDTO;
import lk.ijse.ssms.model.ServiceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MakeServiceBO extends SuperBO {
    public boolean makeService(ServiceDTO ser) throws SQLException, ClassNotFoundException;
    public ArrayList<ServiceDTO> getAllService() throws ClassNotFoundException, SQLException;
    public EmpDetailDTO searchemp(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<EmpDetailDTO> getAllempd() throws ClassNotFoundException, SQLException;




}
