package ShoppingCart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileShoppingCart{
    private File file = new File("DataBase\\cart.txt");

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------


    public void save(ShoppingCart cart){
        // try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        //     writer.write("");
        // }
        // catch (IOException e) {
        //     e.printStackTrace();
        // }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , true))) {
            writer.write("User ID: ");
            writer.newLine();
            writer.write(String.valueOf(cart.getUserID()));
            writer.newLine();
            writer.write("number of items: ");
            writer.newLine();
            writer.write(String.valueOf(cart.getNumberOfItems()));
            writer.newLine();
            for(CartItem item : cart.getItems()){
                writer.write("Item ID: ");
                writer.newLine();
                writer.write(String.valueOf(item.getItemID()));
                writer.newLine();
                writer.write("Item Name: ");
                writer.newLine();
                writer.write(item.getItemName());
                writer.newLine();
                writer.write("Item Quantity: ");
                writer.newLine();
                writer.write(String.valueOf(item.getCartItemQuantity()));
                writer.newLine();
                writer.write("Item Total Price: ");
                writer.newLine();
                writer.write(String.valueOf((item.getItemPrice() - item.getItemDiscount()) * item.getCartItemQuantity()) );
                writer.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}