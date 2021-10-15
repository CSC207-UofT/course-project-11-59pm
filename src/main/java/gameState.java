package main.java;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class gameState {
    /* This class is responsible for keeping track of game data, and creating and saving data to a file */

    private  String filePathway;
    private ArrayList saveInfo;

    public gameState(String filePathway, ArrayList saveInfo) {
        this.saveInfo = saveInfo;
        this.filePathway = filePathway;
    }


    public ArrayList getState()
    {
        return this.saveInfo;
    }

    public void setState(ArrayList state)
    {
        this.saveInfo = state;
    }

    public void setPath(String path)
    {
        this.filePathway = path;
    }

    public String getPath()
    {
        return this.filePathway;
    }

    private void saveGame(String filePath, ArrayList saveInfo) {
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

    private ArrayList loadGame(String filePath) {
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

