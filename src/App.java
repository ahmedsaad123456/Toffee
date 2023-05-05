import user_info_managment.*;
import payment.*;

import java.io.Console;
import java.util.Scanner;

import ShoppingCart.*;

public class App {
    public static void main(String[] args) {
        int options=0;
        Scanner in = new Scanner(System.in);


        while(options!=3){
            System.out.println("choose from the following options :");
            System.out.println("1. Register");
            System.out.println("2. login");
            System.out.println("3. exit");
            options = in.nextInt();
            in.nextLine();
            if(options==1){
                Regstration r = new Regstration();
                System.out.println("Enter your username");
                String username = in.nextLine();
                System.out.println("Enter your email");
                String email = in.nextLine();
                System.out.println("enter your phone");
                String phone = in.nextLine();
                System.out.println("enter your password");
                String password = in.nextLine();
                System.out.println("enter your location");
                String location = in.nextLine();
                User u =r.checkAllInformation(username, email , phone , password , location);
                u.print();

            }
            else if(options==2){
                while(true){
                    System.out.println("Enter your email");
                    String loginEmail = in.nextLine();

                    System.out.println("enter your password");
                    String LoginPassword = in.nextLine();

                    Login login = new Login(loginEmail , LoginPassword);

                    User u1 = login.searchForAccount();
                    if(u1.getUserID() !=0){
                        u1.print();
                        System.out.println("welcome to your account");
                        break;
                    }
                    else{
                        int again=0;
                        System.out.println("if you want to try again , please enter 1 , else enter 0 or anything ");
                        again = in.nextInt();
                        in.nextLine();
                        if(again!=1){
                            break;
                        }
                        
                    }

                }
                

            }
            else if (options!=3){
                System.out.println("Please enter correct number");
            }

        }

        
        
    }
}
