package main.java;
import java.util.ArrayList;

public class gameState {
    /* This class is responsible for keeping track of game data, and creating and saving data to a file */

    public static gameState getState()
    {
        return gameState;
    }

    public static void setState(gameState state)
    {
        gameState = state;
    }

    private void saveGame(String filePath, arrayList saveInfo) {
        File outputFile;
        BufferedWriter outputWriter;

        try {
            outputFile = new File(filePath);
            outputWriter = new BufferedWriter(new FileWriter(outputFile));
            for(int i = 0; i < saveInfo.length; i++){
                outputWriter.write(Integer.toString(saveInfo[i]) + "\n");
            }
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadGame(String filePath) {
        File inputFile;
        BufferedWriter inputWriter;
        //TODO: Set up input writer
        try {
            inputFile = new File(filePath);
            inputWriter = new BufferedWriter(new FileWriter(outputFile));
            for(int i = 0; i < saveInfo.length; i++){
                outputWriter.write(Integer.toString(saveInfo[i]) + "\n");
            }
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
