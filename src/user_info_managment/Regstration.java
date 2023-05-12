package user_info_managment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import DataFiles.File_information;
import DataFiles.OTP;

import javax.mail.MessagingException;

/**
 * this class to register information for new users
 */
public class Regstration
{
    /**
     * default constructor 
     */
    public Regstration(){};
    
//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * check username is valid or not
     * 
     * @param username is the username of the user 
     * @return true if the username is correct otherwise false
     */
    public boolean checkUsername(String username)
    {
        Pattern p = Pattern.compile("(_?[a-z|A-Z]+){1,3}"); 
        if(!p.matcher(username).matches())
        {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("username is invalid , please Enter a valid username in the following format:");
            System.out.println("don't contain spaces and allow only characters and underscores separated by characters"); 
            System.out.println("at most 3 underscores if the username is starting with a underscore");
            System.out.println("and at most 2 underscores if the username isn't starting with underscores");
            System.out.println("----------------------------------------------------------------------------------------");

            return false;
        }

        return true;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * check if email is valid or not
     * 
     * @param email is the email address of the user
     * @return true if the email is valid otherwise false
     */
    public boolean checkEmail(String email)
    {
        Pattern p = Pattern.compile("([a-z|A-Z|0-9|#|%|\\+|!|$|\\-|_|&|\\*]+(\\.{1}[a-z|A-Z|0-9|#|%|\\+|!|$|\\-|_|&|\\*])*)+@{1}([a-z|A-Z|0-9]+(\\-{1}[a-z|A-Z|0-9]+)*)+(.com){1}"); 
        if(!p.matcher(email).matches())
        {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("email is invalid , please enter a valid email address in the following format: ");
            System.out.println("allow characters , numbers and symbols [# , % , + , ! , $ , - , _ , & , * , .] and one of ( @ ) ");
            System.out.println("before ( @ ) it can't end with a dot ");
            System.out.println("after ( @ ) it must be character or numbers only no symbols expect (-) and it cannot end with it ");
            System.out.println("in the end of the email address write (.com)");
            System.out.println("----------------------------------------------------------------------------------------");

            return false;
        }

        return true;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * check if phone number is valid or not
     * 
     * @param phone is the phone number of the user
     * @return true if the phone number is valid otherwise false
     */
    public boolean checkPhone(String phone) 
    {
        Pattern p = Pattern.compile("((011)|(010)|(012)|(015)){1}[0-9]{8}"); 
        while (!p.matcher(phone).matches()) 
        {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("phone is invalid , please enter a valid phone in the following format: ");
            System.out.println("start with one of the following numbers: ");
            System.out.println("(011), (010) , (012) , (015)");
            System.out.println("and another 8 numbers");
            System.out.println("----------------------------------------------------------------------------------------");



        
            return false;
        }

        return true;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    /**
     * check if the password is valid or not
     * 
     * @param password is the password of the user
     * @return true if password is valid otherwise false
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
     * generate an otp
     * 
     * @return OTP 
     */
//    public  int generateOTP()
//    {
//        int randomPin   =(int) (Math.random()*9000);
//        return randomPin;
//    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * check if the otp is valid or not
     * 
     * @param OTP is the real otp
     * @param userInput is otp entered by the user
     * @return true if the otp is valid otherwise false
     */
    public boolean CheckOTP(int OTP , int userInput)
    {
        return OTP==userInput;
    }


//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * check if the email is not used before or not
     * 
     * @param u is the all users in database
     * @param email is email of the address
     * @return true if the email not used before otherwise return false
     */
    public boolean CheckAllEmails(ArrayList<User> u , String email)
    {
        System.out.println("email: " + email);
        for(User user : u){
            if(user.getEmail().equals(email))
            {
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("this email is already used");
                System.out.println("please enter another email address");
                System.out.println("----------------------------------------------------------------------------------------");

                return false;
            }
        }
        return true;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * check all information of the user
     * 
     * @param name is the name of the user
     * @param email is the email of the user
     * @param phone  is the phone number of the user
     * @param password is the password of the user
     * @param location is the location of the user
     * @return User object 
     */
    public User checkAllInformation(String name , String email , String phone , String password , String location) throws MessagingException {
        File_information f = new File_information();
        ArrayList<User> user = f.load();
        Scanner in = new Scanner(System.in);
        while(!checkUsername(name))
        {
            name = in.nextLine();
        }
        
        System.out.println("username is valid");

        while(!checkEmail(email))
        {
            email = in.nextLine();
        }
        while(!CheckAllEmails(user, email))
        {
            email = in.nextLine();
            while(!checkEmail(email))
            {
                email = in.nextLine();
            }
        }
       
        System.out.println("email is valid");

        while(!checkPhone(phone))
        {
            phone = in.nextLine();
        }
       
        System.out.println("phone is valid");

        while(!checkPassword(password))
        {
            password = in.nextLine();
        }
    
        System.out.println("password is valid");
        System.out.println("location is valid");

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

        User u = new User(name , email , password , phone , location , 1);

        
        System.out.println("Account is created");
        if(user.size()==0)
        {
            f.save(u);
            System.out.println("Your ID is 1");
            return u; 

        }

        u.setUserID(user.get(user.size()-1).getUserID()+1);
        f.save(u);
        System.out.println("Your ID is " + u.getUserID());
        return u;
    
    }
}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
