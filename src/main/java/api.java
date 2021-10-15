/* This is the API file. This file defines function to connect our UI to our use case code. 
*
*/
package main.java;

public class api {
    public static void runStartPlayer(String name) {
        // This function starts a new player object, 
        //and initializes a provience for the player using game manager 
        new Player(name, false, 500);
        GameManager.startProvince(name);
    }
    public static userInterface runInitializeUI() {
        // Defines a new user interface, in the userInterface class
        //ui is being defined in the top layer to maintain clean arctiecture
        userInterface ui = userInterface.initializeUI();
        return ui;
    }

}
