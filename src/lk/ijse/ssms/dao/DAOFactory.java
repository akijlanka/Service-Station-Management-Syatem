package lk.ijse.ssms.dao;

import lk.ijse.ssms.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        APPOINTMENT, BIKE, ITEM, EMPLOYEE, MODEL, SERVICE, USERS, APPOINTMENTDETAIL, EMPDETAIL, ITEMDETAIL,QUERY,PLATFORM,INVOICE;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case APPOINTMENT:
                return new AppointmentDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case MODEL:
                return new ModelDAOImpl();
            case SERVICE:
                return new ServiceDAOImpl();
            case EMPDETAIL:
                return new EmpDetailDAOImpl();
            case BIKE:
                return new BikeDAOIpml();
            case PLATFORM:
                return new PlatformDAOImpl();
            case USERS:
                return new UserDAOImpl();
            case ITEMDETAIL:
                return new ItemDetailDAOImpl();
            case APPOINTMENTDETAIL:
                return new AppDetailDAOImpl();
            case INVOICE:
                return new InvoiceDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}