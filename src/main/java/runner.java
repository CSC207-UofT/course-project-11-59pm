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
        userInterface ui = controller.runInitializeUI();
        ArrayList list = new ArrayList<>(ui.startPlayer());
        controller.runStartPlayer((String) list.get(0), (String) list.get(1));
        Decisions d = new Decisions();
        d.displayQuestions();
    }
}
