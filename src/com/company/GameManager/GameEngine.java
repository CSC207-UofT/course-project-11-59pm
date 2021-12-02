package com.company.GameManager;

import com.company.Decisions;

import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceAssembler;
import com.company.ProvinceConstruction.ProvinceBuilder;
import com.company.Snapshots.CaretakerProvince;
import com.company.Snapshots.MementoProvince;
import com.company.Snapshots.OriginatorProvince;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.company.UI.UserInterface;
import com.company.UseCases.Battle;
import com.company.UseCases.ProcessValues;
import com.company.GameSave.GameState;
import com.company.GameSave.SaveLoad;

public class GameEngine {
    private final UserInterface ui;
    private final Decisions decisionList;
    private final ProcessValues processor;
    private final Province playerProvince;
    private final ArrayList<Province> aiProvinces;
    private final AIDecisionMaker aiChoices;
    private final OriginatorProvince origProvince;
    private final CaretakerProvince ctProvince;
    private final Battle battleGenerator;

    public GameEngine() throws IOException {
        /* Loads the Preset Provinces. Will be changed in the future such that
         * the user has a choice between the provinces to choose with provinces being good
         * in some attributes and lack in others, that describe the province.
         * (ie: Military: 95, however, Religion: 20) */
        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.

        ui = UserInterface.initializeUI();
        Boolean saveBool = ui.askLoad();
        ArrayList<Object> list;
        // Sample input for windows filePath: C:\Users\YOURUSERNAME\Desktop
        // Sample input for macOS filePath: /Users/username/Desktop
        if (saveBool) {
            list = new ArrayList<Object>(loadPoint(ui.getFilePathLoad()));
            ui.displayText("Welcome back to Rajan's Conquest, " + list.get(0));
        } else{
            list = new ArrayList<Object>(ui.startPlayer());
            savePoint(list, ui.getFilePathSave());
        }

        String name = (String) list.get(1);
        decisionList = new Decisions();
        processor = new ProcessValues();
        battleGenerator = new Battle();
        origProvince = new OriginatorProvince();
        ctProvince = new CaretakerProvince();
        ProvinceBuilder provinceBuilder1 = new ProvinceBuilder();
        ProvinceAssembler provinceAiAssembler = new ProvinceAssembler();
        ProvinceAssembler provinceUserAssembler = new ProvinceAssembler(provinceBuilder1);

        aiProvinces = provinceAiAssembler.create();

        aiChoices = new AIDecisionMaker();

        provinceUserAssembler.makeUserProvince(name);
        playerProvince = provinceUserAssembler.getUserProvince();

        //TODO startPlayer returns a tuple with [name, provinceName] however these are not saved
        //TODO its a design error rn because provinceName is already declared so we have to change the name
        //TODO below i tried doing it but provinceName is private so we need a setter function
    }

    public void loopGame() {
        while (!playerProvince.isDeath()) {
            turn();
        }
        death();
    }

    public void turn() {
        displayEventValues(playerProvince, processEvent());
        displayEventValues(playerProvince, processEvent());
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        if (randomNumber < 6) {
            processDecision();
        } else {
            processEvent();
        }
        aiTurn();
        stateSnapshot(playerProvince);
        battle_option();
        if (ui.askSummary()){
            summaryOfStates();
        }
    }

    public List<Integer> processEvent() {
        Events event = new Events();
        String eventName = Events.getRandomEvent();
        List<Integer> eventValues = Events.getValues(eventName);
        ui.displayText(eventName);
        String choice = ui.getEventChoice();
        processor.getUserEventDecision(choice, playerProvince, eventValues);
        return eventValues;
    }


    public void processDecision() {
        decisionList.displayQuestions();
        String choice = ui.getDecisionsChoice();
        int max = ui.getDecisionValues(choice, playerProvince.returnMaximumValue(choice));
        processor.getUserDecision(choice, playerProvince, max);
    }

    public void aiTurn() {
        displayValues(playerProvince);
        for (int i = 0; i < aiProvinces.size(); i++) {
            Province currProvince = aiProvinces.get(i);
            if (currProvince.getStatus()) {
                aiChoices.makeDecisions(currProvince);
                displayValues(currProvince);
                if (currProvince.isDeath()) {
                    provinceDeath(currProvince);
                }
            }
        }
    }


