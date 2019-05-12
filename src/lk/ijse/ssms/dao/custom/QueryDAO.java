package lk.ijse.ssms.dao.custom;


import lk.ijse.ssms.dao.SuperDAO;
import lk.ijse.ssms.entity.Appointment;
import lk.ijse.ssms.entity.Platfrom;
import lk.ijse.ssms.entity.Service;
import lk.ijse.ssms.model.CommenDTO;

import java.sql.SQLException;
import java.util.ArrayList;


public interface QueryDAO extends SuperDAO {


    public int getRowcount() throws SQLException, ClassNotFoundException;

    public int getEmpRowcount() throws SQLException, ClassNotFoundException;

    public int getItemRowcount() throws SQLException, ClassNotFoundException;

    public int getBikemodelRowcount() throws SQLException, ClassNotFoundException;

    public int getServiceRowcount() throws SQLException, ClassNotFoundException;

    public String getlastDate() throws SQLException, ClassNotFoundException;

    public String getlastTime() throws SQLException, ClassNotFoundException;

   public Boolean UpSatatus(Appointment appointment) throws SQLException, ClassNotFoundException;

    public ArrayList<Platfrom> getworkingplatform() throws ClassNotFoundException, SQLException;

    public Boolean UpPlatformSatatus(Platfrom platfrom) throws SQLException, ClassNotFoundException;

    public Boolean UpServiceSatatus(Service service) throws SQLException, ClassNotFoundException;

    public ArrayList<Service> endworkservice() throws ClassNotFoundException, SQLException;


    public ArrayList<CommenDTO> serchseviseItem(String ID)throws ClassNotFoundException,SQLException;



}

