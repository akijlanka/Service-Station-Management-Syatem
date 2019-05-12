package lk.ijse.ssms.entity;

public class User {
    private String Userid;
    private String Uname;
    private String Position;
    private String Email;
    private String Username;
    private String Upassword;

    public User(String userid, String uname, String position, String email, String username, String upassword) {
        this.Userid = userid;
        this.Uname = uname;
        this.Position = position;
        this.Email = email;
        this.Username = username;
        this.Upassword = upassword;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        this.Userid = userid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        this.Uname = uname;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        this.Upassword = upassword;
    }
}
