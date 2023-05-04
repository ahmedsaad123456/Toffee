import user_info_managment.*;
import payment.*;
import ShoppingCart.*;

public class App {
    public static void main(String[] args) throws Exception {
        User ahmed = new User("Ahmed Saad" , "ahmed@gmail.com" , "123456" , "01100493553" , "cairo" , 20200020 );
    
        ahmed.print();
    }
}
