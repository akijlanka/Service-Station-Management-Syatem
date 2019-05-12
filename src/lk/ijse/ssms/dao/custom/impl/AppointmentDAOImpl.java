package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.AppointmentDAO;
import lk.ijse.ssms.entity.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public boolean add(Appointment appointment) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Appointment values(?,?,?,?,?,?,?)", appointment.getAid(), appointment.getCusName(), appointment.getDate(), appointment.getTpNum(), appointment.getBNum(), appointment.getStatus(), appointment.getTime());
    }

    @Override
    public boolean update(Appointment appointment) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Appointment set CusName=?,Date=?,TpNum=?,BNum=? where Aid=? ", appointment.getCusName(), appointment.getDate(), appointment.getTpNum(), appointment.getBNum(), appointment.getAid());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("delete from Appointment where Aid=? ",t);
    }

    @Override
    public Appointment search(String t) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Appointment where BNum=? ", t);
        Appointment appointment=null;
        while (rst.next()){
            appointment=new Appointment(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getInt(6),rst.getString(7));
        }
        return appointment;
    }


    @Override
    public ArrayList<Appointment> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Appointment where Status=0");
        ArrayList<Appointment> allApp=new ArrayList();
        while(rst.next()){
            allApp.add(new Appointment(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getInt(6),rst.getString(7)));
        }
        return allApp;
    }
}
