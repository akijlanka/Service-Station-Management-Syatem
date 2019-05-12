package lk.ijse.ssms.entity;

public class Employee {
    private String Empid;
    private String Name;
    private String Address;
    private String Joindate;
    private int TrakeNo;

    public Employee(String empid, String name, String address, String joindate, int trakeNo) {
        this.Empid = empid;
        this.Name = name;
        this.Address = address;
        this.Joindate = joindate;
        this.TrakeNo = trakeNo;
    }

    public String getEmpid() {
        return Empid;
    }

    public void setEmpid(String empid) {
        this.Empid = empid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getJoindate() {
        return Joindate;
    }

    public void setJoindate(String joindate) {
        this.Joindate = joindate;
    }

    public int getTrakeNo() {
        return TrakeNo;
    }

    public void setTrakeNo(int trakeNo) {
        this.TrakeNo = trakeNo;
    }
}
