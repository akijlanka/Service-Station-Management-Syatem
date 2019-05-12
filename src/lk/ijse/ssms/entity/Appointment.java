package lk.ijse.ssms.entity;

public class Appointment {

    private String Aid;
    private String CusName;
    private String Date;
    private int TpNum;
    private String BNum;
    private int Status;
    private String Time;

    public Appointment(String aid, String cusName, String date, int tpNum, String BNum, int status,String Time) {
        this.Aid = aid;
        this.CusName = cusName;
        this.Date = date;
        this.TpNum = tpNum;
        this.BNum = BNum;
        this.Status = status;
        this.Time=Time;


    }

    public Appointment(String aid, int status) {
        Aid = aid;
        Status = status;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public Appointment(String aid) {
        this.Aid = aid;
    }

    public String getAid() { return this.Aid; }

    public void setAid(String aid) {
        this.Aid = aid;
    }

    public String getCusName() {
        return this.CusName;
    }

    public void setCusName(String cusName) {
        this.CusName = cusName;
    }

    public String getDate() { return this.Date; }

    public void setDate(String date) {
        this.Date = date;
    }

    public int getTpNum() {
        return this.TpNum;
    }

    public void setTpNum(int tpNum) { this.TpNum = tpNum; }

    public String getBNum() {
        return this.BNum;
    }

    public void setBNum(String BNum) {
        this.BNum = BNum;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }
}
