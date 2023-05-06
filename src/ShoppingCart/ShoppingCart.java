package ShoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

    public ShoppingCart(int userID) {
        
        this.userID = userID;
        numberOfItems = 0;
    }
    
    public ShoppingCart(int userID , int numberOfItems, ArrayList<CartItem> items) {
        
        this.userID = userID;
        this.numberOfItems = numberOfItems;
        this.items =items;
    }

    private int userID;

    public int getUserID() {
        return userID;
    }

    private int numberOfItems;

    public int getNumberOfItems() {
        return numberOfItems;
    }

    private ArrayList<CartItem> items = new ArrayList<>();

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            totalPrice += (items.get(i).getItemPrice() - items.get(i).getItemDiscount()) * items.get(i).getCartItemQuantity();
        }
        return totalPrice;
    }
    public CartItem searchItem(int itemID, int quantity) {
        FileItem itemFile = new FileItem();
        ArrayList<Item> itemsArray = itemFile.load();
        for (int i = 0; i < itemsArray.size(); i++) {
            if (itemsArray.get(i).getItemID() == itemID) {
                if (itemsArray.get(i).getItemAvailableAmount() >= quantity) {
                    int itemAvailableAmount = itemsArray.get(i).getItemAvailableAmount() - quantity;
                    itemsArray.get(i).setItemAvailableAmount(itemAvailableAmount);
                    itemFile.saveAmount(itemsArray);
                    CartItem cartItem = new CartItem(itemsArray.get(i).getItemID(), itemsArray.get(i).getItemName(), itemsArray.get(i).getItemPrice(), itemsArray.get(i).getItemAvailableAmount(), itemsArray.get(i).getItemDiscount(), quantity);
                    return cartItem;
                }
                else {
                    System.out.println("Sorry, the quantity you entered is not available");
                    return null;
                }
            }
        }
        System.out.println("Sorry, the item you entered is not available");
        return null;
    }

    public void addItem(CartItem item) {
        if (item != null) {
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).getItemID() == item.getItemID()){
                   System.out.println("This item is already in your cart\n Do you want to increase the quantity of this item? (y/n)");
                     Scanner input = new Scanner(System.in);
                     char choice = input.next().charAt(0);
                        if(choice == 'y'){
                            items.get(i).setCartItemQuantity(items.get(i).getCartItemQuantity() + item.getCartItemQuantity());
                            FileShoppingCart shoppingCartFile = new FileShoppingCart();
                            shoppingCartFile.save(this);
                            return;
                        }
                        else{
                            return;
                        }
                }
            }
            items.add(item);
            numberOfItems++;
            FileShoppingCart shoppingCartFile = new FileShoppingCart();
            shoppingCartFile.save(this);
        }
    }


    public void viewCatalog() {
        FileItem itemFile = new FileItem();
        ArrayList<Item> items = itemFile.load();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("itemID: " + items.get(i).getItemID() + "\nitemName: " + items.get(i).getItemName() + "\nitemPrice: $" + items.get(i).getItemPrice() + "\nitemAvailableAmount: " + items.get(i).getItemAvailableAmount() + " pieces" + "\nitemDiscount: $" + items.get(i).getItemDiscount());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        }
    }

}
