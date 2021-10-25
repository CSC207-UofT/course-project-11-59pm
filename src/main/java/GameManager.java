/**
 * This file is responsible for the running and keeping track of the rounds.
 * This file will would be doing the most work since it will be tracking
 * all the objects and calling other entity classes to further manipulate the stats.
 */
package main.java;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

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
          P1 = new Provinces("A", 200, 1000, 200, 800);

          P2 = new Provinces("B", 200, 1000, 200, 800);

          P3 =  new Provinces("C", 200, 1000, 200, 800);

          P4 =  new Provinces("D", 200, 1000, 200, 800);
    }
    public Provinces startProvince(String provinceName) {
        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*
         PlayerProvince = new Provinces(provinceName, 200, 1000, 200, 800);
         return PlayerProvince;
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
    public String PromptEvents() {
        Random rand = new Random();
        int upperbound = 25;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        if (int_random > 20){
            // create an event
            // TODO: plz make events for us :c
            Events events;
            return events;
        }
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

    public void startPlayer(String name, Provinces province) {
        UserPlayer player = new UserPlayer(province, name);
    }
}