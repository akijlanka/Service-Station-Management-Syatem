package lk.ijse.ssms.entity;

public class Item {
    private String Itemid;
    private String Name;
    private String Brand;
    private double price;

    public Item(String itemid, String name, String brand, double price) {
        this.Itemid = itemid;
        this.Name = name;
        this.Brand = brand;
        this.price = price;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        Itemid = itemid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
