package main.java;
/*
Nobility Player class that represents the king.
 */

public class NobilityPlayer extends Player {
    private int money = 999;
    //TODO: Need to discuss and set a default value for the Nobility
    private String name = "Armaan";
    //TODO: Need to the get the name from the controller class

    public NobilityPlayer(int money, String name) {
        this.money = money;
        this.name = name;
    }

    /*
    Getter for the  money variable
     */
    public int getMoney() {
        return money;
    }
    /*
    Overrides the playerStatus from Player.java and returns player status as "Nobility"
     */
    @Override
    public String playerStatus() {
        return "Nobility";
    }
}
