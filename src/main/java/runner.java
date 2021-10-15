/* This file is the runner files that is used to
*  start the program
*/
package main.java;

public class runner {
    public static void main(String[] args) {
        userInterface ui = api.runInitializeUI();
        ui.startPlayer();
    }
}
