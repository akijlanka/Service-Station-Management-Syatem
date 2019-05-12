package lk.ijse.ssms.dao.custom.impl;


import lk.ijse.ssms.dao.CrudDAO;
import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.QueryDAO;
import lk.ijse.ssms.entity.Appointment;
import lk.ijse.ssms.entity.Platfrom;
import lk.ijse.ssms.entity.Service;
import lk.ijse.ssms.model.CommenDTO;
import lk.ijse.ssms.model.PlatformDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class QueryDAOImpl implements QueryDAO {

    @Override
    public int getRowcount() throws SQLException, ClassNotFoundException {
        int rowcount=0;
        ResultSet rst=CrudUtill.executeQuery("select count(*) from Appointment where Status=0");

        while (rst.next()){
            rowcount=rst.getInt("count(*)");
        }

        return rowcount;
    }

    @Override
    public int getEmpRowcount() throws SQLException, ClassNotFoundException {
        int rowcount=0;
        ResultSet rst=CrudUtill.executeQuery("select count(*) from Employee");

        while (rst.next()){
            rowcount=rst.getInt("count(*)");
        }

        return rowcount;
    }

    @Override
    public int getItemRowcount() throws SQLException, ClassNotFoundException {
        int rowcount=0;
        ResultSet rst=CrudUtill.executeQuery("select count(*) from Item");

        while (rst.next()){
            rowcount=rst.getInt("count(*)");
        }

        return rowcount;
    }

    @Override
    public int getBikemodelRowcount() throws SQLException, ClassNotFoundException {
        int rowcount=0;
        ResultSet rst=CrudUtill.executeQuery("select count(*) from Model");

        while (rst.next()){
            rowcount=rst.getInt("count(*)");
        }

        return rowcount;
    }

    @Override
    public int getServiceRowcount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public String getlastDate() throws SQLException, ClassNotFoundException {
        String lastDate = "no";
        ResultSet rst=CrudUtill.executeQuery("select * from Employee order by Empid desc limit 1");

        while (rst.next()){
            lastDate=rst.getString("Joindate");
        }

        return lastDate;
    }

    @Override
    public String getlastTime() throws SQLException, ClassNotFoundException {
        String lastTime = "No";
        ResultSet rst=CrudUtill.executeQuery("select * from Appointment order by Aid desc limit 1");

        while (rst.next()){
            lastTime=rst.getString("Time");
        }

        return lastTime;
    }

    @Override
    public Boolean UpSatatus(Appointment appointment) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Appointment set Status=? where Aid=? ", appointment.getStatus(), appointment.getAid());
    }

    @Override
    public ArrayList<Platfrom> getworkingplatform() throws ClassNotFoundException, SQLException {
        ResultSet rst=CrudUtill.executeQuery("select * from Platform where Status=1");
        ArrayList<Platfrom> allApp=new ArrayList();
        while(rst.next()){
            allApp.add(new Platfrom(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return allApp;
    }

    @Override
    public Boolean UpPlatformSatatus(Platfrom platfrom) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Platform set Status=? where Pid=? ", platfrom.getStatus(), platfrom.getPid());

    }

    @Override
    public Boolean UpServiceSatatus(Service service) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Service set Status=?,OutTime=? where Sid=? ", service.getStatus(), service.getOuttime(), service.getSid());
    }

    @Override
    public ArrayList<Service> endworkservice() throws ClassNotFoundException, SQLException {
        ResultSet rst=CrudUtill.executeQuery("select * from Service where Status=1");
        ArrayList<Service> allApp=new ArrayList();
        while(rst.next()){
            allApp.add(new Service(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getString(7)));
        }
        return allApp;
    }

    @Override
    public ArrayList<CommenDTO> serchseviseItem(String ID) throws ClassNotFoundException, SQLException {
       return null;
    }


}
