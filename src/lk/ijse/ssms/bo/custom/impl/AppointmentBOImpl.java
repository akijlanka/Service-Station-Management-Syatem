package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.AppointmentBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.AppointmentDAO;
import lk.ijse.ssms.entity.Appointment;
import lk.ijse.ssms.model.AppointmentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentBOImpl implements AppointmentBO {
    AppointmentDAO dao=(AppointmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOINTMENT);

    @Override
    public boolean makeappintment(AppointmentDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Appointment(ref.getAid(),ref.getCusName(),ref.getDate(),ref.getTpNum(),ref.getBNum(),ref.getStatus(),ref.getTime()));
    }

    @Override
    public boolean updateappintment(AppointmentDTO ref) throws ClassNotFoundException, SQLException {
        return dao.update(new Appointment(ref.getAid(),ref.getCusName(),ref.getDate(),ref.getTpNum(),ref.getBNum(),ref.getStatus(),ref.getTime()));
    }

    @Override
    public boolean cancelappointment(String id) throws ClassNotFoundException, SQLException {
        return dao.delete(id);
    }

    @Override
    public AppointmentDTO searchappointment(String id) throws SQLException, ClassNotFoundException {
        Appointment search=dao.search(id);
        return new AppointmentDTO(search.getAid(),search.getCusName(),search.getDate(),search.getTpNum(),search.getBNum(),search.getStatus(),search.getTime());
    }

    @Override
    public ArrayList<AppointmentDTO> getAllAppointment() throws ClassNotFoundException, SQLException {

        ArrayList<Appointment> all=dao.getAll();
        ArrayList<AppointmentDTO> allapp=new ArrayList<>();
        for (Appointment search:all) {
            allapp.add(new AppointmentDTO(search.getAid(),search.getCusName(),search.getDate(),search.getTpNum(),search.getBNum(),search.getStatus(),search.getTime()));
        }
        return allapp;
    }
}
