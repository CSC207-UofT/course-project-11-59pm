
package com.company.GameManager;

import com.company.ProvinceConstruction.Province;
import com.company.UseCases.ProcessValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * This file is the basis and computation of the AI used in the game
 *
 * */

public class AIDecisionMaker {
    public AIDecisionMaker(){
        //Nothing to initialize
    }

    /** Totals all stats of given province up and creates a list of percentages that represent the odds of choising
     * a certain choice. This is the third iteration of the AI.
     *
     * @param province The province that is acting
     *
     * returns a list of values of strings 1,2,3
     * May decide to return more than 1 value in the list.
     */
    public List<String> getDecisions(Province province){
        float total = province.getProvinceFood() + province.getProvinceGold() +province.getProvinceFood();
        List<Float> percents = new ArrayList<Float>();
        // Add percents for choice weights
        percents.add(province.getProvinceFood()/total);
        percents.add(province.getProvinceFood() + province.getProvinceGold()/total);

        List<String> choices = new ArrayList<>();
        Random rand = new Random();
        int choice;
        for (int i = 0; i < 3; i++) {
            choice = rand.nextInt(100);
            if (choice <= percents.get(0)) {
                // Boost food
                choices.add("1");
            } else if (choice <= percents.get(1)) {
                // Boost soldiers
                choices.add("2");
            } else {
                // Boost gold
                choices.add("3");
            }
        }
        return choices;
    }

    /** Generate 1 number which represents the choice the given user made.
     * This method allows for the decisions to be skewed, meaning that one decision is favored over another
     */
    public List<String> getDecisions(List<Integer> skews){
        Random rand = new Random();
        int choice;
        List<String> choices = new ArrayList<>();

        choice = rand.nextInt(100);

        if (choice <= skews.get(0)){
            // Boost food
            choices.add("1");
        }

        else if (choice <= skews.get(1)){
            // Boost soldiers
            choices.add("2");
        }

        else {
            // Boost revenue
            choices.add("3");
        }

        return choices;
    }

    /**This is the basis of the AI. The AI uses the random numbers from getDecisions
     * to change the values of each province.
     *
     * @param province The province that the AI will act on
     */
    public void makeDecisions(Province province){
        ProcessValues processor = new ProcessValues();
        List<String> choices = getDecisions(province);


        for (String choice : choices) {
            processor.getUserDecision(choice, province, province.returnMaximumValue(choice) / 2);
        }
        List<Integer> value = randomizeAiEvent();
        processor.getUserEventDecision("Y", province, value);
    }

    /** This is the basis of the AI. The AI uses the random numbers from getDecisions
     * to change the values of each province.
     *
     * @param province The province that the AI will act on
     * @param modifier The value that a province attribute will be modified by
     */
    public void makeDecisions(Province province, int modifier, List<Integer> skews){
        ProcessValues processor = new ProcessValues();
        List<String> choices = getDecisions(skews);

        for (String choice : choices) {
            processor.getUserDecision(choice, province, modifier);
        }
        List<Integer> value = randomizeAiEvent();
        processor.getUserEventDecision("Y", province, value);
    }

    /** This function randomizes a list of number which represents if the user will have an event.
     *
     * */
    public List randomizeAiEvent(){

        List<Integer> randList = new ArrayList<>();
        int counter = 0;
        Random rand = new Random();
        int randInt;
        while(counter < 4){
            randInt = (-3 + rand.nextInt(6)) * 10;
            randList.add(randInt);
            counter++;
        }
        return randList;
    }
}
