package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.ItemDAO;
import lk.ijse.ssms.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Item values(?,?,?,?)", item.getItemid(), item.getName(), item.getBrand(), item.getPrice());
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Item set Name=?,Brand=?,Price=? where Itemid=? ", item.getName(), item.getBrand(), item.getPrice(), item.getItemid());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("delete from Item where Itemid=? ",t);
    }

    @Override
    public Item search(String t) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Item where Itemid");
        Item item=null;
        while (rst.next()){
       item=new Item(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4));
        }
        return item;
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Item");
        ArrayList<Item> allitem=new ArrayList();
        while (rst.next()){
            allitem.add(new Item(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4)));
        }
        return allitem;
    }
}
