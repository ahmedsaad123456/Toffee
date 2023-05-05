import user_info_managment.*;
import payment.*;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

import ShoppingCart.*;

public class App {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available. Exiting...");
            System.exit(1);
        }
        Regstration r = new Regstration();
        Scanner in = new Scanner(System.in);
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
       
    }
}
