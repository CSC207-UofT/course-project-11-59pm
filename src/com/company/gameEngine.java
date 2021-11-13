package com.company;

import com.company.builder.Province;
import com.company.builder.ProvinceAssembler;
import com.company.builder.ProvinceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gameEngine {
    private userInterface ui;
    private Decisions decisionList;
    private ProcessValues processor;
    private Province playerProvince;
    private ProvinceBuilder provinceBuilder;
    private ProvinceAssembler provinceAssembler;
    private Province p1;
    private Province p2;
    private Province p3;
    private Province p4;

    public gameEngine() {
        /* Loads the Preset Provinces. Will be changed in the future such that
         * the user has a choice between the provinces to choose with provinces being good
         * in some attributes and lack in others, that describe the province.
         * (ie: Military: 95, however, Religion: 20) */
        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*
        //TODO take provinceName

        ui = userInterface.initializeUI();
        ArrayList list = new ArrayList<>(ui.startPlayer());
//        playerProvince.setUserProvinceName((String) list.get(0));
        decisionList = new Decisions();
        processor = new ProcessValues();

        ProvinceBuilder provinceBuilder = new ProvinceBuilder();
        ProvinceBuilder provinceBuilder2 = new ProvinceBuilder();
        ProvinceBuilder provinceBuilder3 = new ProvinceBuilder();
        ProvinceBuilder provinceBuilder4 = new ProvinceBuilder();




        ProvinceAssembler provinceAssembler  =  new ProvinceAssembler(provinceBuilder);
        ProvinceAssembler provinceAssembler2  =  new ProvinceAssembler(provinceBuilder2);
        ProvinceAssembler provinceAssembler3  =  new ProvinceAssembler(provinceBuilder3);
        ProvinceAssembler provinceAssembler4  =  new ProvinceAssembler(provinceBuilder4);


        provinceAssembler.makeProvince();
        provinceAssembler2.makeProvince();
        provinceAssembler3.makeProvince();
        provinceAssembler4.makeProvince();



         provinceAssembler.makeUserProvince((String) list.get(0));
         p1 = provinceAssembler.getAiProvince();
         p2 = provinceAssembler2.getAiProvince();
         p3 = provinceAssembler3.getAiProvince();
         p4 = provinceAssembler4.getAiProvince();
         playerProvince = provinceAssembler.getUserProvince();


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
            processor.getUserEventDecision(choice, playerProvince, eventValues);
        }
    }

    public void processDecision(){
        decisionList.displayQuestions();
        String choice = ui.getDecisionsChoice();
        processor.getUserDecision(choice, playerProvince, 50);
    }

    public void displayValues(){
        ui.displayText("Values for province: " + playerProvince.getUserProvinceName());
        ui.displayText("Civilian value: " + playerProvince.getProvinceCivilians());
        ui.displayText("Gold value: " + playerProvince.getProvinceGold());
        ui.displayText("Soldier value: " + playerProvince.getProvinceSoldiers());
        ui.displayText("Food value: " + playerProvince.getProvinceFood());
    }
    public boolean isDeath(){
        //TODO make the code less redundant
        if (playerProvince.getProvinceCivilians() <= 0 || playerProvince.getProvinceGold() < 0
                || playerProvince.getProvinceSoldiers() < 0 || playerProvince.getProvinceFood() < 0){
            return true;
        }
        return false;
    }
    public void death(){
        ui.displayText("You have lost the game!");
        displayValues();
        ui.displayText("One of the values have reached zero :( :skull:");
        //TODO would you like to restart? and have them restart
    }
}