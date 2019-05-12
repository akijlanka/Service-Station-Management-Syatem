package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.BikeBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.BikeDAO;
import lk.ijse.ssms.entity.Bike;
import lk.ijse.ssms.model.BikeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class BikeBOImpl implements BikeBO {

    BikeDAO dao=(BikeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BIKE);

    @Override
    public boolean AddBike(BikeDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Bike(ref.getBid(),ref.getBikeNum(),ref.getCusname(),ref.getTpNum(),ref.getModel()));
    }

    @Override
    public boolean updatebike(BikeDTO ref) throws ClassNotFoundException, SQLException {
        return dao.update(new Bike(ref.getBid(),ref.getBikeNum(),ref.getCusname(),ref.getTpNum(),ref.getModel()));

    }

    @Override
    public boolean Deletebike(String id) throws ClassNotFoundException, SQLException {
      return dao.delete(id);
    }

    @Override
    public BikeDTO searchbike(String id) throws SQLException, ClassNotFoundException {
        Bike bike=dao.search(id);
        return new BikeDTO(bike.getBid(),bike.getBikeNum(),bike.getCusname(),bike.getTpNum(),bike.getModel());
    }

    @Override
    public ArrayList<BikeDTO> getAllbike() throws ClassNotFoundException, SQLException {
        ArrayList<Bike> all=dao.getAll();
        ArrayList<BikeDTO> allbike=new ArrayList<>();
        for (Bike ref:all) {
            allbike.add(new BikeDTO(ref.getBid(),ref.getBikeNum(),ref.getCusname(),ref.getTpNum(),ref.getModel()));

        }
        return allbike;
    }
}
