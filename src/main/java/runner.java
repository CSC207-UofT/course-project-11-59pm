/* This file is the runner files that is used to
*  start the program. NOTE: ONLY FOR PHASE 0: In order to run the program
* We have used this file. We know that this is not good practice according to the
* Clean Architecture and this will be changed in the future.
*/
package main.java;

import java.util.ArrayList;

public class runner {
    // Instantiates an API Object to run the program
    public static void main(String[] args) {
        userInterface ui = userInterface.initializeUI();
        ArrayList list = new ArrayList<>(ui.startPlayer());
        // creating a province and player and assign province to player
        controller.runStartPlayer((String) list.get(0), (String) list.get(1));

        // send decision to the ui

        // get decisions from ui to game manager

        // create and send the events
        controller.sendEvents(ui);

        // ask user whether they want to participate in battle

        // send answer to game manager

        // get answer from ui about event to the game manager
        Decisions d = new Decisions();
        d.displayQuestions();
    }
}
