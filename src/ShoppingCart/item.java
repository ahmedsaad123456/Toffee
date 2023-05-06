package ShoppingCart;

public class Item {
    Item(int itemID,String itemName, double itemPrice, int itemAvailableAmount, double itemDiscount){
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAvailableAmount = itemAvailableAmount;
        this.itemDiscount = itemDiscount;
    }
    private int itemID;
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    private String itemName;
    public String getItemName() {
        return itemName;
    }

    private double itemPrice;
    public double getItemPrice() {
        return itemPrice;
    }

    private int itemAvailableAmount;
    public int getItemAvailableAmount() {
        return itemAvailableAmount;
    }
    public void setItemAvailableAmount(int itemAvailableAmount) {
        this.itemAvailableAmount = itemAvailableAmount;
    }
    private double itemDiscount;
    public double getItemDiscount() {
        return itemDiscount;
    }

}
