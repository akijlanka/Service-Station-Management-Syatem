package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.ItemDetailDAO;
import lk.ijse.ssms.entity.ItemDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDetailDAOImpl implements ItemDetailDAO {
    @Override
    public boolean add(ItemDetail itemDetail) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into ItemDetail values(?,?,?,?,?)", itemDetail.getSid(), itemDetail.getItemid(), itemDetail.getQty(), itemDetail.getTotal(), itemDetail.getItemname());
    }

    @Override
    public boolean update(ItemDetail itemDetail) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update ItemDetail set Itemid=?,Qty=?,Total=?,Itemname=? where Sid=?", itemDetail.getItemid(), itemDetail.getQty(), itemDetail.getTotal(), itemDetail.getItemname(), itemDetail.getSid());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("delete from ItemDetail where Sid=? ",t);

    }

    @Override
    public ItemDetail search(String t) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ItemDetail> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from ItemDetail");
        ArrayList<ItemDetail> allApp=new ArrayList();
        while(rst.next()){
            allApp.add(new ItemDetail(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getString(5)));
        }
        return allApp;
    }
}
