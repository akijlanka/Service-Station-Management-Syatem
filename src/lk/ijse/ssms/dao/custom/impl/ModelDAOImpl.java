package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.ModelDAO;
import lk.ijse.ssms.entity.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDAOImpl implements ModelDAO {
    @Override
    public boolean add(Model model) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Model values(?,?,?,?)", model.getMcode(),model.getMname(),model.getMBrand(),model.getCapacity());
    }

    @Override
    public boolean update(Model model) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Model set Mname=?,MBrand=?,Capacity=? where Mcode=? ", model.getMname(), model.getMBrand(), model.getCapacity(), model.getMcode());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("delete from Model where Mcode=? ",t);
    }

    @Override
    public Model search(String t) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Model where Mcode=?");
        Model model=null;
        while(rst.next()){
            model=new Model(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));

        }
        return model;
    }

    @Override
    public ArrayList<Model> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtill.executeQuery("select * from Model");
        ArrayList<Model> allmodel = new ArrayList();
        while (rst.next()) {
            allmodel.add(new Model(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));

        }
    return allmodel;
    }


}
