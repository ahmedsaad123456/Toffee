package DataFiles;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ShoppingCart.Order;

public class FileOrder {
    private File file = new File("DataBase\\orders.txt");
    
//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    public ArrayList<Order> load(){
        ArrayList<Order> orders = new ArrayList<>();
        int orderID = 0;
        int userID = 0;
        String status = "";
        double totalPrice = 0;
        
        if(file.length() == 0){
            return orders;
        }
        int counter = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (counter == 2) {
                    orderID =  Integer.parseInt(line);
                }
                else if (counter == 4){
                    userID = Integer.parseInt(line);
                }
                else if (counter == 6){
                    status = line;
                }
                else if (counter == 8){
                    totalPrice = Double.parseDouble(line);
                    Order o = new Order(orderID,userID , status, totalPrice);
                    orders.add(o);
                    counter = 0;
                }
                counter++;
                
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return orders;
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
        
    public void save(Order order){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , true))) {
            writer.write("Order ID: ");
            writer.newLine();
            writer.write(String.valueOf(order.getOrderID()));
            writer.newLine();
            writer.write("User ID: ");
            writer.newLine();
            writer.write(String.valueOf(order.getUserID()));
            writer.newLine();
            writer.write("Status: ");
            writer.newLine();
            writer.write(order.getStatus());
            writer.newLine();
            writer.write("Total Price: ");
            writer.newLine();
            writer.write(String.valueOf(order.getTotalPrice()));
            writer.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  
    public void saveAllOrders(ArrayList<Order> orders){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , false))) {
            for (Order order : orders) {
                save(order);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------

