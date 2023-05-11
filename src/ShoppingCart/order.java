package ShoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

import DataFiles.FileOrder;
import DataFiles.FileShoppingCart;
/**
 * class that represents the order
 */
public class Order 
{
    private int orderID;
    private int userID;
    private double totalPrice;
    private ShoppingCart cart;
    private String status;

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * constructor to initialize the order object
     * 
     * @param orderID  is the order identifier
     * @param cart is the shopping cart
     */
    public Order(int orderID, ShoppingCart cart)
    {
        this.orderID = orderID;
        this.userID = cart.getUserID();
        this.totalPrice = cart.getTotalPrice();
        this.cart = cart;
        this.status = "Open";
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * constractor to initialize the order object
     * 
     * @param id is the user identifier
     */
    public Order(int id)
    {
        this.orderID = 0;
        this.userID = id;
        this.totalPrice = 0;
        this.status = "Open";

    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * constructor to initalize the order object
     * 
     * @param orderID is the order id
     * @param userID is the user id
     * @param status is the status o the order request
     * @param totalPrice is the total price of the order
     */
    public Order(int orderID , int userID, String status , double totalPrice)
    {
        this.orderID = orderID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.status = status;
    } 

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the order id
     * 
     * @return order id
     */
    public int getOrderID() 
    {
        return orderID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the user id 
     * 
     * @return user id
     */
    public int getUserID() 
    {
        return userID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the total price
     * 
     * @return total price of order
     */
    public double getTotalPrice() 
    {
        return totalPrice;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the shopping cart
     * 
     * @return the shopping cart
     */
    public ShoppingCart getShoppingCart() 
    {
        return cart;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter  for the status of the order
     * 
     * @return the status of the order
     */
    public String getStatus() 
    {
        return status;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * setter for the order id
     * 
     * @param orderID is the order id
     */
    public void setOrderID(int orderID) 
    {
        this.orderID = orderID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * setter for the total price
     * 
     * @param totalPrice is the total price of the order
     */
    public void setTotalPrice(double totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * setter for the status of the order
     * 
     * @param status is the status of the order
     */
    public void setStatus(String status) 
    {
        this.status = status;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * setter for the shopping cart
     * 
     * @param cart is the shopping cart
     */
    public void setCart(ShoppingCart cart) 
    {
        this.cart = cart;
        this.userID = cart.getUserID();
        this.totalPrice = cart.getTotalPrice();
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * get the shopping cart for the user id
     * 
     * @param cartList is the all shopping cart in the database
     * @param userId is the user id
     * @return the index of the shopping cart of the user if exist otherwise -1
     */
    public int getShoppingCart(ArrayList<ShoppingCart> cartList , int userId) 
    {
        for(int i = 0; i < cartList.size(); i++) 
        {
            if(cartList.get(i).getUserID()==userId) 
            {
                return i;
            }
        }
        return -1;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * get order for the user id
     * 
     * @param userId is the user id of the user
     * @return -2 if no shpping cart in database and -1 if the user already have order otherwise the last order id +1
     */
    public int getOrder(int userId)
    {
        FileOrder orderFile = new FileOrder();
        ArrayList<Order> orderList = orderFile.load();
        if(orderList.size()==0)
        {
            return -2;
        }
        else{
            for(Order order : orderList)
            {
                if(order.getUserID()==userId)
                {
                    if(order.getStatus().equals("Closed"))
                    {
                        continue;
                    }
                    else
                    {
                        return -1;
                    }
                }
            }
        }
        return (orderList.get(orderList.size()-1).getOrderID() +1);

    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * make order for the given user
     */
    public void makeOrder()
    {
        int haveOrder = getOrder(userID);
        if(haveOrder==-1)
        {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("your order has already open , please pay for it to make new order");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");

            return;
        }
        else if(haveOrder==-2)
        {
            this.orderID = 1;
        }else
        {
            this.orderID = haveOrder;
        }
        FileShoppingCart cart = new FileShoppingCart();
        ArrayList<ShoppingCart> cartList = cart.load();
        int found = getShoppingCart(cartList, userID);        
        if(found==-1) 
        {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("you don't have the shopping cart to make order");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");

            return;
        }
        else
        {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("the inforamtion of your shopping cart :");
            cartList.get(found).print();
            setCart(cartList.get(found));
            System.out.println("do you want to make order for your shopping cart? (y/n) ");
            Scanner input = new Scanner(System.in);
            char choice = input.next().charAt(0);
            if(choice=='y')
            {
                FileOrder orderFile = new FileOrder();
                orderFile.save(this);
                System.out.println("oredr done!!");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            }
        }
        

    }
}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 