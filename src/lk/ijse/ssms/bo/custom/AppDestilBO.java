package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.AppDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AppDestilBO extends SuperBO {
    public  boolean makeappDetail(AppDetailDTO ref) throws ClassNotFoundException, SQLException;


}
