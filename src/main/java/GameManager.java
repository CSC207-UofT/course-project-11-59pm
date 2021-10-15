package main.java;

public class GameManager {
    private Provinces P1;
    private Provinces P2;
    private Provinces P3;
    private Provinces P4;
    private Provinces PlayerProvince;


    public GameManager() {
        /* Preset */
        Provinces P1 = new Provinces(100, "Deven",
                "Bandar", 800, true, false);

        Provinces P2 = new Provinces(200, "Saj",
                "Kela", 500, true, false);

        Provinces P3 = new Provinces(400, "Ashwin",
                "Pahaad", 600, true, false);

        Provinces P4 = new Provinces(500, "Maya",
                "Vayu", 1000, true, false);
    }
    public static void startProvince(String name) {
        /* Starts the game */

        // Gets the Name of the raja and then assigns that player to be the King
        // of their Province.
        // NOTE: We are presetting the province for the user *ONLY FOR PHASE 0*

        String raja = name;
        Provinces PlayerProvince = new Provinces(200, name,
                "Zulfein", 800, true, true);

        // Now, the stats for the players and the other provinces have to be
        // saved within the gameState for saving purpose.

    }

    public void StartBattle (Battle battle) {
        /* uses Battle class to begin a battle after the end of the choice selection*/
    }
    public void PromptEvents (userInterface controller) {
        /* uses Controller to ask the user to select between available game choices*/
    }

    public void updatePlayer (gameState gamestate, int updated_variables) {
        /* updates player's variables using GameState*/
    }

    public void updateProvince (gameState gamestate, Provinces province, int updated_variables) {
        /* updates a province's variables using GameState*/
    }

    public void GameStateSaver (gameState gamestate) {
        /* uses GameState to save game*/
    }

    public Provinces getPlayerProvince() {
        return PlayerProvince;
    }
}