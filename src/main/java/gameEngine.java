/**
 * This file is responsible for the running and keeping track of the rounds.
 * This file will would be doing the most work since it will be tracking
 * all the objects and calling other entity classes to further manipulate the stats.
 */
package main.java;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class gameEngine {
    /*Constructor: Declares the Variables for the Province Objects and a
     * gameState Object for saving purposes.
     */
    private Provinces P1;
    private Provinces P2;
    private Provinces P3;
    private Provinces P4;
    private Provinces PlayerProvince;
    private userInterface ui;


    public gameEngine(String provinceName) {
        /* Loads the Preset Provinces. Will be changed in the future such that
         * the user has a choice between the provinces to choose with provinces being good
         * in some attributes and lack in others, that describe the province.
         * (ie: Military: 95, however, Religion: 20) */
        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*

        PlayerProvince = new Provinces(provinceName, 200, 1000, 200, 800);
        P1 = new Provinces("A", 200, 1000, 200, 800);

        P2 = new Provinces("B", 200, 1000, 200, 800);

        P3 =  new Provinces("C", 200, 1000, 200, 800);

        P4 =  new Provinces("D", 200, 1000, 200, 800);

        ui = userInterface.initializeUI();
        ArrayList list = new ArrayList<>(ui.startPlayer());
        // creating a province and player and assign province to player
        controller.runStartPlayer((String) list.get(0), (String) list.get(1));

        // create and send the events
        controller.sendEvents(ui);
        // get answer from ui about event to the game manager
        Decisions d = new Decisions();
        d.displayQuestions();
    }
    public void StartBattle (Battle battle) {
        /* uses Battle class to begin a battle after the end of the choice selection*/
    }

    public void turn(String decision){
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        userInterface ui = new userInterface();
        if (randomNumber > 4){
            ui.displayText(decision);
            getUserDecision();
        }
        else{
            Events event = new Events();
            String eventName = event.getRandomEvent();
            ui.displayText(eventName);
            getUserEventDecision();

        }


    }
    public void getUserDecision(String userDecision, Provinces province, int value){
        if (userDecision == "1"){
            int currentValue = province.getCivilians();
            int currentValue2 = province.getGold();
            province.setCivilians(currentValue + value/2);
            province.setGold(currentValue2 - value);
        }
        else if (userDecision == "2"){
            int currentValue = province.getSoldiers();
            int currentValue2 = province.getCivilians();
            province.setSoldiers(currentValue + value);
            province.setCivilians(currentValue2 - value);
        }
        else if (userDecision == "3"){
            int currentValue = province.getGold();
            int currentValue2 = province.getCivilians();
            province.setGold(currentValue + value);
            province.setCivilians(currentValue2 - value);

        }
    }

    public void getUserEventDecision(String userDecision, Provinces province, int value){
        if (userDecision == "1"){
            int currentValue = province.getCivilians();
            int currentValue2 = province.getGold();
            province.setCivilians(currentValue + value/2);
            province.setGold(currentValue2 - value);
        }
        else if (userDecision == "2"){
            int currentValue = province.getSoldiers();
            int currentValue2 = province.getCivilians();
            province.setSoldiers(currentValue + value);
            province.setCivilians(currentValue - value);
        }
    }


//    public String PromptEvents() {
//        Random rand = new Random();
//        int upperbound = 25;
//        //generate random values from 0-24
//        int int_random = rand.nextInt(upperbound);
//        if (int_random > 20){
//            // create an event
//            // TODO: plz make events for us :c
//            Events events;
//            return events;
//        }
//        /* uses Controller to ask the user to select between available game choices*/
//    }


    public void updatePlayer (gameState gamestate, int updated_variables) {
        /* updates player's variables using GameState*/
    }

    public void updateProvince (gameState gamestate, Provinces province, int updated_variables) {
        /* updates a province's variables using GameState*/
    }

    public void GameStateSaver (gameState gamestate) {
        /* uses GameState to save game*/
    }

    public void loadGameState() {
        // update the player and province and all the other stuff
        // saved from the previous game state
    }

    public static GameManager initializeGM() {
        return new GameManager();
    }

    public void startPlayer(String name, Provinces province) {
        UserPlayer player = new UserPlayer(province, name);
    }
}