package lk.ijse.ssms.dao.custom.impl;

import lk.ijse.ssms.dao.CrudUtill;
import lk.ijse.ssms.dao.custom.EmployeeDAO;
import lk.ijse.ssms.entity.Appointment;
import lk.ijse.ssms.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("insert into Employee values(?,?,?,?,?)", employee.getEmpid(),employee.getName(),employee.getAddress(),employee.getJoindate(),employee.getTrakeNo());
    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("update Employee set Name=?,Address=?,Joindate=?,TrakeNo=? where Empid=? ", employee.getName(), employee.getAddress(), employee.getJoindate(), employee.getTrakeNo(), employee.getEmpid());
    }

    @Override
    public boolean delete(String t) throws SQLException, ClassNotFoundException {
        return CrudUtill.executeupdate("delete from Employee where Empid=? ",t);
    }

    @Override
    public Employee search(String t) throws SQLException, ClassNotFoundException {

        ResultSet rst=CrudUtill.executeQuery("select * from Employee where Empid=? ",t);
        Employee employee=null;
        while (rst.next()){
            employee=new Employee(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5));
        }
        return employee;
    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtill.executeQuery("select * from Employee");
        ArrayList<Employee> allEmp=new ArrayList();
        while(rst.next()){
            allEmp.add(new Employee(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5)));
        }
        return allEmp;
    }
}