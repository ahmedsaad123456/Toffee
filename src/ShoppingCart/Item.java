package ShoppingCart;
/**
 * class that stores information about a item
 */
public class Item 
{

    private int itemID;
    private String itemName;
    private double itemPrice;
    private int itemAvailableAmount;
    private double itemDiscount;


//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * constructor for initializing the item object
     * 
     * @param itemID is the item identifier 
     * @param itemName is the item name 
     * @param itemPrice is the item price
     * @param itemAvailableAmount is the item available amount in the store
     * @param itemDiscount is the item discount amount of the item
     */
    public Item(int itemID,String itemName, double itemPrice, int itemAvailableAmount, double itemDiscount)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAvailableAmount = itemAvailableAmount;
        this.itemDiscount = itemDiscount;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the item identifier
     * 
     * @return item ID
     */
    public int getItemID() 
    {
        return itemID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * setter for the item identifier
     * 
     * @param itemID is the item ID
     */
    public void setItemID(int itemID) 
    {
        this.itemID = itemID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the item name
     * 
     * @return item name
     */
    public String getItemName() 
    {
        return itemName;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the item price
     * 
     * @return item price
     */
    public double getItemPrice() 
    {
        return itemPrice;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * getter for the item avaliable amount
     * 
     * @return the item available amount in the store
     */
    public int getItemAvailableAmount() 
    {
        return itemAvailableAmount;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * setter for the item avaliable amount 
     * 
     * @param itemAvailableAmount is the item available amount in the store
     */
    public void setItemAvailableAmount(int itemAvailableAmount) 
    {
        this.itemAvailableAmount = itemAvailableAmount;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * getter for the discount
     * 
     * @return the discount in item price
     */
    public double getItemDiscount() 
    {
        return itemDiscount;
    }

}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
