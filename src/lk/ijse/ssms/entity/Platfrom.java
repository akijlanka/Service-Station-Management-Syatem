package lk.ijse.ssms.entity;

public class Platfrom {
    private String Pid;
    private String PlatformNo;
    private String Status;

    public Platfrom(String pid, String platformNo, String status) {
        this.Pid = pid;
        this.PlatformNo = platformNo;
        this.Status = status;
    }

    public Platfrom(String pid, String status) {
        Pid = pid;
        Status = status;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        this.Pid = pid;
    }

    public String getPlatformNo() {
        return PlatformNo;
    }

    public void setPlatformNo(String platformNo) {
        this.PlatformNo = platformNo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
