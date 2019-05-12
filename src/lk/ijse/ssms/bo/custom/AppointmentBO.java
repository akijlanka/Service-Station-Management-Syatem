package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.AppointmentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AppointmentBO extends SuperBO {
    public  boolean makeappintment(AppointmentDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updateappintment(AppointmentDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean cancelappointment(String id) throws ClassNotFoundException, SQLException;
    public AppointmentDTO searchappointment(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<AppointmentDTO> getAllAppointment() throws ClassNotFoundException, SQLException;

}
