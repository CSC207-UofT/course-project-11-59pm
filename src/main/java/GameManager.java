/**
 * This file is responsible for the running and keeping track of the rounds.
 * This file will would be doing the most work since it will be tracking
 * all the objects and calling other entity classes to further manipulate the stats.
 */
package main.java;

import java.util.ArrayList;

public class GameManager {
    /*Constructor: Declares the Variables for the Province Objects and a
    * gameState Object for saving purposes.
    */
    private Provinces P1;
    private Provinces P2;
    private Provinces P3;
    private Provinces P4;
    private Provinces PlayerProvince;


    public GameManager() {
        /* Loads the Preset Provinces. Will be changed in the future such that
        * the user has a choice between the provinces to choose with provinces being good
        * in some attributes and lack in others, that describe the province.
        * (ie: Military: 95, however, Religion: 20) */
          P1 = new Provinces(100, "Deven",
                "Bandar", 800);

          P2 = new Provinces(200, "Saj",
                "Kela", 500);

          P3 = new Provinces(400, "Ashwin",
                "Pahaad", 600);

          P4 = new Provinces(500, "Maya",
                "Vayu", 1000);
    }
    public void startProvince(String name) {
        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*
         PlayerProvince = new Provinces(200, name,
                "Zulfein", 800);
    }

    /*
     * Saves every Province within an ArrayList
     * and then returns that ArrayList
    */
    public ArrayList<Provinces> getAllProvinces(){
        ArrayList<Provinces> AIprovinces = new ArrayList<>();
        AIprovinces.add(P1);
        AIprovinces.add(P2);
        AIprovinces.add(P3);
        AIprovinces.add(P4);
        AIprovinces.add(PlayerProvince);
        return AIprovinces;
    }

    /* Saves the Player's Provinces and the AI Provinces with their
    * provided attributes.
    */
    public void saveProgress(){
        gameState currGS = new gameState("", getAllProvinces());
        System.out.println(currGS.getState());
    }

    public void StartBattle (Battle battle) {
        /* uses Battle class to begin a battle after the end of the choice selection*/
    }
    public void PromptEvents (userInterface controller) {
        /* uses Controller to ask the user to select between available game choices*/
    }

    public void updatePlayer (gameState gamestate, int updated_variables) {
        /* updates player's variables using GameState*/
    }

    public void updateProvince (gameState gamestate, Provinces province, int updated_variables) {
        /* updates a province's variables using GameState*/
    }

    public void GameStateSaver (gameState gamestate) {
        /* uses GameState to save game*/
    }

    public static GameManager initializeGM() {
        return new GameManager();
    }

}