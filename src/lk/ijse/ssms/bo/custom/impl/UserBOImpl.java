package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.UserBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.UserDAO;
import lk.ijse.ssms.entity.User;
import lk.ijse.ssms.model.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {

    UserDAO userDAO=(UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USERS);
    @Override
    public boolean addUser(UserDTO ref) throws ClassNotFoundException, SQLException {
        return userDAO.add(new User(ref.getUserid(),ref.getUname(),ref.getPosition(),ref.getEmail(),ref.getUsername(),ref.getUpassword()));
    }

    @Override
    public boolean updateUser(UserDTO ref) throws ClassNotFoundException, SQLException {
        return userDAO.update(new User(ref.getUserid(),ref.getUname(),ref.getPosition(),ref.getEmail(),ref.getUsername(),ref.getUpassword()));
    }

    @Override
    public boolean deleteUser(String id) throws ClassNotFoundException, SQLException {
        return userDAO.delete(id);
    }

    @Override
    public UserDTO searchaUser(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUser() throws ClassNotFoundException, SQLException {
       ArrayList<User> all=userDAO.getAll();
       ArrayList<UserDTO> alluser=new ArrayList<>();
       for (User u:all){
           alluser.add(new UserDTO(u.getUserid(),u.getUname(),u.getPosition(),u.getEmail(),u.getUsername(),u.getUpassword()));
       }
       return alluser;
    }
}
