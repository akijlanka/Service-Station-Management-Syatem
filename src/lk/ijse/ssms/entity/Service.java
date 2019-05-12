package lk.ijse.ssms.entity;

public class Service {
    private String Sid;
    private String Aid;
    private String BikeNum;
    private String Intime;
    private String Outtime;
    private int Status;
    private String Platform;

    public Service(String sid, String aid, String bikeNum, String intime, String outtime, int status, String Platform) {
        Sid = sid;
        Aid = aid;
        BikeNum = bikeNum;
        Intime = intime;
        Outtime = outtime;
        Status = status;
        this.Platform = Platform;
    }

    public Service(String sid, String outtime, int status) {
        Sid = sid;
        Outtime = outtime;
        Status = status;
    }

    public Service(String sid, int status) {
        Sid = sid;
        Status = status;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        this.Platform = platform;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        this.Sid = sid;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        this.Aid = aid;
    }

    public String getBikeNum() {
        return BikeNum;
    }

    public void setBikeNum(String bikeNum) {
        this.BikeNum = bikeNum;
    }

    public String getIntime() {
        return Intime;
    }

    public void setIntime(String intime) {
        Intime = intime;
    }

    public String getOuttime() {
        return Outtime;
    }

    public void setOuttime(String outtime) {
        this.Outtime = outtime;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }
}
