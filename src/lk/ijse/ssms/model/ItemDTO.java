package lk.ijse.ssms.model;

public class ItemDTO {
    private String Itemid;
    private String Name;
    private String Brand;
    private double price;

    public ItemDTO(String itemid, String name, String brand, double price) {
        this.Itemid = itemid;
        this.Name = name;
        this.Brand = brand;
        this.price = price;
    }

    public ItemDTO(String itemid) {
        Itemid = itemid;
    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        this.Itemid = itemid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
