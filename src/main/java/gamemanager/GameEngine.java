package main.java.gamemanager;
import main.java.provinceconstruction.Province;
import main.java.provinceconstruction.ProvinceAssembler;
import main.java.provinceconstruction.ProvinceBuilder;
import main.java.snapshots.CaretakerProvince;
import main.java.snapshots.MementoProvince;
import main.java.snapshots.OriginatorProvince;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.ui.UserInterface;
import main.java.usecases.Battle;
import main.java.usecases.ProcessValues;
import main.java.gamesave.GameState;
import main.java.gamesave.SaveLoad;

/**
 *  This file contains the implementation for the GameEngine Class.
 *  Responsibility: This file is the core of our Game which is
 *  responsible for running the game, turns, taking input to the Use Cases,
 *  and taking output to the UserInterface.
 */

public class GameEngine {
    /**
     * Below are all the Instance Variables for most of the classes that are connected within
     * the Game Engine.
     * NOTE: We have made all the instance variables final to ensure that they do not get mutated during the game.
     */
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
        // First, initialize the UserInterface, and
        // other instances classes that are instance variables
        ui = UserInterface.initializeUI();
        decisionList = new Decisions();
        processor = new ProcessValues();
        battleGenerator = new Battle();
        origProvince = new OriginatorProvince();
        ctProvince = new CaretakerProvince();
        aiChoices = new AIDecisionMaker();

        // Asking the User about their previous GameState
        Boolean saveBool = ui.askLoad();
        ArrayList<Object> list;
        list = getSaveDecision(saveBool);

        // Creation of the User Province
        ProvinceBuilder provinceBuilder1 = new ProvinceBuilder();
        ProvinceAssembler provinceUserAssembler = new ProvinceAssembler(provinceBuilder1);
        String name = (String) list.get(1);
        provinceUserAssembler.makeUserProvince(name);
        playerProvince = provinceUserAssembler.getUserProvince();

