package lk.ijse.ssms.entity;

public class Invoise {
    private String Ino;
    private String Aid;
    private String BikeNum;
    private String Date;
    private String Total;

    public Invoise(String ino, String aid, String bikeNum, String date, String total) {
        Ino = ino;
        Aid = aid;
        BikeNum = bikeNum;
        Date = date;
        Total = total;
    }

    public String getIno() {
        return Ino;
    }

    public void setIno(String ino) {
        Ino = ino;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

    public String getBikeNum() {
        return BikeNum;
    }

    public void setBikeNum(String bikeNum) {
        BikeNum = bikeNum;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}
