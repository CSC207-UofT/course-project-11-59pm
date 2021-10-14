package main.java;

public class GameManager {
    public GameManager() {
        /* Creates game manager*/
    }
    public void RunGame() {
        /* Starts the game */
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