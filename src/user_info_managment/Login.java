package user_info_managment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import DataFiles.OTP;
import DataFiles.File_information;

import javax.mail.MessagingException;

/**
 * is simple class to login to the system by the user
 */
public class Login 
{
    private String email;
    private String password;

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    /**
      *constructor to initialize object from Login

      @param email is the email address of the user
      @param password is the password of the user 
     */

    public Login(String email, String password)
    {
        this.email = email;
        this.password = password;
    }




//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------

    /**
     * function to search for the email address of the user and password 
     * 
     * @return User object 
      
     */
    public User searchForAccount() throws MessagingException {
        File_information f = new File_information();
        Scanner in = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        User u = new User();
        users = f.load();
        for(User user : users)
        {
            if(user.getEmail().equals(email))
            {
                if(user.getPassword().equals(password))
                {
                    System.out.println("Account is exist");
                    return user;
                }
                else{
                    System.out.println("password is incorrect");
                    System.out.println("if you want to reset password enter 1 otherwise enter any number ");
                    int reset=in.nextInt();
                    if(reset==1)
                    {
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
 
    /**
      *function to generate one time password 
      *
      * @return the one time password
     */
//    public  int generateOTP()
//    {
//        int randomPin   =(int) (Math.random()*9000);
//        return randomPin;
//    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
      *function to check if the otp input by user is similer to the real otp or not
      *
      * @param OTP is the real one time password
      * @param userInput is one time password that is entered by the user
      * @return true if the OTP is equal the userInput else false
     */
    public boolean CheckOTP(int OTP , int userInput)
    {
        return OTP==userInput;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    /**
      *function to check if the password is entered in correctly way 
      * @param password is the password of the user
      * @return true if the password is correct otherwise false
     */
    public boolean checkPassword(String password)
    {
        Pattern p = Pattern.compile("[0-9|a-z|A-Z|!|@|#|$|&|%]{8,16}"); 
        while(!p.matcher(password).matches()) 
        {
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

    /**
      * function to reset password 
      *
      * @param users is the all users in the database
      * @param email is the email of the user that he wants to reset password
      * @return User object after successful reset password
     */
    public User resetpassword(ArrayList<User> users, String email) throws MessagingException {
        File_information f = new File_information();
        Scanner in = new Scanner(System.in);

        OTP num = new OTP();
        int OTP = num.generateOTP();
        num.sendEmail(email);

        System.out.println("Enter your OTP");
        int userInput = in.nextInt();
        while(!CheckOTP(OTP, userInput))
        {
            System.out.println("wrong OTP , please try again");
            userInput = in.nextInt();
        }
        in.nextLine();

        User u = new User();
        System.out.println("correct OTP");
        System.out.println("Enter new password");
        String password = in.nextLine();
        while(!checkPassword(password))
        {
            password = in.nextLine();
        }
        for(User user : users)
        {
            if(user.getEmail().equals(email))
            {
                user.setPassword(password);
                u = user;
            }
        }
        f.saveAllUsers(users);
        return u;
        

    }
    
    
}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
