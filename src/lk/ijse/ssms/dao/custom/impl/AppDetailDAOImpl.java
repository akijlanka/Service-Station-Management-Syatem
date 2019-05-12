package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.AppDetailDAO;
import lk.ijse.ssms.entity.AppDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppDetailDAOImpl implements AppDetailDAO {
    @Override
    public boolean add(AppDetail appDetail) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into AppDetail values(?,?,?,?)", appDetail.getBid(), appDetail.getAid(), appDetail.getDate(), appDetail.getMils());
    }

    @Override
    public boolean update(AppDetail appDetail) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public AppDetail search(String t) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<AppDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
