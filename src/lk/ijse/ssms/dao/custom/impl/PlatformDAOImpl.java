package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.PlatformDAO;
import lk.ijse.ssms.entity.Platfrom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlatformDAOImpl implements PlatformDAO {
    @Override
    public boolean add(Platfrom platfrom) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Platform values(?,?,?)", platfrom.getPid(), platfrom.getPlatformNo(), platfrom.getStatus());
    }

    @Override
    public boolean update(Platfrom platfrom) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Platform set Status=? where Pid=? ", platfrom.getStatus(), platfrom.getPid());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("delete from Platform where Pid=? ",t);
    }

    @Override
    public Platfrom search(String t) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Platfrom> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Platform");
        ArrayList<Platfrom> allApp=new ArrayList();
        while(rst.next()){
            allApp.add(new Platfrom(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return allApp;
    }
}
