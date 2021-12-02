/*
Decisions Class prompts the user with 3 options at the start of each event.
The Questions are related to either Money, Food or the Army.
 */
package com.company;
import java.util.ArrayList;

public class Decisions {

    // ArrayList With all the Possible Decisions Presented to Sser
    private final ArrayList<String> decisionQuestions = new ArrayList<>();

    public Decisions() {
        this.decisionQuestions.add("Do you want to boost your food for one round?");
        this.decisionQuestions.add("Do you want to enlist more soldiers?");
        this.decisionQuestions.add("Do you want to increase revenue?");
    }
    /* Returns the ArrayList with All the Possible Decisions */
    public ArrayList<String> getDecisionQuestions() {
        return decisionQuestions;
    }
    //TODO: displayQuestions System.out needs to use UI?

    /* Displays All Decision Questions In the Console */
    public void displayQuestions(){
        for(int i = 0; i < decisionQuestions.size(); i++){
            System.out.println(decisionQuestions.get(i));
        }
    }
}
