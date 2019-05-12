package lk.ijse.ssms.model;

public class BikeDTO {

    private String Bid;
    private String BikeNum;
    private String Cusname;
    private int TpNum;
    private String Model;


    public BikeDTO(String bid, String bikeNum, String cusname, int tpNum, String model) {
        this.Bid = bid;
        this.BikeNum = bikeNum;
        this.Cusname = cusname;
        this.TpNum = tpNum;
        this.Model = model;
    }

    public BikeDTO(String bid) {
        this.Bid = bid;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        this.Bid = bid;
    }

    public String getBikeNum() {
        return BikeNum;
    }

    public void setBikeNum(String bikeNum) {
        this.BikeNum = bikeNum;
    }

    public String getCusname() {
        return Cusname;
    }

    public void setCusname(String cusname) {
        this.Cusname = cusname;
    }

    public int getTpNum() {
        return TpNum;
    }

    public void setTpNum(int tpNum) {
        this.TpNum = tpNum;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }
}
