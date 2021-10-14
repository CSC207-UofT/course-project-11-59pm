package main.java;
/*
Peasant Player class that represents the king.
 */
public class PeasantPlayer extends Player {
    private int money = 999;
    //TODO: Need to discuss and set a default value for the Peasant
    private String name = "Armaan";
    //TODO: Get the name of the user from the controller class


    public PeasantPlayer(int money, String name) {
        this.money = money;
        this.name = name;
    }
    /*
    Overrides the playerStatus from Player.java and returns player status as "Peasant"
     */

    @Override
    public String playerStatus() {
        return "Peasant";
    }
    /*
        Getter for the private attribute money.
     */
    public int getMoney() {
        return money;
    }
}
