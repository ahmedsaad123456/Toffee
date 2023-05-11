package ShoppingCart;

/**
 * class that stores the information about a cart item
 */
public class CartItem extends Item{

    private int cartItemQuantity;
    private double TotalPrice;

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * constructor for intializing a cart item
     * 
     * @param itemID is the item identifier 
     * @param itemName is the item name 
     * @param itemPrice is the item price
     * @param itemAvailableAmount is the amount available in the store
     * @param itemDiscount is the amount discount of the item
     * @param cartItemQuantity is the quantity of the cart item
     */
    public CartItem(int itemID,String itemName, double itemPrice, int itemAvailableAmount, double itemDiscount, int cartItemQuantity)
    {
        super(itemID, itemName, itemPrice, itemAvailableAmount, itemDiscount);
        this.cartItemQuantity = cartItemQuantity;
        this.TotalPrice = (itemPrice - itemDiscount) * cartItemQuantity;
    }
   
//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the quantity of the cart item
     * 
     * @return quantity of the cart item
     */
    public int getCartItemQuantity() 
    {
        return cartItemQuantity;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * setter for the quantity
     * 
     * @param quantity is the quantity of the cart item
     */
    public void setCartItemQuantity(int quantity) 
    {
        this.cartItemQuantity = quantity;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    
    /**
     * setter for the total price 
     * 
     * @param totalPrice is the total price of the amount of the cart item
     */
    public void setTotalPrice(double totalPrice) 
    {
        TotalPrice = totalPrice;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the total price
     * 
     * @return the total price 
     */
    public double getTotalPrice() 
    {
        return TotalPrice;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * print all information about the cart item 
     */
    public void print()
    {
        System.out.println("itemID: " + getItemID() + "\nitemName: " + getItemName() +"\nquantatiy: "+cartItemQuantity+" pieces "+ "\nitemPrice for one piece: $" + getItemPrice() + "\nitemDiscount for one piece: $" + getItemDiscount() +"\ntotal price: $"+ TotalPrice);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");


    }
}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 