package com.company;

import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceAssembler;
import com.company.ProvinceConstruction.ProvinceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameEngine {
    private UserInterface ui;
    private Decisions decisionList;
    private ProcessValues processor;
    private Province playerProvince;
    private ArrayList<Province> aiProvinces;
    private AIDecisionMaker aiChoices;

    public GameEngine() {
        /* Loads the Preset Provinces. Will be changed in the future such that
         * the user has a choice between the provinces to choose with provinces being good
         * in some attributes and lack in others, that describe the province.
         * (ie: Military: 95, however, Religion: 20) */
        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*
        //TODO take provinceName

        ui = UserInterface.initializeUI();
        String name= ui.startPlayer();
        decisionList = new Decisions();
        processor = new ProcessValues();
        ProvinceBuilder provinceBuilder1 = new ProvinceBuilder();
        ProvinceAssembler provinceAiAssembler  =  new ProvinceAssembler();
        ProvinceAssembler provinceUserAssembler  =  new ProvinceAssembler(provinceBuilder1);

        aiProvinces = provinceAiAssembler.create();

        aiChoices = new AIDecisionMaker();

//        p1 = ai_provinces.get(0);
//        p2 = ai_provinces.get(1);
//        p3 = ai_provinces.get(2);
//        p4 = ai_provinces.get(3);

        provinceUserAssembler.makeUserProvince(name);
        playerProvince = provinceUserAssembler.getUserProvince();

        //TODO startPlayer returns a tuple with [name, provinceName] however these are not saved
        //TODO its a design error rn because provinceName is already declared so we have to change the name
        //TODO below i tried doing it but provinceName is private so we need a setter function
    }
    public void loopGame(){
        while (!isDeath()){
            turn();
        }
        death();
    }

    public void turn() {

        processDecision();
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
            processor.getUserEventDecision(choice, playerProvince, eventValues);
        }
        displayValues(playerProvince);
        for (int i = 0; i < aiProvinces.size(); i++){
            Province currProvince = aiProvinces.get(i);
            aiChoices.makeDecisions(currProvince);
            displayValues(currProvince);
        }

    }

    public void processDecision(){
        decisionList.displayQuestions();
        String choice = ui.getDecisionsChoice();
        int max = ui.getDecisionValues(choice, returnMaximumValue(choice));
        processor.getUserDecision(choice, playerProvince, max);
    }

    public int returnMaximumValue(String choice){
        if (choice.equals("1")){
            return playerProvince.getProvinceGold();
        }
        else{
            return playerProvince.getProvinceCivilians();
        }
    }

    public void displayValues(Province province){
        if((province.getUserProvinceName() != null)){
            ui.displayText("Values for province: " + province.getUserProvinceName());
        }
        else{
            ui.displayText("Values for province: " + province.getAiProvinceName());
        }
        ui.displayText("Civilian value: " + province.getProvinceCivilians());
        ui.displayText("Gold value: " + province.getProvinceGold());
        ui.displayText("Soldier value: " + province.getProvinceSoldiers());
        ui.displayText("Food value: " + province.getProvinceFood());
    }
    public boolean isDeath(){
        //TODO make the code less redundant
        return playerProvince.getProvinceCivilians() <= 0 || playerProvince.getProvinceGold() < 0
                || playerProvince.getProvinceSoldiers() < 0 || playerProvince.getProvinceFood() < 0;
    }
    public void death(){
        ui.displayText("You have lost the game!");
        displayValues(playerProvince);
        ui.displayText("One of the values have reached zero :( :skull:");
        //TODO would you like to restart? and have them restart
    }
}