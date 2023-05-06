package ShoppingCart;
public class CartItem extends Item{
    public CartItem(int itemID,String itemName, double itemPrice, int itemAvailableAmount, double itemDiscount, int cartItemQuantity){
        super(itemID, itemName, itemPrice, itemAvailableAmount, itemDiscount);
        this.cartItemQuantity = cartItemQuantity;
    }
    private int cartItemQuantity;
    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int quantity) {
        this.cartItemQuantity = quantity;
    }
}