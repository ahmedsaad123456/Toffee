package ShoppingCart;
public class CartItem extends Item{
    public CartItem(int itemID,String itemName, double itemPrice, int itemAvailableAmount, double itemDiscount, int cartItemQuantity){
        super(itemID, itemName, itemPrice, itemAvailableAmount, itemDiscount);
        this.cartItemQuantity = cartItemQuantity;
        this.TotalPrice = (itemPrice - itemDiscount) * cartItemQuantity;
    }
    private int cartItemQuantity;
    private double TotalPrice;

    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int quantity) {
        this.cartItemQuantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
}