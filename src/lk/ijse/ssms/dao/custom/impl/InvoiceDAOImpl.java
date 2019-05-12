package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.InvoicDAO;
import lk.ijse.ssms.entity.Invoise;

import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAOImpl implements InvoicDAO {
    @Override
    public boolean add(Invoise invoise) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Invoise values(?,?,?,?,?)", invoise.getIno(), invoise.getAid(), invoise.getBikeNum(), invoise.getDate(), invoise.getTotal());
    }

    @Override
    public boolean update(Invoise invoise) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Invoise search(String t) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Invoise> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
