package ShoppingCart;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOrder {
    private File file = new File("C:\\Users\\Hp\\IdeaProjects\\SW\\src\\DataBase\\orders.txt");
    public void save(Order order){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , true))) {
            writer.write(String.valueOf(order.getOrderID()));
            writer.newLine();
            writer.write(String.valueOf(order.getUserID()));
            writer.newLine();
            writer.write(order.getStatus());
            writer.newLine();
            writer.write(String.valueOf(order.getTotalPrice()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
