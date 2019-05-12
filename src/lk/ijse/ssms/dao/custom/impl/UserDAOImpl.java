package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.UserDAO;
import lk.ijse.ssms.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(User user) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into User values(?,?,?,?,?,?)", user.getUserid(), user.getUname(), user.getPosition(), user.getEmail(), user.getUsername(), user.getUpassword());
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update User set Uname=?,Position=?,Email=?,Username=?,Upassword=? where Userid=? ", user.getUname(), user.getPosition(), user.getEmail(), user.getUsername(), user.getUpassword(), user.getUserid());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("delete from User where Userid=? ",t);

    }

    @Override
    public User search(String t) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from User");
        ArrayList<User> allUser=new ArrayList();
        while(rst.next()){
            allUser.add(new User(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return allUser;
    }
}
