package entities;

public class User {
    private int id;
    private String userName;
    private String password;
    private String hashedPassword;
    private int role_id;


    public User()
    {

    }

    public User(String userName,String password, String hasedPassword) {
        this.userName = userName;
        this.password = password;
        this.hashedPassword=hasedPassword;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hasedPassword) {
        this.hashedPassword = hasedPassword;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}