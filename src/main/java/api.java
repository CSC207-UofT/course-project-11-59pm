/* This is the API file. This file defines function to connect our UI to our use case code. 
*
*/
package main.java;

public class api {
    public static void runStartPlayer(String name) {
        // This function starts a new player object, 
        //and initializes a province for the player using game manager
        GameManager gm = GameManager.initializeGM();
        new Player(name, false, 500);
        gm.startProvince(name);
        gm.saveProgress();
    }
    public static userInterface runInitializeUI() {
        // Defines a new user interface, in the userInterface class
        //ui is being defined in the top layer to maintain clean architecture.
        userInterface ui = userInterface.initializeUI();
        return ui;
    }


}
