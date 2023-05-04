package user_info_managment;

public class User extends information {
    public User (String username, String email, String password, String phone , String location , int userID){
        super(username, email, password, phone, location, userID);
    }
    
   

    public void print(){
        System.out.println(username);
    }
    
}
