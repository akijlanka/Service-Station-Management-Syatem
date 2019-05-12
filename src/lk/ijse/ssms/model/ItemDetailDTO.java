package lk.ijse.ssms.model;

public class ItemDetailDTO {
    private String Sid;
    private String Itemid;
    private int Qty;
    private double Total;
    private String Itemname;

    public ItemDetailDTO(String sid, String itemid, int qty, double total, String itemname) {
        Sid = sid;
        Itemid = itemid;
        Qty = qty;
        Total = total;
        Itemname = itemname;
    }

    public ItemDetailDTO(String itemid, int qty, double total, String itemname) {
        Itemid = itemid;
        Qty = qty;
        Total = total;
        Itemname = itemname;
    }

    public ItemDetailDTO(double total) {
        Total = total;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        Itemid = itemid;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String itemname) {
        Itemname = itemname;
    }
}
