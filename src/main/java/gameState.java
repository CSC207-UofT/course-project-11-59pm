package main.java;
import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

public class gameState implements Serializable  {
    /* This class is responsible for keeping track of game data, and creating and saving data to a file */

    private  String filePathway;
    private ArrayList saveInfo;

    /**
    * This is the constructor for the gameState Class
    *
    * @param saveInfo      ArrayList repersenting an ArrayList with game data 
    * @param filePathway    String repersenting the file pathway to a save file
    */
    public gameState(String filePathway, ArrayList saveInfo) {
        this.saveInfo = saveInfo;
        this.filePathway = filePathway;
    }

    /*Get the ArrayList from game state */
    public ArrayList getState()
    {
        return this.saveInfo;
    }

    /*Set the ArrayList for game state */
    public void setState(ArrayList state)
    {
        this.saveInfo = state;
    }

    /*Set the String that repersents the filepath*/
    public void setPath(String path)
    {
        this.filePathway = path;
    }

    /*Gets the String that repersents the filepath*/
    public String getPath()
    {
        return this.filePathway;
    }

    /**
    * This is the saveGame function. Open and edits a file, that for each line adds one index 
    * of the ArrayList called saveInfo.
    *
    * @param saveInfo ArrayList representing an ArrayList with game data
    * @param filePath String representing the file pathway to a save file
    */
    public void saveGame(String filePath, ArrayList saveInfo) throws IOException {
        ObjectOutputStream oos = null;
        FileOutputStream fileOutput = null;
        try{
            fileOutput = new FileOutputStream(filePath, true);
            oos = new ObjectOutputStream(fileOutput);
            oos.writeObject(saveInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(oos != null){
                oos.close();
            }
        }
    }

    /**
    * This is the loadGame function. Opens the save file, that for each line of the file adds one index 
    * to the ArrayList called saveInfo.
    *
    * @param filePath String representing the file pathway to a save file
    */
    public ArrayList loadGame(String filePath) throws IOException {
        ArrayList<Object> saveList = new ArrayList<Object>();
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(filePath);
            objectinputstream = new ObjectInputStream(streamIn);
            ArrayList saveInfo = (ArrayList) objectinputstream.readObject();
            saveList.add(saveInfo);
            //Testing out list to see if it throws error
            }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(objectinputstream != null){
                objectinputstream.close();
        }
    }
        return saveList;
    }


}

