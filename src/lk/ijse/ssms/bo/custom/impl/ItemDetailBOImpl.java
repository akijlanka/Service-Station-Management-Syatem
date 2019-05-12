package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.ItemDetailBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.ItemDetailDAO;
import lk.ijse.ssms.entity.ItemDetail;
import lk.ijse.ssms.model.ItemDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDetailBOImpl implements ItemDetailBO {

    ItemDetailDAO itemDetailDAO=(ItemDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEMDETAIL);

    @Override
    public boolean additemd(ItemDetailDTO ref) throws ClassNotFoundException, SQLException {
        return itemDetailDAO.add(new ItemDetail(ref.getSid(),ref.getItemid(),ref.getQty(),ref.getTotal(),ref.getItemname()));
    }

    @Override
    public boolean updateitemd(ItemDetailDTO ref) throws ClassNotFoundException, SQLException {
        return itemDetailDAO.update(new ItemDetail(ref.getSid(),ref.getItemid(),ref.getQty(),ref.getTotal(),ref.getItemname()));

    }

    @Override
    public boolean cancelitemd(String id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<ItemDetailDTO> getAllItemd() throws ClassNotFoundException, SQLException {
        ArrayList<ItemDetail> all=itemDetailDAO.getAll();
        ArrayList<ItemDetailDTO> allapp=new ArrayList<>();
        for (ItemDetail search:all) {
            allapp.add(new ItemDetailDTO(search.getSid(),search.getItemid(),search.getQty(),search.getTotal(),search.getItemname()));
        }
        return allapp;
    }
}
