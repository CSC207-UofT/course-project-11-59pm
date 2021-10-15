/* # TODO: Write the description of this file
*
*/
package main.java;

public class api {
    public static void runStartPlayer(String name) {
        // Note: hands off the work to the use case class.
        new Player(name, false, 500);
        GameManager.startProvince(name);
    }
    public static userInterface runInitializeUI() {
        // Note: hands off the work to the use case class.
        userInterface ui = userInterface.initializeUI();
        return ui;
    }

}