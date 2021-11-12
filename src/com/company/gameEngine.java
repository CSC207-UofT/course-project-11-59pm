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

    public gameEngine() {
        /* Loads the Preset Provinces. Will be changed in the future such that
         * the user has a choice between the provinces to choose with provinces being good
         * in some attributes and lack in others, that describe the province.
         * (ie: Military: 95, however, Religion: 20) */
        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*
        //TODO take provinceName
        ArrayList list = new ArrayList<>(ui.startPlayer());
        String provinceName = "india";
        PlayerProvince = new Provinces(provinceName, 200, 1000, 200, 800);
        P1 = new Provinces("A", 200, 1000, 200, 800);

        P2 = new Provinces("B", 200, 1000, 200, 800);

        P3 = new Provinces("C", 200, 1000, 200, 800);

        P4 = new Provinces("D", 200, 1000, 200, 800);

        ui = userInterface.initializeUI();

        //TODO startPlayer returns a tuple with [name, provinceName] however these are not saved
        //TODO its a design error rn because provinceName is already declared so we have to change the name
        //TODO below i tried doing it but provinceName is private so we need a setter function
//        this.PlayerProvince.setProvinceName((String) list.get(0));
//        decisionList = new Decisions();
        processor = new ProcessValues();
    }
    public void loopGame(){

    }

    public void turn() {
        displayValues();
        //TODO make the three lines into another method
        processDecision();
        /*TODO instead of 50 take the second value that the player inputs*/
        processDecision();
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        if (randomNumber < 2) {
            processDecision();
        } else {
            Events event = new Events();
            String eventName = event.getRandomEvent();
            List<Integer> eventValues = event.getValues(eventName);
            ui.displayText(eventName);
            String choice = ui.getEventChoice();
            processor.getUserEventDecision(choice, PlayerProvince, eventValues);
        }
        displayValues();

    }

    public void processDecision(){
        decisionList.displayQuestions();
        String choice = ui.getDecisionsChoice();
        processor.getUserDecision(choice, PlayerProvince, 50);
    }

    public void displayValues(){
        ui.displayText("Civilian value: " + PlayerProvince.getCivilians());
        ui.displayText("Gold value: " + PlayerProvince.getGold());
        ui.displayText("Soldier value: " + PlayerProvince.getSoldiers());
        ui.displayText("Food value: " + PlayerProvince.getFood());
    }
    public void isDeath(){
        ui.displayText("You have lost the game!");
        //TODO would you like to restart? and have them restart
    }
}