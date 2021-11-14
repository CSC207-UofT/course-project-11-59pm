/**
 *
 * This file is the basis and computation of the AI used in the game
 *
 * */
package com.company;

import com.company.ProvinceConstruction.Province;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIDecisionMaker {
    public AIDecisionMaker(){
        //Nothing to initilize
    }

    public List<String> getDecisions(){
        /** Generate 1 random number which represents the choice the given user made.
         * Currently randomized.
         *
         * MAY UP TO TWO LATER, HENCE LIST
         */
        Random rand = new Random();
        int choice = rand.nextInt(4);
        List<String> choices = new ArrayList<String>();

        for (int i = 0; i < 3; i++) {
            choice = rand.nextInt(4);
            if (choice == 0) {
                choices.add("1");
            } else if (choice == 1) {
                choices.add("2");
            } else {
                choices.add("3");
            }
        }
//        for (int i = 0; i < 3; i++){
//             choice = rand.nextInt(4);
//
//             if (choice == 0){
//                 choices.add("1");
//             }
//
//             else if (choice == 1){
//                 choices.add("2");
//             }
//
//             else {
//                 choices.add("3");
//             }
//        }

        return choices;
    }

    public List<String> getDecisions(List<Integer> skews){
        /** Generate 1 number which represents the choice the given user made.
         * This method allows for the decisions to be skewed, meaning that one decision is favored over another
         */
        Random rand = new Random();
        int choice;
        List<String> choices = new ArrayList<String>();

        choice = rand.nextInt(100);

        if (choice <= skews.get(0)){
            choices.add("1");
        }

        else if (choice <= skews.get(1)){
            choices.add("2");
        }

        else {
            choices.add("3");
        }

        return choices;
    }

    public void makeDecisions(Province province){
        /**This is the basis of the AI. The ai uses the random numbers from getDecisions
         * to change the values of each province.
         *
         * @param province The province that the AI will act on
         */
        ProcessValues processor = new ProcessValues();
        List<String> choices = getDecisions();

        for (String choice : choices) {
            processor.getUserDecision(choice, province, 50);
        }
    }

    public void makeDecisions(Province province, int modifier, List<Integer> skews){
        /**This is the basis of the AI. The ai uses the random numbers from getDecisions
         * to change the values of each province.
         *
         * @param province The province that the AI will act on
         * @param modifier The value that a province attribute will be modified by
         */
        ProcessValues processor = new ProcessValues();
        List<String> choices = getDecisions(skews);

        for (String choice : choices) {
            processor.getUserDecision(choice, province, modifier);
        }
    }
}
