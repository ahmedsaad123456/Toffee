package ShoppingCart;
import java.String;
import java.io.FileReader;
import java.io.FileWriter;

public class item {
    item(int itemID,String itemName, int itemPrice, int itemAvailableAmount, int itemDiscount){
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAvailableAmount = itemAvailableAmount;
        this.itemDiscount = itemDiscount;
    }
    public int itemID;
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String itemName;
    public String getItemName() {
        return itemName;
    }

    public int itemPrice;
    public int getItemPrice() {
        return itemPrice;
    }

    public int itemAvailableAmount
    public int getItemAvailableAmount() {
        return itemAvailableAmount;
    }
    public void setItemAvailableAmount(int itemAvailableAmount) {
        this.itemAvailableAmount = itemAvailableAmount;
    }
    public int itemDiscount;
    public int getItemDiscount() {
        return itemDiscount;
    }

}
