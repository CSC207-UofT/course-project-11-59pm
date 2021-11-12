package com.company.gameState;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class saveLoad {
    
 /**
     * This is the saveGame function. Open and edits a file, that for each line adds one index
     * of the ArrayList called saveInfo.
     *
     * @param saveInfo ArrayList representing an ArrayList with game data
     * @param filePath String representing the file pathway to a save file
     */
    public void saveGame(String filePath, gameState saveInfo) throws IOException {
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
    public gameState loadGame(String filePath) throws IOException {
        gameState saveList = new gameState();
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(filePath);
            objectinputstream = new ObjectInputStream(streamIn);
            gameState saveInfo = (gameState) objectinputstream.readObject();
            //saveList.add(saveInfo);
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


