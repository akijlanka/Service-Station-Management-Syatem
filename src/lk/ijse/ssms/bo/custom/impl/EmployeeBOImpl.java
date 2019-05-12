package lk.ijse.ssms.bo.custom.impl;

import lk.ijse.ssms.bo.custom.EmployeeBO;
import lk.ijse.ssms.dao.DAOFactory;
import lk.ijse.ssms.dao.custom.EmployeeDAO;
import lk.ijse.ssms.entity.Employee;
import lk.ijse.ssms.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO dao=(EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean AddEmployee(EmployeeDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Employee(ref.getEmpid(),ref.getName(),ref.getAddress(),ref.getJoindate(),ref.getTrakeNo()));
    }

    @Override
    public boolean updateEmployee(EmployeeDTO ref) throws ClassNotFoundException, SQLException {
        return dao.update(new Employee(ref.getEmpid(),ref.getName(),ref.getAddress(),ref.getJoindate(),ref.getTrakeNo()));
    }

    @Override
    public boolean DeleteEmployee(String id) throws ClassNotFoundException, SQLException {
        return dao.delete(id);
    }

    @Override
    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException {
        Employee employee=dao.search(id);
        return new EmployeeDTO(employee.getEmpid(),employee.getName(),employee.getAddress(),employee.getJoindate(),employee.getTrakeNo());
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws ClassNotFoundException, SQLException {
        ArrayList<Employee> all=dao.getAll();
        ArrayList<EmployeeDTO> allapp=new ArrayList<>();
        for (Employee search : all) {
            allapp.add(new EmployeeDTO(search.getEmpid(),search.getName(),search.getAddress(),search.getJoindate(),search.getTrakeNo()));
        }
        return allapp;
    }
}
