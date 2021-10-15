/* This file is the runner files that is used to
*  start the program
*/
package main.java;

public class runner {
    public static void main(String[] args) {
        // TODO: Implement the runner

        // Instantiate Game
        GameManager game = new GameManager();

        /*
        * Build 5 Provinces
        * */
        Provinces P = new Provinces(100, "OOGA-BOOGA", 1000, true);
        // TODO: Get the Name from the UI
        Provinces P1 = new Provinces(200, "OOGA-BOOGA1", 800, true);
        Provinces P2 = new Provinces(200, "OOGA-BOOGA2", 900, true);
        Provinces P3 = new Provinces(200, "OOGA-BOOGA3", 1100, true);
        Provinces P4 = new Provinces(200, "OOGA-BOOGA", 1200, true);

        game.RunGame();

        // TODO: PLACEHOLDER
    }
}
