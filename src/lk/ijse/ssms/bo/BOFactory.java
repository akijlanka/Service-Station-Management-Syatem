package lk.ijse.ssms.bo;

import lk.ijse.ssms.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance(){

        if (boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum  BOTypes{
        APPOINTMENT, BIKE,ITEM,EMPLOYEE,MODEL,MAKESERVICE,USERS,PLATFORM,APPOINTMENTDETAIL,EMPDETAIL,ITEMDETAIL,INVOICE;
    }

    public <T>T getBO(BOTypes types){
        switch (types){
            case APPOINTMENT:
                return (T)new AppointmentBOImpl();
            case EMPLOYEE:
                return (T)new EmployeeBOImpl();
            case ITEM:
                return (T)new ItemBOImpl();
            case MODEL:
                return (T)new ModelBOImpl();
            case MAKESERVICE:
                return (T)new MakeServiceBOImpl();
            case BIKE:
                return (T)new BikeBOImpl();
            case USERS:
                return (T)new UserBOImpl();
            case PLATFORM:
                return (T)new UserBOImpl();
            case ITEMDETAIL:
                return (T)new ItemDetailBOImpl();
            case INVOICE:
                return (T)new InvoiceBOImpl();
            default:
                return null;
        }
    }
}

