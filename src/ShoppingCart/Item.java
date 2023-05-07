package ShoppingCart;

public class Item {

    private int itemID;
    private String itemName;
    private double itemPrice;
    private int itemAvailableAmount;
    private double itemDiscount;


//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public Item(int itemID,String itemName, double itemPrice, int itemAvailableAmount, double itemDiscount){
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAvailableAmount = itemAvailableAmount;
        this.itemDiscount = itemDiscount;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public int getItemID() {
        return itemID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public String getItemName() {
        return itemName;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public double getItemPrice() {
        return itemPrice;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 

    public int getItemAvailableAmount() {
        return itemAvailableAmount;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public void setItemAvailableAmount(int itemAvailableAmount) {
        this.itemAvailableAmount = itemAvailableAmount;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    public double getItemDiscount() {
        return itemDiscount;
    }

}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
