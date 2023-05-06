import user_info_managment.*;
import payment.*;

import java.util.Scanner;

import ShoppingCart.*;

public class App {
    public static void main(String[] args) {
        int options=0;
        Scanner in = new Scanner(System.in);
        User user = new User();


        while(options!=3){
            boolean isLoggedIn = false;
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
                user =r.checkAllInformation(username, email , phone , password , location);
                System.out.println("welcome to your account");
                user.print();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                isLoggedIn= true;

            }
            else if(options==2){
                while(true){
                    System.out.println("Enter your email");
                    String loginEmail = in.nextLine();

                    System.out.println("enter your password");
                    String LoginPassword = in.nextLine();

                    Login login = new Login(loginEmail , LoginPassword);

                    user = login.searchForAccount();
                    if(user.getUserID() !=0){
                        user.print();
                        System.out.println("welcome to your account");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        isLoggedIn=true;
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



            if(isLoggedIn){
                int choose=0;
                while(choose!=5){
                    System.out.println("choose from the following options :");
                    System.out.println("1. View Catalog");
                    System.out.println("2. Add items to shopping cart");
                    System.out.println("3. Make order with shopping cart");
                    System.out.println("4. pay by cash for your order");
                    System.out.println("5. Log out");

                    choose = in.nextInt();
                    in.nextLine();

                    if(choose==1){
                        ShoppingCart cart = new ShoppingCart(user.getUserID());
                        cart.viewCatalog();
                    }
                    else if (choose==2){
                        int exit = 0;
                        while(exit!=1){
                            int itemID=0 , quantity = 0;
                            System.out.println("Enter item ID:");
                            itemID = in.nextInt();
                            in.nextLine();
                            System.out.println("Enter quantity:");
                            quantity = in.nextInt();
                            in.nextLine();
                            ShoppingCart shopCart = new ShoppingCart(user.getUserID());
                            CartItem cart = shopCart.searchItem(itemID, quantity);
                            shopCart.addItem(cart);
                            System.out.println("if you want to exit form shopping cart enter 1 , if you want to add new item enter any number expect 1");
                            exit = in.nextInt();
                            in.nextLine();

                        }
                        

                    }

                }
            }






        }

        
        
    }
}
