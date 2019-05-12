package lk.ijse.ssms.model;

public class EmpDetailDTO {
    private String Empid;
    private String Sid;
    private String Date;
    private String Ename;

    public EmpDetailDTO(String empid, String sid, String date, String ename) {
        this.Empid = empid;
        this.Sid = sid;
        this.Date = date;
        this.Ename = ename;
    }

    public EmpDetailDTO(String empid, String ename) {
        Empid = empid;
        Ename = ename;
    }

    public String getEmpid() {
        return Empid;
    }

    public void setEmpid(String empid) {
        this.Empid = empid;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        this.Sid = sid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        this.Ename = ename;
    }




}
