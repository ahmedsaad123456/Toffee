package DataFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ShoppingCart.Item;

public class FileItem{
    private File file = new File("DataBase\\items.txt");

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Item> load(){
        ArrayList<Item> items = new ArrayList<>();
        int itemID = 0;
        String itemName = "";
        double itemPrice = 0;
        int itemAvailableAmount = 0;
       double itemDiscount = 0;

        if(file.length() == 0){
            return items;
        }
        int counter = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (counter == 2) {
                    itemID =  Integer.parseInt(line);
                }
                else if (counter == 4){
                    itemName = line;
                }
                else if (counter == 6){
                    itemPrice = Double.parseDouble(line);
                }
                else if (counter == 8){
                    itemAvailableAmount = Integer.parseInt(line);
                }
                else if (counter == 10){
                    itemDiscount = Double.parseDouble(line);
                    Item i = new Item(itemID, itemName, itemPrice, itemAvailableAmount, itemDiscount);
                    items.add(i);
                    counter = 0;
                }
                counter++;

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return items;

    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    public void save(Item item){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , true))) {
            writer.write("Item ID: ");
            writer.newLine();
            writer.write(String.valueOf(item.getItemID()));
            writer.newLine();
            writer.write("Item Name: ");
            writer.newLine();
            writer.write(item.getItemName());
            writer.newLine();
            writer.write("Item Price: ");
            writer.newLine();
            writer.write(String.valueOf(item.getItemPrice()));
            writer.newLine();
            writer.write("Item Available Amount: ");
            writer.newLine();
            writer.write(String.valueOf(item.getItemAvailableAmount()));
            writer.newLine();
            writer.write("Item Discount: ");
            writer.newLine();
            writer.write(String.valueOf(item.getItemDiscount()));
            writer.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  

    public void saveAmount(ArrayList<Item> items){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , false))) {
            for (int i = 0; i < items.size(); i++) {
               save(items.get(i));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  