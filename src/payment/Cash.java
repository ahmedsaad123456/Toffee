package payment;

public class Cash extends payment {
    private String location;
    private String state = "open";

    public Cash(){
        super();
        location="undefined";
    }

    public Cash(String location , double price){
        super(price);
        this.location=location;
    }

    public String getLocation() {
        return location;
    }
    public String getState() {
        return state;
    }

    // get location from user id


    
}
