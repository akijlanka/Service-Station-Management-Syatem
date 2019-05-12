package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.ItemBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.ItemDAO;
import lk.ijse.ssms.entity.Item;
import lk.ijse.ssms.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO=(ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean addItem(ItemDTO ref) throws ClassNotFoundException, SQLException {
        return itemDAO.add(new Item(ref.getItemid(),ref.getName(),ref.getBrand(),ref.getPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO ref) throws ClassNotFoundException, SQLException {
        return itemDAO.update(new Item(ref.getItemid(),ref.getName(),ref.getBrand(),ref.getPrice()));
    }

    @Override
    public boolean DeleteItem(String id) throws ClassNotFoundException, SQLException {
        return itemDAO.delete(id);
    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        Item search=itemDAO.search(id);
        return new ItemDTO(search.getItemid(),search.getName(),search.getBrand(),search.getPrice());
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException {
        ArrayList<Item> allitem=itemDAO.getAll();
        ArrayList<ItemDTO> all=new ArrayList<>();
        for (Item search: allitem) {
            all.add(new ItemDTO(search.getItemid(),search.getName(),search.getBrand(),search.getPrice()));
        }
        return all;
    }
}
