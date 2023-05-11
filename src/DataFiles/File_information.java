package DataFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import user_info_managment.User;
/**
 * class to manage information of the user
 */
public class File_information 
{
    private File file = new File("DataBase\\info.txt");

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
    /**
     * load information from the file
     * 
     * @return all users from the database
     */
    public ArrayList<User> load()
    {
        ArrayList<User> users = new ArrayList<>();
        String username=null , password= null , email=null , location=null , phone=null;
        int id=0;
        

        if(file.length()==0)
        {
            return users;
        }
        int counter = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        {
            String line;
    
            while ((line = reader.readLine()) != null) 
            {
                if (counter==1) 
                {
                    username= line;
                }
                else if (counter==2)
                {
                    id = Integer.parseInt(line);
                }
                else if (counter==3)
                {
                    email = line;
                }
                else if (counter==4)
                {
                    password = line;
                }
                else if (counter==5)
                {
                    phone = line;
                }
                else if (counter==6)
                {
                    location = line;
                    User u = new User(username, email, password, phone, location, id);
                    users.add(u);
                    counter = 0;
                }
                counter++;
                    
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        return users;
        
    }


//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * save the user information in the file
     * 
     * @param u is the user object to save it in the database
     */
    public void save(User u){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , true))) 
        {
            writer.write(u.getUsername());
            writer.newLine();
            writer.write(String.valueOf(u.getUserID()));
            writer.newLine();
            writer.write(u.getEmail());
            writer.newLine();
            writer.write(u.getPassword());
            writer.newLine();
            writer.write(u.getPhone());
            writer.newLine();
            writer.write(u.getLocation());
            writer.newLine();
            
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
 
    /**
     * save list of users in the file
     * 
     * @param u is the list of users to save them into database
     */
    public void saveAllUsers(ArrayList<User> u)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file , false))) 
        {
            for(User user : u)
            {
                save(user);
            }
            
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }
    
}



//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------
  

