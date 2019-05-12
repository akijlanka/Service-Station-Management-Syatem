package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.EmpDetailDAO;
import lk.ijse.ssms.entity.EmpDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDetailDAOImpl implements EmpDetailDAO {
    @Override
    public boolean add(EmpDetail empDetail) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into EmpDetail values(?,?,?,?)", empDetail.getEmpid(), empDetail.getSid(), empDetail.getDate(), empDetail.getEname());
    }

    @Override
    public boolean update(EmpDetail empDetail) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public EmpDetail search(String t) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from EmpDetail where Empid=? ", t);
        EmpDetail appointment=null;
        while (rst.next()){
            appointment=new EmpDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }
        return appointment;
    }

    @Override
    public ArrayList<EmpDetail> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from EmpDetail");
        ArrayList<EmpDetail> allEmpd=new ArrayList<>();
        while (rst.next()){
            allEmpd.add(new EmpDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));

        }
        return allEmpd;
    }
}
