package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.ServiceDAO;
import lk.ijse.ssms.entity.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDAOImpl implements ServiceDAO {
    @Override
    public boolean add(Service service) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Service values(?,?,?,?,?,?,?)", service.getSid(), service.getAid(), service.getBikeNum(), service.getIntime(), service.getOuttime(), service.getStatus(), service.getPlatform());
    }

    @Override
    public boolean update(Service service) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Service set Aid=?,BikeNum=?,Intime=?,Outtime=?,Status=?,Platform=? where Sid=?", service.getAid(), service.getBikeNum(), service.getIntime(), service.getOuttime(), service.getStatus(), service.getSid(), service.getPlatform());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Service search(String t) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Service> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Service where Status=0");
        ArrayList<Service> allservice=new ArrayList<>();
        while (rst.next()){
            allservice.add(new Service(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getString(7)));
        }
        return allservice;
    }
}
