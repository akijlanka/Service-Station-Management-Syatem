package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.InvoiceBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.InvoicDAO;
import lk.ijse.ssms.entity.Invoise;
import lk.ijse.ssms.model.InvoiseDTO;

import java.sql.SQLException;

public class InvoiceBOImpl implements InvoiceBO {

    InvoicDAO dao=(InvoicDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INVOICE);

    @Override
    public boolean makeInvoice(InvoiseDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Invoise(ref.getIno(),ref.getAid(),ref.getBikeNum(),ref.getDate(),ref.getTotal()));
    }
}
