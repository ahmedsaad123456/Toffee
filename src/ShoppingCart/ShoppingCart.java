package ShoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

import DataFiles.FileItem;
import DataFiles.FileShoppingCart;
/**
 * class that represents the information about a shopping cart
 */
public class ShoppingCart 
{
    private int userID;
    private int numberOfItems;
    private ArrayList<CartItem> items = new ArrayList<>();


//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * default constructor to initialize the shopping cart object
     */
    public ShoppingCart()
    {
        userID=0;
        numberOfItems=0;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * constructor to initialize the shopping cart
     * 
     * @param userID is the user identifier 
     */
    public ShoppingCart(int userID) 
    {
        
        this.userID = userID;
        numberOfItems = 0;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * constructor to initialize the shopping cart
     * 
     * @param userID is the user identifier 
     * @param numberOfItems is the number of items in the cart
     * @param items is the list of items in the cart
     */
    public ShoppingCart(int userID , int numberOfItems, ArrayList<CartItem> items) 
    {
        
        this.userID = userID;
        this.numberOfItems = numberOfItems;
        this.items =items;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    /**
     * getter to get user id
     * 
     * @return user ID
     */
    public int getUserID() 
    {
        return userID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    /**
     * getter to get number of items 
     * 
     * @return number of items in the cart
     */
    public int getNumberOfItems() 
    {
        return numberOfItems;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    /**
     * getter to get the list of items
     * 
     * @return the list of items in the cart
     */
    public ArrayList<CartItem> getItems() 
    {
        return items;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * setter for the list of items
     * 
     * @param items is the list of items in the cart
     */
    public void setItems(ArrayList<CartItem> items) 
    {
        this.items = items;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * setter of the number of items 
     * 
     * @param numberOfItems is the number of the items in th cart
     */
    public void setNumberOfItems(int numberOfItems) 
    {
        this.numberOfItems = numberOfItems;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the total price 
     * 
     * @return the total price of the items in the shopping cart
     */
    public double getTotalPrice() 
    {
        double totalPrice = 0;
        for (int i = 0; i < items.size(); i++) 
        {
            totalPrice += (items.get(i).getItemPrice() - items.get(i).getItemDiscount()) * items.get(i).getCartItemQuantity();
        }
        return totalPrice;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * search for item using item id and quantity
     * 
     * @param itemID is the item identifier
     * @param quantity is the quantity of the item
     * @return cart item object if the quantity is available and the item is exist otherwise null
     */
    public CartItem searchItem(int itemID, int quantity) 
    {
        FileItem itemFile = new FileItem();
        ArrayList<Item> itemsArray = itemFile.load();
        for (int i = 0; i < itemsArray.size(); i++) 
        {
            if (itemsArray.get(i).getItemID() == itemID) 
            {
                if (itemsArray.get(i).getItemAvailableAmount() >= quantity) 
                {
                    int itemAvailableAmount = itemsArray.get(i).getItemAvailableAmount() - quantity;
                    itemsArray.get(i).setItemAvailableAmount(itemAvailableAmount);
                    itemFile.saveAmount(itemsArray);
                    CartItem cartItem = new CartItem(itemsArray.get(i).getItemID(), itemsArray.get(i).getItemName(), itemsArray.get(i).getItemPrice(), itemsArray.get(i).getItemAvailableAmount(), itemsArray.get(i).getItemDiscount(), quantity);
                    return cartItem;
                }
                else 
                {
                    System.out.println("Sorry, the quantity you entered is not available");
                    return null;
                }
            }
        }
        System.out.println("Sorry, the item you entered is not available");
        return null;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter shopping cart for the user id
     * 
     * @param cartList is the list of cart items in database
     * @param userId is the user id
     * @return number of index of the shopping cart of the user otherwise -1
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
     * add item to shopping cart
     * 
     * @param item is the item that is added to shopping cart
     */
    public void addItem(CartItem item) 
    {
        FileShoppingCart cart = new FileShoppingCart();
        ArrayList<ShoppingCart> cartList = cart.load();
        int found = getShoppingCart(cartList, userID);
        if(found!=-1) 
        {
            items = cartList.get(found).getItems();
        }
        if (item != null) 
        {
            for(int i = 0; i < items.size(); i++)
            {
                if(items.get(i).getItemID() == item.getItemID())
                {
                    System.out.println("This item is already in your cart\n Do you want to increase the quantity of this item? (y/n)");
                    Scanner input = new Scanner(System.in);
                    char choice = input.next().charAt(0);
                        if(choice == 'y')
                        {
                            items.get(i).setCartItemQuantity(items.get(i).getCartItemQuantity() + item.getCartItemQuantity());
                            items.get(i).setTotalPrice((items.get(i).getItemPrice()- items.get(i).getItemDiscount()) * items.get(i).getCartItemQuantity());
                            cartList.get(found).setItems(items);
                            cart.saveAllShoppingCart(cartList);
                            return;
                        }
                        else
                        {
                            return;
                        }
                }
            }
            items.add(item);
            if(found==-1)
            {
                numberOfItems++;
                cartList.add(this);
            }
            else
            {
                cartList.get(found).setItems(items);
                cartList.get(found).setNumberOfItems(items.size());
            }



            cart.saveAllShoppingCart(cartList);


            
        }
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * show the shopping cart
     * 
     * @param id is the id of the user
     */
    public void showMyShoppingCart(int id)
    {
        FileShoppingCart cart = new FileShoppingCart();
        ArrayList<ShoppingCart> cartList = cart.load();
        int found = getShoppingCart(cartList, id);
        if(found==-1)
        {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("you don't have the shopping cart");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        }
        else
        {
            cartList.get(found).print();
        }


    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * prints the shopping cart
     */
    public void print()
    {
        System.out.println("your ID is " +userID);
        System.out.println("number of items is " +numberOfItems);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        for(CartItem c : items)
        {
            c.print();
        }

    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * view catalog
     */
    public void viewCatalog() 
    {
        FileItem itemFile = new FileItem();
        ArrayList<Item> items = itemFile.load();
        for (int i = 0; i < items.size(); i++) 
        {
            System.out.println("itemID: " + items.get(i).getItemID() + "\nitemName: " + items.get(i).getItemName() + "\nitemPrice: $" + items.get(i).getItemPrice() + "\nitemAvailableAmount: " + items.get(i).getItemAvailableAmount() + " pieces" + "\nitemDiscount: $" + items.get(i).getItemDiscount());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        }
    }

}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
