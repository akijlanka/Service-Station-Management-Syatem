package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.ModelBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.ModelDAO;
import lk.ijse.ssms.entity.Model;
import lk.ijse.ssms.model.ModelDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModelBOImpl implements ModelBO {

    ModelDAO dao=(ModelDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MODEL);

    @Override
    public boolean addmodel(ModelDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Model(ref.getMcode(),ref.getMname(),ref.getMBrand(),ref.getCapacity()));
    }

    @Override
    public boolean updatemodel(ModelDTO ref) throws ClassNotFoundException, SQLException {
        return dao.update(new Model(ref.getMcode(),ref.getMname(),ref.getMBrand(),ref.getCapacity()));
    }

    @Override
    public boolean deletemodel(String id) throws ClassNotFoundException, SQLException {
        return dao.delete(id);
    }

    @Override
    public ModelDTO searchmodel(String id) throws SQLException, ClassNotFoundException {
        Model model=dao.search(id);
        return new ModelDTO(model.getMcode(),model.getMname(), model.getMBrand(),model.getCapacity());
    }

    @Override
    public ArrayList<ModelDTO> getAllmodel() throws ClassNotFoundException, SQLException {
        ArrayList<Model> all=dao.getAll();
        ArrayList<ModelDTO> allModel=new ArrayList<>();
        for (Model search:all) {
            allModel.add(new ModelDTO(search.getMcode(),search.getMname(),search.getMBrand(),search.getCapacity()));
        }
        return allModel;
    }
}
