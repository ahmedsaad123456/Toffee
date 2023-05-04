package payment;

public abstract class payment {
    protected double price;

    public payment(){
        price =0;
    }

    public payment(double price){
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // public get price order (order_id)
}
