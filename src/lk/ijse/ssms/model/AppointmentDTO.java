package lk.ijse.ssms.model;

public class AppointmentDTO {
    private String Aid;
    private String CusName;
    private String Date;
    private int TpNum;
    private String BNum;
    private int Status;
    private String Time;

    public AppointmentDTO(String aid, String cusName, String date, int tpNum, String BNum, int status,String Time) {
        this.Aid = aid;
        this.CusName = cusName;
        this.Date = date;
        this.TpNum = tpNum;
        this.BNum = BNum;
        this.Status = status;
        this.Time=Time;
    }

    public AppointmentDTO(String aid, String cusName, String date, int tpNum, String BNum) {
        this.Aid = aid;
        this.CusName = cusName;
        this.Date = date;
        this.TpNum = tpNum;
        this.BNum = BNum;

    }



    public AppointmentDTO(int status) {
        Status = status;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public AppointmentDTO(String aid) {
        Aid = aid;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getTpNum() {
        return TpNum;
    }

    public void setTpNum(int tpNum) {
        TpNum = tpNum;
    }

    public String getBNum() {
        return BNum;
    }

    public void setBNum(String BNum) {
        this.BNum = BNum;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
