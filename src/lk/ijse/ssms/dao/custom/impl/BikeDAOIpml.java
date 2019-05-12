package lk.ijse.ssms.dao.custom.impl;


import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.BikeDAO;
import lk.ijse.ssms.entity.Bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BikeDAOIpml implements BikeDAO {

    @Override
    public boolean add(Bike bike) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Bike values(?,?,?,?,?)", bike.getBid(), bike.getBikeNum(), bike.getCusname(), bike.getTpNum(), bike.getModel());
    }

    @Override
    public boolean update(Bike bike) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Bike set BikeNum=?,Cusname=?,TpNum=?,Model=? where Bid=?", bike.getBikeNum(), bike.getCusname(), bike.getTpNum(), bike.getModel(), bike.getBid());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Bike search(String t) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Bike where BikeNum=? ", t);
        Bike bike=null;
        while (rst.next()){
            bike=new Bike(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5));
        }
        return bike;
    }

    @Override
    public ArrayList<Bike> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Bike");
        ArrayList<Bike> allBike=new ArrayList();
        while(rst.next()){
            allBike.add(new Bike(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5)));
        }
        return allBike;
    }
}
