package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIDecisionMaker {
    public AIDecisionMaker(){
        //Nothing to initilize
    }

    public List getDecisions(){
        /** Generate 3 random numbers which represents the choice the given user made.
         * Currently randomized.
         */
        Random rand = new Random();
        int choice;
        List<String> choices = new ArrayList<String>();

        for (int i = 0; i < 3; i++){
             choice = rand.nextInt(4);

             if (choice == 0){
                 choices.add("1");
             }

             else if (choice == 1){
                 choices.add("2");
             }

             else {
                 choices.add("3");
             }
        }

        return choices;
    }

    public void makeDecisions(Provinces province){
        /** This is the basis of the AI. The ai uses the random numbers from getDecisions
         * to change the values of each province.
         *
         * @param province The province that the AI will act on
         */
        ProcessValues processor = new ProcessValues();
        List<String> choices = getDecisions();

        for (int i = 0; i < choices.size(); i++){
            processor.getUserDecision(choices.get(i), province, 50);
        }
    }
}
