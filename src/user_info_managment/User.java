package user_info_managment;
/**
 * is the class that represents all information about the user
 */
public class User 
{
    private String username;
    private String email;
    private String password;
    private String phone;
    private String location;
    private int userID;

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * default constructor to initialize the User object 
     */
    public User()
    {
        username = null;
        email = null;
        password = null;
        phone = null;
        location = null;
        userID = 0;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * constructor to initialize the User object
     * 
     * @param username is the username of the user 
     * @param email is the email of the user
     * @param password is the password of the user
     * @param phone is the phone of the user
     * @param location is the location of the user
     * @param userID is the user ID of the user
     */
    public User(String username, String email, String password, String phone , String location , int userID) 
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.location = location;
        this.userID = userID;
    }



//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the username
     * 
     * @return username 
     */
    public String getUsername() 
    {
        return username;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the email
     * 
     * @return email
     */
    public String getEmail() 
    {
        return email;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the password
     * 
     * @return password 
     */
    public String getPassword() 
    {
        return password;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the phone number
     * 
     * @return phone number
     */
    public String getPhone()
    {
        return phone;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the user id 
     * 
     * @return user ID
     */
    public int getUserID()
    {
        return userID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the location
     * 
     * @return location
     */
    public String getLocation()
    {
        return location;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    /**
     * setter for the password
     * 
     * @param password is the password of the user
     */
    public void setPassword(String password) 
    {
        this.password = password;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * setter for the user ID
     * 
     * @param userID is the user ID 
     */
    public void setUserID(int userID) 
    {
        this.userID = userID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * function to print all information of the user
     */
    public void print()
    {
        System.out.println("User name: " + username+ " ,email: "+ email + " ,User ID: " + userID + " ,Password: " + password + " ,Phone: " + phone + " ,location: " + location);
    }
    
}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
