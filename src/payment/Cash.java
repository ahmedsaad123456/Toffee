package payment;

import java.util.ArrayList;
import java.util.Scanner;

import DataFiles.FileOrder;
import DataFiles.FileShoppingCart;
import ShoppingCart.Order;
import ShoppingCart.ShoppingCart;



public class Cash extends payment {
    private String location;
    private String phone;

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  

    public Cash(){
        super();
        location="undefined";
        phone="undefined";
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  

    public Cash(String location , double price , String phone){
        super(price);
        this.location=location;
        this.phone=phone;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    public Cash(String location , String phone){
        super(0);
        this.location=location;
        this.phone=phone;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  

    public String getLocation() {
        return location;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    
    public void setLocation(String location) {
        this.location = location;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    public int getOrder(ArrayList<Order> orderList , int userid){
        for(int i=0; i<orderList.size(); i++){
            if(orderList.get(i).getUserID()==userid){
                if(orderList.get(i).getStatus().equals("Open")){
                    return i;
                }
            }
        }

        return -1;

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
 
public int getShoppingCart(ArrayList<ShoppingCart> cartList , int userId) {
    for(int i = 0; i < cartList.size(); i++) {
        if(cartList.get(i).getUserID()==userId) {
            return i;
        }
    }
    return -1;
}
    
//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    @Override
    public void pay(int userid){
        FileOrder order = new FileOrder();
        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList = order.load();
        int haveOrder = getOrder(orderList, userid);
        if(haveOrder==-1){
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("you don't have order to pay for it");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            Order userOrder = orderList.get(haveOrder);
            this.price = userOrder.getTotalPrice();
            System.out.println("the total price of the order is " + userOrder.getTotalPrice());
            System.out.println("Do you want to pay for this order? (y/n)");
            Scanner input = new Scanner(System.in);
            char choice = input.next().charAt(0);
            input.nextLine();
            if(choice == 'y'){
                System.out.println("your location is "+ location);
                System.out.println("Do you want to take the order in this location? (y/n)");
                choice = input.next().charAt(0);
                input.nextLine();
                if(choice == 'n'){
                    System.out.println("enter the new location : ");
                    this.location = input.nextLine();
                }
                System.out.println("verify the phone number : " + phone);
                int OTP = generateOTP();
                System.out.println("Your OTP is: " + OTP);
                System.out.println("Enter your OTP");
                int userInput = input.nextInt();
                while(!CheckOTP(OTP, userInput)){
                    System.out.println("wrong OTP , please try again");
                    userInput = input.nextInt();
                }
                System.out.println("the phone number is verified ");
                orderList.get(haveOrder).setStatus("Closed");
                System.out.println("the order now is closed");
                order.saveAllOrders(orderList);
                FileShoppingCart cart = new FileShoppingCart();
                ArrayList<ShoppingCart> cartList = cart.load();
                int found = getShoppingCart(cartList, orderList.get(haveOrder).getUserID());
                cartList.remove(found);
                cart.saveAllShoppingCart(cartList);
            }
        }
        
    }
   
}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
