package ShoppingCart;
public class Order {
    private int orderID;
    private int userID;
    private double totalPrice;
    private ShoppingCart cart;
    private String status;
    public Order(int orderID, ShoppingCart cart){
        this.orderID = orderID;
        this.userID = cart.getUserID();
        this.totalPrice = cart.getTotalPrice();
        this.cart = cart;
        this.status = "Open";
    }
    public int getOrderID() {
        return orderID;
    }
    public int getUserID() {
        return userID;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public ShoppingCart getShoppingCart() {
        return cart;
    }
    public String getStatus() {
        return status;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    void makeOrder(){
        FileOrder orderFile = new FileOrder();
        orderFile.save(this);

    }
}