package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.model.ModelDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ModelBO {
    public  boolean addmodel(ModelDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean updatemodel(ModelDTO ref) throws ClassNotFoundException, SQLException;
    public  boolean deletemodel(String id) throws ClassNotFoundException, SQLException;
    public ModelDTO searchmodel(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<ModelDTO> getAllmodel() throws ClassNotFoundException, SQLException;
}
