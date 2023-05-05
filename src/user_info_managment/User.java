package user_info_managment;

public class User {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String location;
    private int userID;

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public User(){
        username = null;
        email = null;
        password = null;
        phone = null;
        location = null;
        userID = 0;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public User(String username, String email, String password, String phone , String location , int userID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.location = location;
        this.userID = userID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public String getUsername() {
        return username;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public String getEmail() {
        return email;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public String getPassword() {
        return password;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public String getPhone(){
        return phone;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public int getUserID(){
        return userID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public String getLocation(){
        return location;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 


    public void setPassword(String password) {
        this.password = password;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public void setUserID(int userID) {
        this.userID = userID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public void print(){
        System.out.println("User name: " + username+ " ,email: "+ email + " ,User ID: " + userID + " ,Password: " + password + " ,Phone: " + phone + " ,location: " + location);
    }


    
}
