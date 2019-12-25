package Dao;

public class User {
    private String username,password,email,gender,time_register;
    private  Boolean isBoss=false;

    public String getGender() {
        return gender;
    }

    public User(String username, String password, String email, String gender, String time_register) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.time_register = time_register;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", time_register='" + time_register + '\'' +
                ", isBoss=" + isBoss +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTime_register() {
        return time_register;
    }

    public void setTime_register(String time_register) {
        this.time_register = time_register;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getBoss() {
        return isBoss;
    }

    public void setBoss(Boolean boss) {
        isBoss = boss;
    }
}
