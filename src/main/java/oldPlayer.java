/**
The class is responsible for the Player.
 */
//TODO: Decide what we wanna do with this class
package main.java;

public class oldPlayer {
    private int money;
    private String name;
    private boolean isDead;

    public oldPlayer(String name, boolean isDead, int money) {
        this.name = name;
        this.isDead = isDead;
        this.money = money;
    }

    /*Getter for the getMoney*/
    public int getMoney() {
        return money;
    }

    /*Getter for the alive or dead*/
    public boolean getStatus(){
        return isDead;
    }
}
