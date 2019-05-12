package lk.ijse.ssms.model;

public class AppDetailDTO {
    private String Bid;
    private String Aid;
    private String Date;
    private String Mils;

    public AppDetailDTO(String bid, String aid, String date, String mils) {
        Bid = bid;
        Aid = aid;
        Date = date;
        Mils = mils;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMils() {
        return Mils;
    }

    public void setMils(String mils) {
        Mils = mils;
    }
}
