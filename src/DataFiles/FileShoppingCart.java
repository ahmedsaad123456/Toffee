package DataFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ShoppingCart.CartItem;
import ShoppingCart.ShoppingCart;


public class FileShoppingCart{
    private File file = new File("DataBase\\cart.txt");

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------

    public ArrayList<ShoppingCart> load(){
        ArrayList<ShoppingCart> cart = new ArrayList<ShoppingCart>();
        int userID=0 , numberOfItems = -1;
        ArrayList<CartItem> items = new ArrayList<CartItem>();
        int itemID = 0;
        String itemName = "";
        double itemPrice = 0;
        double itemDiscount = 0;
        int quantity = 0;

        if(file.length()==0){
            return cart;
        }
        int counter =1 , itemInfo = 1 , finish=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;


            while ((line = reader.readLine()) != null) {

                if (counter == 2) {

                    userID =  Integer.parseInt(line);
                }
                else if (counter == 4){
                    numberOfItems = Integer.parseInt(line);
                }
                if (counter > 4 ) {
                    if(itemInfo==2){

                        itemID =  Integer.parseInt(line);
                    }
                    else if(itemInfo==4){
                        itemName = line;
                    }
                    else if(itemInfo==6){
                        quantity =  Integer.parseInt(line);
                    }
                    else if(itemInfo==8){
                        itemPrice = Double.parseDouble(line);
                    }
                    else if (itemInfo==10){
                        itemDiscount = Double.parseDouble(line);

                    }
                    else if (itemInfo==12){

                        itemInfo=0;
                        CartItem item = new CartItem(itemID , itemName , itemPrice , 0 , itemDiscount , quantity);
                        items.add(item);
                        finish++;
                    }
                    itemInfo++;
   
                }
                if(finish==numberOfItems){

                    ShoppingCart newCart = new ShoppingCart(userID , numberOfItems ,new ArrayList<>( items));
                    cart.add(newCart);
                    numberOfItems=-1;
                    counter=0;
                    finish=0;
                    items.clear();

                }
                counter++;
                

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
       
        return cart;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    public void save(ShoppingCart cart){
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
                writer.write("Item Price for one piece:");
                writer.newLine();
                writer.write(String.valueOf(item.getItemPrice())  );
                writer.newLine();
                writer.write("dicount for one piece:");
                writer.newLine();
                writer.write(String.valueOf(item.getItemDiscount())  );
                writer.newLine();
                writer.write("Total price:");
                writer.newLine();
                writer.write(String.valueOf(item.getTotalPrice())  );
                writer.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  

    public void saveAllShoppingCart(ArrayList<ShoppingCart> cart){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , false))) {
           
            for (ShoppingCart c : cart){
                save(c);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }


}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  