/*
Decisions Class prompts the user with 3 options at the start of each event.
The Questions are related to either Money, Food or the Army.
 */
package main.java.game_manager;
import java.util.ArrayList;

/**
 *  This file contains the implementation for the Decisions Class.
 *  Responsibility: This file is to send the decisions to the GameEngine
 *  when needed.
 */
public class Decisions {

    // Instance Variable: ArrayList with all the Possible Decisions Presented to User
    private final ArrayList<String> DECISIONS_QUESTIONS = new ArrayList<>();

    public Decisions() {
        this.DECISIONS_QUESTIONS.add("Do you want to boost your food for one round?");
        this.DECISIONS_QUESTIONS.add("Do you want to enlist more soldiers?");
        this.DECISIONS_QUESTIONS.add("Do you want to increase revenue?");
    }
    /* Returns the ArrayList with All the Possible Decisions */
    public ArrayList<String> getDECISIONS_QUESTIONS() {
        return DECISIONS_QUESTIONS;
    }

    /* Displays All Decision Questions In the Console */
    public void displayQuestions(){
        for (String decisionQuestion : DECISIONS_QUESTIONS) {
            System.out.println(decisionQuestion);
        }
    }
}
