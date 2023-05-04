package user_info_managment;

public abstract class information {
    protected String username;
    protected String email;
    protected String password;
    protected String phone;
    protected String location;
    protected int userID;

    public information(String username, String email, String password, String phone , String location , int userID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.location = location;
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone(){
        return phone;
    }

    public int getUserID(){
        return userID;
    }

    public String getLocation(){
        return location;
    }


    
}
