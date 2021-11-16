/*
Decisions Class prompts the user with 3 options at the start of each event.
The Questions are related to either Money, Food or the Army.
 */
package com.company.GameManager;
import java.util.ArrayList;

public class Decisions {

    // ArrayList With all the Possible Decisions Presented to Sser
    private final ArrayList<String> decisionQuestions = new ArrayList<>();

    public Decisions() {
        this.decisionQuestions.add("Do you want to boost your food for one round?");
        this.decisionQuestions.add("Do you want to enlist more soldiers?");
        this.decisionQuestions.add("Do you want to increase revenue?");
    }

    /* Displays All Decision Questions In the Console */
    public void displayQuestions(){
        for (String decisionQuestion : decisionQuestions) {
            System.out.println(decisionQuestion);
        }
    }
}
