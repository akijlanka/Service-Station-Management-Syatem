package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.MakeServiceBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.EmpDetailDAO;
import lk.ijse.ssms.dao.custom.ServiceDAO;
import lk.ijse.ssms.dbconnection.DBConnection;
import lk.ijse.ssms.entity.EmpDetail;
import lk.ijse.ssms.entity.Service;
import lk.ijse.ssms.model.EmpDetailDTO;
import lk.ijse.ssms.model.ServiceDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MakeServiceBOImpl implements MakeServiceBO {
    ServiceDAO service=(ServiceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE);
    EmpDetailDAO empd=(EmpDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPDETAIL);
    ServiceDAO dao=(ServiceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE);

    @Override
    public boolean makeService(ServiceDTO ser) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean add=service.add(new Service(ser.getSid(),ser.getAid(),ser.getBikeNum(),ser.getIntime(),ser.getOuttime(),
                ser.getStatus(),ser.getPlatform()));
        if (add){
            for (EmpDetailDTO a:ser.getAllempdetails()){
                boolean empdadd=empd.add(new EmpDetail(a.getEmpid(),a.getSid(),a.getDate(),a.getEname()));
                if (!empdadd){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
    }

    @Override
    public ArrayList<ServiceDTO> getAllService() throws ClassNotFoundException, SQLException {
        ArrayList<Service> all=dao.getAll();
        ArrayList<ServiceDTO> allapp=new ArrayList<>();
        for (Service search:all) {
            allapp.add(new ServiceDTO(search.getSid(),search.getAid(),search.getBikeNum(),search.getIntime(),
                    search.getOuttime(),search.getStatus(),search.getPlatform()));
        }
        return allapp;
    }

    @Override
    public EmpDetailDTO searchemp(String id) throws SQLException, ClassNotFoundException {
        EmpDetail search=empd.search(id);
        return new EmpDetailDTO(search.getEmpid(),search.getSid(),search.getDate(),search.getEname());
    }

    @Override
    public ArrayList<EmpDetailDTO> getAllempd() throws ClassNotFoundException, SQLException {
        ArrayList<EmpDetail> all=empd.getAll();
        ArrayList<EmpDetailDTO> allapp=new ArrayList<>();
        for (EmpDetail search:all) {
            allapp.add(new EmpDetailDTO(search.getEmpid(),search.getSid(),search.getDate(),search.getEname()));
        }
        return allapp;
    }
}
