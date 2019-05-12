package lk.ijse.ssms.entity;

public class Model {
    private String Mcode;
    private String Mname;
    private String MBrand;
    private String Capacity;

    public Model(String mcode, String mname, String MBrand, String capacity) {
        this.Mcode = mcode;
        this.Mname = mname;
        this.MBrand = MBrand;
        this.Capacity = capacity;
    }

    public String getMcode() {
        return Mcode;
    }

    public void setMcode(String mcode) {
        this.Mcode = mcode;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        this.Mname = mname;
    }

    public String getMBrand() {
        return MBrand;
    }

    public void setMBrand(String MBrand) {
        this.MBrand = MBrand;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        this.Capacity = capacity;
    }
}