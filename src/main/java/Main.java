package main.java;
import main.java.gamemanager.GameEngine;
import java.io.IOException;

/**
 *  This file contains the implementation for the Main Class.
 *  Responsibility: This file is responsible for running the program
 *  and calls on the Game Engine to start the game.
 */

public class Main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        GameEngine engine = new GameEngine();
        engine.loopGame();
    }
}
