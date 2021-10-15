/**
The class is responsible for the Player.
 */
package main.java;

public class Player {
    private int money;
    private String name;
    private boolean isDead;

    public Player(String name, boolean isDead, int money) {
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
