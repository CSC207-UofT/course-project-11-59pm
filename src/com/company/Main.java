package com.company;

import com.company.GameManager.GameEngine;

import java.io.IOException;
/**
 *
 * This is the main file that should be run for the whole program.
 *
 * */
public class Main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        GameEngine engine = new GameEngine();
        engine.loopGame();
    }
}