    public void displayValues(Province province) {
        printAttributes(province);
    }

    // Can safely ignore this method for now
    public void displayEventValues(Province province, List eventValues) {
        //TODO so basically i want to say civilian value = old value + eventValue = new value
        //TODO must use memento to keep track of what the value was before the value changes
        printAttributes(province);
        // Can use this here

    }

    private void printAttributes(Province province) {
        if ((province.getUserProvinceName() != null)) {
            ui.displayText("Values for province: " + province.getUserProvinceName());
        } else {
            ui.displayText("Values for province: " + province.getAiProvinceName());
        }
        ui.displayText("Civilian value: " + province.getProvinceCivilians());
        ui.displayText("Gold value: " + province.getProvinceGold());
        ui.displayText("Soldier value: " + province.getProvinceSoldiers());
        ui.displayText("Food value: " + province.getProvinceFood());
    }

    private void savePoint(ArrayList list, String filePathSave) throws IOException {
        // Creates a save file for the current GameState
        ui.displayText("Saving Game...");
        GameState gs = new GameState(list);
        SaveLoad.saveGame(filePathSave, gs);
        ui.displayText("Game State Saved");
    }

    private ArrayList<Object> loadPoint(String filePathLoad) throws IOException {
        // Loads the save.ser file for the current GameState
        ui.displayText("Loading Game State...");
        return SaveLoad.loadGame(filePathLoad).getSaveState();
    }


    public void provinceDeath(Province province) {
        ui.displayText(province.getAiProvinceName() + " is dead");
        province.die();
    }

    public void death() {
        ui.displayText("You have lost the game!");
        displayValues(playerProvince);
        ui.displayText("One of the values have reached zero :( :skull:");
        //TODO would you like to restart? and have them restart
    }

    public void battle_option() {
        boolean battle = ui.beginBattle();

        List<String> provinces = new ArrayList<>();

        if (battle) {
            for (Province province: aiProvinces){
                if (province.getStatus()){
                    provinces.add(province.getAiProvinceName());
                }
            }
            String enemy = ui.selectOpponent(provinces);
            System.out.println(enemy);
            for (Province province: aiProvinces){
                if (province.getAiProvinceName().equals(enemy)){
                    String winner = battleGenerator.startsBattle(playerProvince, province);
                    ui.displayText("The winner of the battle is " + winner);
                }
            }
        }
    }

//    public Province prevProvinceState() {
//        // send the province state to the Originator
//        origProvince.setProvince(playerProvince);
//        // System.out.println("Food" + origProvince.getProvince().getProvinceFood());
//        // Create a memento Object from the given state.
//        MementoProvince mp = origProvince.createMementoProvinces();
//
//        // send to the CareTackerProvince
//        ctProvince.addMementoProvince(mp);
//
//        // return the prev state Province Object
//        return origProvince.setMementoProvinces(ctProvince.getMementoProvince(0));
//    }

    public void summaryOfStates(){
        int counter = 0;

        for (Province p: origProvince.setListOfMementoProvinces(ctProvince.getMementoProvinceList())){
            ui.displayText("State: " + counter);
            printAttributes(p);
            counter += 1;
        }
    }

    private void stateSnapshot(Province p){
        origProvince.setProvince(p);
        // listOfProvince(p);
        MementoProvince mp = origProvince.createMementoProvinces();
        ctProvince.addMementoProvince(mp);
        // origProvince.setMementoProvinces(ctProvince.getMementoProvinceList(0))
    }

    private List<Province> listOfProvince(Province p){
        List<Province> lst = new ArrayList<>();
        lst.add(p);
        return lst;
    }

//    private ArrayList<Province> listOfPrevProvincesStates(int min, int max) {
//        // send the province state to the Originator
//        origProvince.setProvince(playerProvince);
//
//        // Create a memento Object from the given state.
//        MementoProvince mp = origProvince.createMementoProvinces();
//
//        // send to the CareTackerProvince
//        ctProvince.addMementoProvince(mp);
//        ArrayList<MementoProvince> ctP = ctProvince.getListMementoProvince(min, max);
//        return origProvince.setMementoProvinces(ctP);
}
