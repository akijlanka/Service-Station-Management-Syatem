package lk.ijse.ssms.model;

public class CommenDTO {
    private String Name;
    private String Itemid;
    private double price;
    private int Qty;
    private double Total;

    public CommenDTO(String name, String itemid, double price, int qty, double total) {
        Name = name;
        Itemid = itemid;
        this.price = price;
        Qty = qty;
        Total = total;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        Itemid = itemid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}
