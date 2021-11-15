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
        
        ui = userInterface.initializeUI();
        Boolean saveBool = ui.askLoad();
        ArrayList list;
        if (saveBool) {
             list = new ArrayList<>(loadPoint(ui.getFilePathLoad()));
             ui.displayText("Welcome back to Rajan's Conquest, " + list.get(0));
        } else{
            list = new ArrayList<>(ui.startPlayer());
            savePoint(list, ui.getFilePathSave());
        }

        String name= list.get(1);
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
        while (!playerProvince.isDeath()){
            turn();
        }
        death();
    }

    public void turn() {
        displayEventValues(playerProvince, processEvent());
        displayEventValues(playerProvince, processEvent());
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        if (randomNumber < 2) {
            processDecision();
        } else {
            processEvent();
        }
        aiTurn();
    }

    public List<Integer> processEvent(){
        Events event = new Events();
        String eventName = event.getRandomEvent();
        List<Integer> eventValues = event.getValues(eventName);
        ui.displayText(eventName);
        String choice = ui.getEventChoice();
        processor.getUserEventDecision(choice, playerProvince, eventValues);
        return eventValues;
    }


    public void processDecision(){
        decisionList.displayQuestions();
        String choice = ui.getDecisionsChoice();
        int max = ui.getDecisionValues(choice, playerProvince.returnMaximumValue(choice));
        processor.getUserDecision(choice, playerProvince, max);
    }

    public void aiTurn(){
        displayValues(playerProvince);
        for (int i = 0; i < aiProvinces.size(); i++){
            Province currProvince = aiProvinces.get(i);
            if (currProvince.getStatus()){
                aiChoices.makeDecisions(currProvince);
                displayValues(currProvince);
                if (currProvince.isDeath()){
                    provinceDeath(currProvince);
                }
            }
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

    public void displayEventValues(Province province, List eventValues){
        //TODO so basically i want to say civilian value = old value + eventValue = new value
        //TODO must use memento to keep track of what the value was before the value changes
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


    public void provinceDeath(Province province){
        ui.displayText(province.getAiProvinceName() + " is dead");
        province.die();
    }
    public void death(){
        ui.displayText("You have lost the game!");
        displayValues(playerProvince);
        ui.displayText("One of the values have reached zero :( :skull:");
        //TODO would you like to restart? and have them restart
    }
    
    private void savePoint(ArrayList list, String filePathSave) throws IOException {
        ui.displayText("Saving Game...");
        gameState gs = new gameState(list);
        saveLoad.saveGame(filePathSave, gs);
        ui.displayText("Game State Saved");
    }

    private ArrayList<Object> loadPoint(String filePathLoad) throws IOException {
        ui.displayText("Loading Game State...");
        return saveLoad.loadGame(filePathLoad).getSaveState();
    }
}
