package main.java;

public class GameManager {
    public GameManager() {
        /* Creates game manager*/
    }
    public void RunGame() {
        /* Starts the game */

        /*
         * Build 5 Provinces
         */
        Provinces P = new Provinces(100, "OOGA-BOOGA", 1000, true);
        // TODO: Get the Name from the UI
        Provinces P1 = new Provinces(200, "OOGA-BOOGA1", 800, true);
        Provinces P2 = new Provinces(200, "OOGA-BOOGA2", 900, true);
        Provinces P3 = new Provinces(200, "OOGA-BOOGA3", 1100, true);
        Provinces P4 = new Provinces(200, "OOGA-BOOGA", 1200, true);
    }

    public void StartBattle (Battle battle) {
        /* uses Battle class to begin a battle after the end of the choice selection*/
    }
    public void PromptEvents (Controller controller) {
        /* uses Controller to ask the user to select between available game choices*/
    }

    public void updatePlayer (Gamestate gamestate, int updated_variables) {
        /* updates player's variables using GameState*/
    }

    public void updateProvince (Gamestate gamestate, Province province, int updated_variables) {
        /* updates a province's variables using GameState*/
    }

    public void GameStateSaver (GameState gamestate) {
        /* uses GameState to save game*/
    }

}