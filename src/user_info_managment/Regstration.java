package user_info_managment;

public class Regstration extends information{
    public Regstration(String username, String email, String password, String phone , String location , int userID){
        super(username, email, password, phone, location, userID);
    }


    public void print(){
        System.out.println(email);
    }

    public boolean checkUsername(){
        return true;
    }

    public boolean checkEmail(){
        return false;
    }

    public boolean checkPhone(){
        return false;
    }

    public boolean checkUserID(){
        return false;
    }

    public boolean checkPassword(){
        return false;
    }
}
