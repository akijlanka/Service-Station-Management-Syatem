package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.AppDestilBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.AppDetailDAO;
import lk.ijse.ssms.entity.AppDetail;
import lk.ijse.ssms.model.AppDetailDTO;

import java.sql.SQLException;

public class AppDetailBOImpl implements AppDestilBO {

    AppDetailDAO appDetailDAO=(AppDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOINTMENTDETAIL);

    @Override
    public boolean makeappDetail(AppDetailDTO ref) throws ClassNotFoundException, SQLException {
        return appDetailDAO.add(new AppDetail(ref.getBid(),ref.getAid(),ref.getDate(),ref.getMils()));
    }
}
