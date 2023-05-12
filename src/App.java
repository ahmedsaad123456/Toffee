/*


  - if you have an error , go to DataFiles package and in each class change the file path according to your PC -


 
*/

 /*
  
    * Some notes for dealing with the program:
    - make the terminal bigger to see the whole output
    - the registration and login menu will appear every action until enter 4 to exit 
    - first you must register for new account and the program will display the menu for the shopping
    - if you exit the program after the registration you can run again and just log in
    - the shopping the main menu will appear every action until enter 6 to log out
    - in the shopping you can see the catalog and its items
    - you can see your shopping cart if it exists
    - to add items to the shopping cart , you must enter the item id and the quantity
    - if the item is already in the shopping cart , you can increment the quantity only
    - to make order you must have shopping cart 
    - to pay for order you must have order
    

*/






import user_info_managment.*;

import java.util.Scanner;

import ShoppingCart.ShoppingCart;
import ShoppingCart.CartItem;
import ShoppingCart.Order;
import payment.Cash;

import javax.mail.MessagingException;


public class App 
{
    
    
    public static void main(String[] args) throws MessagingException 
    {
        
        int options=0;
        Scanner in = new Scanner(System.in);
        User user = new User();


        while(options!=4)
        {
            boolean isLoggedIn = false;
            System.out.println("choose from the following options :");
            System.out.println("1. Register");
            System.out.println("2. login");
            System.out.println("3. View Catalog");
            System.out.println("4. exit");
            options = in.nextInt();
            in.nextLine();
            if(options==1)
            {
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
            else if(options==2)
            {
                while(true)
                {
                    System.out.println("Enter your email");
                    String loginEmail = in.nextLine();

                    System.out.println("enter your password");
                    String LoginPassword = in.nextLine();

                    Login login = new Login(loginEmail , LoginPassword);

                    user = login.searchForAccount();
                    if(user.getUserID() !=0)
                    {
                        user.print();
                        System.out.println("welcome to your account");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        isLoggedIn=true;
                        break;
                    }
                    else
                    {
                        int again=0;
                        System.out.println("if you want to try again , please enter 1 , else enter 0 or anything ");
                        again = in.nextInt();
                        in.nextLine();
                        if(again!=1)
                        {
                            break;
                        }
                        
                    }

                }
                

            }
            else if (options==3)
            {
                ShoppingCart cart = new ShoppingCart();
                cart.viewCatalog();
            }
            else if (options!=4)
            {
                System.out.println("Please enter correct number");
            }



            if(isLoggedIn)
            {
                ShoppingCart shopcart = new ShoppingCart(user.getUserID());

                int choose=0;
                while(choose!=6)
                {
                    System.out.println("choose from the following options :");
                    System.out.println("1. View Catalog");
                    System.out.println("2. Add items to shopping cart");
                    System.out.println("3. View my shopping cart");
                    System.out.println("4. Make order with shopping cart");
                    System.out.println("5. pay by cash for your order");
                    System.out.println("6. Log out");

                    choose = in.nextInt();
                    in.nextLine();

                    if(choose==1)
                    {
                        shopcart.viewCatalog();
                    }
                    else if (choose==2)
                    {
                        int exit = 0;
                        while(exit!=1)
                        {
                            int itemID=0 , quantity = 0;
                            System.out.println("Enter item ID:");
                            itemID = in.nextInt();
                            in.nextLine();
                            System.out.println("Enter quantity:");
                            quantity = in.nextInt();
                            in.nextLine();
                            CartItem cart = shopcart.searchItem(itemID, quantity);
                            shopcart.addItem(cart);
                            System.out.println("if you want to exit form shopping cart enter 1 , if you want to add new item enter any number expect 1");
                            exit = in.nextInt();
                            in.nextLine();

                        }
                        
                    }
                    else if (choose==3)
                    {
                        shopcart.showMyShoppingCart(user.getUserID());
                    }
                    else if (choose==4)
                    {
                        Order order = new Order(user.getUserID());
                        order.makeOrder();
                    }
                    else if (choose==5)
                    {
                        Cash cash = new Cash(user.getLocation() , user.getPhone());
                        cash.pay(user.getUserID());

                    }

                }
            }

        }

        
        
    }
}
