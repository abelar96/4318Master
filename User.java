import java.io.Serializable;

public class User implements Serializable {

    private String fname;
    private String lname;


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public User() {
    }
}
