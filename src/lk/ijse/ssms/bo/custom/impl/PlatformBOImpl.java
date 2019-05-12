package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.PlatformBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.PlatformDAO;
import lk.ijse.ssms.entity.Platfrom;
import lk.ijse.ssms.model.PlatformDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlatformBOImpl implements PlatformBO {
    PlatformDAO dao=(PlatformDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PLATFORM);

    @Override
    public boolean addplatform(PlatformDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Platfrom(ref.getPid(),ref.getPlatformNo(),ref.getStatus()));
    }

    @Override
    public boolean updateplatfrom(PlatformDTO ref) throws ClassNotFoundException, SQLException {
        return dao.update(new Platfrom(ref.getPid(),ref.getPlatformNo(),ref.getStatus()));

    }

    @Override
    public boolean deleteplatform(String id) throws ClassNotFoundException, SQLException {
        return dao.delete(id);
    }

    @Override
    public PlatformDTO searchplatform(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<PlatformDTO> getAllplatform() throws ClassNotFoundException, SQLException {
        ArrayList<Platfrom> all=dao.getAll();
        ArrayList<PlatformDTO> allplat=new ArrayList<>();
        for (Platfrom p: all){
            allplat.add(new PlatformDTO(p.getPid(),p.getPlatformNo(),p.getStatus()));
        }
        return allplat;
    }
}
