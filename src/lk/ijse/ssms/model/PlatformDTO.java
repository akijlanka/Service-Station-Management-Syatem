package lk.ijse.ssms.model;

public class PlatformDTO {

    private String Pid;
    private String PlatformNo;
    private String Status;

    public PlatformDTO(String pid, String platformNo, String status) {
        this.Pid = pid;
        this.PlatformNo = platformNo;
        this.Status = status;
    }

    public PlatformDTO(String pid) {
        Pid = pid;
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
