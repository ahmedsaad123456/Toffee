package user_info_managment;

public class User {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String location;
    private int userID;

    public User(String username, String email, String password, String phone , String location , int userID) {
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
