package ShoppingCart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart{

    public ShoppingCart(int ShoppingCartID, int userID){
        this.ShoppingCartID = ShoppingCartID;
        this.userID = userID;
        numberOfItems = 0;
    }
    public int ShoppingCartID;
    public int getShoppingCartID() {
        return ShoppingCartID;
    }

    public int userID;
    public int getUserID() {
        return userID;
    }

    public int numberOfItems;
    public int getNumberOfItems() {
        return numberOfItems;
    }
    public ArrayList<cartItem> items= new ArrayList<>();

    public void addItem(cartItem item){
        //implement
    }


    
    private File itemsFile = new File("items.txt");
    public ArrayList<cartItem> viewCatalog(){
        // implement
        
        if(itemsFile.length()==0){
            return items;
        }

        
        return items;
    
    }
    
//    public void removeItem(cartItem item){
//
//    }


//    public void viewShoppingCart(){
//
//    }

}
