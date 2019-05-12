package lk.ijse.ssms.bo.custom;

import lk.ijse.ssms.bo.SuperBO;
import lk.ijse.ssms.model.InvoiseDTO;

import java.sql.SQLException;

public interface InvoiceBO extends SuperBO {
    public  boolean makeInvoice(InvoiseDTO ref) throws ClassNotFoundException, SQLException;

}
