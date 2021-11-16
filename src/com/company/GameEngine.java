package com.company;

import com.company.ProvinceConstruction.Province;
import com.company.ProvinceConstruction.ProvinceAssembler;
import com.company.ProvinceConstruction.ProvinceBuilder;
import com.company.Snapshots.CaretakerProvince;
import com.company.Snapshots.MementoProvince;
import com.company.Snapshots.OriginatorProvince;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.company.gameState.gameState;
import com.company.gameState.saveLoad;

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
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*
        //TODO take provinceName

        ui = UserInterface.initializeUI();
        Boolean saveBool = ui.askLoad();
        ArrayList<Object> list;
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
        battle_option();
        prevProvinceState();
        summaryOfStates();
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

    public void displayEventValues(Province province, List eventValues) {
        //TODO so basically i want to say civilian value = old value + eventValue = new value
        //TODO must use memento to keep track of what the value was before the value changes
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
        ui.displayText("Saving Game...");
        gameState gs = new gameState(list);
        saveLoad.saveGame(filePathSave, gs);
        ui.displayText("Game State Saved");
    }

    private ArrayList<Object> loadPoint(String filePathLoad) throws IOException {
        ui.displayText("Loading Game State...");
        return saveLoad.loadGame(filePathLoad).getSaveState();
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

    public Province prevProvinceState() {
        // send the province state to the Originator
        origProvince.setProvince(playerProvince);
        // System.out.println("Food" + origProvince.getProvince().getProvinceFood());
        // Create a mememto Object from the given state.
        MementoProvince mp = origProvince.createMementoProvinces();

        // send to the CareTackerProvince
        ctProvince.addMementoProvince(mp);

        // return the prev state Province Object
        return origProvince.setprevMementoProvince(ctProvince.getPrevMementoProvince());
    }

    public void summaryOfStates(){
        int counter = 0;
        ArrayList<Integer> bounds = ui.askForBounds();
        ArrayList attributes = new ArrayList<>();
        ArrayList<Province> provinces = listOfPrevProvincesStates(bounds.get(0), bounds.get(1));
        for (Province p: provinces){
            ui.displayText("State: " + counter);
            attributes.add(p.getUserProvinceName());
            attributes.add(p.getProvinceGold());
            attributes.add(p.getProvinceCivilians());
            attributes.add(p.getProvinceSoldiers());
            attributes.add(p.getProvinceFood());
            ui.displaySummary(attributes);
            counter += 1;

        }
    }

    private ArrayList<Province> listOfPrevProvincesStates(int min, int max) {
        // send the province state to the Originator
        origProvince.setProvince(playerProvince);

        // Create a mememto Object from the given state.
        MementoProvince mp = origProvince.createMementoProvinces();

        // send to the CareTackerProvince
        ctProvince.addMementoProvince(mp);
        ArrayList<MementoProvince> ctP = ctProvince.getListMementoProvince(min, max);
        System.out.println(ctProvince.getListOfMementoProvinces().get(0).getProvince().getProvinceFood());
        System.out.println(ctProvince.getListOfMementoProvinces().get(1).getProvince().getProvinceFood());
        return origProvince.setMementoProvinces(ctP);
    }
}