package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class gameEngine {
    private userInterface ui;
    private Decisions decisionList;
    private ProcessValues processor;
    private Provinces P1;
    private Provinces P2;
    private Provinces P3;
    private Provinces P4;
    private Provinces PlayerProvince;

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

        P3 = new Provinces("C", 200, 1000, 200, 800);

        P4 = new Provinces("D", 200, 1000, 200, 800);

        ui = userInterface.initializeUI();
        ArrayList list = new ArrayList<>(ui.startPlayer());
        decisionList = new Decisions();
        processor = new ProcessValues();
    }


    public void turn() {
        System.out.println(PlayerProvince.getCivilians());
        System.out.println(PlayerProvince.getGold());
        System.out.println(PlayerProvince.getSoldiers());
        System.out.println(PlayerProvince.getFood());
        //TODO make the three lines into another method
        decisionList.displayQuestions();
        String choice = ui.getDecisionsChoice();
        processor.getUserDecision(choice, PlayerProvince, 50);
        /*TODO instead of 50 take the second value that the player inputs*/
        decisionList.displayQuestions();
        choice = ui.getDecisionsChoice();
        processor.getUserDecision(choice, PlayerProvince, 50);
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        if (randomNumber < 2) {
            decisionList.displayQuestions();
            choice = ui.getDecisionsChoice();
            processor.getUserDecision(choice, PlayerProvince, 50);
        } else {
            Events event = new Events();
            String eventName = event.getRandomEvent();
            List<Integer> eventValues = event.getValues(eventName);
            ui.displayText(eventName);
            choice = ui.getEventChoice();
            processor.getUserEventDecision(choice, PlayerProvince, eventValues);
        }
        System.out.println(PlayerProvince.getCivilians());
        System.out.println(PlayerProvince.getGold());
        System.out.println(PlayerProvince.getSoldiers());
        System.out.println(PlayerProvince.getFood());

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


//    public void updatePlayer (gameState gamestate, int updated_variables) {
//        /* updates player's variables using GameState*/
//    }
//
//    public void updateProvince (gameState gamestate, Provinces province, int updated_variables) {
//        /* updates a province's variables using GameState*/
//    }
//
//    public void GameStateSaver (gameState gamestate) {
//        /* uses GameState to save game*/
//    }
//
//    public void loadGameState() {
//        // update the player and province and all the other stuff
//        // saved from the previous game state
//    }
//
//    //    public void StartBattle (Battle battle) {
////        /* uses Battle class to begin a battle after the end of the choice selection*/
////    }
//
//    public static GameManager initializeGM() {
//        return new GameManager();
//    }
//
//    public void startPlayer(String name, Provinces province) {
//        UserPlayer player = new UserPlayer(province, name);
//    }
//}