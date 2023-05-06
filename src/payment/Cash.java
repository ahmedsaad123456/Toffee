package payment;

public class Cash extends payment {
    private String location;

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
    
    public void setLocation(String location) {
        this.location = location;
    }

    // get location from user id


    
}
