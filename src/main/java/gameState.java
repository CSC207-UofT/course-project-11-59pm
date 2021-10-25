package main.java;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class gameState {
    /* This class is responsible for keeping track of game data, and creating and saving data to a file */

    private  String filePathway;
    private ArrayList saveInfo;

    /**
    * This is the constructor for the gameState Class
    *
    * @param saveInfo ArrayList repersenting an ArrayList with game data
    * @param filePathway String repersenting the file pathway to a save file
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
    private void saveGame(String filePath, ArrayList saveInfo){
        File outputFile;
        BufferedWriter outputWriter;

        try {
            outputFile = new File(filePath);
            outputWriter = new BufferedWriter(new FileWriter(outputFile));
            for(int i = 0; i < saveInfo.size(); i++){
                outputWriter.write(saveInfo.get(i) + "\n");
            }
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * This is the loadGame function. Opens the save file, that for each line of the file adds one index 
    * to the ArrayList called saveInfo.
    *
    * @param filePath String representing the file pathway to a save file
    */
    private ArrayList loadGame(String filePath){
        var saveInfo = new ArrayList<>();
        try {
            File inputFile = new File(filePath);
            Scanner inputReader = new Scanner(inputFile);

            while (inputReader.hasNextLine()) {
                String data = inputReader.nextLine();
                saveInfo.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveInfo;
    }

}

