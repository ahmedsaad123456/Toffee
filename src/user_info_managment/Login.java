package user_info_managment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Login {
    private String email;
    private String password;

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    
    public User searchForAccount(){
        File_information f = new File_information();
        Scanner in = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        User u = new User();
        users = f.load();
        for(User user : users){
            if(user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    System.out.println("Account is exist");
                    return user;
                }
                else{
                    System.out.println("password is incorrect");
                    System.out.println("if you want to reset password enter 1 else enter 0 or anything ");
                    int reset=in.nextInt();
                    if(reset==1){
                        return resetpassword(users , email);
                    }

                    return u;
                }

            }
        }
        System.out.println("Account is not exist");
        return u;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public  int generateOTP() 
    {  
        int randomPin   =(int) (Math.random()*9000);
        return randomPin; 
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public boolean CheckOTP(int OTP , int userInput){
        return OTP==userInput;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public boolean checkPassword(String password){
        Pattern p = Pattern.compile("[0-9|a-z|A-Z|!|@|#|$|&|%]{8,16}"); 
        while(!p.matcher(password).matches()) {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("password is invalid , please enter a valid password in the following format: ");
            System.out.println("characters and numbers are allowed and this symbols: ");
            System.out.println("(! , @ , # , $ , & , %)");
            System.out.println("password must be in range 8-16");
            System.out.println("----------------------------------------------------------------------------------------");

            return false;
        }
        return true;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public User resetpassword(ArrayList<User> users, String email){
        File_information f = new File_information();
        Scanner in = new Scanner(System.in);
        int OTP = generateOTP();
        System.out.println("Your OTP is: " + OTP);
        System.out.println("Enter your OTP");
        int userInput = in.nextInt();
        while(!CheckOTP(OTP, userInput)){
            System.out.println("wrong OTP , please try again");
            userInput = in.nextInt();
        }
        in.nextLine();

        User u = new User();
        System.out.println("correct OTP");
        System.out.println("Enter new password");
        String password = in.nextLine();
        while(!checkPassword(password)){
            password = in.nextLine();
        }
        for(User user : users){
            if(user.getEmail().equals(email)){
                user.setPassword(password);
                u = user;
            }
        }
        f.saveAllUsers(users);
        return u;
        

    }
    
    
}
