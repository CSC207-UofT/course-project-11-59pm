/* This is the API file. This file defines function to connect our UI to our use case code. 
*
*/
package main.java;

public class controller {
    public static void runStartPlayer(String name, String provinceName) {
        // This function starts a new player object, 
        //and initializes a province for the player using game manager

        // create a game manager
        GameManager gm = GameManager.initializeGM();

        //create the province
        Provinces province = gm.startProvince(provinceName);

        // create Userplayer and assign province to it
        gm.startPlayer(name, province);

        // save game progress #1
        gm.saveProgress();

        // get decision

        //start battle

    }
    public static String sendEvents(userInterface ui){

        //send event to ui

        // possibility of an event to the player
        GameManager gm = GameManager.initializeGM();
        gm.loadGameState(); // we have player and province that we created
        // load the game state that has the player and province in it here
        String event = gm.PromptEvents();
        ui.displayText(event);

        String choice = ui.getEventChoice();
        //get answer back to gamemanager

        return choice;
    }
//    public static userInterface runInitializeUI() {
//        // Defines a new user interface, in the userInterface class
//        //ui is being defined in the top layer to maintain clean architecture.
//        userInterface ui = userInterface.initializeUI();
//        return ui;
//    }


}