        // Creation of the 4 AI Provinces
        ProvinceAssembler provinceAiAssembler = new ProvinceAssembler();
        aiProvinces = provinceAiAssembler.create();
    }

    /**
     *  // TODO: Girish could you write this method's documentation.
     *
     *     - Sample input for windows filePath: C:\Users\YOURUSERNAME\Desktop
     *     - Sample input for macOS filePath: /Users/username/Desktop
     * @param saveBool the result of the User's prompt
     * @throws IOException if the user inputs improper data.
     */
    private ArrayList<Object> getSaveDecision(Boolean saveBool) throws IOException {
        ArrayList<Object> list;
        if (saveBool) {
            list = new ArrayList<>(loadPoint(ui.getFilePathLoad()));
            ui.displayText("Welcome back to Rajan's Conquest, " + list.get(0));
        } else{
            list = new ArrayList<Object>(ui.startPlayer());
            savePoint(list, ui.getFilePathSave());
        }
        return list;
    }

    /**
     * Loops the game until the playerProvince is NOT dead.
     * @throws CloneNotSupportedException if the object is not Cloneable due to missing
     *                                      implementation of the Cloneable Interface.
     */
    public void loopGame() throws CloneNotSupportedException {
        while (!playerProvince.isDeath()) {
            turn();
        }
        death();
    }

    /**
     * Runs each turn:
     * i) Each turn consists of 3 turns in total,
     *  where User is given 1 Decisions and 2 Random Events during the process. After each turn,
     *  changes are made and then is displayed to the User.
     *  NOTE: Each event affects the user's attributes that are preset depending on their choice.
     *
     *  *** A ROUND CONSISTS of 3 turns and AFTER EACH ROUND, USER HAS A OPTION TO BATTLE OTHER PROVINCE ***
     *
     * ii) Next, AI turns are conducted for every province and values are altered.
     * iii) After 3 turn (round ends), snapshot of the User attributes are taken.
     * iv) Then, the User is prompted to start a Battle
     * v) User has the option to get a summary of their attributes.
     */
    public void turn() throws CloneNotSupportedException {
        // Displaying the two Event
        printAttributes(playerProvince);
        processEvent();
        //second display
        printAttributes(playerProvince);
        processEvent();

        printAttributes(playerProvince);
        processDecision();

        aiTurn();
        stateSnapshot(playerProvince);

        if (allDead()){
            conclusion();
        }

        battle_option();
        if (ui.askSummary()){
            summaryOfStates();
        }

        // Checks to see if all the other provinces have been beaten

        if (allDead()){
            conclusion();
        }
    }

    /**
     * An equivalent of the Python "all" function to see if the user has beaten all provinces
     */
    private boolean allDead(){
        for (Province aiProvince: aiProvinces){
            if (aiProvince.getStatus()) return false;
        }
        return true;
    }

    /**
     * Ends the game
     */
    private void conclusion(){
        ui.displayText("Congratulations, you have conquered all the other provinces! You win!");
        System.exit(0);
    }

    /**
     * Makes the Decisions for all 4 AI Provinces in the back which is hidden from the User.
     */
    private void aiTurn() {
        displayValues(playerProvince);
        for (Province currProvince : aiProvinces) {
            if (currProvince.getStatus()) {
                aiChoices.makeDecisions(currProvince);
                displayValues(currProvince);
                if (currProvince.isDeath()) {
                    provinceDeath(currProvince);
                }
            }
        }
    }

    /**
     * Displays values after the User's choice given a Decision.
     */
    private void displayValues(Province province) {
        printAttributes(province);
    }

    /**
     * This function gets a random event and the displays it
     * You then answer Y/N to the question, and it changes your parameters based on the individual event
     */
    public List<Integer> processEvent() {
        Events event = new Events();
        String eventName = Events.getRandomEvent();
        List<Integer> eventValues = Events.getValues(eventName);
        ui.displayText(eventName);
        String choice = ui.getEventChoice();
        processor.getUserEventDecision(choice, playerProvince, eventValues);
        return eventValues;
    }

    /**
     * Multi-tasked Function for Processing the Values after User's decision:
     *                    i) Displays the 3 Decisions.
     *                    ii) Obtains the User's Choice.
     *                    iii) Finds the attribute that needs to be altered.
     *                    iv) Sends this information to the ProcessValues for updating.
     */
    private void processDecision() {
        decisionList.displayQuestions();
        String choice = ui.getDecisionsChoice();
        int max = ui.getDecisionValues(choice, playerProvince.returnMaximumValue(choice));
        processor.getUserDecision(choice, playerProvince, max);
    }

    /**
     * Displays the Province which are dead.
     */
    public void provinceDeath(Province province) {
        ui.displayText("***" + province.getAiProvinceName() + " is dead" + "***");
        province.die();
    }

    /**
     * Displays when the User is dead and prompts the User to restart the game.
     */
    public void death() {
        ui.displayText("You have lost the game!");
        displayValues(playerProvince);
        ui.displayText("One of the values have reached zero :( :skull:");
        System.exit(0);
    }

    /** Multi-tasked Function for Starting a Battle:
     *                     i) Displays the list of Provinces that can battle (Are still Alive).
     *                     ii) Prompts the User to choose their opponent
     *                     iii) Then, proceeds to start the battle between the user and its chosen province
     *                     iv) Displays the winner
     */
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
                    ui.displayText("The Winner of the battle is " + winner);
                }
            }
        }
    }

    /**
     * Displays the Summary of each Round
     */
    private void summaryOfStates(){
        int counter = 0;
        for (Province p: origProvince.setListOfMementoProvinces(ctProvince.getMementoProvinceList())){
            ui.displayText("-------------------------");
            ui.displayText("Round: " + counter);
            ui.displayText("-------------------------");
            printAttributes(p);
            counter += 1;
        }
    }

    /**
     * TODO: Girish Finish the Documentation
     */
    private void savePoint(ArrayList list, String filePathSave) throws IOException {
        // Creates a save file for the current GameState
        ui.displayText("Saving Game...");
        GameState gs = new GameState(list);
        SaveLoad.saveGame(filePathSave, gs);
        ui.displayText("Game State Saved");
        ui.displayText("\n");
    }

    /**
     * TODO: Girish Finish the Documentation
     */
    private ArrayList<Object> loadPoint(String filePathLoad) throws IOException {
        // Loads the save.ser file for the current GameState
        ui.displayText("Loading Game State...");
        ui.displayText("\n");
        return SaveLoad.loadGame(filePathLoad).getSaveState();
    }

    /**
     * Saves the Snapshot of the current state using the Memento Design Pattern
     */
    private void stateSnapshot(Province p) throws CloneNotSupportedException {
        Province copyProvince = (Province)p.clone();
        origProvince.setProvince(copyProvince);
        MementoProvince mp = origProvince.createMementoProvinces();
        ctProvince.addMementoProvince(mp);
    }


    private void printAttributes(Province province) {
        ui.displayText("===============================");
        if ((province.getUserProvinceName() != null)) {
            ui.displayText("Values for province: " + province.getUserProvinceName());
        } else {
            ui.displayText("Values for province: " + province.getAiProvinceName());
        }
        ui.displayText("Civilian value: " + province.getProvinceCivilians());
        ui.displayText("Gold value: " + province.getProvinceGold());
        ui.displayText("Soldier value: " + province.getProvinceSoldiers());
        ui.displayText("Food value: " + province.getProvinceFood());
        ui.displayText("===============================");
    }
}
