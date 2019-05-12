package lk.ijse.ssms.model;

import java.util.ArrayList;

public class ServiceDTO {

    private String Sid;
    private String Aid;
    private String BikeNum;
    private String Intime;
    private String Outtime;
    private int Status;
    private String Platform;
    private ArrayList<EmpDetailDTO> allempdetails=new ArrayList<>();

    public ArrayList<EmpDetailDTO> getAllempdetails() {
        return allempdetails;
    }

    public void setAllempdetails(ArrayList<EmpDetailDTO> allempdetails) {
        this.allempdetails = allempdetails;
    }

    public ServiceDTO(String sid, String aid, String bikeNum, String intime, String outtime, int status, String platform, ArrayList<EmpDetailDTO> allempdetails) {
        Sid = sid;
        Aid = aid;
        BikeNum = bikeNum;
        Intime = intime;
        Outtime = outtime;
        Status = status;
        Platform = platform;
        this.allempdetails = allempdetails;
    }

    public ServiceDTO(String sid, String aid, String bikeNum, String intime, String outtime, int status, String platform) {
        Sid = sid;
        Aid = aid;
        BikeNum = bikeNum;
        Intime = intime;
        Outtime = outtime;
        Status = status;
        Platform = platform;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
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
        this.Intime = intime;
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
