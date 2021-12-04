package com.company;

import com.company.GameManager.GameEngine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        GameEngine engine = new GameEngine();
        engine.loopGame();
    }
}
